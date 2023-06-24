package mul.cam.a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mul.cam.a.dao.EducationDao;
import mul.cam.a.dto.AttendanceEdu;
import mul.cam.a.dto.CFR_User;
import mul.cam.a.dto.EducationDto;
import mul.cam.a.dto.ListParam;
import mul.cam.a.dto.MailDto;
import mul.cam.a.dto.MailParam;
import mul.cam.a.dto.TeacherUserDto;
import mul.cam.a.dto.UserDto;

@Service
@Transactional
public class EducationService {
	
	@Autowired
	EducationDao dao;
	
	public boolean eduAdd(EducationDto edu) {
		int n = dao.eduAdd(edu);
		return n>0?true:false;
	}
	public boolean eduAddAdmain(UserDto admin) {
		int n = dao.eduAddAdmain(admin);
		return n>0?true:false;
	}
	public boolean userEduAdd(EducationDto edu) {
		int n = dao.userEduAdd(edu);
		return n>0?true:false;
	}
	public boolean eduCodeCheck(String eduCode) {
		int n = dao.eduCodeCheck(eduCode);
		return n>0?true:false;
	}
	public boolean eduDuplicateCheck(EducationDto edu) {
		int n = dao.eduDuplicateCheck(edu);
		return n>0?true:false;
	}
	public List<EducationDto> getEduList(ListParam param) {
		return dao.getEduList(param);
	}
	public int getAllEdu(ListParam param) {
		return dao.getAllEdu(param);
	}
	public EducationDto getEdu(String eduCode) {
		return dao.getEdu(eduCode);
	}
	public boolean eduUpdate(EducationDto edu) {
		int n = dao.eduUpdate(edu);
		return n>0?true:false;
	}
	public boolean eduUpdateAdmin(EducationDto edu) {
		int n = dao.eduUpdateAdmin(edu);
		return n>0?true:false;
	}
	public boolean eduDelete(EducationDto edu) {
		int n = dao.eduDelete(edu);
		return n>0?true:false;
	}
	public List<EducationDto> homeEduCode(String id) {
		return dao.homeEduCode(id);
	}
	public int unreducedMail(String id) {
		return dao.unreducedMail(id);
	}
}



