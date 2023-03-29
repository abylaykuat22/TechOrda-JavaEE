package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.DBManager;
import models.Footballer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(value = "/home")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        //Task 1-3
        out.print("<div>");
        out.print("<form action='/task1_3' method='get'>");
        out.print("<input type='text' placeholder='Insert name' name='user_name'>");
        out.print("<input type='text' placeholder='Insert surname' name='user_surname'>");
        out.print("<button>SEND</button>");
        out.print("</form>");
        out.print("</div>");

        //Task1-4
        out.print("<div>");
        out.print("<form action='/task1_4' method='get'>");
        out.print("<input type='text' placeholder='Insert name' name='user_name'>");
        out.print("<input type='text' placeholder='Insert surname' name='user_surname'>");
        out.print("<select name='order'>");
        out.print("<option>Manty - 900KZT</option>");
        out.print("<option>Plov - 1000KZT</option>");
        out.print("</select>");
        out.print("<button>SEND</button>");
        out.print("</form>");
        out.print("</div>");

        //Task1-7
        out.print("<div>");
        out.print("<form action='/task1_7' method='post'>");
        out.print("<input type='text' placeholder='Insert name' name='f_name'>");
        out.print("<input type='text' placeholder='Insert surname' name='f_surname'>");
        out.print("<select name='f_club'>");
        out.print("<option>Real Madrid</option>");
        out.print("<option>PSG</option>");
        out.print("</select>");
        out.print("<input type='number' placeholder='Insert salary' name='f_salary'>");
        out.print("<input type='number' placeholder='Insert transfer price' name='f_transfer_price'>");
        out.print("<button>ADD FOOTBALLER</button>");
        out.print("</form>");
        out.print("</div>");


        List<Footballer> footballers = DBManager.getFootballers();
        for (Footballer footballer : footballers) {
            out.print("<h1>"+footballer.getName() + " " +footballer.getSurname()+"</h1>");
            out.print("<h2>"+footballer.getClub()+"</h2>");
            out.print("<h3>"+footballer.getSalary()+"</h3>");
            out.print("<h4>"+footballer.getTransferPrice()+"</h4>");
            out.print("<br>");
        }
    }
}
