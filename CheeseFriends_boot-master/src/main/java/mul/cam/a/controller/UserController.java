package mul.cam.a.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import mul.cam.a.dto.EduInfoDto;
import mul.cam.a.dto.EducationDto;
import mul.cam.a.dto.GradeDto;
import mul.cam.a.dto.LearningDto;
import mul.cam.a.dto.LectureDto;
import mul.cam.a.dto.MailParam;
import mul.cam.a.dto.MypageStudentDto;
import mul.cam.a.dto.MysubjectDto;
import mul.cam.a.dto.SearchGradeDto;
import mul.cam.a.dto.SortParam;
import mul.cam.a.dto.TaskDto;

import mul.cam.a.dto.TestEduDto;
import mul.cam.a.dto.UserDto;
import mul.cam.a.dto.UserparentsDto;
import mul.cam.a.service.EduInfoService;
import mul.cam.a.service.LearningService;
import mul.cam.a.service.LectureService;
import mul.cam.a.service.TaskService;
import mul.cam.a.service.UserService;
import mul.cam.a.util.naver2;

@RestController
public class UserController {

	@Autowired
	UserService service;
	@Autowired
	LectureService lecservice;
	@Autowired
	TaskService taskservice;
	@Autowired
	EduInfoService eduservice;
	@Autowired
	LearningService learnservice;
	
	@PostMapping(value = "idcheck")
	public String idcheck(String id) {
		System.out.println("UserController idcheck() " + new Date());
		
		System.out.println("id: " + id);
		
		boolean isS = service.idcheck(id);
		if(isS == true) {
			return "NO";
		}
		
		return "YES";
	}
	
	@GetMapping(value = "subjectlist")
	public List<TestEduDto> subjectlist(String edu_code){
		System.out.println("UserController subjectlist() " + new Date());
		
		List<TestEduDto> list = service.subjectlist(edu_code);
		
		System.out.println(list.toString());
		
		return list;
		
	}
	
	@GetMapping(value = "eduname")
	public String eduname(String edu_code){
		System.out.println("UserController eduname() " + new Date());
		
		String eduname = service.eduname(edu_code);
		
		System.out.println("eduname : " + eduname);
		
		return eduname;
	}
	
	@GetMapping(value = "subname")
	public String subname(String sub_code){
		System.out.println("UserController subname() " + new Date());
		System.out.println("subcode : " + sub_code );
		
		String subname = service.subname(sub_code);
		
		System.out.println("subname : " + subname);
		
		return subname;
	}
	
	@PostMapping("phoneAuth")
	public String phoneAuth(String phone, HttpSession session) {
		System.out.println("UserController phoneAuth() " + new Date());
//	    try { // 이미 가입된 전화번호가 있으면
//	        if(UserService.memberTelCount(tel) > 0) 
//	            return true; 
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	    }
		System.out.println("phone : " + phone);
		
	    String code = service.sendRandomMessage(phone);
	    System.out.println("code : " + code);
	    
	    session.setAttribute("rand", code);
	    String rand = (String)session.getAttribute("rand");
	    System.out.println("rand : " + rand);
	    
