package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.print.Book;
import java.io.IOException;
import java.util.List;

@WebServlet("/guest-book")
public class Servlet_04 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        String name= request.getParameter("name");
        String text= request.getParameter("text");
        GuestBook book = new GuestBook(name,text);
        GuestBookDao.getInstance().save(book);
        List<GuestBook> guestBooks = GuestBookDao.getInstance().findAll();
        request.setAttribute("guestBooks",guestBooks);
        getServletContext().getRequestDispatcher("/form4.jsp")
                .forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        List<GuestBook> guestBooks = GuestBookDao.getInstance().findAll();
        request.setAttribute("guestBooks",guestBooks);
        getServletContext().getRequestDispatcher("/form4.jsp")
                .forward(request, response);
    }
}
