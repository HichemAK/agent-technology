package com.app.admin;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends javafx.application.Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("admin.fxml"));
        primaryStage.setTitle("Expert System Administrator");
        primaryStage.setScene(new Scene(root, 600, 400));

        primaryStage.show();
    }
}
