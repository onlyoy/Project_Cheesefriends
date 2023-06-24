package mul.cam.a.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import mul.cam.a.dto.ListParam;
import mul.cam.a.dto.QnaDto;

@Mapper
@Repository
public interface QnaDao {

	// 수업 질문 목록
	List<QnaDto> qnaLearningList(ListParam param);
	
	int getAllQna(ListParam param);
	
	// 수업 질문 등록
	int writeQna (QnaDto bbs);
	
	// 수업 질문 상세
	QnaDto getLearningQna (Integer seq);
	
	int answerUpdate(QnaDto bbs);
	
	int answerInsert (QnaDto bbs);
}
