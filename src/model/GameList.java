package model;

import java.util.ArrayList;
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

    @Override
    public String toString() {
        return "Список Игр\n" + gameList;
    }
}
