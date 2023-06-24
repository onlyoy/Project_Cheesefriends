package mul.cam.a.dto;

public class SubjectDto {
	private String eduCode;
	private String eduName;
	private String subCode;
	private String subName;
	private String educatorName;
	private String name;
	private String classGrade;
	
	public SubjectDto() {
	}
	

	public SubjectDto(String eduCode, String eduName, String subCode, String subName, String educatorName, String name,
			String classGrade) {
		super();
		this.eduCode = eduCode;
		this.eduName = eduName;
		this.subCode = subCode;
		this.subName = subName;
		this.educatorName = educatorName;
		this.name = name;
		this.classGrade = classGrade;
	}
	

	public String getEduCode() {
		return eduCode;
	}

	public void setEduCode(String eduCode) {
		this.eduCode = eduCode;
	}

	public String getEduName() {
		return eduName;
	}

	public void setEduName(String eduName) {
		this.eduName = eduName;
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
	

	public String getClassGrade() {
		return classGrade;
	}


	public void setClassGrade(String classGrade) {
		this.classGrade = classGrade;
	}


	@Override
	public String toString() {
		return "SubjectDto [eduCode=" + eduCode + ", eduName=" + eduName + ", subCode=" + subCode + ", subName="
				+ subName + ", educatorName=" + educatorName + ", name=" + name + ", classGrade=" + classGrade + "]";
	}


	
	
}