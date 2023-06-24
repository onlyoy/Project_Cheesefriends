package mul.cam.a.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mul.cam.a.dao.SubjectDao;
import mul.cam.a.dto.ListParam;
import mul.cam.a.dto.SubjectDto;
import mul.cam.a.dto.UserDto;

@Service
@Transactional
public class SubjectService {
	
	@Autowired
	SubjectDao dao;
	//
	public List<SubjectDto> getSubList(ListParam param) {
		return dao.getSubList(param);
	}
	public int getAllSub(ListParam param) {
		return dao.getAllSub(param);
	}
	public SubjectDto getSub(String subCode) {
		return dao.getSub(subCode);
	}
	public boolean subUpdate(SubjectDto sub) {
		int n = dao.subUpdate(sub);
		return n>0?true:false;
	}
	public boolean subDelete(String subCode) {
		int n = dao.subDelete(subCode);
		return n>0?true:false;
	}
	public List<UserDto> getIdList(String auth) {
		return dao.getIdList(auth);
	}
	public boolean subAdd(SubjectDto sub) {
		int n = dao.subAdd(sub);
		return n>0?true:false;
	}
	public List<SubjectDto> getTSubList(String teacher) {
		return dao.getTSubList(teacher);
	}
	public SubjectDto getTSub(String subCode) {
		return dao.getTSub(subCode);
	}
	public boolean subCodeCheck(String subCode) {
		int n = dao.subCodeCheck(subCode);
		return n>0?true:false;
	}
	public boolean subDuplicateCheck(SubjectDto sub) {
		int n = dao.subDuplicateCheck(sub);
		return n>0?true:false;
	}
}