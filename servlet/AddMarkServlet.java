package com.servlet;

import com.dao.MarkDAO;
import com.model.StudentMark;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

@WebServlet("/AddMarkServlet")
public class AddMarkServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Set response content type
        response.setContentType("text/html");

        // Retrieve form parameters
        int studentID = Integer.parseInt(request.getParameter("studentID"));
        String studentName = request.getParameter("studentName");
        String subject = request.getParameter("subject");
        int marks = Integer.parseInt(request.getParameter("marks"));
        LocalDate examDate = LocalDate.parse(request.getParameter("examDate"));

        // Create StudentMark object
        StudentMark studentMark = new StudentMark(studentID, studentName, subject, marks, examDate);

        // Create MarkDAO object
        MarkDAO markDAO = new MarkDAO();

        try {
            // Add student mark to the database
            boolean isAdded = markDAO.addMark(studentMark);

            // Prepare response message
            String message;
            if (isAdded) {
                message = "Student marks added successfully!";
            } else {
                message = "Failed to add student marks. Please try again.";
            }

            // Set message as request attribute
            request.setAttribute("message", message);

            // Forward to result page
            RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");
            dispatcher.forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Database error: " + e.getMessage());
        }
    }
}
