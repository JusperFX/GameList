package model;

import java.util.ArrayList;
import java.util.List;

public class DoneList extends GameList{
    private List<Game> doneGameList;
    private static int idCounter = 0;
    private int id;

    public DoneList() {
        this.doneGameList = new ArrayList<>();
        this.id = ++idCounter;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addGame(Game game) {
        game.setId(id);
        doneGameList.add(game);
    }

    public void addGroupOfGames (GameGroup gameGroup) {
        doneGameList.add(gameGroup);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Game game : doneGameList) {
            sb.append(game).append("\n");
        }
        return sb.toString();
    }
}
