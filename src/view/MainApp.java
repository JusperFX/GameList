package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Создаем кнопку
        Button btn = new Button();
        btn.setText("Нажми меня");
        btn.setOnAction(event -> System.out.println("Кнопка нажата!"));

        // Создаем layout и добавляем кнопку
        StackPane root = new StackPane();
        root.getChildren().add(btn);

        // Создаем сцену
        Scene scene = new Scene(root, 300, 250);

        // Настраиваем и отображаем окно
        primaryStage.setTitle("JavaFX Пример");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
