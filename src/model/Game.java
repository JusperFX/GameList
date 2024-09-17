package model;

public class Game {
    private String name;
    private String genre;
    private int year;
    private Integer rating;
    private String groupName;
    private static int idCounter = 0;
    private int id;

    //Если игра наполнена всеми параметрами - конструктор
    public Game(String name, String genre, int year, Integer rating) {
        this.id = ++idCounter;
        this.name = name;
        this.genre = genre;
        this.year = year;
        this.rating = rating;
    }

    // Если игра не имеет рейтинг - конструктор
    public  Game(String name, String genre, int year) {
        this(name, genre, year, null);
    }

    // Для группы игр - конструктор
    public Game(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        if (rating != null) { // Проверяем, что рейтинг не равен null
            return id + ")" + name + " " + genre + " " + year + " " + rating;
        } else {
            return id + ")" + name + " " + genre + " " + year; // Если рейтинг отсутствует
        }
    }


}
