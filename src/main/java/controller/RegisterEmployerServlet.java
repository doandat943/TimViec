package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Account;
import model.Employer;
import model.User;

import java.io.IOException;

import dal.AccountDAO;
import dal.EmployerDAO;
import dal.UserDAO;

/**
 * Servlet implementation class RegisterEmployerServlet
 */
public class RegisterEmployerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterEmployerServlet() {
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
		String contact_name = request.getParameter("contact_name");
		String employer_name = request.getParameter("employer_name");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String image = request.getParameter("image");
		String city = request.getParameter("city");

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

				EmployerDAO ad = new EmployerDAO();
				Employer c = new Employer(contact_name, employer_name, phone, address, image, city, email);
				ad.insert(c);
				error = "Đăng ký thành công";
			}
			
		} else {
			error = "Tài khoản với email này đã tồn tại!!";
		}
		request.setAttribute("error", error);
		request.getRequestDispatcher("register-employer.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
