package mul.cam.a.dto;

public class SortParam {
	private String subCode;
	private String educatorName;
	private String choice;
	
	public SortParam() {
		// TODO Auto-generated constructor stub
	}

	public SortParam(String subCode, String educatorName, String choice) {
		super();
		this.subCode = subCode;
		this.educatorName = educatorName;
		this.choice = choice;
	}

	public String getSubCode() {
		return subCode;
	}

	public void setSubCode(String subCode) {
		this.subCode = subCode;
	}

	public String getEducatorName() {
		return educatorName;
	}

	public void setEducatorName(String educatorName) {
		this.educatorName = educatorName;
	}

	public String getChoice() {
		return choice;
	}

	public void setChoice(String choice) {
		this.choice = choice;
	}

	@Override
	public String toString() {
		return "sortParam [subCode=" + subCode + ", educatorName=" + educatorName + ", choice=" + choice + "]";
	}
	
	
}

