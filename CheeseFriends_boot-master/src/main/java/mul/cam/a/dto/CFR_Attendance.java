package mul.cam.a.dto;
import java.sql.Timestamp;

public class CFR_Attendance {
    private String attendanceID;
    private String studentID;
    private String subCode;
    private Timestamp attendanceTime;
    private String status;
    private String eduCode;
    private String comment;
    private String name;
    private String subName;
    
	public String getSubName() {
		return subName;
	}
	public void setSubName(String subName) {
		this.subName = subName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getAttendanceID() {
		return attendanceID;
	}
	public void setAttendanceID(String string) {
		this.attendanceID = string;
	}
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	public String getSub_code() {
		return subCode;
	}
	public void setSub_code(String subCode) {
		this.subCode = subCode;
	}
	public Timestamp getAttendanceTime() {
		return attendanceTime;
	}
	public void setAttendanceTime(Timestamp attendanceTime) {
		this.attendanceTime = attendanceTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getEdu_code() {
		return eduCode;
	}
	public void setEdu_code(String eduCode) {
		this.eduCode = eduCode;
	}


}
