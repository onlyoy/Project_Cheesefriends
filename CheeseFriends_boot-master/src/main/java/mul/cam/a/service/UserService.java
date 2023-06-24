package mul.cam.a.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.JsonParser;
import com.google.protobuf.TextFormat.ParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonElement;


import mul.cam.a.dao.UserDao;
import mul.cam.a.dto.EducationDto;
import mul.cam.a.dto.GradeDto;
import mul.cam.a.dto.MailParam;
import mul.cam.a.dto.MypageStudentDto;
import mul.cam.a.dto.MysubjectDto;
import mul.cam.a.dto.SearchGradeDto;
import mul.cam.a.dto.SortParam;
import mul.cam.a.dto.TestEduDto;
import mul.cam.a.dto.UserDto;
import mul.cam.a.dto.UserparentsDto;
import mul.cam.a.util.naver2;
	


@Service
@Transactional
public class UserService {
	
	@Autowired
	UserDao dao;
	
	public boolean idcheck(String id) {
		String userid = dao.idcheck(id);
		
		if(userid != null && !userid.equals("")) {
			return true;
		}
		
		return false;
	}
	
	public List<TestEduDto> subjectlist(String edu_code){
		System.out.println("UserService subjectlist() " + new Date());
		
		return dao.subjectlist(edu_code);
	}
	
	public String eduname(String edu_code) {
		System.out.println("UserService eduname() " + new Date());
		
		return dao.eduname(edu_code);
	}
	
	public String subname(String sub_code) {
		System.out.println("UserService subname() " + new Date());
		
		return dao.subname(sub_code);
	}
	
	public String sendRandomMessage(String phone) {
		naver2 message = new naver2();
	    Random rand = new Random();
	    String random = "";
	    for (int i = 0; i < 6; i++) {
	        String ran = Integer.toString(rand.nextInt(10));
	        random += ran;
	    }
	    System.out.println("회원가입 문자 인증 => " + random);

	    message.sendSMS(phone, random);

	    return random;
	}
	
	// 학생 가입
	public boolean adduser(UserDto dto) {
		int count = dao.adduser(dto);
		return count>0?true:false;
	}
	
	public boolean addusersubject(TestEduDto dto) {
		int count = dao.addusersubject(dto);
		return count>0?true:false;
	}
	
	public String educodematching(String sub_code) {
		System.out.println("UserService educodematching() " + new Date());
		
		String s = dao.educodematching(sub_code);
		return s;
	}
	
	public EducationDto addusereducheck(TestEduDto dto) {
		System.out.println("UserService addusereducheck() " + new Date());
		
		EducationDto dtocheck = dao.addusereducheck(dto);
		return dtocheck;
	}
	
	
	// 학부모 가입
	public UserDto idmatching(String studentid){
		System.out.println("UserService idmatching() " + new Date());
		
		return dao.idmatching(studentid);
	}
	
	public boolean adduserparents(UserparentsDto dto) {
		int count = dao.adduserparents(dto);
		return count>0?true:false;
	}
	
	public boolean studentidmatching(String studentid) {
		
		String userid = dao.studentidmatching(studentid);
		
		if(userid != null && !userid.equals("")) {
			return true;
		}
		
		return false;
	}
	
	// 교사 가입
	public List<EducationDto> edusearch(String edu_name) {
		System.out.println("UserService edusearch() " + new Date());
		
		return dao.edusearch(edu_name);
	}
	
	public boolean adduseredu(TestEduDto dto) {
		System.out.println("UserService adduseredu() " + new Date());
		
		int count = dao.adduseredu(dto);
		return count>0?true:false;
	}
	
	
	
	
	// 아이디 찾기
	public UserDto idsearch(UserDto dto) {
		System.out.println("UserService idsearch() " + new Date());

		UserDto getdto = dao.idsearch(dto);
	
		return getdto;
	}
	
	// 아이디 찾기2
	public boolean idchecktwo(UserDto dto) {
		String userid = dao.idchecktwo(dto);
		
		if(userid != null && !userid.equals("")) {
			return true;
		}
		
		return false;
	}
	
	// 비밀번호 변경
	public boolean updatepassword(UserDto dto) {
		int count = dao.updatepassword(dto);
		return count>0?true:false;
	}

	// 로그인
	public UserDto login(UserDto dto) {
		return dao.login(dto);
	}
	
		// 학생 마이페이지
	//개인정보 변경
	public boolean changeuser(UserDto dto) {
		int count = dao.changeuser(dto);
		return count>0?true:false;
	}
	
	// 마이 페이지 - 성적표 확인
	public List<SearchGradeDto> gradecheck(MailParam param) {
		return dao.gradecheck(param);
	}
	
