package mul.cam.a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mul.cam.a.dao.TimeTableDao;
import mul.cam.a.dto.TimeTableDto;

@Service
@Transactional
public class TimeTableService {
	
	@Autowired
	TimeTableDao dao;
	
	public List<TimeTableDto> subTimeList(String teacher) {
		return dao.subTimeList(teacher);
	}
	public boolean timeTableAdd(TimeTableDto dto) {
		int n = dao.timeTableAdd(dto);
		return n>0?true:false;
	}
	public boolean timeDuplicateCheck(TimeTableDto dto) {
		int n = dao.timeDuplicateCheck(dto);
		return n>0?true:false;
	}
	public boolean timeTableUpdate(TimeTableDto dto) {
		int n = dao.timeTableUpdate(dto);
		return n>0?true:false;
	}
	public boolean timeTableDelete(int seq) {
		int n = dao.timeTableDelete(seq);
		return n>0?true:false;
	}
	
}
