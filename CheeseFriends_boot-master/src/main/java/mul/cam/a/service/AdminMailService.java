package mul.cam.a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mul.cam.a.dao.AdminMailDao;
import mul.cam.a.dto.EducationDto;
import mul.cam.a.dto.ListParam;
import mul.cam.a.dto.MailDto;
import mul.cam.a.dto.MailParam;
import mul.cam.a.dto.TeacherUserDto;

@Service
@Transactional
public class AdminMailService {
	@Autowired
	AdminMailDao dao;
	
	public List<EducationDto> getEduMailList(ListParam param) {
		return dao.getEduMailList(param);
	}
	public List<TeacherUserDto> getIdMailList(ListParam param) {
		return dao.getIdMailList(param);
	}
	public List<TeacherUserDto> getEduIdMailList(String eduCode) {
		return dao.getEduIdMailList(eduCode);
	}
	public List<MailDto> sendMaillist(MailParam param) {
		return dao.sendMaillist(param);
	}
	public int getsendAllMail(MailParam param) {
		return dao.getsendAllMail(param);
	}
	public MailDto getSendMailDetail(String wdate) {
		return dao.getSendMailDetail(wdate);
	}
	public boolean deleteMail(String wdate) {
		int n = dao.deleteMail(wdate);
		return n>0?true:false;
	}
	public int getEduMaiAllList(ListParam param) {
		return dao.getEduMaiAllList(param);
	}
	public int getIdMailAllList(ListParam param) {
		return dao.getIdMailAllList(param);
	}
}
