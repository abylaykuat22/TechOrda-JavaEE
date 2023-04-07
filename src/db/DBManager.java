package db;

import java.util.ArrayList;
import java.util.List;
import models.Item;

public class DBManager {
  private static List<Item> items = new ArrayList<>();

  private static Long id = 5L;

  static {
    items.add(new Item(1L, "IPhone X", 400000, 20));
    items.add(new Item(2L, "IPhone 13", 500000, 10));
    items.add(new Item(3L, "Samsung S21", 400000, 20));
    items.add(new Item(4L, "XIAOMI", 300000, 50));
  }

  public static List<Item> getItems() {
    return items;
  }

  public static void addItem(Item item) {
    item.setId(id);
    items.add(item);
    id++;
  }

  public static Item getItemById(Long id) {
    for (Item item : items) {
      if (item.getId() == id) {
        return item;
      }
    }
    return null;
  }
}