	// 마이 페이지 - 수강중인 학습
	public List<MysubjectDto> subjectcheck(MailParam param){
		return dao.subjectcheck(param);
	}
	
	// 마이 페이지 - 학습 탈퇴 신청 및 취소
	public boolean quitsubject(MysubjectDto dto) {
		int count = dao.quitsubject(dto);
		return count>0?true:false;
	}
	
	public boolean quitcancel(MysubjectDto dto) {
		int count = dao.quitcancel(dto);
		return count>0?true:false;
	}
	
	// 마이 페이지 - 학습 추가 신청
	// 학습 진행중 체크
	public String approvedcheck(MysubjectDto dto) {
		return dao.approvedcheck(dto);
	}
	
	// 학습 추가 신청
	public boolean approving(MysubjectDto dto) {
		int count = dao.approving(dto);
		return count>0?true:false;
	}
	
	public boolean changeapproving(MysubjectDto dto) {
		int count = dao.changeapproving(dto);
		return count>0?true:false;
	}
	
	// 마이 페이지 - 학부모 auth 조건
	public List<UserparentsDto> parentsidmatching(String parentsid) {
		return dao.parentsidmatching(parentsid);
	}
	
	// 교사 마이 페이지 - 학교 select 
	public MysubjectDto eduselect(String id){
		return dao.eduselect(id);
	}
	
	// 교사 마이 페이지 - 과목 select 
	public List<MysubjectDto> subselect(MysubjectDto dto){
		return dao.subselect(dto);
	}
	
	// 교사 마이 페이지 - 수강생 리스트
	public List<MypageStudentDto> studentlist(MailParam param){
		return dao.studentlist(param);
	}
	

	// 교사 마이페이지 - 수강 신청 승인
	public boolean makeapproved(MysubjectDto dto) {
		int count = dao.makeapproved(dto);
		return count>0?true:false;
	}
	
	public boolean changeapproved(MysubjectDto dto) {
		int count = dao.changeapproved(dto);
		return count>0?true:false;
	}
	
	// 교사 마이페이지 - 수강생 탈퇴 신청 승인 
	public boolean deletestudent(MysubjectDto dto) {
		int count = dao.deletestudent(dto);
		System.out.println("deletestudent : " + count);
		return count>0?true:false;
	}
	
	public boolean changequited(MysubjectDto dto) {
		int count = dao.changequited(dto);
		System.out.println("changequited : " + count);
		return count>0?true:false;
	}
	
		// 소셜 로그인
	// 카카오 로그인
	public String getKaKaoAccessToken(String code) {

        String access_Token = "";
        String refresh_Token = "";
        String reqURL = "https://kauth.kakao.com/oauth/token";

        String result = null;
        String id_token = null;
        try {
            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            //POST 요청을 위해 기본값이 false인 setDoOutput을 true로
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);

            //POST 요청에 필요로 요구하는 파라미터 스트림을 통해 전송
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
            StringBuilder sb = new StringBuilder();
            sb.append("grant_type=authorization_code");
            sb.append("&client_id=f3613163848bb3a96a1dd490a0855f2c"); // TODO REST_API_KEY 입력
            sb.append("&redirect_uri=http://localhost:9100/kakaologin"); // TODO 인가코드 받은 redirect_uri 입력
            System.out.println("code = " + code);
            sb.append("&code=" + code);
            bw.write(sb.toString());
            bw.flush();

            //결과 코드가 200이라면 성공
            int responseCode = conn.getResponseCode();
            System.out.println("responseCode : " + responseCode);
            //요청을 통해 얻은 JSON타입의 Response 메세지 읽어오기
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";
            result = "";

            while ((line = br.readLine()) != null) {
                result += line;
            }
            // bearer 토큰 값만 추출(log에 찍히는 값의 이름은 id_Token)
            System.out.println("response body : " + result);
            String[] temp = result.split(",");
            id_token = temp[3].substring(11);
            System.out.println("idToken = " + id_token);


//            Gson 라이브러리에 포함된 클래스로 JSON파싱 객체 생성
            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(result);

            access_Token = element.getAsJsonObject().get("access_token").getAsString();
            refresh_Token = element.getAsJsonObject().get("refresh_token").getAsString();

            System.out.println("access_token : " + access_Token);
            System.out.println("refresh_token : " + refresh_Token);

            br.close();
            bw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return access_Token;
    }

