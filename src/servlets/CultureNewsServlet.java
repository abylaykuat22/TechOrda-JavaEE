package servlets;

import db.DBManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import models.News;

@WebServlet(value = "/cultureNews")
public class CultureNewsServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    List<News> cultureNews = DBManager.getCultureNews();
    req.setAttribute("cultureNews", cultureNews);
    req.getRequestDispatcher("/cultureNews.jsp").forward(req, resp);
  }
}