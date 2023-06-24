package mul.cam.a.controller;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mul.cam.a.attendSMS.SmsSender;
import mul.cam.a.dto.AttendanceEdu;
import mul.cam.a.dto.AttendanceSMSCheck;
import mul.cam.a.dto.CFR_Attendance;
import mul.cam.a.dto.SubjectDto;
import mul.cam.a.service.AttManageService;

@RestController
@RequestMapping("/attManage")
public class AttManageController {
    @Autowired
    private AttManageService attManageService;
    @Autowired
    private SmsSender smsSender;

    
    @GetMapping("/{studentID}/{subCode}/{eduCode}")
    public ResponseEntity<?> getAttendanceList(@PathVariable String studentID,
                                                @PathVariable String subCode,
                                                @PathVariable String eduCode) {
        List<CFR_Attendance> attendanceData = attManageService.getAttendanceList(studentID, subCode, eduCode);
        List<Map<String, String>> newAttendanceData = new ArrayList<>();
        for (CFR_Attendance attendance : attendanceData) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String formattedTime = dateFormat.format(attendance.getAttendanceTime());
            
            Map<String, String> newAttendance = new HashMap<>();
            newAttendance.put("attendanceTime", formattedTime);
            newAttendance.put("status", attendance.getStatus());
            newAttendanceData.add(newAttendance);
        }
        return ResponseEntity.ok(newAttendanceData);
    }
    
    @GetMapping("/subjects/{userId}")
    public ResponseEntity<List<SubjectDto>> getSubjectsByUserId(@PathVariable String userId) {
        List<SubjectDto> subjects = attManageService.getSubjectsByUserId(userId);
        return ResponseEntity.ok(subjects);
    }
    
    @GetMapping("/edu/{userId}")
    public ResponseEntity<List<AttendanceEdu>> getEduByUserId(@PathVariable String userId) {
        List<AttendanceEdu> edu = attManageService.getEduByUserId(userId);
        return ResponseEntity.ok(edu);
    }
    
    @GetMapping("/{subCode}")
    public List<CFR_Attendance> getAttendanceBySubjectCode(@PathVariable String subCode) {
      return attManageService.getAttendanceBySubjectCode(subCode);
    }
    

    @PostMapping("/{attendanceID}/attendance")
    public ResponseEntity<Integer> updateAttendanceStatus(@PathVariable String attendanceID, @RequestBody CFR_Attendance updatedAttendance) {
    	int attendance = attManageService.updateAttendanceStatus(attendanceID, updatedAttendance.getStatus());
    	return ResponseEntity.ok(attendance);
    }

    @PostMapping("/{attendanceID}/comment")
    public ResponseEntity<Integer> updateAttendancecomment(@PathVariable String attendanceID, @RequestBody CFR_Attendance updatedAttendancecomment) {
    	int attendance = attManageService.updateAttendancecomment(attendanceID, updatedAttendancecomment.getComment());
    	return ResponseEntity.ok(attendance);
    }
    
    
    @PostMapping("/{userId}/AlarmTrue")
    public ResponseEntity<?> updateUserSMSCheck(@PathVariable String userId, @RequestBody Map<String, Object> requestMap) {
        Boolean minCheck = (Boolean) requestMap.get("minCheck");
        AttendanceSMSCheck SMSCheckset = new AttendanceSMSCheck();
        SMSCheckset.setUserID(userId);
        SMSCheckset.setMinCheck(minCheck);

        attManageService.updateUserSMSCheck(SMSCheckset);
        return ResponseEntity.ok(SMSCheckset);
    }
    
    @PostMapping("/{userId}/AbsentAlarmTrue")
    public ResponseEntity<?> updateUserSMSCheckAbsent(@PathVariable String userId, @RequestBody Map<String, Object> requestMap) {
        Boolean absentAlarm = (Boolean) requestMap.get("absentAlarm");
        AttendanceSMSCheck absentSMSCheckset = new AttendanceSMSCheck();
        absentSMSCheckset.setUserId(userId);
        absentSMSCheckset.setAbsentCheck(absentAlarm);
        attManageService.updateUserSMSCheckAbsent(absentSMSCheckset);
        return ResponseEntity.ok(absentSMSCheckset);
    }
    
    @GetMapping("/{userId}/GetAlarm")
    public ResponseEntity<?> getAlarm(@PathVariable String userId) {
        List<AttendanceSMSCheck> minCheck = attManageService.getAlarm(userId);
      return ResponseEntity.ok(minCheck);
    }
    
    @GetMapping("/{userId}/AbsentAlarm")
    public ResponseEntity<?> getAbsentAlarm(@PathVariable String userId) {
        List<AttendanceSMSCheck> absentAlarm = attManageService.getAbsentAlarm(userId);
      return ResponseEntity.ok(absentAlarm);
    }
    
    
    //@Scheduled(cron = "0 30 * * * *") // 매 시간 30분에 실행 -> 30분 이전 알림 체크라서
    public String sendSms() {
        List<String> userIds = attManageService.findUserMinCheckTrue();
        for (String userId : userIds) {
        	List<String> subCodes = attManageService.findSubCodesByUserId(userId);
            LocalDate nowDate = LocalDate.now();
            DayOfWeek dayOfWeek = nowDate.getDayOfWeek(); 
            String displayName = dayOfWeek.getDisplayName(TextStyle.FULL_STANDALONE, Locale.KOREAN);
            
        	for (String subCode : subCodes) {
        	String subName = attManageService.findSubName(subCode);
            String subStartTimeStr = attManageService.findSubStartTimeBySubCode(subCode, displayName);
            if (subStartTimeStr == null) {
                continue;
            }
            LocalTime subStartTime = LocalTime.parse(subStartTimeStr);

            // 현재 시각
            LocalDateTime now = LocalDateTime.now();
            LocalTime currentTime = now.toLocalTime();
            
            System.out.println(subStartTime);
            System.out.println(currentTime);

         // 30분 이내라면 문자 발송
            if (subStartTime.isBefore(currentTime.plusMinutes(30)) && subStartTime.isAfter(currentTime)) {
                smsSender.sendSMS(userId, subName);
            }
        }
        }
        return "SMS Sent Successfully!";
    }
    
    @GetMapping("/getStudentId/{userId}")
    public String getStudentId(@PathVariable String userId) {
    	 return attManageService.getStudentId(userId);
    }
    
    @GetMapping("/teacher/subjects/{userId}")
    public ResponseEntity<List<SubjectDto>> getTeacherSubjectsByUserId(@PathVariable String userId) {
        List<SubjectDto> subjects = attManageService.getTeacherSubjectsByUserId(userId);
        return ResponseEntity.ok(subjects);
    }
      
}

