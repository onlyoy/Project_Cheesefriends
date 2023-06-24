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
import mul.cam.a.dto.UserDto;
import mul.cam.a.service.SubjectService;
import mul.cam.a.util.RandomCode;

@RestController
public class SubjectController {
	
	@Autowired
	SubjectService service;
	
	@GetMapping(value="sublist")
	public Map<String, Object> sublist(ListParam param) {
		System.out.println("SubjectController sublist()" + new Date());
		
		// 글의 시작과 끝 
		int pn = param.getPageNumber(); // 0 1 2 3 4
		int start = (pn * 15);
		int end = (pn + 1) * 15;
		
		param.setStart(start);
		param.setEnd(end);
		
		List<SubjectDto> list = service.getSubList(param);
		
		int len = service.getAllSub(param);
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("cnt", len);	// react에 보낼 때
		
		return map;
	}
	@GetMapping(value="getSub")
	public SubjectDto getSub(String subCode) {
		System.out.println("SubjectController getSub()" + new Date());
		
		return service.getSub(subCode);
	}
	@PostMapping(value="subUpdate")
	public String subUpdate(SubjectDto sub) {
		System.out.println("SubjectController subUpdate()" + new Date());
		
		boolean isS = service.subUpdate(sub);
		
		if(isS) {
			return "success";
		}
		return "fail";
	}
	@PostMapping(value="subDelete")
	public String subDelete(String subCode) {
		System.out.println("SubjectController subDelete()" + new Date());
				
		boolean isS = service.subDelete(subCode);
		
		if(isS) {
			return "success";
		}
		return "fail";
	}
	@GetMapping(value="getIdList")
	public List<UserDto> getIdList(String auth) {
		System.out.println("SubjectController getIdList()" + new Date());
		
		List<UserDto> teacher = service.getIdList(auth);
		return teacher;
	}
	@PostMapping(value="subAdd")
	public String subAdd(SubjectDto sub) {
		System.out.println("SubjectController getIdList()" + new Date());
		System.out.println(sub.toString());
		// 이미 등록된 과목인지 확인
		boolean duplicate = service.subDuplicateCheck(sub);
		if(duplicate) {
			return "duplicate";
		}
		// 과목코드 생성
		String subCode = new RandomCode().subCode();
		boolean subCodeChk = service.subCodeCheck(subCode);
		
		// 중복코드있으면 다시생성
		while(subCodeChk) {
			subCode = new RandomCode().subCode();
			subCodeChk = service.subCodeCheck(subCode);
		}
		// 과목코드 삽입
		sub.setSubCode(subCode);
		boolean isS = service.subAdd(sub);
		if(isS) {
			return "success";
		}else {
			return "fail";
		}
	}
	
	@GetMapping(value="getTSubList")
	public List<SubjectDto> getTSubList(String teacher) {
		System.out.println("SubjectController getTSubList()" + new Date());
		List<SubjectDto> sublist = service.getTSubList(teacher);
		return sublist;
	}
	
	@GetMapping(value="getTSub")
	public SubjectDto getTSub(String subCode) {
		System.out.println("SubjectController getTSub()" + new Date());
		
		return service.getTSub(subCode);
	}
	
}