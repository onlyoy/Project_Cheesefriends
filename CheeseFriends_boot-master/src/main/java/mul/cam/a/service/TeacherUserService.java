package mul.cam.a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mul.cam.a.dao.TeacherUserDao;
import mul.cam.a.dto.ListParam;
import mul.cam.a.dto.TeacherUserDto;

@Service
@Transactional
public class TeacherUserService {
	
	@Autowired
	TeacherUserDao dao;
	
	public List<TeacherUserDto> getTeacherList(ListParam param){
		return dao.getTeacherList(param);
	}
	
	public int getAllTeacher(ListParam param) {
		return dao.getAllTeacher(param);
	}
	public TeacherUserDto getTeacher(String id) {
		return dao.getTeacher(id);
	}
	public List<TeacherUserDto> getTeacherSubList(String id) {
		return dao.getTeacherSubList(id);
	}
	public boolean teacherUpdate(TeacherUserDto teacher) {
		int n = dao.teacherUpdate(teacher);
		return n>0?true:false;
	}
	public boolean teacherDelete(String id) {
		int n = dao.teacherDelete(id);
		return n>0?true:false;
	}
}
