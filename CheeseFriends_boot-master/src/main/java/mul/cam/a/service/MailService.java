package mul.cam.a.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mul.cam.a.dao.MailDao;
import mul.cam.a.dto.EducationDto;
import mul.cam.a.dto.MailDto;
import mul.cam.a.dto.MailParam;
import mul.cam.a.dto.TestEduDto;
import mul.cam.a.dto.UserDto;

@Service
@Transactional
public class MailService {

	@Autowired
	MailDao dao;
		
		// 메일 보내기
	// 메일 받는사람 검색
	public List<UserDto> mailreceiverid(String name){
		System.out.println("MailService mailreceiverid() " + new Date());
		
		return dao.mailreceiverid(name);
	}
	
	// 메일 받는사람 추가
	public UserDto mailreceiveradd(String id){
		System.out.println("MailService mailreceiveradd() " + new Date());
		
		return dao.mailreceiveradd(id);
	}
	
	// 메일 보내기
	public boolean mailsend(MailDto dto) {
		int count = dao.mailsend(dto);
		return count>0?true:false;
	}
	
	// 단체 메일 보내기
	// 교육기관 검색
	public List<EducationDto> eduselect(String id){
		System.out.println("MailService eduselect() " + new Date());
		
		return dao.eduselect(id);
	}
	
	// 과목 검색
	public List<TestEduDto> subselect(EducationDto dto){
		System.out.println("MailService subselect() " + new Date());
		
		return dao.subselect(dto);
	}
	
	// 수강생 리스트
	public List<UserDto> userlist(TestEduDto dto){
		System.out.println("MailService userlist() " + new Date());
		
		return dao.userlist(dto);
	}
	public List<UserDto> userlisttwo(TestEduDto dto){
		System.out.println("MailService userlisttwo() " + new Date());
		
		return dao.userlisttwo(dto);
	}
	
		// 받은 메일
	// 메일 리스트
	public List<MailDto> receivemaillist(MailParam param){
		return dao.receivemaillist(param);
	}
	
	// 메일 총 수
	public int getallmail(MailParam param) {
		return dao.getallmail(param);
	}
	
	// 메일 디테일
	public MailDto getmail(int seq) {
		return dao.getmail(seq);
	}
	
	// 받은 메일 오픈시 리드 카운트 상승
	public int readcountup(int seq) {
		return dao.readcountup(seq);
	}
	
	// 메일 삭제
	public boolean receivedeleteMail(int seq) {
		int count = dao.receivedeleteMail(seq);
		return count>0?true:false;
	}
	
		// 보낸 메일
	// 메일 리스트
	public List<MailDto> sendmaillist(MailParam param){
		return dao.sendmaillist(param);
	}
	
	// 메일 총 수
	public int getsendallmail(MailParam param) {
		return dao.getsendallmail(param);
	}
	
	// 메일 삭제
	public boolean senddeleteMail(int seq) {
		int count = dao.senddeleteMail(seq);
		return count>0?true:false;
	}

}

