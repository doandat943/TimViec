package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
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
		
		Cookie cu = new Cookie("email", email);
		Cookie cp = new Cookie("password", password);
		Cookie cr = new Cookie("rememberPassword", rememberPassword);
		if (rememberPassword != null) {
			cu.setMaxAge(7 * 60 * 60 * 24);
			cp.setMaxAge(7 * 60 * 60 * 24);
			cr.setMaxAge(7 * 60 * 60 * 24);
		} else {
			cu.setMaxAge(0);
			cp.setMaxAge(0);
			cr.setMaxAge(0);
		}

		response.addCookie(cu);
		response.addCookie(cp);
		response.addCookie(cr);
		AccountDAO d = new AccountDAO();
		Account a = d.check(email, password);
		if (a == null) {
			request.setAttribute("error", "Email or password invalid!!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("account", a);
			response.sendRedirect("ManageAccountServlet");
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
