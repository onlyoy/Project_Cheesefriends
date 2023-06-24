package mul.cam.a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mul.cam.a.dao.AttManageDao;
import mul.cam.a.dto.AttendanceEdu;
import mul.cam.a.dto.AttendanceSMSCheck;
import mul.cam.a.dto.CFR_Attendance;
import mul.cam.a.dto.SubjectDto;

@Service
public class AttManageService {
    
	@Autowired
	private AttManageDao attManageDao;

    public List<CFR_Attendance> getAttendanceList(String studentID, String subCode, String eduCode) {
        return attManageDao.getAttendanceList(studentID, subCode, eduCode);
    }
    
    public List<SubjectDto> getSubjectsByUserId(String userId) {
        return attManageDao.getSubjectsByUserId(userId);
    }
    public List<AttendanceEdu> getEduByUserId(String userId) {
        return attManageDao.getEduByUserId(userId);
    }
    
    public List<CFR_Attendance> getAttendanceBySubjectCode(String subCode) {
    	return attManageDao.getAttendanceBySubjectCode(subCode);
}
    @Transactional
    public int updateAttendanceStatus(String attendanceID, String status) {
        return attManageDao.updateAttendanceStatus(attendanceID, status);
    }
    
    @Transactional
    public int updateAttendancecomment(String attendanceID, String comment) {
        return attManageDao.updateAttendancecomment(attendanceID, comment);
    }
    
    public int updateUserSMSCheck(AttendanceSMSCheck SMSCheck) {
    	return attManageDao.updateUserSMSCheck(SMSCheck);
    }
    public int updateUserSMSCheckAbsent(AttendanceSMSCheck SMSCheckAbsent) {
    	return attManageDao.updateUserSMSCheckAbsent(SMSCheckAbsent);
    }
    
    public List<AttendanceSMSCheck> getAlarm(String userId) {
    	return attManageDao.getAlarm(userId);
}
    public List<AttendanceSMSCheck> getAbsentAlarm(String userId) {
    	return attManageDao.getAbsentAlarm(userId);
}
    public String getPhoneNumber(String userId) {
        return attManageDao.getPhoneNumber(userId);
    }

	public List<String> findUserMinCheckTrue() {
		 return attManageDao.findUserMinCheckTrue();
	}
	public List<String> findSubCodesByUserId(String userId){
		return attManageDao.findSubCodesByUserId(userId);
	}
	public String findSubStartTimeBySubCode(String subCode, String displayName){
		return attManageDao.findSubStartTimeBySubCode(subCode, displayName);
	}
	public String findSubName(String subCode) {
		return attManageDao.findSubName(subCode);
	}
	public Boolean findUserAbsentAlarmTrue(String studentId) {
		 return attManageDao.findUserAbsentAlarmTrue(studentId);
	}
	
	public String getStudentId(String userId) {
		return attManageDao.getStudentId(userId);
	}
	
    public List<SubjectDto> getTeacherSubjectsByUserId(String userId) {
        return attManageDao.getTeacherSubjectsByUserId(userId);
    }
}

