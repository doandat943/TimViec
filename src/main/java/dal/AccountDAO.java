package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Account;

public class AccountDAO extends DBContext {

	public List<Account> getList() {
		List<Account> list = new ArrayList<>();
		String sql = "SELECT * FROM account";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Account c = new Account(rs.getString(1), rs.getString(2), rs.getString(3));
				list.add(c);
			}
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public Account getAccountByEmail(String email) {
		String sql = "select * from account " 
					+ "where email = ?";

		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Account c = new Account(email, rs.getString("password"), rs.getString("role"));
				return c;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Account> getAccountsByType(String accountType) {
        List<Account> accountList = new ArrayList<>();
        String sql = "SELECT * FROM account WHERE role = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, accountType);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Account account = new Account(rs.getString("email"), rs.getString("password"), rs.getString("role"));
                    accountList.add(account);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return accountList;
    }
	
	public List<Account> findAccountsByEmail(String partialEmail) {
	    List<Account> accountList = new ArrayList<>();
	    String sql = "SELECT * FROM account WHERE email LIKE ?";

	    try (PreparedStatement ps = connection.prepareStatement(sql)) {
	        ps.setString(1, "%" + partialEmail + "%");

	        try (ResultSet rs = ps.executeQuery()) {
	            while (rs.next()) {
	                Account account = new Account(rs.getString("email"), rs.getString("password"), rs.getString("role"));
	                accountList.add(account);
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return accountList;
	}


	public String check(String email, String password) {
		String sql = "SELECT role " + "FROM account " + "WHERE email=? AND password=?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void insert(Account c) {
		String sql = "INSERT INTO account VALUES (?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, c.getEmail());
			ps.setString(2, c.getPassword());
			ps.setString(3, c.getRole());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(Account c) {
	    String sql = "UPDATE account SET email = ?, password = ?, role = ? WHERE email=?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, c.getEmail());
			ps.setString(2, c.getPassword());
			ps.setString(3, c.getRole());
			ps.setString(4, c.getEmail());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(String email) {
		String sql = "DELETE from account " + "WHERE email=?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, email);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
