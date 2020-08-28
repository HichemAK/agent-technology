package com.app.jadeimplement;

import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class MainAppController {
    @FXML
    public JFXButton buttPcAssembler;
    public JFXButton buttPhone;
    public JFXButton buttExit;

    private String clrBlue = "#42acff", clrRed = "#e03d3d", clrBlack = "#000000";

    public MainAppController() throws Exception {

    }

    public void initialize(){
        buttExit.setOnAction(this::exit);
        buttPcAssembler.setOnAction(this::pcAssembler);
        buttPhone.setOnAction(this::buyPhone);
    }

    private void exit(ActionEvent actionEvent){
        Platform.exit();
        System.exit(0);
    }

    private void pcAssembler(ActionEvent actionEvent){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("commercial.fxml"));
        Parent root1 = null;
        try {
            root1 = (Parent) fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("PC Assembler");
        stage.setScene(new Scene(root1));
        stage.show();
    }

    private void buyPhone(ActionEvent actionEvent){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("phone.fxml"));
        Parent root1 = null;
        try {
            root1 = (Parent) fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Buy Smartphone");
        stage.setScene(new Scene(root1));
        stage.show();
    }
}
