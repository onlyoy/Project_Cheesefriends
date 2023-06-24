package mul.cam.a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mul.cam.a.dao.QnaDao;
import mul.cam.a.dto.ListParam;
import mul.cam.a.dto.QnaDto;

@Service
@Transactional
public class QnaService {

	@Autowired
	QnaDao dao;

	public List<QnaDto> qnaLearningList(ListParam param) {
		return dao.qnaLearningList(param);
	}
	
	public int getAllQna(ListParam param) {
		return dao.getAllQna(param);
	}
	
	public boolean writeQna(QnaDto bbs) {
		int n = dao.writeQna(bbs);
		return n>0? true:false;
	}
	
	public QnaDto getLearningQna(Integer seq) {
		return dao.getLearningQna(seq);
	}
	
	public boolean answerQna(QnaDto bbs) {
		dao.answerUpdate(bbs);
		int n = dao.answerInsert(bbs);
		return n>0?true:false;
	}
}
