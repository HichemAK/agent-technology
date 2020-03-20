package com.app.admin;

import com.expertsystem.*;
import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class AdminController {
    @FXML
    JFXButton buttLoad, buttSave, buttSaveAs, buttNormalize, buttNew, buttExit, buttRules, buttRefresh;
    ExpertSystem ES = new ExpertSystem();
    VBox vbRules;


    File currentFile = null;

    public void intialize() throws Exception {
        
    }


    public void loadES(javafx.event.ActionEvent actionEvent) {
        FileChooser fc = new FileChooser();
        fc.setTitle("Open Expert System File");
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Expert System File (*.es)", "*.es");
        fc.getExtensionFilters().add(extFilter);
        File fileES = fc.showOpenDialog(buttLoad.getScene().getWindow());
        if(fileES != null){
            ES = new ExpertSystem(fileES);
            currentFile = fileES;
            refresh();
        }
    }

    public void saveES(javafx.event.ActionEvent actionEvent) {
        if(currentFile != null){
            ES.save(currentFile);
        }
    }

    public void saveAsES(javafx.event.ActionEvent actionEvent) {
        FileChooser fc = new FileChooser();
        fc.setTitle("Save Expert System File");
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Expert System File (*.es)", "*.es");
        fc.getExtensionFilters().add(extFilter);
        File fileES = fc.showSaveDialog(buttSaveAs.getScene().getWindow());
        if(fileES != null){
            ES.save(fileES);
        }
    }

    public void exit(ActionEvent actionEvent){
        Platform.exit();
        System.exit(0);
    }

    public void newES(ActionEvent actionEvent){
        if (currentFile != null){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText("All unsaved changes will be ignored.");
            alert.setContentText("Are you sure to continue?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() != ButtonType.OK){
                return;
            }
        }
        currentFile = null;
        ES = new ExpertSystem();
        buttSave.setDisable(true);
        refresh();
    }

    public void clearES(ActionEvent actionEvent){
        ES = new ExpertSystem();
        refresh();
    }

    private void refresh() {

    }
}
