package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;

import java.io.IOException;

import dal.AccountDAO;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String rememberPassword = request.getParameter("rememberPassword");

		AccountDAO d = new AccountDAO();
		String role = d.check(email, password);
		
		Cookie cu = new Cookie("email", email);
		Cookie cp = new Cookie("password", password);
		Cookie cro = new Cookie("role", role);
		Cookie cr = new Cookie("rememberPassword", rememberPassword);
		if (rememberPassword != null) {
			cu.setMaxAge(7 * 60 * 60 * 24);
			cp.setMaxAge(7 * 60 * 60 * 24);
			cro.setMaxAge(7 * 60 * 60 * 24);
			cr.setMaxAge(7 * 60 * 60 * 24);
		} else {
			cu.setMaxAge(0);
			cp.setMaxAge(0);
			cro.setMaxAge(0);
			cr.setMaxAge(0);
		}

		response.addCookie(cu);
		response.addCookie(cp);
		response.addCookie(cro);
		response.addCookie(cr);
		if (role == null) {
			request.setAttribute("error", "Email or password invalid!!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else if (role.equals("Admin")){
			response.sendRedirect("ManageAccountServlet");
		} else if (role.equals("Employer")){
			response.sendRedirect("EmployerServlet");
		} else if (role.equals("User")){
			response.sendRedirect("JobListServlet");
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
