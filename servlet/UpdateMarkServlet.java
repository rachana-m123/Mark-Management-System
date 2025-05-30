package com.servlet;

import com.dao.MarkDAO;
import com.model.StudentMark;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

@WebServlet("/UpdateMarkServlet")
public class UpdateMarkServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve the StudentID from the request
        int studentID = Integer.parseInt(request.getParameter("studentID"));

        // Create MarkDAO object
        MarkDAO markDAO = new MarkDAO();

        try {
            // Retrieve the student mark record by StudentID
            StudentMark studentMark = markDAO.getMarksByStudentID(studentID);

            // Check if the record exists
            if (studentMark != null) {
                // Set the student mark object as a request attribute
                request.setAttribute("studentMark", studentMark);

                // Forward the request to the update form JSP
                RequestDispatcher dispatcher = request.getRequestDispatcher("markupdate.jsp");
                dispatcher.forward(request, response);
            } else {
                // Record not found, set error message
                request.setAttribute("errorMessage", "Student record not found.");
                // Forward to error page
                RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
                dispatcher.forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Set error message
            request.setAttribute("errorMessage", "Database error: " + e.getMessage());
            // Forward to error page
            RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
            dispatcher.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
            // Update the student mark record in the database
            boolean isUpdated = markDAO.updateMark(studentMark);

            // Prepare response message
            String message;
            if (isUpdated) {
                message = "Student marks updated successfully!";
            } else {
                message = "Failed to update student marks. Please try again.";
            }

            // Set message as request attribute
            request.setAttribute("message", message);

            // Forward to result page
            RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");
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
