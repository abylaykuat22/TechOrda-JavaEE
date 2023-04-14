package servlets;

import db.DBUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import models.Student;

@WebServlet(value = "/studentDetails")
public class StudentDetailsServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    Long id = Long.parseLong(req.getParameter("id"));
    Student student = DBUtil.getStudentById(id);
    req.setAttribute("student", student);
    req.getRequestDispatcher("/studentDetails.jsp").forward(req, resp);
  }
}
