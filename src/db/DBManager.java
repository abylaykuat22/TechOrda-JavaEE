package db;

import java.util.ArrayList;
import java.util.List;
import models.News;

public class DBManager {
  private static List<News> news = new ArrayList<>();

  private static Long id = 5L;

  static {
    news.add(new News(1L, "Title sport 1", "Content sport 1", "Author 1", "sport"));
    news.add(new News(2L, "Title sport 2", "Content sport 2", "Author 2", "sport"));
    news.add(new News(3L, "Title culture 1", "Content culture 1", "Author 3", "culture"));
    news.add(new News(4L, "Title culture 2", "Content sport 2", "Author 1", "culture"));
    news.add(new News(4L, "Title cinema 2", "Content cinema 2", "Author 2", "cinema"));
    news.add(new News(4L, "Title cinema 2", "Content cinema 3", "Author 1", "cinema"));
  }

  public static List<News> getNews() {
    return news;
  }

  public static List<News> getCultureNews() {
    List<News> cultureNews = new ArrayList<>();
    for (News n : news) {
      if (n.getCategory().equals("culture")){
        cultureNews.add(n);
      }
    }
    return cultureNews;
  }

}
