package org.example;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MyGUI extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // 创建标签
        Label label = new Label("Hello, World!");

        // 创建布局
        StackPane root = new StackPane();
        root.getChildren().add(label);

        // 创建场景
        Scene scene = new Scene(root, 300, 200);

        // 设置场景到舞台
        primaryStage.setScene(scene);
        primaryStage.setTitle("My GUI");
        primaryStage.show();
    }
}