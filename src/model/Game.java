package model;

public class Game {
    private String name;
    private String genre;
    private int year;
    private int rating;
    private String groupName;

    public Game(String name, String genre, int year, int rating) {
        this.name = name;
        this.genre = genre;
        this.year = year;
        this.rating = rating;
    }

    public Game(String groupName) {
        this.groupName = groupName;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Game{" +
                "name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", year=" + year +
                ", rating=" + rating +
                ", groupName='" + groupName + '\'' +
                '}';
    }
}
