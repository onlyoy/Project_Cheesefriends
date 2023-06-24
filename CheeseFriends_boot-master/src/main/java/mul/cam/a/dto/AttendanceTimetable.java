package mul.cam.a.dto;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class AttendanceTimetable {
    private String subCode;
    private String eduCode;
    private String subStartTime;
    private String subEndTime;
    private String subDay;        // 강의 요일
    
	public String getSubDay() {
		return subDay;
	}
	public void setSubDay(String subDay) {
		this.subDay = subDay;
	}
	public String getSubEndTime() {
		return subEndTime;
	}
	public void setSubEndTime(String subEndTime) {
		this.subEndTime = subEndTime;
	}
	public String getSubCode() {
		return subCode;
	}
	public void setSubCode(String subCode) {
		this.subCode = subCode;
	}
	public String getEduCode() {
		return eduCode;
	}
	public void setEduCode(String eduCode) {
		this.eduCode = eduCode;
	}
	public String getSubStartTime() {
		return subStartTime;
	}
	public void setSubStartTime(String subStartTime) {
		this.subStartTime = subStartTime;
	}

}