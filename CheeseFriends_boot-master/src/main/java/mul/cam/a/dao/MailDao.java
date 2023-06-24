package mul.cam.a.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import mul.cam.a.dto.EducationDto;
import mul.cam.a.dto.MailDto;
import mul.cam.a.dto.MailParam;
import mul.cam.a.dto.TestEduDto;
import mul.cam.a.dto.UserDto;

@Mapper
@Repository
public interface MailDao {
	
		// 쪽지 보내기
	// 메일 받는사람 검색
	List<UserDto> mailreceiverid(String name);
	
	// 메일 받는사람 추가
	UserDto mailreceiveradd(String id);
	
	// 메일 보내기
	int mailsend(MailDto dto);
	
		// 메일 단체보내기
	// 교육기관 검색
	List<EducationDto> eduselect(String id);
	
	// 과목 검색
	List<TestEduDto> subselect(EducationDto dto);
	
	// 수강생 리스트
	List<UserDto> userlist(TestEduDto dto);
	List<UserDto> userlisttwo(TestEduDto dto);
	
		// 받은 쪽지
	// 받은 메일 리스트
	List<MailDto> receivemaillist(MailParam param);
	
	// 받은 메일 총수
	int getallmail(MailParam param);
	
	// 받은 메일 디테일
	MailDto getmail(int seq);
	
	// 받은 메일 오픈시 리드 카운트 상승
	int readcountup(int seq);
	
	// 받은 메일 삭제
	int receivedeleteMail(int seq);
	
		// 보낸 쪽지
	// 보낸 메일 리스트
	List<MailDto> sendmaillist(MailParam param);
	
	// 보낸 메일 총수
	int getsendallmail(MailParam param);
	
	// 보낸 메일 삭제
	int senddeleteMail(int seq);
	
	

}
