package mul.cam.a.dto;

import java.time.LocalTime;

public class AttendanceSearch {

    private String studentID;
    private String subCode;
    private int month;
    private int day;
	private LocalTime endTime;

    public AttendanceSearch() {}

    public AttendanceSearch(String studentID, String subCode, int month, int day) {
        this.studentID = studentID;
        this.subCode = subCode;
        this.month = month;
        this.day = day;
    }

    public AttendanceSearch(String subCode, LocalTime endTime) {
        this.subCode = subCode;
        this.endTime = endTime;
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

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

}