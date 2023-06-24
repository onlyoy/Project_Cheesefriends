package mul.cam.a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mul.cam.a.dao.EduInfoDao;
import mul.cam.a.dto.EduInfoDto;
import mul.cam.a.dto.ListParam;

@Service
@Transactional
public class EduInfoService {

	@Autowired
	EduInfoDao dao;
	
	public List<EduInfoDto> eduInfoList(ListParam param) {
		return dao.eduInfoList(param);
	}
	
	public int getAllEduInfo(ListParam param) {
		return dao.getAllEduInfo(param);
	}
	
	public boolean writeEduInfo(EduInfoDto dto) {
		int n = dao.writeEduInfo(dto);
		return n>0? true:false;
	}
	
	public EduInfoDto getEduInfo(Integer seq) {
		return dao.getEduInfo(seq);
	}
}
