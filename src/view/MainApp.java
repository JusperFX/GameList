package view;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import presenter.Presenter;

public class MainApp extends Application {

    private Presenter presenter;
    private ListView<String> gameListView;
    private ListView<String> doneGameListView;

    @Override
    public void start(Stage primaryStage) {
        presenter = new Presenter();

        // Создаем кнопки
        Button addGameButton = new Button("Add Game");
        Button saveButton = new Button("Save Data");
        Button loadButton = new Button("Load Data");

        // Создаем ListView для отображения игр
        gameListView = new ListView<>();
        doneGameListView = new ListView<>();

        // Настраиваем возможность выбора только одного элемента
        gameListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        doneGameListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        // Обработка события добавления игры
        addGameButton.setOnAction(event -> openAddGameWindow());

        // Обработка события сохранения данных
        saveButton.setOnAction(event -> {
            presenter.saveData();
            System.out.println("Data saved!");
        });

        // Обработка события загрузки данных
        loadButton.setOnAction(event -> {
            presenter.loadData();
            updateGameList();
            updateDoneGameList();
            System.out.println("Data loaded!");
        });

        // Обработка события выбора игры для оценки
        gameListView.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {  // Двойной клик для оценки и отзыва
                String selectedGame = gameListView.getSelectionModel().getSelectedItem();
                if (selectedGame != null) {
                    int gameId = Integer.parseInt(selectedGame.split(" ")[0].replace(")", ""));
                    openRatingWindow(gameId);  // Открываем окно для оценки
                }
            }
        });

        // Добавляем слушателя для обновления списка
        updateGameList();
        updateDoneGameList();

        // Создаем VBox для размещения элементов
        VBox layout = new VBox(10);
        layout.getChildren().addAll(addGameButton, saveButton, loadButton, gameListView, doneGameListView);

        // Настройка сцены
        Scene scene = new Scene(layout);
        primaryStage.setTitle("Game Manager");
        primaryStage.setScene(scene);
        primaryStage.setWidth(Screen.getPrimary().getVisualBounds().getWidth());
        primaryStage.setHeight(Screen.getPrimary().getVisualBounds().getHeight());
        primaryStage.show();
    }

    // Метод для открытия нового окна для добавления игры
    private void openAddGameWindow() {
        Stage addGameStage = new Stage();
        addGameStage.initModality(Modality.APPLICATION_MODAL);
        addGameStage.setTitle("Add New Game");

        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();
        Label genreLabel = new Label("Genre:");
        TextField genreField = new TextField();
        Label yearLabel = new Label("Year:");
        TextField yearField = new TextField();
        Button saveButton = new Button("Save");

        saveButton.setOnAction(event -> {
            String name = nameField.getText();
            String genre = genreField.getText();
            int year = Integer.parseInt(yearField.getText());

            // Передаем данные в Presenter
            presenter.addGame(name, genre, year);
            updateGameList();  // Обновляем список игр после добавления
            addGameStage.close();  // Закрываем окно после добавления
        });

        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.add(nameLabel, 0, 0);
        grid.add(nameField, 1, 0);
        grid.add(genreLabel, 0, 1);
        grid.add(genreField, 1, 1);
        grid.add(yearLabel, 0, 2);
        grid.add(yearField, 1, 2);
        grid.add(saveButton, 1, 3);

        Scene scene = new Scene(grid, 400, 250);
        addGameStage.setScene(scene);
        addGameStage.showAndWait();
    }

    // Метод для открытия окна для оценки игры
    private void openRatingWindow(int gameId) {
        Stage ratingStage = new Stage();
        ratingStage.initModality(Modality.APPLICATION_MODAL);
        ratingStage.setTitle("Rate Game");

        Label ratingLabel = new Label("Rating (1-10):");
        TextField ratingField = new TextField();
        Label reviewLabel = new Label("Review:");
        TextArea reviewArea = new TextArea();
        Button confirmButton = new Button("Confirm");

        confirmButton.setOnAction(event -> {
            int rating = Integer.parseInt(ratingField.getText());
            String review = reviewArea.getText();

            // Передаем данные в Presenter для переноса игры в завершенный список
            presenter.addDoneGame(gameId, rating, review);
            updateGameList();  // Обновляем список игр
            updateDoneGameList();  // Обновляем завершенный список
            ratingStage.close();  // Закрываем окно после добавления
        });

        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.add(ratingLabel, 0, 0);
        grid.add(ratingField, 1, 0);
        grid.add(reviewLabel, 0, 1);
        grid.add(reviewArea, 1, 1);
        grid.add(confirmButton, 1, 2);

        Scene scene = new Scene(grid, 400, 300);
        ratingStage.setScene(scene);
        ratingStage.showAndWait();
    }

    // Обновление списка игр
    private void updateGameList() {
        gameListView.setItems(FXCollections.observableArrayList(presenter.getGameList().stream()
                .map(game -> game.getId() + ") " + game.getName())
                .toArray(String[]::new)));
    }

    // Обновление списка завершенных игр
    private void updateDoneGameList() {
        doneGameListView.setItems(FXCollections.observableArrayList(presenter.getDoneGameList().stream()
                .map(game -> game.getId() + ") " + game.getName() + " - Rating: " + game.getRating() + " - Review: " + game.getReview())
                .toArray(String[]::new)));
    }

    public static void main(String[] args) {
        launch(args);
    }
}