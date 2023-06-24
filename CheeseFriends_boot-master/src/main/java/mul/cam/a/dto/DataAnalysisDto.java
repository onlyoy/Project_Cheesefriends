package mul.cam.a.dto;

public class DataAnalysisDto {

    private String studentId;
    private String subName;
    private int studentGrade;
    private int studentRanks;
    private int subTotal;
    private String  studentName;
    


	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getSubName() {
		return subName;
	}
	public void setSubName(String subName) {
		this.subName = subName;
	}
	public int getStudentGrade() {
		return studentGrade;
	}
	public void setStudentGrade(int studentGrade) {
		this.studentGrade = studentGrade;
	}
	public int getStudentRanks() {
		return studentRanks;
	}
	public void setStudentRanks(int studentRanks) {
		this.studentRanks = studentRanks;
	}
	public int getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(int subTotal) {
		this.subTotal = subTotal;
	}
}
