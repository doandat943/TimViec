package model;

public class User {
	private String username;
	private String password;
	private String role_id;
	
	public User() {
		super();
	}

	public User(String username, String password, String role_id) {
		super();
		this.username = username;
		this.password = password;
		this.role_id = role_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole_id() {
		return role_id;
	}

	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}
}
