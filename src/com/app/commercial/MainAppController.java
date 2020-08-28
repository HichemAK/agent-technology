package com.app.commercial;

import com.app.admin.Reusables;
import com.expertsystem.ExpertSystem;
import com.expertsystem.Operation;
import com.expertsystem.Statement;
import com.expertsystem.Type;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Paint;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.*;

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
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("PC Assembler");
        stage.setScene(new Scene(root1));
        stage.show();
    }
}
