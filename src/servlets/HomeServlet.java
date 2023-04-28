package servlets;

import db.DBUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import models.City;
import models.Student;
import models.University;

@WebServlet(value = "/home")
public class HomeServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    List<Student> students = DBUtil.getStudents();
    List<City> cities = DBUtil.getCities();
    List<University> universities = DBUtil.getUniversities();
    req.setAttribute("studenty", students);
    req.setAttribute("goroda", cities);
    req.setAttribute("universitetter", universities);
    req.getRequestDispatcher("/home.jsp").forward(req, resp);
  }
}