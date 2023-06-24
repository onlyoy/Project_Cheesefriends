package mul.cam.a.controller;

import java.util.Date;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import mul.cam.a.dto.AdminAnswerDto;
import mul.cam.a.dto.AdminQuestionDto;
import mul.cam.a.dto.ListParam;
import mul.cam.a.service.AdminQnaService;

@RestController
public class AdminQnaController {
	
	@Autowired
	AdminQnaService service;
	
	@GetMapping(value="qnalist")
	public Map<String, Object> qnalist(ListParam param) {
		System.out.println("AdminQnaController qnalist()" + new Date());
		
		// 글의 시작과 끝 
		int pn = param.getPageNumber(); // 0 1 2 3 4
		int start = (pn * 15);
		int end = (pn + 1) * 15;
		
		param.setStart(start);
		param.setEnd(end);
		
		List<AdminQuestionDto> list = service.getQnaList(param);
		
		int len = service.getAllQna(param);
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("cnt", len);	// react에 보낼 때
		
		return map;
	}
	
	@GetMapping(value="getQna")
	public AdminQuestionDto getQna(Integer seq) {
		System.out.println("AdminQnaController getQna()" + new Date());
		
		return service.getQna(seq);
	}
	
	@GetMapping(value="getAnswer")
	public AdminAnswerDto getAnswer(Integer getQnaSeq) {
		System.out.println("AdminQnaController getAnswer()" + new Date());
		
		return service.getAnswer(getQnaSeq);
	}
	@PostMapping(value="answerWrite")
	public String answerWrite(AdminAnswerDto dto) {
		System.out.println("AdminQnaController answerWrite()" + new Date());
		
		boolean isS = service.answerWrite(dto);
		if(isS) {
			boolean ss = service.answerStatus(dto.getGetQnaSeq());
			System.out.println("여기는 넘어오나?");
			if(ss) {
				return "success";
				
			}
			return "fail";
			
		}else {
			return "fail";
		}
	}
	@PostMapping(value="answerUpdate")
	public String answerUpdate(AdminAnswerDto dto) {
		System.out.println("AdminQnaController answerUpdate()" + new Date());
		
		boolean isS = service.answerUpdate(dto);
		if(isS) {
			return "success";
		} else {
			return "fail";
		}
	}
}
