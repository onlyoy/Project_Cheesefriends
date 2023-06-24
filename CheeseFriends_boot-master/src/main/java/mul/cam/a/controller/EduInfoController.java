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

import mul.cam.a.dto.EduInfoDto;

import mul.cam.a.dto.ListParam;
import mul.cam.a.service.EduInfoService;

@RestController
public class EduInfoController {
	
	@Autowired
	EduInfoService service;

	@GetMapping(value="eduInfoList")
	public Map<String, Object> eduInfoList(ListParam param) {
		 System.out.println("EduInfoController eduInfoList " + new Date());
		
		// 글의 시작과 끝 
				int pn = param.getPageNumber(); // 0 1 2 3 4
				int start = (pn * 6);
				int end = (pn + 1) * 6;
				
				param.setStart(start);
				param.setEnd(end);
				
				List<EduInfoDto> list = service.eduInfoList(param);
				
				int len = service.getAllEduInfo(param);
				Map<String, Object> map = new HashMap<>();
				map.put("list", list);
				map.put("cnt", len);	
				
				return map;
		}
	
	@PostMapping(value="writeEduInfo")
	public String writeEduInfo(EduInfoDto dto) {
		System.out.println("EduInfoController writeEduInfo " + new Date());
		
		boolean b = service.writeEduInfo(dto);
		
		if(b == false) {
			return "NO";
		}
		
		return "YES";
	}
	
	@GetMapping(value="getEduInfo")
	public EduInfoDto getEduInfo(Integer seq) {
		System.out.println("EduInfoController getEduInfo "  + new Date());
		
		return service.getEduInfo(seq);
	}
}
