package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import model.Account;
import model.Employer;
import model.JobApp;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import dal.AccountDAO;
import dal.EmployerDAO;
import dal.JobDAO;

/**
 * Servlet implementation class ApplyServlet
 */
public class ApplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String job_id = request.getParameter("job_id");

		String applicationStatus = "Application Submitted Successfully";
        
        try {
            // Get the file part from the request
            Part filePart = request.getPart("file");

            // Get the file name
            String fileName = getSubmittedFileName(filePart);

            // Define the directory to store the uploaded file
            String uploadDir = getServletContext().getRealPath("/uploads");
            File uploadDirFile = new File(uploadDir);
            if (!uploadDirFile.exists()) {
                uploadDirFile.mkdir();
            }

            // Save the file to the server
            String filePath = uploadDir + File.separator + fileName;
            filePart.write(filePath);
            System.out.println(filePath);

            // Additional processing logic can be added here

        } catch (Exception e) {
            applicationStatus = "Error in Application Submission";
            e.printStackTrace();
        }

        // Set application status as a request attribute
        request.setAttribute("error", applicationStatus);

        // Forward the request to the Apply.jsp page
        getServletContext().getRequestDispatcher("/apply.jsp").forward(request, response);
    
		request.setAttribute("error", "Nộp SV thành công!!!");
		request.getRequestDispatcher("apply.jsp").forward(request, response);
	}
	
	private String getSubmittedFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] tokens = contentDisp.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return "";
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
