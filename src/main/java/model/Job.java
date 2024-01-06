package model;

public class Job {
	private int job_id;
	private String title;
	private String description;
	private String job_require;
	private String interest;
	private int quantity;
	private double max_salary;
	private double min_salary;
	private String profession;
	private String due_date;
	private boolean confirm;
	private String city;
	private String email;
	
	public Job() {
		super();
	}

	public Job(int job_id, String title, String description, String job_require, String interest, int quantity,
			double max_salary, double min_salary, String profession, String due_date, boolean confirm, String city,
			String email) {
		super();
		this.job_id = job_id;
		this.title = title;
		this.description = description;
		this.job_require = job_require;
		this.interest = interest;
		this.quantity = quantity;
		this.max_salary = max_salary;
		this.min_salary = min_salary;
		this.profession = profession;
		this.due_date = due_date;
		this.confirm = confirm;
		this.city = city;
		this.email = email;
	}

	public int getJob_id() {
		return job_id;
	}

	public void setJob_id(int job_id) {
		this.job_id = job_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getJob_require() {
		return job_require;
	}

	public void setJob_require(String job_require) {
		this.job_require = job_require;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getMax_salary() {
		return max_salary;
	}

	public void setMax_salary(double max_salary) {
		this.max_salary = max_salary;
	}

	public double getMin_salary() {
		return min_salary;
	}

	public void setMin_salary(double min_salary) {
		this.min_salary = min_salary;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getDue_date() {
		return due_date;
	}

	public void setDue_date(String due_date) {
		this.due_date = due_date;
	}

	public boolean isConfirm() {
		return confirm;
	}

	public void setConfirm(boolean confirm) {
		this.confirm = confirm;
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

	public void setEmail(String emp_id) {
		this.email = emp_id;
	}
}
