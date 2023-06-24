package mul.cam.a.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mul.cam.a.dto.CFR_Attendance;
import mul.cam.a.dto.DataAnalysisDto;
import mul.cam.a.service.DataAnalysisService;

@RestController
@RequestMapping("/da")
public class DataAnalysisController {
    
	@Autowired
    private DataAnalysisService dataAnalysisService;
// 학생용
	@GetMapping("{eduCode}/{studentId}/grades")
	public List<DataAnalysisDto> getGradesByStudentId(@PathVariable String eduCode, @PathVariable String studentId) {
	    return dataAnalysisService.getGradesByStudentId(eduCode, studentId);
	}
	
	@GetMapping("/{eduCode}/{studentId}/attendance")
    public List<CFR_Attendance> getAttendanceList(@PathVariable String eduCode, @PathVariable String studentId) {
        return dataAnalysisService.getAttendanceList(eduCode, studentId);
    }
    
 // 교사용   
    @GetMapping("/grades/{subCode}")
    public ResponseEntity<List<DataAnalysisDto>> getGradesBySubCode(@PathVariable String subCode) {
        List<DataAnalysisDto> dataAnalysisDtoList = dataAnalysisService.getGradesBySubCode(subCode);
        return new ResponseEntity<>(dataAnalysisDtoList, HttpStatus.OK);
    }
    

}