package servlets;

import db.DBManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import models.Item;

@WebServlet(value = "/addItem")
public class AddItemServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    req.getRequestDispatcher("/addItem.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String name = req.getParameter("i_name");
    String price = req.getParameter("i_price");
    String amount = req.getParameter("i_amount");

    Item item = new Item();
    item.setName(name);
    item.setPrice(Double.parseDouble(price));
    item.setAmount(Integer.parseInt(amount));
    DBManager.addItem(item);
    resp.sendRedirect("/home");
  }
}
