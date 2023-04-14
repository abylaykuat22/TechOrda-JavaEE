package servlets;

import db.DBUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import models.Student;

@WebServlet(value = "/home")
public class HomeServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    List<Student> students = DBUtil.getStudents();
    req.setAttribute("studenty", students);
    req.getRequestDispatcher("/home.jsp").forward(req, resp);
  }
}