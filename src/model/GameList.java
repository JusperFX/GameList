package model;

import java.io.Serializable;
import java.util.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class GameList implements Serializable {
    private ObservableList<Game> gameList;

    public GameList() {
        this.gameList = FXCollections.observableArrayList();
    }

    public ObservableList<Game> getGameList() {
        return gameList;
    }

    public void addGame(Game game) {
        if (!gameList.contains(game)) {
            gameList.add(game);
        }
    }

    public void addGroupOfGames (GameGroup gameGroup) {
        gameList.add(gameGroup);
    }

    public void sortByID() {
        Collections.sort(gameList, Comparator.comparing(Game::getId));
    }

    public Game getGameById(int id) {
        return gameList.stream().filter(game -> game.getId() == id).findFirst().orElse(null);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Game game : gameList) {
            sb.append(game).append("\n");
        }
        return sb.toString();
    }

    public void clear() {
        gameList.clear();
    }

    public void addAll(List<Game> games) {
        gameList.addAll(games);
    }

    public Iterator<Game> iterator() {
        return gameList.iterator(); // Возвращаем итератор стандартного списка
    }

//    public List<Game> toList() {
//        List<Game> list = new ArrayList<>();
//        for (Game game : gameList) { // Предполагая, что GameList реализует Iterable
//            list.add(game);
//        }
//        return list;
//    }

    public List<Game> toList() {
//        return new ArrayList<>(gameList); // Конвертируем ObservableList в ArrayList
        List<Game> listedGames = gameList;
        return listedGames;
    }

    public int size() {
        return gameList.size();
    }
}