	    return rand;
	}

	@PostMapping("phoneAuthOk")
	public Boolean phoneAuthOk(String phone_public, HttpSession session) {
		System.out.println("UserController phoneAuthOk() " + new Date());
		
	    String rand = (String)session.getAttribute("rand");
	    String code = phone_public;

	    System.out.println(rand + " 비교: " + code);

	    if (rand.equals(code)) {
	        session.removeAttribute("rand");
	        return false;
	    } 

	    return true;
	}
	
	
	@PostMapping(value = "fileUpload")	
	public String fileUpload(@RequestParam("uploadFile")MultipartFile uploadFile, LectureDto dto, LearningDto bbs, HttpServletRequest req,
			TaskDto tts, EduInfoDto edu) {	
		System.out.println("UserController fileUpload " + new Date());
		System.out.println(bbs.toString());
		System.out.println(dto.toString());
		
		String uploadpath = req.getServletContext().getRealPath("/mailfile");
		
		String filename = uploadFile.getOriginalFilename();
		String filepath = uploadpath + "/" + filename;		
		System.out.println(filepath);
				
		try {
			
			BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(new File(filepath)));
			os.write(uploadFile.getBytes());
			os.close();
			
			 bbs.setFilename(filename);

			 dto.setFilename(filename);
			 
			 tts.setFilename(filename);
			 
			 edu.setFilename(filename);
			 
			 System.out.println(dto.toString());
			 lecservice.writeLecture(dto);
			 taskservice.writeTask(tts);
			 eduservice.writeEduInfo(edu);
			 learnservice.writeLearning(bbs);			
		
		} catch (Exception e) {			
			e.printStackTrace();
			return "fail";
		}

		return "success";
	}	
	
	@PostMapping(value = "adduser")
	public String addmember(UserDto dto) {
		System.out.println("UserController addmember() " + new Date());
		
		boolean isS = service.adduser(dto);
		if(isS == true) {
			return "YES";
		}
			
		return "NO";
	}
	
	@PostMapping(value = "addusersubject")
	public String addusersubject(TestEduDto dto) {
		System.out.println("UserController addusersubject() " + new Date());
		
		boolean isS = service.addusersubject(dto);
		if(isS == true) {
			return "YES";
		}
			
		return "NO";
	}
	
	@PostMapping(value = "educodematching")
	public String educodematching(String sub_code) {
		System.out.println("UserController educodematching() " + new Date());
		
		String s = service.educodematching(sub_code);
		System.out.println("Educode : " + s);
	
		return s;
	}
	
	// 학부모 가입
	@GetMapping(value = "idmatching")
	public UserDto idmatching(String studentid){
		System.out.println("UserController idmatching() " + new Date());
		
		UserDto dto = service.idmatching(studentid);
		
		if(dto != null) {
			System.out.println(dto.getId());
			System.out.println(dto.getName());
		}
		return dto;
	}
	
	@PostMapping(value = "studentidmatching")
	public String studentidmatching(String studentid){
		System.out.println("UserController studentidmatching() " + new Date());
		
		boolean isS = service.studentidmatching(studentid);
		if(isS == true) {
			return "NO";
		}
		
		return "YES";
	}
	
	@PostMapping(value = "adduserparents")
	public String adduserparents(UserparentsDto dto) {
		System.out.println("UserController addmember() " + new Date());
		
		boolean isS = service.adduserparents(dto);
		if(isS == true) {
			return "YES";
		}
			
		return "NO";
	}
	
	// 교사 가입
	@GetMapping(value = "edusearch")
	public List<EducationDto> edusearch(String edu_name) {
		System.out.println("UserController edusearch() " + new Date());
		
		List<EducationDto> list = service.edusearch(edu_name);
		
		if(list != null) {
			System.out.println(list.toString());
		}
		return list;
	}
	
	@PostMapping(value = "adduseredu")
	public String adduseredu(TestEduDto dto) {
		System.out.println("UserController adduseredu() " + new Date());
		
		boolean isS = service.adduseredu(dto);
		if(isS == true) {
			return "YES";
		}
			
		return "NO";
	}
	
	@PostMapping(value = "addusereducheck")
	public String addusereducheck(TestEduDto dto) {
		System.out.println("UserController addusereducheck() " + new Date());
		System.out.println(dto.toString());
		
		EducationDto dtocheck = service.addusereducheck(dto);
		
		if(dtocheck != null) {
			System.out.println("dtocheck : notnull");
			return "NO";
		}else {
			System.out.println("dtocheck : null");
			service.adduseredu(dto);
			return "YES";
		}
		
	}
	
	
	@PostMapping(value = "idsearch")
	public UserDto idsearch(UserDto dto) {
		System.out.println("UserController idsearch() " + new Date());
		
		UserDto getdto = service.idsearch(dto);
		System.out.println(getdto);
		
		if(getdto == null) {
			return null;
		}
		
		return getdto;
	}
	
	@PostMapping(value = "idchecktwo")
	public String idchecktwo(UserDto dto) {
		System.out.println("UserController idcheck() " + new Date());
		
		boolean isS = service.idchecktwo(dto);
		if(isS == true) {
			return "NO";
		}
		
		return "YES";
	}
	
	
	@PostMapping(value = "updatepassword")
	public String updatepassword(UserDto dto) {
		System.out.println("UserController updatepassword() " + new Date());
		
		boolean isS = service.updatepassword(dto);
		if(isS == true) {
			return "YES";
		}
			
		return "NO";
	}
	
	@PostMapping(value = "login")
	public UserDto login(UserDto dto) {
		System.out.println("UserController login() " + new Date());
		
		return service.login(dto);
	}
	
	@PostMapping(value = "changeuser")
	public String changeuser(UserDto dto) {
		System.out.println("UserController changeuser() " + new Date());
		
		boolean isS = service.changeuser(dto);
		if(isS == true) {
			return "YES";
		}
			
		return "NO";
	}
		// 학생 마이페이지
	// 마이 페이지 - 성적표 확인
	@GetMapping(value = "gradecheck")
	public Map<String, Object> gradecheck(MailParam param) {
		System.out.println("UserController gradecheck() " + new Date());
		
		// 글의 시작과 끝
		int pn = param.getPageNumber();  // 0 1 2 3 4
		int start = pn * 10;	// 1  11
		int end = (pn + 1) * 10;	// 10 20 
		
		param.setStart(start);
		param.setEnd(end);
		
		// 성적표 뽑기
		List<SearchGradeDto> listcheck = service.gradecheck(param);
				
		int cnt = listcheck.size();
		System.out.println(cnt);
		
		List<SearchGradeDto> list = service.gradecheck(param)
							.stream()
							.skip(param.getStart())
							.limit(10)
							.collect(Collectors.toList());
		System.out.println(list);
		
		Map<String, Object> map = new HashMap<>();
		
		map.put("list", list);
		map.put("cnt", cnt);
		
		return map;
	}
	
	// 마이 페이지 - 수강중인 학습
	@GetMapping(value = "subjectcheck")
	public Map<String, Object> subjectcheck(MailParam param) {
		System.out.println("UserController subjectcheck() " + new Date());
		
		// 글의 시작과 끝
		int pn = param.getPageNumber();  // 0 1 2 3 4
		int start = pn * 10;	// 1  11
		int end = (pn + 1) * 10;	// 10 20 
		
		param.setStart(start);
		param.setEnd(end);
		
		// 성적표 뽑기
		List<MysubjectDto> listcheck = service.subjectcheck(param);
				
		int cnt = listcheck.size();
		System.out.println(cnt);
		
		List<MysubjectDto> list = service.subjectcheck(param)
							.stream()
							.skip(param.getStart())
							.limit(10)
							.collect(Collectors.toList());
		System.out.println(list);
		
		Map<String, Object> map = new HashMap<>();
		
		map.put("list", list);
		map.put("cnt", cnt);
		
		return map;
	}
	
	// 마이 페이지 - 학습 탈퇴 신청 및 취소
	@GetMapping(value = "quitsubject")
	public String quitsubject(MysubjectDto dto) {
		System.out.println("UserController quitsubject() " + new Date());
		
		boolean isS = service.quitsubject(dto);
		if(isS == true) {
			return "YES";
		}
			
		return "NO";
	}
	
	@GetMapping(value = "quitcancel")
	public String quitcancel(MysubjectDto dto) {
		System.out.println("UserController quitcancel() " + new Date());
		
		boolean isS = service.quitcancel(dto);
		if(isS == true) {
			return "YES";
		}
			
		return "NO";
	}
	
	@GetMapping(value = "approvedcheck")
	public String approvedcheck(MysubjectDto dto) {
		System.out.println("UserController approvedcheck() " + new Date());
		
		String state = service.approvedcheck(dto);
	
		return state;
	}
	
	@GetMapping(value = "approving")
	public String approving(MysubjectDto dto) {
		System.out.println("UserController approving() " + new Date());
		
		boolean isS = service.approving(dto);
		if(isS == true) {
			return "YES";
		}
			
		return "NO";
	}
	
	@GetMapping(value = "changeapproving")
	public String changeapproving(MysubjectDto dto) {
		System.out.println("UserController changeapproving() " + new Date());
		
		boolean isS = service.changeapproving(dto);
		if(isS == true) {
			return "YES";
		}
			
		return "NO";
	}
	
	// 마이 페이지 - 학부모 auth 조건
	@PostMapping(value = "parentsidmatching")
	public List<UserparentsDto> parentsidmatching(String parentsid) {
		System.out.println("UserController parentsidmatching() " + new Date());
		
		List<UserparentsDto> dto = service.parentsidmatching(parentsid);
			
		return dto;
	}
	
	// 교사 마이 페이지 - 학교 select 
	@PostMapping(value = "eduselect")
	public MysubjectDto eduselect(String id){
		System.out.println("UserController eduselect() " + new Date());
		
		System.out.println("id: " + id);
		
		MysubjectDto dto = service.eduselect(id);
			
		return dto;
	}
	
	// 교사 마이 페이지 - 과목 select 
	@PostMapping(value = "subselect")
	public List<MysubjectDto> subselect(MysubjectDto dto){
		System.out.println("UserController subselect() " + new Date());
		
		System.out.println(dto.toString());
		
		List<MysubjectDto> list = service.subselect(dto);
		System.out.println(list.toString());
			
		return list;
	}
	
	// 교사 마이 페이지 - 수강생 리스트
	@GetMapping(value = "studentlist")
	public Map<String, Object> studentlist(MailParam param) {
		System.out.println("UserController studentlist() " + new Date());
		
		// 글의 시작과 끝
		int pn = param.getPageNumber();  // 0 1 2 3 4
		int start = pn * 10;	// 1  11
		int end = (pn + 1) * 10;	// 10 20 
		
		param.setStart(start);
		param.setEnd(end);
		
		// 성적표 뽑기
		List<MypageStudentDto> listcheck = service.studentlist(param);
				
		int cnt = listcheck.size();
		System.out.println(cnt);
		
		List<MypageStudentDto> list = service.studentlist(param)
							.stream()
							.skip(param.getStart())
							.limit(10)
							.collect(Collectors.toList());
		System.out.println(list);
		
		Map<String, Object> map = new HashMap<>();
		
		map.put("list", list);
		map.put("cnt", cnt);
		
		return map;
	}
	
	// 교사 마이페이지 - 수강 신청 승인
	@GetMapping(value = "makeapproved")
	public String makeapproved(MysubjectDto dto) {
		System.out.println("UserController makeapproved() " + new Date());
		
		System.out.println(dto.toString());
		
		boolean is = service.changeapproved(dto);
		boolean isS = service.makeapproved(dto);
		
		GradeDto student = service.subStudentList(dto);
		student.setStudentId(dto.getId());
		
		System.out.println(student.toString());
		
		boolean gradeInsert = service.setStudentGrade(student);
		
		if(isS == true) {
			return "YES";
		}
			
		return "NO";
	}
	
	
	// 교사 마이페이지 - 수강생 탈퇴 신청 승인 
	@GetMapping(value = "deletestudent")
	public String deletestudent(MysubjectDto dto) {
		System.out.println("UserController deletestudent() " + new Date());
		
		System.out.println(dto.toString());
		
		service.changequited(dto);
		service.deletestudent(dto);
		
		String id = dto.getId();
		
		List<MysubjectDto> list = service.breakcheck(id);
		System.out.println(list.size());
		System.out.println(list.toString());
		
		if(list.size() <= 0) {
			System.out.println("useredu delete 작동");
			return "YES";
		} else {
			return "NO";
		}

	}
	
		// 소셜 로그인
	// 카카오 로그인
	@GetMapping(value = "kakaoLogin")
	public HashMap<String, Object> kakaoLogin(String code){
		System.out.println("UserController kakaoLogin() " + new Date());
		
		// 1번
		System.out.println("code:" + code);
		
		// 2번
		String access_Token = null;
		try {
			access_Token = service.getKaKaoAccessToken(code);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("###access_Token#### : " + access_Token);
		// 위의 access_Token 받는 걸 확인한 후에 밑에 진행
		
		// 3번
		HashMap<String, Object> userInfo = new HashMap<>();
		try {
			userInfo = service.getUserInfo(access_Token);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return userInfo;	
		// return에 페이지를 해도 되고, 여기서는 코드가 넘어오는지만 확인할거기 때문에 따로 return 값을 두지는 않았음

	}
	
	// 해당 social로 가입된 아이디가 있는지 체크해서 있으면 로그인 없으면 회원가입
	@PostMapping(value = "socialLogincheck")
	public UserDto socialLogincheck(UserDto dto){
		System.out.println("UserController socialLogincheck() " + new Date());
		
		System.out.println("joinid: " + dto);
		
		UserDto result = service.socialLogincheck(dto);
		System.out.println(result);
			
		return result;
	}
	
	// 회원탈퇴
	@GetMapping(value = "breakoutuser")
	public String breakoutuser(String id, String auth){
		System.out.println("UserController breakoutuser() " + new Date());
		
		System.out.println("auth : " + auth);
		
		// 학생
		if(auth.equals("student")) {
			List<MysubjectDto> list = service.breakcheck(id);
			System.out.println(list.size());
			System.out.println(list.toString());
			
			if(list.size() <= 0) {
				
				service.breakoutuser(id);
				service.breakoutuseredu(id);
				service.breakouttempusersubject(id);
				service.breakoutstudentuserparents(id);
			
				return "YES";
			
			}else {
				return "수강학습남음";
			}
			
		// 학부모
		}else if(auth.equals("parents")) {
			service.breakoutuser(id);
			service.breakoutparentsuserparents(id);
			
			return "YES";
		
		// 교사
		}else if(auth.equals("teacher")) {
			List<MysubjectDto> list = service.breakchecksubject(id);
			System.out.println(list.size());
			System.out.println(list.toString());
			
			if(list.size() <= 0) {
				
				service.breakoutuser(id);
				service.breakoutuseredu(id);
			
				return "YES";
			
			}else {
				return "수업학습남음";
			}
		}
		
		return "NO";
		
	}
	
	// 해당 번호로 가입된 계정이 있는지 체크
	@PostMapping(value = "phonecheck")
	public String phonecheck(String phone) {
		System.out.println("UserController phonecheck() " + new Date());
		
		System.out.println("phone: " + phone);
		
		boolean isS = service.phonecheck(phone);
		if(isS == true) {
			return "NO";
		}
		
		return "YES";
	}
	

	@PostMapping(value = "stuselect")
	public MysubjectDto stuselect(String subcode){
		System.out.println("UserController eduselect() " + new Date());
		
		System.out.println("subcode: " + subcode);
		
		MysubjectDto dto = service.stuselect(subcode);
			
		return dto;
	}

	@PostMapping(value = "deleteuseredu")
	public String deleteuseredu(EducationDto dto) {
		System.out.println("UserController deleteuseredu() " + new Date());
		
		System.out.println(dto.toString());
		
		service.deleteuseredu(dto);
		
		return "";

	}


}
