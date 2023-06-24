package mul.cam.a.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import mul.cam.a.dto.LectureDto;
import mul.cam.a.dto.ListParam;

@Mapper
@Repository
public interface LectureDao {

	// 강의 목록
	List<LectureDto> lectureList(ListParam param);
	
	int getAllLecture(ListParam param);
	
	// 강의 자료 등록
	int writeLecture(LectureDto bbs);
	
	// 강의 자료 상세
	LectureDto getLecture(Integer seq);

}
