package mul.cam.a.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import mul.cam.a.dto.EduInfoDto;
import mul.cam.a.dto.ListParam;

@Mapper
@Repository
public interface EduInfoDao {

	// 교육 정보 목록
	List<EduInfoDto> eduInfoList(ListParam param);
	
	int getAllEduInfo(ListParam param);
	
	// 교육 정보 등록
	int writeEduInfo(EduInfoDto dto);
	
	// 교육 정보 상세
	EduInfoDto getEduInfo(Integer seq);
}
