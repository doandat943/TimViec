package dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Job;
import model.JobEmployer;

public class JobDAO extends DBContext {
	private static final Integer JOBS_PER_PAGE = 6;

	public List<JobEmployer> getList() {
		List<JobEmployer> list = new ArrayList<>();

		String sql = "SELECT j.*, c.employer_name, c.image\r\n" + "FROM job AS j\r\n"
				+ "INNER JOIN employer AS c ON j.email = c.email\r\n"
				+ "WHERE DATEDIFF(j.due_date, NOW()) > 0 AND j.confirm = 1\r\n" + "ORDER BY j.job_id DESC\r\n"
				+ "LIMIT 10;";
		

		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int job_id = rs.getInt("job_id");
				String title = rs.getString("title");
				String description = rs.getString("description");
				String job_require = rs.getString("job_require");
				String interest = rs.getString("interest");
				int quantity = rs.getInt("quantity");
				Double max_malary = rs.getDouble("max_salary");
				Double min_malary = rs.getDouble("min_salary");
				String profession = rs.getString("profession");
				String due_date = rs.getString("due_date");
				boolean confirm = rs.getBoolean("confirm");
				String city = rs.getString("city");
				String emp_name = rs.getString("employer_name");
				String image = rs.getString("image");

				list.add(new JobEmployer(job_id, title, description, job_require, interest, quantity, max_malary,
						min_malary, profession, due_date, confirm, city, emp_name, image));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<JobEmployer> getAList() {
		List<JobEmployer> list = new ArrayList<>();

		String sql = "SELECT j.*, c.employer_name, c.image\r\n" + "FROM job AS j\r\n"
				+ "INNER JOIN employer AS c ON j.email = c.email\r\n";

		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int job_id = rs.getInt("job_id");
				String title = rs.getString("title");
				String description = rs.getString("description");
				String job_require = rs.getString("job_require");
				String interest = rs.getString("interest");
				int quantity = rs.getInt("quantity");
				Double max_malary = rs.getDouble("max_salary");
				Double min_malary = rs.getDouble("min_salary");
				String profession = rs.getString("profession");
				String due_date = rs.getString("due_date");
				boolean confirm = rs.getBoolean("confirm");
				String city = rs.getString("city");
				String emp_name = rs.getString("employer_name");
				String image = rs.getString("image");

				list.add(new JobEmployer(job_id, title, description, job_require, interest, quantity, max_malary,
						min_malary, profession, due_date, confirm, city, emp_name, image));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<JobEmployer> getListByEmail(String email) {
		List<JobEmployer> list = new ArrayList<>();

		String sql = "SELECT j.*, c.employer_name, c.image, c.email\r\n" + "FROM job AS j\r\n"
				+ "INNER JOIN employer AS c ON j.email = c.email\r\n"
				+ "WHERE DATEDIFF(j.due_date, NOW()) > 0 AND c.email = ?\r\n" 
				+ "ORDER BY j.job_id DESC\r\n"
				+ "LIMIT 10;";

		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int job_id = rs.getInt("job_id");
				String title = rs.getString("title");
				String description = rs.getString("description");
				String job_require = rs.getString("job_require");
				String interest = rs.getString("interest");
				int quantity = rs.getInt("quantity");
				Double max_malary = rs.getDouble("max_salary");
				Double min_malary = rs.getDouble("min_salary");
				String profession = rs.getString("profession");
				String due_date = rs.getString("due_date");
				boolean confirm = rs.getBoolean("confirm");
				String city = rs.getString("city");
				String emp_name = rs.getString("employer_name");
				String image = rs.getString("image");

				list.add(new JobEmployer(job_id, title, description, job_require, interest, quantity, max_malary,
						min_malary, profession, due_date, confirm, city, emp_name, image));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<JobEmployer> getJobListExpire() {
		List<JobEmployer> list = new ArrayList<>();
		String sql = "SELECT j.*, c.employer_name, c.image\r\n" + "FROM job AS j\r\n"
				+ "INNER JOIN employer AS c ON j.email = c.email\r\n"
				+ "WHERE DATEDIFF(j.due_date, NOW()) <= 0 AND j.confirm = 1\r\n" + "ORDER BY j.job_id DESC";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int job_id = rs.getInt("job_id");
				String title = rs.getString("title");
				String description = rs.getString("description");
				String job_require = rs.getString("job_require");
				String interest = rs.getString("interest");
				int quantity = rs.getInt("quantity");
				Double max_malary = rs.getDouble("max_salary");
				Double min_malary = rs.getDouble("min_salary");
				String profession = rs.getString("profession");
				String due_date = rs.getString("due_date");
				boolean confirm = rs.getBoolean("confirm");
				String city = rs.getString("city");
				String emp_name = rs.getString("employer_name");
				String image = rs.getString("image");

				list.add(new JobEmployer(job_id, title, description, job_require, interest, quantity, max_malary,
						min_malary, profession, due_date, confirm, city, emp_name, image));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<JobEmployer> findJobByNameOrProfession(Integer currentPage, String search) {
		int offset = (currentPage - 1) * JOBS_PER_PAGE;
		List<JobEmployer> list = new ArrayList<>();
		String sql = "SELECT j.*, e.employer_name, e.image\r\n" + "FROM job AS j\r\n"
				+ "INNER JOIN employer AS e ON j.email = e.email\r\n" + "WHERE DATEDIFF(j.due_date, NOW()) > 0\r\n"
				+ "  AND j.confirm = 1\r\n"
				+ "  AND (j.title LIKE CONCAT('%', ?, '%') OR j.profession LIKE CONCAT('%', ?, '%'))\r\n"
				+ "ORDER BY j.job_id DESC;";
		List<JobEmployer> jobs = new ArrayList<>();
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, search);
			ps.setString(2, search);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int job_id = rs.getInt("job_id");
				String title = rs.getString("title");
				String description = rs.getString("description");
				String job_require = rs.getString("job_require");
				String interest = rs.getString("interest");
				int quantity = rs.getInt("quantity");
				Double max_malary = rs.getDouble("max_salary");
				Double min_malary = rs.getDouble("min_salary");
				String profession = rs.getString("profession");
				String due_date = rs.getString("due_date");
				boolean confirm = rs.getBoolean("confirm");
				String city = rs.getString("city");
				String emp_name = rs.getString("employer_name");
				String image = rs.getString("image");

				jobs.add(new JobEmployer(job_id, title, description, job_require, interest, quantity, max_malary,
						min_malary, profession, due_date, confirm, city, emp_name, image));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		if (jobs != null) {
			int minIndex = Math.min(jobs.size(), offset + JOBS_PER_PAGE);
			for (int i = offset; i < minIndex; i++) {
				list.add(jobs.get(i));
			}
		}
		return list;
	}

	public int getTotalPageSearch(String name) {
	    int totalPage = 0;
	    String sql = "SELECT COUNT(*) FROM job AS j INNER JOIN employer AS c ON j.email = c.email WHERE DATEDIFF(j.due_date, NOW()) > 0 AND j.confirm = 1 AND (j.title LIKE CONCAT('%', ? ,'%') OR j.profession LIKE CONCAT('%', ? ,'%'))";

	    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	        preparedStatement.setString(1, name);
	        preparedStatement.setString(2, name);

	        try (ResultSet resultSet = preparedStatement.executeQuery()) {
	            if (resultSet.next()) {
	                int totalJobs = resultSet.getInt(1);
	                totalPage = (int) Math.ceil((double) totalJobs / JOBS_PER_PAGE);
	            }
	        }

	    } catch (SQLException e) {
	        // Xử lý ngoại lệ SQLException
	        e.printStackTrace();
	    }
	    return totalPage;
	}


	public JobEmployer findJobById(int jobId) {
		String sql = "SELECT j.*, c.employer_name, c.image FROM job AS j INNER JOIN employer AS c ON j.email = c.email WHERE j.job_id=?";

		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, jobId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int job_id = rs.getInt("job_id");
				String title = rs.getString("title");
				String description = rs.getString("description");
				String job_require = rs.getString("job_require");
				String interest = rs.getString("interest");
				int quantity = rs.getInt("quantity");
				Double max_malary = rs.getDouble("max_salary");
				Double min_malary = rs.getDouble("min_salary");
				String profession = rs.getString("profession");
				String due_date = rs.getString("due_date");
				boolean confirm = rs.getBoolean("confirm");
				String city = rs.getString("city");
				String emp_name = rs.getString("employer_name");
				String image = rs.getString("image");

				return new JobEmployer(job_id, title, description, job_require, interest, quantity, max_malary,
						min_malary, profession, due_date, confirm, city, emp_name, image);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void deleteJob(int job_id) {
		String sql = "DELETE from job WHERE job_id=?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, job_id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteJobExpire() {
		String sql = "delete from job where datediff(due_date, now()) <= 0";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void confirmJob(int job_id, boolean confirm) {
		String sql = "update job set confirm=? where job_id=?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setBoolean(1, confirm);
			ps.setInt(2, job_id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int saveJob(Job job) {

		String sql = "INSERT INTO job(title, description, job_require, interest, quantity, max_salary, min_salary, profession, due_date, confirm, city, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, job.getTitle());
			ps.setString(2, job.getDescription());
			ps.setString(3, job.getJob_require());
			ps.setString(4, job.getInterest());
			ps.setInt(5, job.getQuantity());
			ps.setDouble(6, job.getMax_salary());
			ps.setDouble(7, job.getMin_salary());
			ps.setString(8, job.getProfession());
			ps.setDate(9, Date.valueOf(job.getDue_date()));
			ps.setBoolean(10, job.isConfirm());
			ps.setString(11, job.getCity());
			ps.setString(12, job.getEmail());
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
