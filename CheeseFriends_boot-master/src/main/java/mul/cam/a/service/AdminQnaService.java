package mul.cam.a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mul.cam.a.dao.AdminQnaDao;
import mul.cam.a.dto.AdminAnswerDto;
import mul.cam.a.dto.AdminQuestionDto;
import mul.cam.a.dto.ListParam;

@Service
@Transactional
public class AdminQnaService {
	
	@Autowired
	AdminQnaDao dao;
	
	public List<AdminQuestionDto> getQnaList(ListParam param) {
		return dao.getQnaList(param);
	}
	
	public int getAllQna(ListParam param) {
		return dao.getAllQna(param);
	}
	
	public AdminQuestionDto getQna(int seq) {
		return dao.getQna(seq);
	}
	public AdminAnswerDto getAnswer(int getQnaSeq) {
		return dao.getAnswer(getQnaSeq);
	}
	public boolean answerWrite(AdminAnswerDto dto) {
		int n = dao.answerWrite(dto);
		return n>0?true:false;
	}
	public boolean answerStatus(int seq) {
		int n = dao.answerStatus(seq);
		return n>0?true:false;
	}
	public boolean answerUpdate(AdminAnswerDto dto) {
		int n = dao.answerUpdate(dto);
		return n>0?true:false;
	}
}
