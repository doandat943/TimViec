package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Employer;

public class EmployerDAO extends DBContext {

	public List<Employer> getList() {
		List<Employer> list = new ArrayList<>();
		String sql = "SELECT * FROM employer";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Employer c = new Employer(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
				list.add(c);
			}
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public Employer getEmployerByEmployerID(String email) {
		String sql = "select * FROM employer " 
					+ "where email = ?";

		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Employer c = new Employer(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
				return c;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Employer> findEmployerByName(String partialEmail) {
	    List<Employer> list = new ArrayList<>();
	    String sql = "SELECT * FROM employer WHERE email LIKE ?";

	    try (PreparedStatement ps = connection.prepareStatement(sql)) {
	        ps.setString(1, "%" + partialEmail + "%");

	        try (ResultSet rs = ps.executeQuery()) {
	            while (rs.next()) {
					Employer c = new Employer(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
	            	list.add(c);
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return list;
	}


	public Employer check(String email, String password) {
		String sql = "SELECT role " + "FROM employer " + "WHERE email=? AND password=?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String role = rs.getString(1);
				Employer c = new Employer(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
            	return c;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void insert(Employer c) {
		String sql = "INSERT INTO employer (contact_name, employer_name, phone, address, image, city, email) VALUES (?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, c.getContact_name());
		    ps.setString(2, c.getEmployer_name());
		    ps.setString(3, c.getPhone());
		    ps.setString(4, c.getAddress());
		    ps.setString(5, c.getImage());
		    ps.setString(6, c.getCity());
		    ps.setString(7, c.getEmail());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(Employer c) {
		String sql = "UPDATE Employer SET fullname = ?, phone = ?, address = ?, sex = ?, dob = ?, email = ? WHERE Employer_id = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, c.getContact_name());
		    ps.setString(2, c.getEmployer_name());
		    ps.setString(3, c.getPhone());
		    ps.setString(4, c.getAddress());
		    ps.setString(5, c.getImage());
		    ps.setString(6, c.getCity());
		    ps.setString(7, c.getEmail());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(String email) {
		String sql = "DELETE FROM employer " + "WHERE email=?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, email);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
