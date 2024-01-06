package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class UserDAO extends DBContext {

	public List<User> getList() {
		List<User> list = new ArrayList<>();
		String sql = "SELECT * FROM user";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User c = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
				list.add(c);
			}
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public User getUserByEmail(String email) {
		String sql = "select * FROM user where email = ?";

		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				User c = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
				return c;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<User> findUserByName(String partialEmail) {
	    List<User> list = new ArrayList<>();
	    String sql = "SELECT * FROM user WHERE email LIKE ?";

	    try (PreparedStatement ps = connection.prepareStatement(sql)) {
	        ps.setString(1, "%" + partialEmail + "%");

	        try (ResultSet rs = ps.executeQuery()) {
	            while (rs.next()) {
	            	User c = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
	            	list.add(c);
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return list;
	}


	public User check(String email, String password) {
		String sql = "SELECT role FROM user WHERE email=? AND password=?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String role = rs.getString(1);
				User c = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
            	return c;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void insert(User c) {
		String sql = "INSERT INTO user (fullname, phone, address, sex, dob, email) VALUES (?,?,?,?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, c.getFullname());
		    ps.setString(2, c.getPhone());
		    ps.setString(3, c.getAddress());
		    ps.setString(4, c.getSex());
		    ps.setString(5, c.getDob());
		    ps.setString(6, c.getEmail());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(User c) {
		String sql = "UPDATE user SET fullname = ?, phone = ?, address = ?, sex = ?, dob = ? WHERE email = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, c.getFullname());
		    ps.setString(2, c.getPhone());
		    ps.setString(3, c.getAddress());
		    ps.setString(4, c.getSex());
		    ps.setString(5, c.getDob());
		    ps.setString(6, c.getEmail());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(String email) {
		String sql = "DELETE FROM user " + "WHERE email=?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, email);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
