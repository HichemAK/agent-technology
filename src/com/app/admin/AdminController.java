package com.app.admin;


import com.expertsystem.ExpertSystem;
import com.expertsystem.Rule;
import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.event.ActionEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.util.Optional;

public class AdminController {
    @FXML
    JFXButton buttLoad, buttSave, buttSaveAs, buttNormalize, buttNew, buttExit, buttRules, buttRefresh, buttAddRule;
    ExpertSystem ES = new ExpertSystem();
    VBox vbRules;


    File currentFile = null;
    public static Rule addedRule = null;

    public void initialize(){
        System.out.println(123456);
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

    public void addRule(ActionEvent actionEvent){
        Stage dialog = new Stage();

        dialog.initOwner(buttAddRule.getScene().getWindow());
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.showAndWait();

        // Now the rule is stocked in the static variable "addedRule". Do the right modification TODO
    }

    private void refresh() {

    }
}
