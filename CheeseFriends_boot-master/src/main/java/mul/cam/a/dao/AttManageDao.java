package mul.cam.a.dao;

import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mul.cam.a.dto.AttendanceEdu;
import mul.cam.a.dto.AttendanceSMSCheck;
import mul.cam.a.dto.CFR_Attendance;
import mul.cam.a.dto.SubjectDto;

@Repository
public class AttManageDao {
	
	 private final String NS = "AttManage.";

    @Autowired
    private SqlSession sqlSession;
	    
    public List<CFR_Attendance> getAttendanceList(String studentID, String subCode, String eduCode) {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("studentID", studentID);
        paramMap.put("subCode", subCode);
        paramMap.put("eduCode", eduCode);

        return sqlSession.selectList(NS + "getAttendanceList", paramMap);
    }

    public List<SubjectDto> getSubjectsByUserId(String userId) {
        return sqlSession.selectList(NS+ "getSubjectsByUserId", userId);
    }

    public List<CFR_Attendance> getAttendanceBySubjectCode(String subCode) {
    	  return sqlSession.selectList(NS+ "getAttendanceBySubjectCode", subCode);
      }

    public int updateAttendanceStatus(String attendanceID, String status) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("attendanceID", attendanceID);
        parameters.put("status", status);
        return sqlSession.update(NS+ "updateAttendanceStatus", parameters);
      }
    
    public int updateAttendancecomment(String attendanceID, String comment) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("attendanceID", attendanceID);
        parameters.put("comment", comment);
        return sqlSession.update(NS+"updateAttendancecomment", parameters);
      }

    public int updateUserSMSCheck(AttendanceSMSCheck SMSCheck) {
       return sqlSession.insert(NS+"updateUserSMSCheck", SMSCheck);
    }
    public int updateUserSMSCheckAbsent(AttendanceSMSCheck SMSCheckAbsent) {
        return sqlSession.insert(NS+"updateUserSMSCheckAbsent", SMSCheckAbsent);
     }
    
    public List<AttendanceSMSCheck> getAlarm(String userId) {
  	  return sqlSession.selectList(NS+ "getAlarm", userId);
    }
    public List<AttendanceSMSCheck> getAbsentAlarm(String userId) {
    	  return sqlSession.selectList(NS+ "getAbsentAlarm", userId);
      }
    public String getPhoneNumber(String userId) {
        return sqlSession.selectOne(NS+"getPhoneNumber", userId);
    }
    
    public List<String> findUserMinCheckTrue(){
    	return sqlSession.selectList(NS + "findUserMinCheckTrue" );
    }
    public List<String> findSubCodesByUserId(String userId){
    	return sqlSession.selectList(NS + "findSubCodesByUserId", userId);
    }
    
    public String findSubStartTimeBySubCode(String subCode, String displayName) {
        Map<String, Object> params = new HashMap<>();
        params.put("subCode", subCode);
        params.put("displayName", displayName);
        return sqlSession.selectOne(NS + "findSubStartTimeBySubCode", params);
    }


    public String findSubName(String subCode) {
    	return sqlSession.selectOne(NS + "findSubName" , subCode);
    }
    public Boolean findUserAbsentAlarmTrue(String studentId){
    	return sqlSession.selectOne(NS + "findUserAbsentAlarmTrue", studentId );
    }
    
    public String getStudentId(String userId) {
    	return sqlSession.selectOne(NS + "getStudentId" , userId);
    }
    public List<SubjectDto> getTeacherSubjectsByUserId(String userId) {
        return sqlSession.selectList(NS+ "getTeacherSubjectsByUserId", userId);
    }

	public List<AttendanceEdu> getEduByUserId(String userId) {
		return sqlSession.selectList(NS+"getEduByUserId", userId);
				
	}

}
