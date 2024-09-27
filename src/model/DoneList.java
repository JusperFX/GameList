package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DoneList extends GameList implements Serializable {
    private ObservableList<Game> doneGameList;
    private static int idCounter = 0;
    private int id;

    public DoneList() {
        this.doneGameList = FXCollections.observableArrayList();
        this.id = ++idCounter;
    }

    public ObservableList<Game> getDoneGameList() {
        return doneGameList;
    }

    public void addDoneGame(Game game) {
        doneGameList.add(game);
    }

    public void addDoneGroupOfGames (GameGroup gameGroup) {
        doneGameList.add(gameGroup);
    }

//    public List<Game> toList() {
//        List<Game> list = new ArrayList<>();
//        for (Game game : doneGameList) {
//            list.add(game);
//        }
//        return list;
//    }

    public List<Game> toList() {
//        return new ArrayList<>(doneGameList); // Конвертируем ObservableList в ArrayList
        List<Game> listedDoneGames = doneGameList;
        return doneGameList;
    }

    public int size() {
        return doneGameList.size();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Game game : doneGameList) {
            sb.append(game).append("\n");
        }
        return sb.toString();
    }
}
