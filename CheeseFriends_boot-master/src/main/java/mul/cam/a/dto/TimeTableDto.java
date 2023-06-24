package mul.cam.a.dto;

public class TimeTableDto {
	private int seq;
	private String eduCode;
	private String subCode;
	private String subName;
	private String classGrade;
	private String subStart;
	private String subDay;
	private String subStartTime;
	private String subEndTime;
	private String educatorName;
	private String name;
	
	public TimeTableDto() {
		
	}

	public TimeTableDto(int seq, String eduCode, String subCode, String subName, String classGrade, String subStart,
			String subDay, String subStartTime, String subEndTime, String educatorName, String name) {
		super();
		this.seq = seq;
		this.eduCode = eduCode;
		this.subCode = subCode;
		this.subName = subName;
		this.classGrade = classGrade;
		this.subStart = subStart;
		this.subDay = subDay;
		this.subStartTime = subStartTime;
		this.subEndTime = subEndTime;
		this.educatorName = educatorName;
		this.name = name;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getEduCode() {
		return eduCode;
	}

	public void setEduCode(String eduCode) {
		this.eduCode = eduCode;
	}

	public String getSubCode() {
		return subCode;
	}

	public void setSubCode(String subCode) {
		this.subCode = subCode;
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

	public String getSubStart() {
		return subStart;
	}

	public void setSubStart(String subStart) {
		this.subStart = subStart;
	}

	public String getSubDay() {
		return subDay;
	}

	public void setSubDay(String subDay) {
		this.subDay = subDay;
	}

	public String getSubStartTime() {
		return subStartTime;
	}

	public void setSubStartTime(String subStartTime) {
		this.subStartTime = subStartTime;
	}

	public String getSubEndTime() {
		return subEndTime;
	}

	public void setSubEndTime(String subEndTime) {
		this.subEndTime = subEndTime;
	}

	public String getEducatorName() {
		return educatorName;
	}

	public void setEducatorName(String educatorName) {
		this.educatorName = educatorName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "TimeTableDto [seq=" + seq + ", eduCode=" + eduCode + ", subCode=" + subCode + ", subName=" + subName
				+ ", classGrade=" + classGrade + ", subStart=" + subStart + ", subDay=" + subDay + ", subStartTime="
				+ subStartTime + ", subEndTime=" + subEndTime + ", educatorName=" + educatorName + ", name=" + name
				+ "]";
	}


	




	
	
}
