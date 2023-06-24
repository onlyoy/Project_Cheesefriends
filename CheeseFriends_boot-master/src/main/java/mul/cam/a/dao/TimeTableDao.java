package mul.cam.a.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import mul.cam.a.dto.TimeTableDto;

@Mapper
@Repository
public interface TimeTableDao {
	
	// 과목 강의시간리스트
	List<TimeTableDto> subTimeList(String teacher);
	
	// 강의 시간 입력
	int timeTableAdd(TimeTableDto dto);
	
	// 강의시간 중복입력 확인
	int timeDuplicateCheck(TimeTableDto dto);
	
	// 강의시간 업데이트
	int timeTableUpdate(TimeTableDto dto);
	
	// 강의시간 삭제
	int timeTableDelete(int seq);
}
