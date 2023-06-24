package mul.cam.a.dto;

import java.io.Serializable;

public class UserparentsDto implements Serializable {
	
	String studentid;
	String parentsid;
	String name;
	
	public UserparentsDto() {
		// TODO Auto-generated constructor stub
	}
	
	public UserparentsDto(String studentid, String parentsid, String name) {
		super();
		this.studentid = studentid;
		this.parentsid = parentsid;
		this.name = name;
	}

	public String getStudentid() {
		return studentid;
	}

	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}

	public String getParentsid() {
		return parentsid;
	}

	public void setParentsid(String parentsid) {
		this.parentsid = parentsid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "UserparentsDto [studentid=" + studentid + ", parentsid=" + parentsid + ", name=" + name + "]";
	}
	
	
	
	

}
