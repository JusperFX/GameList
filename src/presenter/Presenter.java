package presenter;

import model.Game;
import model.GameGroup;
import model.Service;

public class Presenter {
    private Service service;

    public Presenter() {
        service = new Service();
    }

    public void addGameToGroup(Game game) {
        service.addGameToGroup(game);
    }

    public void addGame(Game game) {
        service.addGame(game);
    }

    public void addGroupOfGames (GameGroup gameGroup) {
        service.addGroupOfGames(gameGroup);
    }

}
