package mul.cam.a.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import mul.cam.a.dto.GradeDto;
import mul.cam.a.dto.SortParam;
import mul.cam.a.dto.SubjectDto;
import mul.cam.a.service.GradeManageService;

@RestController
public class GradeManageController {
	
	@Autowired
	GradeManageService service;
	
	@GetMapping(value="subTeacherList")
	public List<SubjectDto> subTeacherList(String teacher) {
		System.out.println("GradeManageController subTeacherList()" + new Date());
//		System.out.println(teacher);
		return service.subTeacherlist(teacher);
	}
	
	@PostMapping(value="gradeAdd")
	public String gradeAdd(@RequestParam(value="data", required=false)String data) throws Exception{
		System.out.println("GradeManageController subStudentList()" + new Date());
		System.out.println(data);
		
		//String json = data.get("data").toString();
		ObjectMapper mapper = new ObjectMapper();
		
		List<GradeDto> list = mapper.readValue(data, new TypeReference<ArrayList<GradeDto>>(){});
		
		for(GradeDto dto : list) {
			System.out.println(dto.toString());
		}
		
		System.out.println(list.get(0).getSubCode());
		// 성적 이미입력되었는지 확인
//		boolean duplicate = service.gradeDuplicate(list);
//		if(duplicate) {
//			return "duplicate";
//		}
		
		boolean isS = service.gradeAdd(list);
		if(isS) {
			
			return "success";
	
		}else {
			return "fail";
		}
	}
	@GetMapping(value="gradeRanks")
	public List<GradeDto> gradeRanks(SortParam param){
		System.out.println("GradeManageController gradeRanks()" + new Date());
		
		return service.gradeRanks(param);
	}
	
	@PostMapping(value="gradeUpdate")
	public String gradeUpdate(@RequestParam(value="data", required=false)String data) throws Exception{
		System.out.println("GradeManageController gradeUpdate()" + new Date());
		System.out.println(data);
		
		//String json = data.get("data").toString();
		ObjectMapper mapper = new ObjectMapper();
		
		List<GradeDto> list = mapper.readValue(data, new TypeReference<ArrayList<GradeDto>>(){});
		
		for(GradeDto dto : list) {
			System.out.println(dto.toString());
		}
		
		boolean isS = service.gradeUpdate(list);
		if(isS) {
			
			return "success";
	
		}else {
			return "fail";
		}
	}
}
