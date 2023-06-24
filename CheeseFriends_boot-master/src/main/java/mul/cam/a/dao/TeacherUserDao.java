package mul.cam.a.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import mul.cam.a.dto.ListParam;
import mul.cam.a.dto.TeacherUserDto;

@Mapper
@Repository
public interface TeacherUserDao {
	
	// 교사 리스트 가져오기
	List<TeacherUserDto> getTeacherList(ListParam param);
	
	// 교사 총 수
	int getAllTeacher(ListParam param);
	
	// 교사 데이터 가져오기
	TeacherUserDto getTeacher(String id);
	
	// 교사 담당과목 가져오기
	List<TeacherUserDto> getTeacherSubList(String id);
	
	// 교사 정보 수정
	int teacherUpdate(TeacherUserDto teacher);
	
	// 교사 삭제
	int teacherDelete(String id);
	
}
