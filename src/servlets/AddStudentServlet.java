package servlets;

import db.DBUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import models.City;
import models.Student;
import models.University;

@WebServlet(value = "/addStudent")
public class AddStudentServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String name = req.getParameter("s_name");
    String surname = req.getParameter("s_surname");
    String birthdate = req.getParameter("s_birthdate");
    Long cityId = Long.parseLong(req.getParameter("s_city"));
    Long universityId = Long.parseLong(req.getParameter("university_id"));

    Student student = new Student();
    student.setName(name);
    student.setSurname(surname);
    student.setBirthdate(birthdate);

    City city = DBUtil.getCityById(cityId);
    student.setCity(city);

    University university = DBUtil.getUniversityById(universityId);
    student.setUniversity(university);

    DBUtil.addStudent(student);
    resp.sendRedirect("/");
  }
}
