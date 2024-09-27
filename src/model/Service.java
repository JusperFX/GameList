package model;

import javafx.collections.ObservableList;
import model.writer.FileHandler;
import model.writer.Writer;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Service {
    private GameGroup gameGroup;
    private GameList gameList;
    private DoneList doneGameList;
    private Writer fileHandler;

    public Service() {
        gameGroup = new GameGroup("Default Game Group");
        this.gameList = new GameList();
        this.doneGameList = new DoneList();
        this.fileHandler = new FileHandler();

    }

    public void addGameToGroup(Game game) {
        gameGroup.addGameToGroup(game);
    }

    public void addGame(Game game) {
        gameList.addGame(game);
    }

    public void addGroupOfGames (GameGroup gameGroup) {
        gameList.addGroupOfGames(gameGroup);
    }

    public ObservableList<Game> getGameList() {
        return gameList.getGameList();
    }

    public void sortByID () {
        gameList.sortByID();
    }

    public ObservableList<Game> getDoneGameList() {
        return doneGameList.getDoneGameList();
    }

    public void addDoneGame(Game game) {
        doneGameList.addDoneGame(game);
    }

    public void addDoneGroupOfGames (GameGroup gameGroup) {
        doneGameList.addDoneGroupOfGames(gameGroup);
    }

    public Game getGameById(int id) {
        return gameList.getGameById(id);
    }

    public void saveData() {
        fileHandler.save(getGamesForSerialization()); // Сохраняем основной список
        fileHandler.save(getDoneGamesForSerialization()); // Сохраняем завершенные игры
        System.out.println("Game List: " + gameList.size() + " games saved.");
        System.out.println("Done Game List: " + doneGameList.size() + " games saved.");
    }

    public void loadData() {
        List<Game> loadedGames = (List<Game>) fileHandler.read();
        if (loadedGames != null) {
            gameList.clear();
            gameList.addAll(loadedGames); // Загружаем игры в основной список
        }

        List<Game> loadedDoneGames = (List<Game>) fileHandler.read(); // Загружаем завершенные игры
        if (loadedDoneGames != null) {
            doneGameList.clear();
            doneGameList.addAll(loadedDoneGames); // Загружаем завершенные игры
        }
        System.out.println("Game List: " + gameList.size() + " games loaded.");
        System.out.println("Done Game List: " + doneGameList.size() + " games loaded.");
    }

    public Serializable getGamesForSerialization() {
        return new ArrayList<>(gameList.toList()); // Используйте ваш новый метод

    }

    public Serializable getDoneGamesForSerialization() {
        return new ArrayList<>(doneGameList.toList()); // Используйте ваш новый метод
    }



}
