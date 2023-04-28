package models;

public class University {

  private Long id;
  private String name;
  private double rating;

  public University(Long id, String name, double rating) {
    this.id = id;
    this.name = name;
    this.rating = rating;
  }

  public University() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getRating() {
    return rating;
  }

  public void setRating(double rating) {
    this.rating = rating;
  }
}
