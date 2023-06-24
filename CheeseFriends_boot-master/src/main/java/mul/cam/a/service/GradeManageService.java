package mul.cam.a.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mul.cam.a.dao.GradeManageDao;
import mul.cam.a.dto.GradeDto;
import mul.cam.a.dto.SortParam;
import mul.cam.a.dto.SubjectDto;

@Service
@Transactional
public class GradeManageService {
	
	@Autowired
	GradeManageDao dao;
	
	public List<SubjectDto> subTeacherlist(String teacher) {
		return dao.subTeacherlist(teacher);
	}
	
	public boolean gradeAdd(List<GradeDto> data) {
		int n = dao.gradeAdd(data);
		return n>0?true:false;
	}
//	public boolean gradeDuplicate(List<GradeDto> data) {
//		int n = dao.gradeDuplicate(data);
//		return n>0?true:false;
//	}
	public List<GradeDto> gradeRanks(SortParam param) {
		return dao.gradeRanks(param);
	}
	public boolean gradeUpdate(List<GradeDto> data) {
		int n = dao.gradeUpdate(data);
		return n>0?true:false;
	}
}
