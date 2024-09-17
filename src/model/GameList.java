package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GameList {
    private List<Game> gameList;

    public GameList() {
        this.gameList = new ArrayList<>();
    }

    public void addGame(Game game) {
        gameList.add(game);
    }

    public void addGroupOfGames (GameGroup gameGroup) {
        gameList.add(gameGroup);
    }

    public void sortByID() {
        Collections.sort(gameList, Comparator.comparing(Game::getId));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Game game : gameList) {
            sb.append(game).append("\n");
        }
        return sb.toString();
    }
}
