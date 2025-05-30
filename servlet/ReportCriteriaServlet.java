package com.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/ReportCriteriaServlet")
public class ReportCriteriaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Forward the request to the report_form.jsp page
        RequestDispatcher dispatcher = request.getRequestDispatcher("report_form.jsp");
        dispatcher.forward(request, response);
    }
}
