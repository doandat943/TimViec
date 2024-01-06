package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import dal.AccountDAO;
import model.Account;

/**
 * Servlet implementation class UpdateAccountServlet
 */
public class UpdateAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AccountDAO cd = new AccountDAO();
		String email = request.getParameter("email");
		Account c = cd.getAccountByEmail(email);
		request.setAttribute("account", c);
		request.getRequestDispatcher("change-password.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AccountDAO cd = new AccountDAO();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		Account c = new Account(email, password, role); 
		cd.update(c);
		if ("Admin".equals(cd.check(email, password)))
		{
			response.sendRedirect("ManageAccountServlet");
		}
		else {
			response.sendRedirect("login.jsp");
		}
	}
}
