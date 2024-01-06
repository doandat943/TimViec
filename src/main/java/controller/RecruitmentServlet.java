package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Job;
import model.JobEmployer;

import java.io.IOException;
import java.util.List;

import dal.JobDAO;

/**
 * Servlet implementation class RecruitmentServlet
 */
public class RecruitmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecruitmentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		request.setAttribute("email", email);
		request.getRequestDispatcher("recruitment.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String job_require = request.getParameter("job_require");
		String interest = request.getParameter("interest");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		double max_salary = Double.parseDouble(request.getParameter("max_salary"));
		double min_salary = Double.parseDouble(request.getParameter("min_salary"));
		String profession = request.getParameter("profession");
		String due_date = request.getParameter("due_date");
		String city = request.getParameter("city");
		String email = request.getParameter("email");
		
		JobDAO ad = new JobDAO();
		Job c = new Job();
		int result = ad.saveJob(new Job(0, title, description, job_require, interest,
				quantity, max_salary, min_salary, profession,
				due_date, false, city, email));
		String error = "";
		if (result > 0) {
			error = "Lưu tin thành công. Vui lòng đợi duyệt!";
		} else {
			error = "Lưu tin không thành công.";
		}
		request.setAttribute("error", error);
		request.getRequestDispatcher("recruitment.jsp").forward(request, response);
	}

}
