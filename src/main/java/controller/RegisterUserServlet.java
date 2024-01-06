package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;
import model.User;

import java.io.IOException;

import dal.AccountDAO;
import dal.UserDAO;

/**
 * Servlet implementation class RegisterUserServlet
 */
public class RegisterUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String repeatPassword = request.getParameter("repeatPassword");
		String fullname = request.getParameter("fullname");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String sex = request.getParameter("sex");
		String dob = request.getParameter("dob");

		AccountDAO d = new AccountDAO();
		Account a = d.getAccountByEmail(email);
		String error = "cc";
		if (a == null) {
			if (!password.equals(repeatPassword)) {
				error = "Mật khẩu không khớp!!!";
			}
			else {
				Account b = new Account(email, password, "User");
				d.insert(b);

				UserDAO ad = new UserDAO();
				User c = new User(fullname, phone, address, sex, dob, email);
				ad.insert(c);
				error = "Đăng ký thành công";
			}
			
		} else {
			error = "Tài khoản với email này đã tồn tại!!";
		}
		request.setAttribute("error", error);
		request.getRequestDispatcher("register-user.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
