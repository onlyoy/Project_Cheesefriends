package mul.cam.a.dto;

public class GradeDto {
	private String subCode;
	private String eduCode;
	private String subName;
	private String classGrade;
	private String studentId;
	private String userId;
	private String name;
	private int studentGrade;
	private int studentRanks;
	private int subTotal;
	
	
	public GradeDto() {
		
	}
	public GradeDto(String subCode, String eduCode, String subName, String classGrade, String studentId,
			String userId, String name, int studentGrade, int studentRanks, int subTotal) {
		super();
		this.subCode = subCode;
		this.eduCode = eduCode;
		this.subName = subName;
		this.classGrade = classGrade;
		this.studentId = studentId;
		this.userId = userId;
		this.name = name;
		this.studentGrade = studentGrade;
		this.studentRanks = studentRanks;
		this.subTotal = subTotal;
	}
	public GradeDto(String subCode, String eduCode, String subName, String classGrade, String studentId,
			String userId, String name) {
		super();
		this.subCode = subCode;
		this.eduCode = eduCode;
		this.subName = subName;
		this.classGrade = classGrade;
		this.studentId = studentId;
		this.userId = userId;
		this.name = name;
	}
		
	
	public GradeDto(String subCode, String studentId, int studentGrade, int studentRanks) {
		super();
		this.subCode = subCode;
		this.studentId = studentId;
		this.studentGrade = studentGrade;
		this.studentRanks = studentRanks;
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
	public String getSubName() {
		return subName;
	}
	public void setSubName(String subName) {
		this.subName = subName;
	}
	public String getClassGrade() {
		return classGrade;
	}
	public void setClassGrade(String classGrade) {
		this.classGrade = classGrade;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	@Override
	public String toString() {
		return "subCode=" + subCode + ", eduCode=" + eduCode + ", subName=" + subName
				+ ", classGrade=" + classGrade + ", studentId=" + studentId + ", userId=" + userId + ", name=" + name
				+ ", studentGrade=" + studentGrade + ", studentRanks=" + studentRanks + ", subTotal=" + subTotal + "]";
	}
	
	

	

	
}
