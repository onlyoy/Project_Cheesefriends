package mul.cam.a.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import mul.cam.a.dto.LearningDto;
import mul.cam.a.dto.ListParam;
import mul.cam.a.dto.QnaDto;
import mul.cam.a.service.QnaService;

@RestController
public class QnaController {

	@Autowired
	QnaService service;
	
	@ResponseBody
	@GetMapping(value="qnalearninglist")
	
	public Map<String, Object> qnaList (ListParam param) {
		System.out.println("QnaController qnalist() " + new Date());
		
		int pn = param.getPageNumber();
		int start = (pn * 10);
		int end = (pn + 1) * 10;
		
		param.setStart(start);
		param.setEnd(end);
		
		List<QnaDto> list = service.qnaLearningList(param);
		
		int len = service.getAllQna(param);
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("cnt", len);
		
		return map;
	}
	
	@ResponseBody
	@PostMapping(value="writeQna")
	public String writeQna(QnaDto bbs) {
		System.out.println("QnaController writeQna() " + new Date());
		
		boolean b = service.writeQna(bbs);
		
		if(b == false) {
			return "NO";
		}
		
		return "YES";
	}
	
	@ResponseBody
	@GetMapping(value = "getLearningQna")
	public QnaDto getLearningQna(Integer seq) {
		System.out.println("QnaController getLearningQna " + new Date());
		
		return service.getLearningQna(seq);
	}
	
	@ResponseBody
	@PostMapping (value="answerQna")
	public String answerQna(QnaDto bbs) {
		System.out.println("QnaController answerQna " + new Date());
		
		boolean b = service.answerQna(bbs);
		if(b == false) {
			return "NO";
		}
		return "YES";
	}
	

	
}
