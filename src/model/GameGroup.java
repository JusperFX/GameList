package model;

import java.util.ArrayList;
import java.util.List;

public class GameGroup extends Game {
    private List<Game> gameGroup = new ArrayList<>();

    public GameGroup(String name) {
        super(name);
    }

    public void addGameToGroup (Game game) {
        gameGroup.add(game);
    }

    @Override
    public String toString() {
        return "GameGroup{" +
                "gameGroup=" + gameGroup +
                '}';
    }
}
