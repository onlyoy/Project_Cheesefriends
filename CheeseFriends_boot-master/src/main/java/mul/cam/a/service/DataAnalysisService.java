package mul.cam.a.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mul.cam.a.dao.DataAnalysisDao;
import mul.cam.a.dto.AttendanceSubject;
import mul.cam.a.dto.CFR_Attendance;
import mul.cam.a.dto.DataAnalysisDto;

@Service
public class DataAnalysisService {

    @Autowired
    private DataAnalysisDao dataAnalysisDao;

    public List<DataAnalysisDto> getGradesByStudentId(String eduCode, String studentId) {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("eduCode", eduCode);
        paramMap.put("studentId", studentId);
        return dataAnalysisDao.getGradesByStudentId(paramMap);
    }
    
    public List<CFR_Attendance> getAttendanceList(String eduCode, String studentId) {
    	 Map<String, String> paramMap = new HashMap<>();
         paramMap.put("eduCode", eduCode);
         paramMap.put("studentId", studentId);
         return dataAnalysisDao.getAttendanceList(paramMap);
    }
    
    public List<DataAnalysisDto> getGradesBySubCode(String subCode) {
        return dataAnalysisDao.getGradesBySubCode(subCode);
    }

}
