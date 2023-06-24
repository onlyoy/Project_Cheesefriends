package mul.cam.a.dto;

public class TeacherUserDto {
	private String eduCode;
	private String eduName;
	private String subCode;
	private String subName;
	private String id;
	private String name;
	private String email;
	private String phone;
	private String auth;
	
	public TeacherUserDto() {
		
	}

	public TeacherUserDto(String id, String name, String email, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}

	public TeacherUserDto(String eduCode, String eduName, String subCode, String subName, String id, String name,
			String email, String phone, String auth) {
		super();
		this.eduCode = eduCode;
		this.eduName = eduName;
		this.subCode = subCode;
		this.subName = subName;
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.auth = auth;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	@Override
	public String toString() {
		return "TeacherUserDto [eduCode=" + eduCode + ", eduName=" + eduName + ", subCode=" + subCode + ", subName="
				+ subName + ", id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", auth=" + auth + "]";
	}

	
	
}
