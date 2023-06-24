package mul.cam.a.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import mul.cam.a.dto.ListParam;
import mul.cam.a.dto.ServiceDto;

@Mapper
@Repository
public interface ServiceDao {

	// 고객센터 목록
	List<ServiceDto> serviceList(ListParam param);
	
	int getAllService(ListParam param);
	
	// 고객센터 등록
	int writeService(ServiceDto dto);
	
	ServiceDto getService(Integer seq);
	
	int answerUpService(ServiceDto bbs);
	int answerInService(ServiceDto bbs);
		
	
	int getAllCategoryService(ListParam param);
	List<ServiceDto> getCategorylist(String category);
		
}
