package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.JobEmployer;

import java.io.IOException;

import dal.JobDAO;

/**
 * Servlet implementation class JobDetailServlet
 */
public class JobDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JobDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int job_id = Integer.parseInt(request.getParameter("job_id"));
	    JobDAO cd = new JobDAO();
	    JobEmployer job = cd.findJobById(job_id);

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

	    request.setAttribute("job", job);
	    request.setAttribute("email", email);
	    request.getRequestDispatcher("job-detail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
