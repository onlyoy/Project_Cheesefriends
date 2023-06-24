package mul.cam.a.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import mul.cam.a.dto.ListParam;
import mul.cam.a.dto.SubjectDto;
import mul.cam.a.dto.TeacherUserDto;
import mul.cam.a.service.TeacherUserService;

@RestController
public class TeacherUserController {
	
	@Autowired
	TeacherUserService service;
	
	@GetMapping(value="teacherlist")
	public Map<String, Object> teacherlist(ListParam param) {
		System.out.println("TeacherUserController teacherlist()" + new Date());
		
		// 글의 시작과 끝 
		int pn = param.getPageNumber(); // 0 1 2 3 4
		System.out.println(pn);
		int start = (pn * 15);
		int end = (pn + 1) * 15;
		
		param.setStart(start);
		param.setEnd(end);
		
		System.out.println(start);
		System.out.println(end);
		List<TeacherUserDto> list = service.getTeacherList(param);
		
		int len = service.getAllTeacher(param);
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("cnt", len);	// react에 보낼 때
		
		return map;
	}
	@GetMapping(value="getTeacher")
	public TeacherUserDto getTeacher(String id) {
		System.out.println("TeacherUserController getTeacher()" + new Date());
		
		return service.getTeacher(id);
	}
	@GetMapping(value="getTeacherSubList")
	public List<TeacherUserDto> getTeacherSubList(String id) {
		System.out.println("TeacherUserController getTeacherSubList()" + new Date());
		
		List<TeacherUserDto> teacherSub = service.getTeacherSubList(id);
		return teacherSub;
	}
	@PostMapping(value="teacherUpdate")
	public String teacherUpdate(TeacherUserDto teacher) {
		System.out.println("TeacherUserController teacherUpdate()" + new Date());
				
		boolean isS = service.teacherUpdate(teacher);
		
		if(isS) {
			return "success";
		}
		return "fail";
	}
	@PostMapping(value="teacherDelete")
	public String teacherUpdate(String id) {
		System.out.println("TeacherUserController teacherDelete()" + new Date());
				
		boolean isS = service.teacherDelete(id);
		
		if(isS) {
			return "success";
		}
		return "fail";
	}
}
