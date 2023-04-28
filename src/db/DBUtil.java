package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.City;
import models.Student;
import models.University;

public class DBUtil {

  private static Connection connection;

  static {
    try {
      Class.forName("org.postgresql.Driver");
      connection = DriverManager.getConnection(
          "jdbc:postgresql://localhost:5432/techorda-javaee-db",
          "postgres",
          "postgre"
      );
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static List<Student> getStudents() {
    List<Student> students = new ArrayList<>();
    try {
      PreparedStatement statement = connection.prepareStatement(""
          + "select s.id, s.name, s.surname, s.birthdate, s.city_id, s.university_id, c.name as city_name, "
          + "c.code, u.name as u_name, u.rating "
          + "from students s "
          + "inner join universities u on s.university_id = u.id "
          + "inner join cities c on s.city_id = c.id");
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()) {
        Student student = new Student();
        student.setId(resultSet.getLong("id"));
        student.setName(resultSet.getString("name"));
        student.setSurname(resultSet.getString("surname"));
        student.setBirthdate(resultSet.getString("birthdate"));

        City city = new City();
        city.setId(resultSet.getLong("city_id"));
        city.setName(resultSet.getString("city_name"));
        city.setCode(resultSet.getString("code"));
        student.setCity(city);

        University university = new University();
        university.setId(resultSet.getLong("university_id"));
        university.setName(resultSet.getString("u_name"));
        university.setRating(resultSet.getDouble("rating"));
        student.setUniversity(university);

        students.add(student);
      }
      statement.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return students;
  }

  public static void addStudent(Student student) {
    try {
      PreparedStatement statement = connection.prepareStatement(""
          + "insert into students(name, surname, birthdate, city_id, university_id) "
          + "values (?, ?, ?, ?, ?)");
      statement.setString(1, student.getName());
      statement.setString(2, student.getSurname());
      statement.setString(3, student.getBirthdate());
      statement.setLong(4, student.getCity().getId());
      statement.setLong(5, student.getUniversity().getId());
      statement.executeUpdate();
      statement.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static Student getStudentById(Long id) {
    Student student = null;
    try {
      PreparedStatement statement = connection.prepareStatement(""
          + "select * from students where id=?");
      statement.setLong(1, id);
      ResultSet resultSet = statement.executeQuery();
      if (resultSet.next()) {
        student = new Student();
        student.setId(resultSet.getLong("id"));
        student.setName(resultSet.getString("name"));
        student.setSurname(resultSet.getString("surname"));
        student.setBirthdate(resultSet.getString("birthdate"));

        Long universityId = resultSet.getLong("university_id");
        University university = getUniversityById(universityId);
        student.setUniversity(university);

        Long cityId = resultSet.getLong("city_id");
        City city = getCityById(cityId);
        student.setCity(city);
      }
      statement.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return student;
  }

  public static void updateStudent(Student student) {
    try {
      PreparedStatement statement = connection.prepareStatement(""
          + "update students "
          + "set name=?, surname=?, birthdate=?, city_id=? "
          + "where id=?");
      statement.setString(1, student.getName());
      statement.setString(2, student.getSurname());
      statement.setString(3, student.getBirthdate());
      statement.setLong(4, student.getCity().getId());
      statement.setLong(5, student.getId());
      statement.executeUpdate();
      statement.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void deleteStudentById(Long id) {
    try {
      PreparedStatement statement = connection.prepareStatement(""
          + "delete from students where id=?");
      statement.setLong(1, id);
      statement.executeUpdate();
      statement.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static List<City> getCities() {
    List<City> cities = new ArrayList<>();
    try {
      PreparedStatement statement = connection.prepareStatement(
          "select * from cities"
      );
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()) {
        City city = new City();
        city.setId(resultSet.getLong("id"));
        city.setName(resultSet.getString("name"));
        city.setCode(resultSet.getString("code"));
        cities.add(city);
      }
      statement.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return cities;
  }

  public static City getCityById(Long id) {
    City city = null;
    try {
      PreparedStatement statement = connection.prepareStatement(
          "select * from cities where id=?"
      );
      statement.setLong(1, id);
      ResultSet resultSet = statement.executeQuery();
      if (resultSet.next()) {
        city = new City();
        city.setId(resultSet.getLong("id"));
        city.setName(resultSet.getString("name"));
        city.setCode(resultSet.getString("code"));
      }
      statement.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return city;
  }

  public static List<University> getUniversities() {
    List<University> universities = new ArrayList<>();
    try {
      PreparedStatement statement = connection.prepareStatement(
          "select * from universities"
      );
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()) {
        University university = new University();
        university.setId(resultSet.getLong("id"));
        university.setName(resultSet.getString("name"));
        university.setRating(resultSet.getDouble("rating"));
        universities.add(university);
      }
      statement.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return universities;
  }

  public static University getUniversityById(Long universityId) {
    University university = null;
    try {
      PreparedStatement statement = connection.prepareStatement(
          "select * from universities where id=?"
      );
      statement.setLong(1, universityId);
      ResultSet resultSet = statement.executeQuery();
      if (resultSet.next()) {
        university = new University();
        university.setId(resultSet.getLong("id"));
        university.setName(resultSet.getString("name"));
        university.setRating(resultSet.getDouble("rating"));
      }
      statement.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return university;
  }
}
