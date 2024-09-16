package model;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        GameList gameList = new GameList();
        Game game1 = new Game("GTAV", "Action", 2014, 0);
        Game game2 = new Game("GTAIV", "Action", 2008, 0);
        gameList.addGame(game1);
        GameGroup gameGroup = new GameGroup("GTA");
        gameGroup.addGameToGroup(game1);
        gameGroup.addGameToGroup(game2);
        gameList.addGroupOfGames(gameGroup);
        System.out.println(gameList);
//        System.out.println(gameGroup);
    }
}
