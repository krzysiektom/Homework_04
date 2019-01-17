package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/Servlet_01_2")
public class Servlet_01_2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        String langAbr = request.getParameter("lang");
        Map<String, String> lang = Servlet_01_1.initMap();
        if (lang.containsKey(langAbr)) {

            Cookie cookie = new Cookie("language", lang.get(langAbr));
            cookie.setMaxAge(60);
            response.addCookie(cookie);
            response.getWriter().append("Ustawiono ciasteczko na: ").append(lang.get(langAbr));
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
