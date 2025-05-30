package com.servlet;

import com.dao.MarkDAO;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/DeleteMarkServlet")
public class DeleteMarkServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve the StudentID from the request
        int studentID = Integer.parseInt(request.getParameter("studentID"));

        // Create MarkDAO object
        MarkDAO markDAO = new MarkDAO();

        try {
            // Delete the student mark record by StudentID
            boolean isDeleted = markDAO.deleteMark(studentID);

            // Prepare response message
            String message;
            if (isDeleted) {
                message = "Student marks deleted successfully!";
            } else {
                message = "Failed to delete student marks. Please try again.";
            }

            // Set message as request attribute
            request.setAttribute("message", message);

            // Forward to result page
            RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");
            dispatcher.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            // Set error message
            request.setAttribute("errorMessage", "Database error: " + e.getMessage());
            // Forward to error page
            RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
            dispatcher.forward(request, response);
        }
    }
}
