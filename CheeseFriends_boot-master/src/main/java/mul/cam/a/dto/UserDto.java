package mul.cam.a.dto;

import java.io.Serializable;

public class UserDto implements Serializable {
	
	String id;
	String password;
	String name;
	String gender;
	String email;
	String birth;
	String address;
	String facename;
	String newfacename;
	String phone;
	String phone_public;
	String jointype;
	String auth;
	int breakaway;
	String regidate;
	String joinid;
	
	public UserDto() {
		// TODO Auto-generated constructor stub
	}

	public UserDto(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public UserDto(String id, String password, String name, String gender, String email, String birth, String address,
			String facename, String newfacename, String phone, String phone_public, String jointype, String auth,
			int breakaway, String regidate, String joinid) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.birth = birth;
		this.address = address;
		this.facename = facename;
		this.newfacename = newfacename;
		this.phone = phone;
		this.phone_public = phone_public;
		this.jointype = jointype;
		this.auth = auth;
		this.breakaway = breakaway;
		this.regidate = regidate;
		this.joinid = joinid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFacename() {
		return facename;
	}

	public void setFacename(String facename) {
		this.facename = facename;
	}

	public String getNewfacename() {
		return newfacename;
	}

	public void setNewfacename(String newfacename) {
		this.newfacename = newfacename;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhone_public() {
		return phone_public;
	}

	public void setPhone_public(String phone_public) {
		this.phone_public = phone_public;
	}

	public String getJointype() {
		return jointype;
	}

	public void setJointype(String jointype) {
		this.jointype = jointype;
	}

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	public int getBreakaway() {
		return breakaway;
	}

	public void setBreakaway(int breakaway) {
		this.breakaway = breakaway;
	}

	public String getRegidate() {
		return regidate;
	}

	public void setRegidate(String regidate) {
		this.regidate = regidate;
	}

	public String getJoinid() {
		return joinid;
	}

	public void setJoinid(String joinid) {
		this.joinid = joinid;
	}

	@Override
	public String toString() {
		return "UserDto [id=" + id + ", password=" + password + ", name=" + name + ", gender=" + gender + ", email="
				+ email + ", birth=" + birth + ", address=" + address + ", facename=" + facename + ", newfacename="
				+ newfacename + ", phone=" + phone + ", phone_public=" + phone_public + ", jointype=" + jointype
				+ ", auth=" + auth + ", breakaway=" + breakaway + ", regidate=" + regidate + ", joinid=" + joinid + "]";
	}
	
	
	
}
