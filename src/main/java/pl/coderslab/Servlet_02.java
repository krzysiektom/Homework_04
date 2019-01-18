package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
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
        if (airportFrom.equals(airportTo)) {
            response.getWriter().append("Lotnisko startu i lądowania jest takie same.");
            return;
        }
        if (localTime == "" || flightTime == "") {
            response.getWriter().append("Wprowadzno niepoprawną datę lub czas lotu.");
            return;
        }
        if ("".equals(price) || Double.parseDouble(price) <= 0) {
            response.getWriter().append("Cena biletu musi być większa od 0.");
            return;
        }
        List<Airport> airports = AirportDao.getList();

        String departureZoneIdString = "";
        String arrivalZoneIdString = "";
        for (Airport airport : airports) {
            if (airport.getCode().equals(airportFrom)) {
                departureZoneIdString = airport.getTimezone();
            }
            if (airport.getCode().equals(airportTo)) {
                arrivalZoneIdString = airport.getTimezone();
            }
        }
        LocalDateTime ldt = LocalDateTime.parse(localTime);
        ZoneId departureZoneId = ZoneId.of(departureZoneIdString);
        ZonedDateTime departureZonedDateTime = ldt.atZone(departureZoneId);
        ZoneId arrivalZoneId = ZoneId.of(arrivalZoneIdString);
        ZonedDateTime arrivalZonedDateTime = departureZonedDateTime.withZoneSameInstant(arrivalZoneId);
        ZonedDateTime arrivalTime = arrivalZonedDateTime.plusHours(Long.parseLong(flightTime));
        Flight flightTemp = new Flight(airportFrom, airportTo, arrivalTime, Double.parseDouble(price));

        response.getWriter().append("Lotnisko startu: ").append(airportFrom).append("<br>");
        response.getWriter().append("Lotnisko docelowe: ").append(airportTo).append("<br>");
        response.getWriter().append("Czas startu: ").append(localTime).append("<br>");
        response.getWriter().append("Długość lotu w godz: ").append(flightTime).append("<br>");
        response.getWriter().append("Cena lotu: ").append(price).append("<br>");
        response.getWriter().append("Obiekt Flight: ").append(flightTemp.toString()).append("<br>");
        request.setAttribute("flight", flightTemp);
        request.setAttribute("airports", airports);
        request.setAttribute("flightTime", flightTime);
        request.setAttribute("ldt", ldt);

        getServletContext().getRequestDispatcher("/table2.jsp")
                .forward(request, response);
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
