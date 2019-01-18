package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/Servlet_02")
public class Servlet_02 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");

        String airportFrom = request.getParameter("airportFrom");
        String airportTo = request.getParameter("airportTo");
        String localTime = request.getParameter("localTime");
        String flightTime = request.getParameter("flightTime");
        String price = request.getParameter("price");
        response.getWriter().append("Lotnisko startu: ").append(airportFrom).append("<br>");
        response.getWriter().append("Lotnisko docelowe: ").append(airportTo).append("<br>");
        response.getWriter().append("Czas startu: ").append(localTime).append("<br>");
        response.getWriter().append("Długość lotu w godz: ").append(flightTime).append("<br>");
        response.getWriter().append("Cena lotu: ").append(price).append("<br>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        List<Airport> airports = AirportDao.getList();
        request.setAttribute("airports", airports);
        getServletContext().getRequestDispatcher("/form2.jsp")
                .forward(request, response);

    }
}
