package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Account;
import model.JobEmployer;

import java.io.IOException;
import java.util.List;

import dal.AccountDAO;
import dal.JobDAO;

/**
 * Servlet implementation class SearchServlet
 */
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int VISIBLE_PAGES = 5;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JobDAO cd = new JobDAO();
		Integer currentPage = Integer.parseInt(request.getParameter("currentPage"));
		String search = request.getParameter("search");
		
		if (currentPage == null) {
			currentPage = 1;
		}
		
		List<JobEmployer> listJobs = cd.findJobByNameOrProfession(currentPage, search);
		int totalPages = cd.getTotalPageSearch(search);
		int startPage = Math.max(currentPage - VISIBLE_PAGES / 2, 1);
		int endPage = Math.min(startPage + VISIBLE_PAGES - 1, totalPages);
		request.setAttribute("totalPages", totalPages);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("listJobs", listJobs);
		request.setAttribute("search", search);
		
		request.getRequestDispatcher("search.jsp").forward(request, response);
//		response.sendRedirect("search.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
