package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Account;

import java.io.IOException;
import java.util.List;

import dal.AccountDAO;

/**
 * Servlet implementation class SearchAccountServlet
 */
public class SearchAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchAccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String partialEmail = request.getParameter("partialEmail");
		String accountType = request.getParameter("accountType");
		AccountDAO cd = new AccountDAO();
		List<Account> list;
		if (partialEmail != null) {
			list = cd.findAccountsByEmail(partialEmail);
		} else {
			list = cd.getAccountsByType(accountType);
			if ("Admin".equals(accountType)) {
		        accountType = "Quản trị viên";
		    } else if ("Employer".equals(accountType)) {
		        accountType = "Nhà tuyển dụng";
		    } else if ("User".equals(accountType)) {
		        accountType = "Người dùng";
		    }
		}
		request.setAttribute("data", list);
		request.setAttribute("role", accountType);
		request.getRequestDispatcher("/manageAccount.jsp").forward(request, response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
