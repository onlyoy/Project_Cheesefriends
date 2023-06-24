package mul.cam.a.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import mul.cam.a.dto.EducationDto;
import mul.cam.a.dto.ListParam;
import mul.cam.a.dto.MailDto;
import mul.cam.a.dto.MailParam;
import mul.cam.a.dto.TeacherUserDto;
import mul.cam.a.service.AdminMailService;

@RestController
public class AdminMailController {
	
	@Autowired
	AdminMailService service;
	
	@GetMapping(value="getEduMailList")
	public Map<String, Object> getEduMailList(ListParam param) {
		System.out.println("AdminMailController getEduMailList()" + new Date());
		// 글의 시작과 끝 
		int pn = param.getPageNumber(); // 0 1 2 3 4
		System.out.println(pn);
		pn = pn-1;
		System.out.println(pn);
		int start = pn * 10;
		int end = (pn + 1) * 10;
		
		param.setStart(start);
		param.setEnd(end);
		
		System.out.println(param.getStart());
		System.out.println(param.getEnd());
		List<EducationDto> list = service.getEduMailList(param);
		
		int len = service.getEduMaiAllList(param);
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("cnt", len);	// react에 보낼 때
		
		return map;
	}
	@GetMapping(value="getIdMailList")
	public Map<String, Object> getIdMailList(ListParam param) {
		System.out.println("AdminMailController getIdMailList()" + new Date());
		
		int pn = param.getPageNumber(); // 0 1 2 3 4
		System.out.println(pn);
		pn = pn-1;
		System.out.println(pn);
		int start = pn * 10;
		int end = (pn + 1) * 10;
		
		param.setStart(start);
		param.setEnd(end);
		System.out.println(param.toString());
		System.out.println(param.getEnd());
		List<TeacherUserDto> list = service.getIdMailList(param);
		System.out.println(list.toString());
		
		int len = service.getIdMailAllList(param);
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("cnt", len);	// react에 보낼 때
		
		return map;
	}
	@GetMapping(value="getEduIdMailList")
	public List<TeacherUserDto> getEduIdMailList(String eduCode) {
		System.out.println("AdminMailController getEduIdMailList()" + new Date());
		System.out.println(eduCode);
		List<TeacherUserDto> id = service.getEduIdMailList(eduCode);
		System.out.println(id.toString());
		return id;
	}
	@GetMapping(value="sendMaillist")
	public Map<String, Object> sendMaillist(MailParam param) {
		System.out.println("AdminMailController sendMaillist()" + new Date());
		// 글의 시작과 끝
		int pn = param.getPageNumber();  // 0 1 2 3 4
		System.out.println(pn);
		int start = pn * 12;	// 1  11
		int end = (pn + 1) * 12;	// 10 20 
		
		param.setStart(start);
		param.setEnd(end);

		List<MailDto> list = service.sendMaillist(param);
		
		System.out.println(param.toString());
		System.out.println(list.toString());
		
		int len = service.getsendAllMail(param);
		
		System.out.println("len :" + len);
		
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("cnt", len);

		return map;

	}
	@GetMapping(value="getSendMailDetail")
	public MailDto getSendMailDetail(String wdate) {
		System.out.println("AdminMailController sendMaillist()" + new Date());
		System.out.println(wdate);
		MailDto mail = service.getSendMailDetail(wdate);
		System.out.println(mail.toString());
		return mail;
	}
	@PostMapping(value="deleteMail")
	public String deleteMail(String wdate) {
		
		boolean isS = service.deleteMail(wdate);
		
		if(isS) {
			return "success";
		}
		return "fail";
	}
}
