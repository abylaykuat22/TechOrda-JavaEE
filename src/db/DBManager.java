package db;

import java.util.ArrayList;
import java.util.List;
import models.Footballer;

public class DBManager {
    public static List<Footballer> footballers = new ArrayList<>();

    private static Long id = 4L;
    static {
        footballers.add(new Footballer(1L, "Lionel", "Messi", 2000000, "PSG", 200000));
        footballers.add(new Footballer(2L, "Cristiano", "Ronaldo", 2000000, "Al Nassr", 200000));
        footballers.add(new Footballer(3L, "Killian", "Mbappe", 2000000, "PSG", 200000));
    }

    public static List<Footballer> getFootballers() {
        return footballers;
    }

    public static void addFootballer(Footballer footballer) {
        footballer.setId(id);
        footballers.add(footballer);
        id++;
    }

}
