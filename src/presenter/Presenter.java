package presenter;

import javafx.collections.ObservableList;
import model.Game;
import model.GameGroup;
import model.Service;
import model.writer.FileHandler;

import java.io.Serializable;
import java.util.List;

public class Presenter {
    private Service service;
    private FileHandler fileHandler;

    public Presenter() {
        service = new Service();
    }

    public void addGameToGroup(Game game) {
        service.addGameToGroup(game);
    }

    public void addGame(String name, String genre, int year) {
        Game newGame = new Game(name, genre, year);
        service.addGame(newGame);
    }

    public void addGroupOfGames (GameGroup gameGroup) {
        service.addGroupOfGames(gameGroup);
    }

    public ObservableList<Game> getGameList() {
        return service.getGameList();
    }

    public void sortByID () {
        service.sortByID();
    }

    public ObservableList<Game> getDoneGameList() {
        return service.getDoneGameList();
    }

    public void addDoneGame(Game game) {
        service.addDoneGame(game);
    }

    public void addDoneGroupOfGames (GameGroup gameGroup) {
        service.addDoneGroupOfGames(gameGroup);
    }

    public Game getGameById(int id) {
        return service.getGameById(id);
    }

    public void addDoneGame(int gameId, int rating, String review) {
        Game game = service.getGameById(gameId);
        if (game != null) {
            game.setRating(rating);
            game.setReview(review);
            service.addDoneGame(game);
        }
    }

    // Метод для сохранения данных
    public void saveData() {
        try {
            service.saveData(); // Вызываем метод saveData из сервиса
        } catch (Exception e) {
            System.err.println("Error saving data: " + e.getMessage());
        }
    }

    // Метод для загрузки данных
    public void loadData() {
        try {
            service.loadData(); // Вызываем метод loadData из сервиса
        } catch (Exception e) {
            System.err.println("Error loading data: " + e.getMessage());
        }

    }
}
