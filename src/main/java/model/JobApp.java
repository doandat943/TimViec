package model;

public class JobApp {
	private String email;
	private int job_id;
	private String file_cv;
	
	public JobApp() {
		super();
	}

	public JobApp(String email, int job_id, String file_cv) {
		super();
		this.email = email;
		this.job_id = job_id;
		this.file_cv = file_cv;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getJob_id() {
		return job_id;
	}

	public void setJob_id(int job_id) {
		this.job_id = job_id;
	}

	public String getFile_cv() {
		return file_cv;
	}

	public void setFile_cv(String file_cv) {
		this.file_cv = file_cv;
	}
}
