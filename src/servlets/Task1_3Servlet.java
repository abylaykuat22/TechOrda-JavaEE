package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/task1_3")
public class Task1_3Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("user_name");
        String surname = req.getParameter("user_surname");
        PrintWriter out = resp.getWriter();
        out.print("<h1>"+name+"</h1>");
        out.print("<h1>"+surname+"</h1>");
    }
}
