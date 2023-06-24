package mul.cam.a.dao.impl;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mul.cam.a.dao.CFR_AttendanceDao;
import mul.cam.a.dto.AttendanceSearch;
import mul.cam.a.dto.AttendanceSubject;
import mul.cam.a.dto.AttendanceTimetable;
import mul.cam.a.dto.CFR_Attendance;
import mul.cam.a.dto.CFR_User;

@Repository
public class CFR_AttendanceDaoImpl implements CFR_AttendanceDao {

    private final String NS = "CFR.";

    @Autowired
    private SqlSession sqlSession;

    @Override
    public CFR_Attendance getAttendanceById(int attendanceID) {
        return sqlSession.selectOne(NS + "getAttendanceById", attendanceID);
    }

    @Override
    public List<String> getAllAttendances(String subCode) {
        return sqlSession.selectList(NS + "getAllAttendances", subCode);
    }

    @Override
    public void addAttendance(CFR_Attendance attendance) {
        sqlSession.insert(NS + "addAttendance", attendance);
    }

    @Override
    public void updateAttendance(CFR_Attendance attendance) {
        sqlSession.update(NS + "updateAttendance", attendance);
    }

    @Override
    public void deleteAttendance(int attendanceID) {
        sqlSession.delete(NS + "deleteAttendance", attendanceID);
    }
    
    @Override
    public List<AttendanceTimetable> getSubjectByUserIdAndEduCode(String userId, String eduCode, String subCode) {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("userId", userId);
        paramMap.put("eduCode", eduCode);
        paramMap.put("subCode", subCode);
        
        return sqlSession.selectList(NS + "getSubjectByUserIdAndEduCode", paramMap);
    }

    @Override
    public void checkAttendance(CFR_Attendance attendance) {
        sqlSession.insert(NS + "checkAttendance", attendance);
    }

    @Override
    public List<String> findAttendanceIdsByStudentAndSubject(String studentId, String subCode, String eduCode) {
    	 Map<String, String> paramMap = new HashMap<>();
         paramMap.put("studentId", studentId);
         paramMap.put("eduCode", eduCode);
         paramMap.put("subCode", subCode);
         
         return sqlSession.selectList(NS + "findAttendanceIdsByStudentAndSubject", paramMap);
    }
    
    @Override
    public List<AttendanceSubject> getAllSubjects() {
        return sqlSession.selectList(NS + "getAllSubjects");
    }

	@Override
	public List<AttendanceSubject> getAllUser() {
		 return sqlSession.selectList(NS + "getAllUser");
	}

	 @Override
	    public List<AttendanceTimetable> getSubjectByDayOfWeek(String subDay) {
	        return sqlSession.selectList(NS + "getSubjectByDayOfWeek", subDay);
	    }

	    @Override
	    public List<String> findAbsentAttendanceIdsBySubCodeAndEndTime(String subCode, LocalTime endTime) {
	        return sqlSession.selectList(NS + "findAbsentAttendanceIdsBySubCodeAndEndTime", new AttendanceSearch(subCode, endTime));
	    }

	    @Override
	    public List<String> getStudentIdsBySubCode(String subCode) {
	        return sqlSession.selectList(NS + "getStudentIdsBySubCode", subCode);
	    }

		@Override
		public String getNameById(String userId) {
			String name = sqlSession.selectOne(NS + "getNameById", userId);
			 CFR_User user = new CFR_User();
		        user.setName(name);
		        return user.getName();
		}


		}
    

