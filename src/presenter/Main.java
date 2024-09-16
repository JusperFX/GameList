package presenter;

import model.Game;
import model.GameGroup;
import model.GameList;

public class Main {
    public static void main(String[] args) {
        GameList gameList = new GameList();
        Presenter presenter = new Presenter();
        Game game1 = new Game("GTA V", "Action", 2014);
        Game game2 = new Game("GTA IV", "Action", 2008);
//        gameList.addGame(game1);
        GameGroup gameGroup = new GameGroup("GTA");
        presenter.addGameToGroup(game1);
        presenter.addGameToGroup(game2);
        presenter.addGroupOfGames(gameGroup);
        System.out.println(gameGroup);
//        System.out.println(gameGroup);
    }
}
