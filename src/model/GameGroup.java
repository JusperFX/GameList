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
        StringBuilder sb = new StringBuilder();
        for (Game game : gameGroup) {
            sb.append(game).append("\n");
        }
        return "\n" +getGroupName() + ":\n" + sb;
    }



}
