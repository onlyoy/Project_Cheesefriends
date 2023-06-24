package mul.cam.a.dto;

import java.io.Serializable;

public class TestEduDto implements Serializable {
	
	private String id;
	private String subname;
	private String subcode;
	private String educode;
	
	public TestEduDto() {
		// TODO Auto-generated constructor stub
	}

	public TestEduDto(String id, String subname, String subcode, String educode) {
		super();
		this.id = id;
		this.subname = subname;
		this.subcode = subcode;
		this.educode = educode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSubname() {
		return subname;
	}

	public void setSubname(String subname) {
		this.subname = subname;
	}

	public String getSubcode() {
		return subcode;
	}

	public void setSubcode(String subcode) {
		this.subcode = subcode;
	}

	public String getEducode() {
		return educode;
	}

	public void setEducode(String educode) {
		this.educode = educode;
	}

	@Override
	public String toString() {
		return "TestEduDto [id=" + id + ", subname=" + subname + ", subcode=" + subcode + ", educode=" + educode + "]";
	}
	
	
	

}
