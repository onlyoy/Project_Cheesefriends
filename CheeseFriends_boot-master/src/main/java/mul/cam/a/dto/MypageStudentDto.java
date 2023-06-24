package mul.cam.a.dto;

import java.io.Serializable;

public class MypageStudentDto implements Serializable{
	
	String name;
	String id;
	String parentsid;
	String subcode;
	String subname;
	String startdate;
	String enddate;
	String state;
	
	public MypageStudentDto() {
		// TODO Auto-generated constructor stub
	}

	public MypageStudentDto(String name, String id, String parentsid, String subcode, String subname, String startdate,
			String enddate, String state) {
		super();
		this.name = name;
		this.id = id;
		this.parentsid = parentsid;
		this.subcode = subcode;
		this.subname = subname;
		this.startdate = startdate;
		this.enddate = enddate;
		this.state = state;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getParentsid() {
		return parentsid;
	}

	public void setParentsid(String parentsid) {
		this.parentsid = parentsid;
	}

	public String getSubcode() {
		return subcode;
	}

	public void setSubcode(String subcode) {
		this.subcode = subcode;
	}

	public String getSubname() {
		return subname;
	}

	public void setSubname(String subname) {
		this.subname = subname;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "MypageStudentDto [name=" + name + ", id=" + id + ", parentsid=" + parentsid + ", subcode=" + subcode
				+ ", subname=" + subname + ", startdate=" + startdate + ", enddate=" + enddate + ", state=" + state
				+ "]";
	}
	
	

}
