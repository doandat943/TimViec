package model;

public class User {
	private String fullname;
	private String phone;
	private String address;
	private String sex;
	private String dob;
	private String email;
	
	public User() {
		super();
	}
	public User(String fullname, String phone, String address, String sex, String dob, String email) {
		super();
		this.fullname = fullname;
		this.phone = phone;
		this.address = address;
		this.sex = sex;
		this.dob = dob;
		this.email = email;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
