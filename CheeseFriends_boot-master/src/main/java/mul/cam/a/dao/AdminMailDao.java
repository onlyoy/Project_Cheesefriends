package mul.cam.a.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import mul.cam.a.dto.EducationDto;
import mul.cam.a.dto.ListParam;
import mul.cam.a.dto.MailDto;
import mul.cam.a.dto.MailParam;
import mul.cam.a.dto.TeacherUserDto;

@Mapper
@Repository
public interface AdminMailDao {
	// 메일용 교육기관 리스트
	List<EducationDto> getEduMailList(ListParam param);
	
	// 메일용 교육기관 총 수 
	int getEduMaiAllList(ListParam param);
	
	// 메일용 아이디 리스트
	List<TeacherUserDto> getIdMailList(ListParam param);
	
	// 메일용 아이디리스트 총 수 
	int getIdMailAllList(ListParam param);
	
	// 메일용 교육기관 아이디 리스트
	List<TeacherUserDto> getEduIdMailList(String eduCode);
	
	// 보낸메일 시간별로 묶은 리스트
	List<MailDto> sendMaillist(MailParam param);
	
	// 보낸메일 총 수
	int getsendAllMail(MailParam param);
	
	// 보낸메일 디테일
	MailDto getSendMailDetail(String wdate);
	
	// 보낸메일 삭제
	int deleteMail(String wdate);
}
