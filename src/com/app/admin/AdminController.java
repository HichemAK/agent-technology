package com.app.admin;

import com.expertsystem.*;
import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.event.ActionEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class AdminController {
    @FXML
    public JFXButton buttNew, buttLoad, buttSave, buttSaveAs, buttCommit, buttOptimize, buttExit, buttAddRule, buttClear;
    public VBox vbRules;

    ExpertSystem ES;

    File currentFile = null;
    public static Rule addedRule = null;

    public void initialize() throws IOException {
        ES = new ExpertSystem();
        prepare();
        refresh();
    }

    private void prepare(){
        VBox.setVgrow(vbRules, Priority.ALWAYS);
        buttNew.setOnAction(this::newES);
        buttLoad.setOnAction(this::loadES);
        buttSave.setOnAction(this::saveES);
        buttSaveAs.setOnAction(this::saveAsES);
        // buttCommit.setOnAction()
        buttOptimize.setOnAction(this::optimizeES);
        buttExit.setOnAction(this::exit);
        buttAddRule.setOnAction(actionEvent -> {
            try {
                addRule(actionEvent);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        buttClear.setOnAction(this::clearES);
    }

    public void optimizeES(ActionEvent actionEvent) {

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
            refresh();
            return ;
        }
        buttSave.setDisable(true);
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

        if(!alertProceed()) {
            return;
        }

        Platform.exit();
        System.exit(0);
    }

    public void newES(ActionEvent actionEvent){
        if (currentFile != null || ES.getRules().size() != 0){
            if(!alertProceed()) {
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

    public void addRule(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(AddRuleController.class.getResource("addRule.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("My modal window");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());
        stage.show();

        // Now the rule is stocked in the static variable "addedRule". Do the right modification TODO
    }

    private void refresh() {
        vbRules.getChildren().clear();

        if(currentFile == null) {
            buttSave.setDisable(true);
        }
        else {
            buttSave.setDisable(false);
        }

        for(Rule r : ES.getRules()) {
            vbRules.getChildren().add(new RuleVBox(r));
        }
    }

    private boolean alertProceed() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("All unsaved changes will be ignored.");
        alert.setContentText("Are you sure to continue?");

        Optional<ButtonType> result = alert.showAndWait();

        return result.get() == ButtonType.OK;
    }
}
