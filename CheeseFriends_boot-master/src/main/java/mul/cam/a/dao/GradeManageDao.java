package mul.cam.a.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import mul.cam.a.dto.GradeDto;
import mul.cam.a.dto.SortParam;
import mul.cam.a.dto.SubjectDto;

@Mapper
@Repository
public interface GradeManageDao {
	
	// 교사담당과목 리스트
	List<SubjectDto> subTeacherlist(String teacher);
	
	// 과목 학생 성적입력
	int gradeAdd(List<GradeDto> data);
	
	// 성적중복등록확인
//	int gradeDuplicate(List<GradeDto> data);
	
	// 과목 석차 집계
	List<GradeDto> gradeRanks(SortParam param);
	
	// 학생성적수정
	int gradeUpdate(List<GradeDto> data);
}