	public HashMap<String, Object> getUserInfo(String access_Token) throws Throwable {
		// 요청하는 클라이언트마다 가진 정보가 다를 수 있기에 HashMap타입으로 선언
		HashMap<String, Object> userInfo = new HashMap<String, Object>();
		String reqURL = "https://kapi.kakao.com/v2/user/me";
		
		System.out.println("UserService getUserInfo() " + new Date());
		// 통과
		
		System.out.println("access_Token : " + access_Token);
		// 통과

		try {
			URL url = new URL(reqURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");

			// 요청에 필요한 Header에 포함될 내용
			conn.setRequestProperty("Authorization", "Bearer " + access_Token);

			int responseCode = conn.getResponseCode();
			System.out.println("responseCode : " + responseCode);
			// 통과

			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

			String line = "";
			String result = "";

			while ((line = br.readLine()) != null) {
				result += line;
			}
			System.out.println("response body : " + result);
			System.out.println("result type" + result.getClass().getName()); // java.lang.String

			try {
				// jackson objectmapper 객체 생성
				ObjectMapper objectMapper = new ObjectMapper();
				// JSON String -> Map
				Map<String, Object> jsonMap = objectMapper.readValue(result, new TypeReference<Map<String, Object>>() {
				});

				System.out.println("jsonMap : " + jsonMap);
				
				System.out.println(jsonMap.get("kakao_account"));
				Map<String, Object> kakao_account = (Map<String, Object>) jsonMap.get("kakao_account");
				System.out.println("kakao_account : " + kakao_account);
				
				System.out.println("email : " + kakao_account.get("email"));
				String email = (String)kakao_account.get("email");
				
				// System.out.println(jsonMap.get("properties"));
				Map<String, Object> properties = (Map<String, Object>) jsonMap.get("properties");
				System.out.println("nickname : " + properties.get("nickname"));
	            String nickname = (String)properties.get("nickname");
	            
				System.out.println("gender : " + kakao_account.get("gender"));
				String gender = (String)kakao_account.get("gender");
				
				System.out.println("id : " + jsonMap.get("id"));
				String id = jsonMap.get("id").toString();
				System.out.println("id : " + id);
			 
				// String properties = kakao_account.get("properties").toString();

				// String email = kakao_account.get("email").toString();

				userInfo.put("email", email);
				userInfo.put("gender", gender);
				userInfo.put("nickname", nickname);
				userInfo.put("id", id);

			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return userInfo;
	}
	
	// 해당 social로 가입된 아이디가 있는지 체크해서 있으면 로그인 없으면 회원가입
	public UserDto socialLogincheck(UserDto dto) {
		return dao.socialLogincheck(dto);
	}
	
	// 회원탈퇴 학생
	public List<MysubjectDto> breakcheck(String id) {
		return dao.breakcheck(id);
	}
	
	public boolean breakoutuser(String id) {
		System.out.println("UserService breakoutuser() " + new Date());
		int count = dao.breakoutuser(id);
		return count>0?true:false;
	}
	
	public boolean breakoutuseredu(String id) {
		System.out.println("UserService breakoutuseredu() " + new Date());
		int count = dao.breakoutuseredu(id);
		return count>0?true:false;
	}
	
	public boolean breakouttempusersubject(String id) {
		System.out.println("UserService breakouttempusersubject() " + new Date());
		int count = dao.breakouttempusersubject(id);
		return count>0?true:false;
	}
	
	public boolean breakoutstudentuserparents(String id) {
		System.out.println("UserService breakoutstudentuserparents() " + new Date());
		int count = dao.breakoutstudentuserparents(id);
		return count>0?true:false;
	}
	
	// 학부모
	public boolean breakoutparentsuserparents(String id) {
		System.out.println("UserService breakoutparentsuserparents() " + new Date());
		int count = dao.breakoutparentsuserparents(id);
		return count>0?true:false;
	}
	
	// 교사
	public List<MysubjectDto> breakchecksubject(String id) {
		return dao.breakchecksubject(id);
	}
	
	// 해당 번호로 가입된 계정이 있는지 체크
	public boolean phonecheck(String phone) {
		String userid = dao.phonecheck(phone);
		
		if(userid != null && !userid.equals("")) {
			return true;
		}
		
		return false;
	}
	

	public MysubjectDto stuselect(String id){
		return dao.eduselect(id);
	}

	public GradeDto subStudentList(MysubjectDto dto) {
		return dao.subStudentList(dto);
	}
	public boolean setStudentGrade(GradeDto dto) {
		int count = dao.setStudentGrade(dto);
		return count>0?true:false;
	}
	
	// useredu 삭제
	public boolean deleteuseredu(EducationDto dto) {
		int count = dao.deleteuseredu(dto);
		return count>0?true:false;
	}
	

}
