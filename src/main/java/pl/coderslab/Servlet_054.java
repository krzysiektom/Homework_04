package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/Servlet_054")
public class Servlet_054 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        HttpSession session = request.getSession();
        List<String> pages = (List<String>) session.getAttribute("pages");
        if (pages == null) {
            pages = new ArrayList<>();
        } else {
            pages.add("Strona 4");
        }
        session.setAttribute("pages", pages);
        getServletContext().getRequestDispatcher("/page4.jsp")
                .forward(request, response);
    }
}
