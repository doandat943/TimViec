package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.JobEmployer;

import java.io.IOException;
import java.util.List;

import dal.JobDAO;

/**
 * Servlet implementation class EmployerServlet
 */
public class EmployerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JobDAO cd = new JobDAO();
		
		// Lấy giá trị của cookie có tên "email"
	    Cookie[] cookies = request.getCookies();
	    String email = null;
	    if (cookies != null) {
	        for (Cookie cookie : cookies) {
	            if ("email".equals(cookie.getName())) {
	                email = cookie.getValue();
	                break;
	            }
	        }
	    }
		List<JobEmployer> list = cd.getListByEmail(email);
		
		request.setAttribute("joblist", list);
		request.getRequestDispatcher("employer.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
