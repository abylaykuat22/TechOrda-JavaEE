package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.DBManager;
import models.Footballer;

import java.io.IOException;

@WebServlet(value = "/task1_7")
public class Task1_7Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("f_name");
        String surname = req.getParameter("f_surname");
        String club = req.getParameter("f_club");
        String salary = req.getParameter("f_salary");
        String transferPrice = req.getParameter("f_transfer_price");

        Footballer footballer = new Footballer();
        footballer.setName(name);
        footballer.setSurname(surname);
        footballer.setClub(club);
        footballer.setSalary(Integer.parseInt(salary));
        footballer.setTransferPrice(Integer.parseInt(transferPrice));
        DBManager.addFootballer(footballer);
        resp.sendRedirect("/home");
    }
}
