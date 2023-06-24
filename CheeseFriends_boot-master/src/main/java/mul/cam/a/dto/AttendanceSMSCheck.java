package mul.cam.a.dto;

public class AttendanceSMSCheck {
    private String userId;
    private Boolean minCheck;
    private Boolean absentAlarm;
    
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Boolean getAbsentCheck() {
		return absentAlarm;
	}
	public void setAbsentCheck(Boolean absentAlarm) {
		this.absentAlarm = absentAlarm;
	}
	public String getUserID() {
		return userId;
	}
	public void setUserID(String userId) {
		this.userId = userId;
	}
	
	public Boolean getMinCheck() {
		return minCheck;
	}
	public void setMinCheck(Boolean minCheck) {
		this.minCheck = minCheck;
	}
}
