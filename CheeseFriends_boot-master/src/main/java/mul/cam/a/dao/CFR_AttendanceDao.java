package mul.cam.a.dao;

import java.time.LocalTime;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import mul.cam.a.dto.AttendanceSubject;
import mul.cam.a.dto.AttendanceTimetable;
import mul.cam.a.dto.CFR_Attendance;

public interface CFR_AttendanceDao {
    CFR_Attendance getAttendanceById(int attendanceID);
    List<String> getAllAttendances(String subCode);
    void addAttendance(CFR_Attendance attendance);
    void updateAttendance(CFR_Attendance attendance);
    void deleteAttendance(int attendanceID);
    List<AttendanceTimetable> getSubjectByUserIdAndEduCode(String userId, String eduCode, String subCode);
    void checkAttendance(CFR_Attendance attendance);
    List<String> findAttendanceIdsByStudentAndSubject(@Param("studentId") String studentId,
                                                           @Param("subCode") String subCode, 
                                                           @Param("eduCode") String eduCode);
    

        List<AttendanceSubject> getAllSubjects();
		List<AttendanceSubject> getAllUser();
    
		 // 해당 요일에 진행되는 강의 목록 조회
	    List<AttendanceTimetable> getSubjectByDayOfWeek(String subDay);

	    // 해당 강의에 대해 지정된 시간 이후 결석한 학생들의 AttendanceID 조회
	    List<String> findAbsentAttendanceIdsBySubCodeAndEndTime(String subCode, LocalTime endTime);

	    // 해당 강의에 대해 수강하는 학생들의 UserID 조회
	    List<String> getStudentIdsBySubCode(String subCode);
	    
	    String getNameById(String userId);
	    

    }
