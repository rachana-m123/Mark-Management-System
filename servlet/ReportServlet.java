package com.servlet;

import com.dao.MarkDAO;
import com.model.StudentMark;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/ReportServlet")
public class ReportServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve form parameters
        String subject = request.getParameter("subject");
        int marksThreshold = Integer.parseInt(request.getParameter("marksThreshold"));
        LocalDate startDate = LocalDate.parse(request.getParameter("startDate"));
        LocalDate endDate = LocalDate.parse(request.getParameter("endDate"));

        // Create MarkDAO object
        MarkDAO markDAO = new MarkDAO();

        try {
            // Retrieve student marks based on the report criteria
            List<StudentMark> reportData = markDAO.getReportData(subject, marksThreshold, startDate, endDate);

            // Set report data as request attribute
            request.setAttribute("reportData", reportData);

            // Forward to report_result.jsp
            RequestDispatcher dispatcher = request.getRequestDispatcher("report_result.jsp");
            dispatcher.forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
            // Set error message
            request.setAttribute("errorMessage", "Database error: " + e.getMessage());
            // Forward to error page
            RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
            dispatcher.forward(request, response);
        }
    }
}
