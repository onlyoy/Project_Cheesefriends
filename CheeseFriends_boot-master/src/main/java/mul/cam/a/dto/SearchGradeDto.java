package mul.cam.a.dto;

import java.io.Serializable;

public class SearchGradeDto implements Serializable{

	private String studentid;
	private String subname;
	private String subcode;
	private String educode;
	private String eduname;
	private String classgrade;
	private int studentgrade; 
	private String studentranks;
	private int subtotal;
	
	public SearchGradeDto() {
		// TODO Auto-generated constructor stub
	}

	public SearchGradeDto(String studentid, String subname, String subcode, String educode, String eduname,
			String classgrade, int studentgrade, String studentranks, int subtotal) {
		super();
		this.studentid = studentid;
		this.subname = subname;
		this.subcode = subcode;
		this.educode = educode;
		this.eduname = eduname;
		this.classgrade = classgrade;
		this.studentgrade = studentgrade;
		this.studentranks = studentranks;
		this.subtotal = subtotal;
	}

	public String getStudentid() {
		return studentid;
	}

	public void setStudentid(String studentid) {
		this.studentid = studentid;
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

	public String getEduname() {
		return eduname;
	}

	public void setEduname(String eduname) {
		this.eduname = eduname;
	}

	public String getClassgrade() {
		return classgrade;
	}

	public void setClassgrade(String classgrade) {
		this.classgrade = classgrade;
	}

	public int getStudentgrade() {
		return studentgrade;
	}

	public void setStudentgrade(int studentgrade) {
		this.studentgrade = studentgrade;
	}

	public String getstudentranks() {
		return studentranks;
	}

	public void setstudentranks(String studentranks) {
		this.studentranks = studentranks;
	}

	public int getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(int subtotal) {
		this.subtotal = subtotal;
	}

	@Override
	public String toString() {
		return "SearchGradeDto [studentid=" + studentid + ", subname=" + subname + ", subcode=" + subcode + ", educode="
				+ educode + ", eduname=" + eduname + ", classgrade=" + classgrade + ", studentgrade=" + studentgrade
				+ ", studentranks=" + studentranks + ", subtotal=" + subtotal + "]";
	}

	

	
	
	
	
	
}
