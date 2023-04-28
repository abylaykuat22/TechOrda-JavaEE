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

@WebServlet(value = "/editStudent")
public class EditStudentServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    Long id = Long.parseLong(req.getParameter("id"));
    Student student = DBUtil.getStudentById(id);
    List<City> cities = DBUtil.getCities();
    req.setAttribute("kalalar", cities);
    req.setAttribute("student", student);
    req.getRequestDispatcher("/editStudent.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    Long id = Long.parseLong(req.getParameter("id"));
    String name = req.getParameter("name");
    String surname = req.getParameter("surname");
    String birthdate = req.getParameter("birthdate");
    Long cityId = Long.parseLong(req.getParameter("city_id"));

    Student student = DBUtil.getStudentById(id);
    student.setName(name);
    student.setSurname(surname);
    student.setBirthdate(birthdate);

    City city = DBUtil.getCityById(cityId);
    student.setCity(city);

    DBUtil.updateStudent(student);
    resp.sendRedirect("/");
  }
}
