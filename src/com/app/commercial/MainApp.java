package com.app.commercial;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends javafx.application.Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("commercial.fxml"));
        primaryStage.setTitle("PC Assembler");
        primaryStage.setScene(new Scene(root));

        primaryStage.show();
    }
}