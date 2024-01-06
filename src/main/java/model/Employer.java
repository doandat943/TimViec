package model;

public class Employer {
	private String contact_name;
	private String employer_name;
	private String phone;
	private String address;
	private String image;
	private String city;
	private String email;
	
	public Employer() {
		super();
	}

	public Employer(String contact_name, String employer_name, String phone, String address, String image,
			String city, String email) {
		super();
		this.contact_name = contact_name;
		this.employer_name = employer_name;
		this.phone = phone;
		this.address = address;
		this.image = image;
		this.city = city;
		this.email = email;
	}

	public String getContact_name() {
		return contact_name;
	}

	public void setContact_name(String contact_name) {
		this.contact_name = contact_name;
	}

	public String getEmployer_name() {
		return employer_name;
	}

	public void setEmployer_name(String employer_name) {
		this.employer_name = employer_name;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
