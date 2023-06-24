package mul.cam.a.service;

import java.time.LocalTime;
import java.util.List;


import org.springframework.stereotype.Service;

import mul.cam.a.dto.AttendanceSubject;
import mul.cam.a.dto.AttendanceTimetable;
import mul.cam.a.dto.CFR_Attendance;
import mul.cam.a.dto.CFR_User;


@Service
public interface CFR_AttendanceService {
	// attendance ID로 출석 정보 조회
    CFR_Attendance getAttendanceById(int attendanceID); 
    // 모든 출석 정보 조회, 추가 수정 삭제 
    List<String> getAllAttendances(String subCode);
    void addAttendance(CFR_Attendance attendance);
    void updateAttendance(CFR_Attendance attendance);
    void deleteAttendance(int attendanceID);
    // 출석체크
    void checkAttendance(CFR_Attendance attendance);
	List<AttendanceTimetable> getSubjectByUserIdAndEduCode(String userId, String eduCode, String subCode);
	

    public boolean checkAttendanceId(String studentId, String subCode, String eduCode, String attendanceId) ;
    

	List<AttendanceSubject> getAllSubjects();
	List<AttendanceSubject> getAllUser();
	
	
	  // 해당 요일에 진행되는 강의 목록 조회
    List<AttendanceTimetable> getSubjectByDayOfWeek(String subDay);

    // 해당 강의에 대해 지정된 시간 이후 결석한 학생들의 AttendanceID 조회
    List<String> findAbsentAttendanceIdsBySubCodeAndEndTime(String subCode, LocalTime endTime);

    // 해당 강의에 대해 수강하는 학생들의 UserID 조회
    List<String> getStudentIdsBySubCode(String subCode);

    // UserID, SubCode, Month, Day를 결합하여 AttendanceID 생성
    String generateAttendanceId(String userId, String subCode, int month, int day);
    
    String getNameById(String userId);

}