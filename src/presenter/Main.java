package presenter;

import model.DoneList;
import model.Game;
import model.GameGroup;
import model.GameList;

public class Main {
    public static void main(String[] args) {
        GameList gameList = new GameList();

        // Создаем игры
        Game game1 = new Game("GTA V", "Action", 2014);
        Game game2 = new Game("GTA IV", "Action", 2008);
        Game game3 = new Game("Fallout 3", "RPG", 2009);

        // Создаем группу игр
        GameGroup gameGroup = new GameGroup("GTA");
        gameGroup.addGameToGroup(game1);
        gameGroup.addGameToGroup(game2);

        // Добавляем игры и группу игр в список
        gameList.addGame(game3);
        gameList.addGame(gameGroup);  // Используем один метод для добавления группы
        gameList.sortByID();
        // Выводим список игр
        System.out.println(gameList);

        DoneList doneList = new DoneList();
        doneList.addGame(game3);
        System.out.println(doneList);
    }
}
