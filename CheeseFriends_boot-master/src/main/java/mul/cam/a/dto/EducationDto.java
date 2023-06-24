package mul.cam.a.dto;

public class EducationDto {
	private String eduCode;
	private String eduName;
	private String eduAddress;
	private String eduPhone;
	private String id;
	
	public EducationDto() {
		
	}
	
	public EducationDto(String eduCode, String eduName, String eduAddress, String eduPhone) {
		super();
		this.eduCode = eduCode;
		this.eduName = eduName;
		this.eduAddress = eduAddress;
		this.eduPhone = eduPhone;
	}
	public EducationDto(String eduCode, String eduName, String eduAddress, String eduPhone, String id) {
		super();
		this.eduCode = eduCode;
		this.eduName = eduName;
		this.eduAddress = eduAddress;
		this.eduPhone = eduPhone;
		this.id = id;
	}
	
	public EducationDto(String eduName, String eduAddress, String eduPhone) {
		super();
		this.eduName = eduName;
		this.eduAddress = eduAddress;
		this.eduPhone = eduPhone;
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

	public String getEduAddress() {
		return eduAddress;
	}

	public void setEduAddress(String eduAddress) {
		this.eduAddress = eduAddress;
	}

	public String getEduPhone() {
		return eduPhone;
	}

	public void setEduPhone(String eduPhone) {
		this.eduPhone = eduPhone;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "EducationDto [eduCode=" + eduCode + ", eduName=" + eduName + ", eduAddress=" + eduAddress
				+ ", eduPhone=" + eduPhone + ", id=" + id + "]";
	}
}