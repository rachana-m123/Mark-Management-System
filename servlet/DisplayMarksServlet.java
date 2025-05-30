package com.servlet;

import com.dao.MarkDAO;
import com.model.StudentMark;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/DisplayMarksServlet")
public class DisplayMarksServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Create MarkDAO object
        MarkDAO markDAO = new MarkDAO();

        try {
            // Retrieve all student marks from the database
            List<StudentMark> marksList = markDAO.getAllMarks();

            // Set the list of student marks as a request attribute
            request.setAttribute("marksList", marksList);

            // Forward the request to the markdisplay.jsp page
            RequestDispatcher dispatcher = request.getRequestDispatcher("markdisplay.jsp");
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
