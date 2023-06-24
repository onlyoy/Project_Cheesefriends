package mul.cam.a.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import mul.cam.a.dto.AdminAnswerDto;
import mul.cam.a.dto.AdminQuestionDto;
import mul.cam.a.dto.ListParam;

@Mapper
@Repository
public interface AdminQnaDao {
	
	// 문의 리스트
	List<AdminQuestionDto> getQnaList(ListParam param);
	// 문의 총 수
	int getAllQna(ListParam param);
	// 문의 데이터
	AdminQuestionDto getQna(int seq);
	// 답변데이터
	AdminAnswerDto getAnswer(int getQnaSeq);
	// 답변작성
	int answerWrite(AdminAnswerDto dto);
	// 답변작성시 상태변경
	int answerStatus(int seq);
	// 답변 수정
	int answerUpdate(AdminAnswerDto dto);
	
}
