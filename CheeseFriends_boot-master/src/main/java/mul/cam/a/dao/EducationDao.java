package mul.cam.a.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import mul.cam.a.dto.AttendanceEdu;
import mul.cam.a.dto.CFR_User;
import mul.cam.a.dto.EducationDto;
import mul.cam.a.dto.ListParam;
import mul.cam.a.dto.MailDto;
import mul.cam.a.dto.MailParam;
import mul.cam.a.dto.TeacherUserDto;
import mul.cam.a.dto.UserDto;

@Mapper
@Repository
public interface EducationDao {
	// 교육기관등록 
	int eduAdd(EducationDto edu);
	
	// 교육기관등록 시 메인계정 생성
	int eduAddAdmain(UserDto admin);
	
	// useredu에 아이디 등록
	int userEduAdd(EducationDto edu);
	
	// 교육기관코드 중복체크
	int eduCodeCheck(String eduCode);
	
	// 등록된 교육기관 중복체크 
	int eduDuplicateCheck(EducationDto edu);
	
	// 교육기관리스트
	List<EducationDto> getEduList(ListParam param);
	
	// 교육기관 총 수
	int getAllEdu(ListParam param);
	
	// 교육기관 데이터
	EducationDto getEdu(String eduCode);
	
	// 교육기관 수정
	int eduUpdate(EducationDto edu);
	
	// 교육기관 계정 수정
	int eduUpdateAdmin(EducationDto edu);
	
	// 교육기관 삭제
	int eduDelete(EducationDto edu);
	
	// 메인페이지 유저 eduCode 가져오기
	List<EducationDto> homeEduCode(String id);
	
	// 메인페이지 안읽은 쪽지 가져오기
	int unreducedMail(String id);
	
}



