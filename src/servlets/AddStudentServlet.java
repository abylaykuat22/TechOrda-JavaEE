package servlets;

import db.DBUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import models.Student;

@WebServlet(value = "/addStudent")
public class AddStudentServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String name = req.getParameter("s_name");
    String surname = req.getParameter("s_surname");
    String birthdate = req.getParameter("s_birthdate");
    String city = req.getParameter("s_city");

    Student student = new Student();
    student.setName(name);
    student.setSurname(surname);
    student.setBirthdate(birthdate);
    student.setCity(city);
    DBUtil.addStudent(student);
    resp.sendRedirect("/");
  }
}
