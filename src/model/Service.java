package model;

public class Service {
    private GameGroup gameGroup;
    private GameList gameList;

    public Service() {
        gameGroup = new GameGroup("Default Game Group");
        this.gameList = new GameList();
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

    public void sortByID () {
        gameList.sortByID();
    }


}
