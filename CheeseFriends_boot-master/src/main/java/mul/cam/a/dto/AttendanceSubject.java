package mul.cam.a.dto;

import java.time.LocalDateTime;

public class AttendanceSubject {
    private String userId;
    private String subCode;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
   
    
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getSubCode() {
		return subCode; 
	}
	public void setSubCode(String subCode) {
		this.subCode = subCode;
	}
	public LocalDateTime getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}
	public LocalDateTime getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

}

