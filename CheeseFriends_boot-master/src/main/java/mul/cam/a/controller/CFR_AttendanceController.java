package mul.cam.a.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.TextStyle;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.opencv.core.Core;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import mul.cam.a.attendSMS.AbsentSender;
import mul.cam.a.camera.User_Face_Crop;
import mul.cam.a.dao.CFR_AttendanceDao;
import mul.cam.a.dto.AttendanceRequest;
import mul.cam.a.dto.AttendanceTimetable;
import mul.cam.a.dto.CFR_Attendance;
import mul.cam.a.service.AttManageService;
import mul.cam.a.service.CFR_AttendanceService;

@Controller
public class CFR_AttendanceController {
	@Autowired
	private CFR_AttendanceDao attendanceuserDAO;	
    private CFR_AttendanceService attendanceService;
    @Autowired
    private AbsentSender AbsentSender;
    @Autowired
    private AttManageService attManageService;
    
    public CFR_AttendanceController(CFR_AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }
   
    @PostMapping("/api/compareFaces")
    public ResponseEntity<String> compareFaces() {
        String command = "java -cp .;opencv-470.jar mul.cam.a.camera.Compare";
        String userId = "Unknown";
        System.out.println("출석체크 시스템 실행");
        System.out.println(getClass().getProtectionDomain().getCodeSource().getLocation());

        try {
            ProcessBuilder builder = new ProcessBuilder(command.split(" "));
            builder.directory(new File("./target/classes"));
            Process process = builder.start();
            BufferedReader reader = new BufferedReader(new FileReader("userId.txt"));
            String line = reader.readLine();
            System.out.println(command);
            System.out.println(process);
            System.out.println(line);

            if (line != null) {
                userId = line.trim();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("catch");
        }
        System.out.println(userId);
        return ResponseEntity.ok(userId);
    }
    
       
        @GetMapping("/api/userId")
        public ResponseEntity<String> getUserId() {
            String userId = "Unknown";
            
            try {
                BufferedReader reader = new BufferedReader(new FileReader("userId.txt"));
                String line = reader.readLine();
                
                if (line != null) {
                    userId = line.trim();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            return ResponseEntity.ok(userId);
        }
        
    


 // userID별로 사진 크롭해서 저장
    @PostMapping("/api/imgcrop/{userId}")
    public ResponseEntity<Object> compareFaces(@PathVariable String userId) {
    	
    	
    	System.out.println(userId);
        try {
            // 이미지를 자르는 기능
            User_Face_Crop faceCrop = new User_Face_Crop();
            String imagePath = "./src/main/webapp/upload/" + userId + ".jpg";
            System.out.println(imagePath);
            String croppedImagePath = "./src/AttendanceFace/"+userId+".jpg";
            boolean cropSuccess = faceCrop.cropUserFace(imagePath, croppedImagePath);

            // 자르기가 성공했는지에 따라 결과 반환
            if (cropSuccess) {
            	System.out.println(userId + " 생성 성공");
                return ResponseEntity.ok().build();
            } else {
            	System.out.println(userId + " 생성 실패");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Failed to crop image");
        }
    }
    

    public static LocalTime convertStringToLocalTime(String timeString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return LocalTime.parse(timeString, formatter);
    }
  //출석
    @PostMapping(value = "/attendance")
    public ResponseEntity<?> postAttendance(@RequestBody AttendanceRequest request, Model model) {
    	System.out.println("출석 실행");
        String userId = request.getUserId();
        String eduCode = request.getEduCode();
        String subCode = request.getSubCode();
        Date now = new Date();

        String month = String.format("%02d", now.getMonth() + 1);
        String date = String.format("%02d", now.getDate());
        String AttendanceID = userId + subCode + month + date;

        List<AttendanceTimetable> timetableList = attendanceService.getSubjectByUserIdAndEduCode(userId, eduCode, subCode);

        // Attendance ID 중복 체크
        boolean checkattendanceIds = attendanceService.checkAttendanceId(userId, subCode, eduCode, AttendanceID);

        LocalDateTime nowTime = now.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        String attendanceStatus = "";
        String attendanceMessage = "";
        

        for (AttendanceTimetable timetable : timetableList) {
        	LocalTime startTime = convertStringToLocalTime(timetable.getSubStartTime());
        	LocalTime endTime = convertStringToLocalTime(timetable.getSubEndTime());

    

            if (checkattendanceIds == false) {
            	attendanceStatus = "이미 출석";
                System.out.println(userId + "이미 출석했습니다");
            } else {
                CFR_Attendance attendance = new CFR_Attendance();
                attendance.setAttendanceID(AttendanceID);
                attendance.setStudentID(userId);
                attendance.setSub_code(subCode);
                attendance.setEdu_code(eduCode);

                // 현재 시간이 출석 시작 시간보다 빠르면 출석으로 처리, 아니면 지각으로 처리
                if (nowTime.toLocalTime().isBefore(startTime)) {
                	attendanceStatus = "출석 처리";
                    attendance.setStatus("출석");
                    System.out.println(userId + " 출석했습니다.");
                } else if(nowTime.toLocalTime().isAfter(endTime)) {
                	attendanceStatus = "결석 처리";
                    attendance.setStatus("결석");
                    System.out.println(userId + " 결석했습니다.");
                }else {
                	attendanceStatus = "지각 처리";
                    attendance.setStatus("지각");
                    System.out.println(userId + " 지각했습니다.");
                }

                attendanceService.checkAttendance(attendance);
                break;
            }
        }

        return ResponseEntity.ok(attendanceStatus);
    }
    
    @GetMapping("/user/{userId}")
    public ResponseEntity<String> getNameById(@PathVariable String userId) {
        String name = attendanceuserDAO.getNameById(userId);
        return ResponseEntity.ok(name);
    }
    
    // 결석
    //@Scheduled(cron = "0 5 * * * *") // 매 시간 5분에 실행
    public void checkAbsence() {
        // 요일 문자열을 숫자로 변환 (일: 1, 월: 2, ... , 토: 7)
    	System.out.println("결석 체크 실행");
        DayOfWeek subDay = LocalDate.now().getDayOfWeek();
        String displayName = subDay.getDisplayName(TextStyle.FULL_STANDALONE, Locale.KOREAN);
        System.out.println(displayName);

        // 해당 요일에 해당하는 강의 목록을 조회
        List<AttendanceTimetable> timetableList = attendanceService.getSubjectByDayOfWeek(displayName);
        
        
        for (AttendanceTimetable timetable : timetableList) {
        	String subCode = (timetable.getSubCode());
            List<String> studentIds = attendanceService.getStudentIdsBySubCode(subCode);
            
            for (String studentId : studentIds) {
                String attendanceId = attendanceService.generateAttendanceId(studentId, subCode, LocalDate.now().getMonthValue(), LocalDate.now().getDayOfMonth());
                System.out.println("만들어진 출석 번호" + attendanceId);
                
                List<String> getId = attendanceService.getAllAttendances(subCode);

                System.out.println(subCode +" 과목에 해당하는 출석 번호 "+ getId);
                
              
                if (!getId.contains(attendanceId)) {
                    // endtime 비교하고 결석처리 하기
                	LocalTime endTime = convertStringToLocalTime(timetable.getSubEndTime());
                	LocalTime now = LocalTime.now();
                	System.out.println(endTime);
                	System.out.println(now);
                	if (endTime.isBefore(now)) {
                        CFR_Attendance attendance = new CFR_Attendance();
                        attendance.setAttendanceID(attendanceId);
                        attendance.setStudentID(studentId);
                        attendance.setSub_code(subCode);
                        attendance.setEdu_code(timetable.getEduCode());
                        attendance.setStatus("결석");
                        attendanceService.checkAttendance(attendance);
                        // 결석 문자 보내기
                        Boolean absentAlarm = attManageService.findUserAbsentAlarmTrue(studentId);
                        System.out.println(absentAlarm);
                        if (absentAlarm != null && absentAlarm) {
                            String subName = attManageService.findSubName(subCode);
                            AbsentSender.sendSMS(studentId, subName);
                        }
                        
                        System.out.println(studentId + " 학생의 결석 처리 완료");
                        
                    }
                } else {
                    // 해당 출석번호가 이미 있으면 건너뜀
                    System.out.println(studentId + " 학생은 이미 출석 처리되었습니다.");
                }
            }
        }
    }
}





    
    

    


