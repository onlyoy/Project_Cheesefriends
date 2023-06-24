package mul.cam.a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mul.cam.a.dao.ServiceDao;
import mul.cam.a.dto.ListParam;
import mul.cam.a.dto.ServiceDto;

@Service
@Transactional
public class ServiceService {

	@Autowired
	ServiceDao dao;
	
	public List<ServiceDto> serviceList(ListParam param) {
		return dao.serviceList(param);
	}
	
	public int getAllService(ListParam param) {
		return dao.getAllService(param);
	}
	
	public boolean writeService(ServiceDto dto) {
		int n = dao.writeService(dto);
		return n>0? true:false;
	}
	
	public ServiceDto getService(Integer seq) {
		return dao.getService(seq);
	}
	
	public boolean answerUpService(ServiceDto bbs) {
		dao.answerUpService(bbs);
		int n = dao.answerInService(bbs);
		return n>0?true:false;
	}
	
	public List<ServiceDto> getCategorylist(String category) {
		return dao.getCategorylist(category);
	}
	
	public int getAllCategoryService(ListParam param) {
		return dao.getAllCategoryService(param);
	}
}
