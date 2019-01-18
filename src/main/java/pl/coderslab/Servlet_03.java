package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/newsletter")
public class Servlet_03 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        Cookie[] cookies = request.getCookies();
        if (cookies == null || cookies.length == 0) {
            Cookie cookie = new Cookie("visit", "true");
            cookie.setMaxAge(60);
            response.addCookie(cookie);
        }
        boolean existCookie = false;
        for (Cookie cookie : cookies) {
            if ("visit".equals(cookie.getName())) {
                cookie.setMaxAge(60);
                response.addCookie(cookie);
                existCookie = true;
            }
        }
        if (!existCookie) {
            Cookie cookie = new Cookie("visit", "true");
            cookie.setMaxAge(60);
            response.addCookie(cookie);
        }
        User user = new User(email, name);
        UserDao.getInstance().save(user);
        getServletContext().getRequestDispatcher("/form3.jsp")
                .forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/form3.jsp")
                .forward(request, response);
    }
}
