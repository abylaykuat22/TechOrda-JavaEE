package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/task1_4")
public class Task1_4Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("user_name");
        String surname = req.getParameter("user_surname");
        String order = req.getParameter("order");
        PrintWriter out = resp.getWriter();
        out.print("<h1>"+name+" "+surname+" ordered "+ order+"</h1>");
    }
}
