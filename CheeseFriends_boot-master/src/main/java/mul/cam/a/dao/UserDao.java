package mul.cam.a.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

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

@Mapper
@Repository
public interface UserDao {
	
	String idcheck(String id);
	
	List<TestEduDto> subjectlist(String edu_code);
	
	String eduname(String edu_code);
	String subname(String sub_code);
	
	// 회원가입
	int adduser(UserDto dto);
	
	// 학생 가입
	int addusersubject(TestEduDto dto);
	String educodematching(String sub_code);
	EducationDto addusereducheck(TestEduDto dto);
	
	// 학부모 가입
	UserDto idmatching(String studentid);
	int adduserparents(UserparentsDto dto);
	String studentidmatching(String studentid);
	
	// 교사 가입
	List<EducationDto> edusearch(String edu_name);
	int adduseredu(TestEduDto dto);

	
	// 아이디 찾기
	UserDto idsearch(UserDto dto);
	
	// 비밀번호 재설정
	String idchecktwo(UserDto dto);
	int updatepassword(UserDto dto);
	
	// 로그인
	UserDto login(UserDto dto);
	
		// 학생 마이페이지
	// 개인정보 변경
	int changeuser(UserDto dto);
	
	// 마이 페이지 - 성적표 확인
	List<SearchGradeDto> gradecheck(MailParam param);

	// 마이 페이지 - 수강중인 학습
	List<MysubjectDto> subjectcheck(MailParam param);
	
	// 마이 페이지 - 학습 탈퇴 신청 및 취소
	int quitsubject(MysubjectDto dto);
	int quitcancel(MysubjectDto dto);
	
	// 마이 페이지 - 학습 추가 신청
	// 학습 진행중 체크
	String approvedcheck(MysubjectDto dto);
	
	// 학습 추가 신청
	int approving(MysubjectDto dto);
	int changeapproving(MysubjectDto dto);
	
	// 마이 페이지 - 학부모 auth 조건
	List<UserparentsDto> parentsidmatching(String parentsid);
	
	// 교사 마이 페이지 - 학교 select 
	MysubjectDto eduselect(String id);
	
	// 교사 마이 페이지 - 과목 select 
	List<MysubjectDto> subselect(MysubjectDto dto);
	
	// 교사 마이 페이지 - 수강생 리스트
	List<MypageStudentDto> studentlist(MailParam param);
	
	// 교사 마이페이지 - 수강 신청 승인
	int makeapproved(MysubjectDto dto);
	int changeapproved(MysubjectDto dto);
	
	// 교사 마이페이지 - 수강생 탈퇴 신청 승인 
	int deletestudent(MysubjectDto dto);
	int changequited(MysubjectDto dto);
	
		// 소셜 로그인
	// 해당 social로 가입된 아이디가 있는지 체크해서 있으면 로그인 없으면 회원가입
	UserDto socialLogincheck(UserDto dto);
	
		// 회원탈퇴
	// 학생
	List<MysubjectDto> breakcheck(String id);
	int breakoutuser(String id);
	int breakoutuseredu(String id);
	int breakouttempusersubject(String id);
	int breakoutstudentuserparents(String id);
	
	// 학부모
	int breakoutparentsuserparents(String id);
	
	// 교사
	List<MysubjectDto> breakchecksubject(String id);
	
	// 해당 번호로 가입된 계정이 있는지 체크
	String phonecheck(String phone);
	

	String stuselect(MysubjectDto dto);


	// 과목 학생 성적리스트
	GradeDto subStudentList(MysubjectDto dto);
	int setStudentGrade(GradeDto dto);
	
	// useredu 삭제
	int deleteuseredu(EducationDto dto);
	

}
	

