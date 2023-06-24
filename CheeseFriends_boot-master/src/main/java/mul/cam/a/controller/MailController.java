package mul.cam.a.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import mul.cam.a.MediaTypeUtiles;
import mul.cam.a.dto.EducationDto;
import mul.cam.a.dto.MailDto;
import mul.cam.a.dto.MailParam;
import mul.cam.a.dto.TestEduDto;
import mul.cam.a.dto.UserDto;
import mul.cam.a.service.MailService;

@RestController
public class MailController {

	@Autowired
	MailService service;
	
		// 쪽지 보내기
	// 메일 받는사람 검색
	@GetMapping(value = "mailreceiverid")
	public Map<String, Object> mailreceiverid(String name){
		System.out.println("MailController mailreceiverid() " + new Date());
		
		List<UserDto> list = service.mailreceiverid(name);
		
		System.out.println(list.toString());
		
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		
		return map;
	}
	
	// 메일 받는사람 추가
	@GetMapping(value = "mailreceiveradd")
	public UserDto mailreceiveradd(String id){
		System.out.println("MailController mailreceiveradd() " + new Date());
		
		UserDto dto = service.mailreceiveradd(id);
		
		System.out.println(dto.toString());
		
		return dto;
	}
	
	// 메일 보내기
	@PostMapping(value = "mailsend")
	public String mailsend(MailDto dto) {
		System.out.println("MailController mailsend() " + new Date());
		
		boolean isS = service.mailsend(dto);
		if(isS == true) {
			return "YES";
		}
			
		return "NO";
	}
	
	// 업로드
	@PostMapping(value = "mailfile")
	public String fileUpload(@RequestParam("uploadFile")MultipartFile uploadFile, 
								HttpServletRequest req) {		
		System.out.println("MailController filemail " + new Date());
		
		String uploadpath = req.getServletContext().getRealPath("/mailfile");
		
		String filename = uploadFile.getOriginalFilename();
		String filepath = uploadpath + "/" + filename;		
		System.out.println(filepath);

		
		try {
			BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(new File(filepath)));
			os.write(uploadFile.getBytes());
			os.close();
			
		} catch (Exception e) {			
			e.printStackTrace();
			return "fail";
		}

		return "success";
	}
	
	// 단체 메일 보내기
	// 교육기관 검색
	@GetMapping(value = "eduselect")
	public List<EducationDto> eduselect(String id) {
		System.out.println("MailController eduselect() " + new Date());
		
		List<EducationDto> list = service.eduselect(id);
		
		if(list != null) {
			System.out.println(list.toString());
		}
		return list;
	}
	
	// 과목 검색
	@GetMapping(value = "subselect")
	public List<TestEduDto> subselect(EducationDto dto) {
		System.out.println("MailController subselect() " + new Date());
		
		List<TestEduDto> list = service.subselect(dto);
		
		if(list != null) {
			System.out.println(list.toString());
		}
		return list;
	}
	
	// 수강생 리스트
	@GetMapping(value = "userlist")
	public Map<String, Object> userlist(TestEduDto dto){
		System.out.println("MailController userlist() " + new Date());
		
		List<UserDto> list = service.userlist(dto);
		
		if(list != null) {
			System.out.println(list.toString());
		}
		
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		
		return map;
	}
	@GetMapping(value = "userlisttwo")
	public Map<String, Object> userlisttwo(TestEduDto dto){
		System.out.println("MailController userlisttwo() " + new Date());
		
		List<UserDto> list = service.userlisttwo(dto);
		
		if(list != null) {
			System.out.println(list.toString());
		}
		
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		
		return map;
	}
	
	
		// 받은 쪽지함
	// 쪽지 리스트
	@GetMapping(value = "receivemaillist")
	public Map<String, Object> receivemaillist(MailParam param){
		System.out.println("MailController receivemaillist() " + new Date());
		
		// 글의 시작과 끝
		int pn = param.getPageNumber();  // 0 1 2 3 4
		int start = pn * 10;	// 1  11
		int end = (pn + 1) * 10;	// 10 20 
		
		param.setStart(start);
		param.setEnd(end);
		
		List<MailDto> list = service.receivemaillist(param)
				.stream()
				.skip(param.getStart())
				.limit(10)
				.collect(Collectors.toList());
		
		System.out.println(param.toString());
		System.out.println(list.toString());
		
		int len = service.getallmail(param);
		
		System.out.println("len :" + len);
		
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("cnt", len);

		return map;
	}
	
	// 받은 쪽지 디테일
	@GetMapping(value = "getmail")
	public MailDto getmail(int seq) {
		MailDto dto = service.getmail(seq);
		int count = service.readcountup(seq);
		
		System.out.println(dto.toString());
		
		return dto;
	}
	
	// download
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping(value = "fileDownload")
	public ResponseEntity<InputStreamResource> download(String filename, HttpServletRequest req) throws Exception {
		System.out.println("MailController download " + new Date());
		
		// 경로
		String path = req.getServletContext().getRealPath("/mailfile");
		// String path = "c:\temp";
		
		MediaType mediaType = MediaTypeUtiles.getMediaTypeForFileName(this.servletContext, filename);
		System.out.println("filename:" + filename);
		System.out.println("mediaType:" + mediaType);
		
		File file = new File(path + File.separator + filename);		// newfilename
		
		InputStreamResource isr = new InputStreamResource(new FileInputStream(file));
		
		// db 다운로드 카운트
		
		return ResponseEntity.ok()
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName()) // 원본파일명
					.contentType(mediaType)
					.contentLength(file.length())
					.body(isr);					
	}
	
	
	// 메일 삭제
	@GetMapping(value = "receivedeleteMail")
	public String receivedeleteMail(int seq) {
		System.out.println("MailController receivedeleteMail " + new Date());
		
		boolean isS = service.receivedeleteMail(seq);
		
		if(isS) {
			return "YES";
		}else {
			return "NO";
		}
	}
	
		// 보낸 쪽지함
	// 쪽지 리스트
	@GetMapping(value = "sendmaillist")
	public Map<String, Object> sendmaillist(MailParam param){
		System.out.println("MailController sendmaillist() " + new Date());
		
		// 글의 시작과 끝
		int pn = param.getPageNumber();  // 0 1 2 3 4
		int start = pn * 10;	// 1  11
		int end = (pn + 1) * 10;	// 10 20 
		
		param.setStart(start);
		param.setEnd(end);
		
		List<MailDto> list = service.sendmaillist(param)
				.stream()
				.skip(param.getStart())
				.limit(10)
				.collect(Collectors.toList());
		
		System.out.println(param.toString());
		System.out.println(list.toString());
		
		int len = service.getsendallmail(param);
		
		System.out.println("len :" + len);
		
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("cnt", len);

		return map;
	}
	
	// 메일 삭제
	@GetMapping(value = "senddeleteMail")
	public String senddeleteMail(int seq) {
		System.out.println("MailController senddeleteMail " + new Date());
		
		boolean isS = service.senddeleteMail(seq);
		
		if(isS) {
			return "YES";
		}else {
			return "NO";
		}
	}
	
	// 보낸 쪽지 디테일
	@GetMapping(value = "getsendmail")
	public MailDto getsendmail(int seq) {
		MailDto dto = service.getmail(seq);
		
		System.out.println(dto.toString());
		
		return dto;
	}
	
	
}



