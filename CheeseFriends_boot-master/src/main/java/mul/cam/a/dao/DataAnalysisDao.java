package mul.cam.a.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mul.cam.a.dto.CFR_Attendance;
import mul.cam.a.dto.DataAnalysisDto;

@Repository
public class DataAnalysisDao {
	
	 private final String NS = "DA.";

	    @Autowired
	    private SqlSession sqlSession;

	    public List<DataAnalysisDto> getGradesByStudentId(Map<String, String> paramMap) {
	        return sqlSession.selectList(NS + "getGradesByStudentId", paramMap);
	    }
	    
	    public List<CFR_Attendance> getAttendanceList(Map<String, String> paramMap) {
	        return sqlSession.selectList(NS + "getAttendanceList", paramMap);
	    }
	    

	        public List<DataAnalysisDto> getGradesBySubCode(String subCode){
		        return sqlSession.selectList(NS + "getGradesBySubCode", subCode);
		    }

}
