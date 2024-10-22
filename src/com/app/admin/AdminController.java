package com.app.admin;

import com.expertsystem.*;
import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.event.ActionEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class AdminController {
    @FXML
    public JFXButton buttNew, buttLoad, buttSave, buttSaveAs, buttOptimize, buttExit, buttAddRule, buttClear;
    public VBox vbRules;
    public Label lblDirectory, lblFileName, lblNumberOfRules;

    ExpertSystem ES;

    File currentFile = null;
    public static Rule addedRule = null;
    public static Rule editedRule = null;
    public static Function function = null;

    public void initialize() throws IOException {
        ES = new ExpertSystem();
        this.prepare();
        this.refresh();
    }

    private void updateLabels() {
        if(currentFile == null) {
            String none = "None";
            lblFileName.setText(none);
            lblDirectory.setText(none);
        }
        else {
            String absPath = currentFile.getAbsolutePath();
            String entities[] = absPath.split("\\\\");
            String fileName = entities[entities.length - 1];
            lblFileName.setText(fileName);

            String subPath = absPath.substring(0, absPath.length() - fileName.length() - 1);
            lblDirectory.setText(subPath);
        }
        lblNumberOfRules.setText(Integer.toString(ES.getNumberOfRules()));
    }

    private void prepare(){
        VBox.setVgrow(vbRules, Priority.ALWAYS);
        buttNew.setOnAction(this::newES);
        buttLoad.setOnAction(actionEvent2 -> {
            try {
                loadES(actionEvent2);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });
        buttSave.setOnAction(actionEvent1 -> {
            try {
                saveES(actionEvent1);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        buttSaveAs.setOnAction(actionEvent1 -> {
            try {
                saveAsES(actionEvent1);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
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
        ES.removeRedundancies();
        refresh();
    }

    public void programDelete() {
        vbRules.getChildren().forEach(ele -> {
            RuleVBox mine = (RuleVBox)ele;
            JFXButton butt;
            butt = ((JFXButton)(((HBox)(((GridPane)(mine.getChildren().get(0))).getChildren().get(1))).getChildren().get(1)));

            butt.setOnAction(actionEvent -> {
                ES.removeRule(mine.getRule());
                refresh();
            });
        });
    }

    public void programEdit(){
        vbRules.getChildren().stream().map(ele -> (RuleVBox) ele).forEach(mine -> {
            JFXButton butt;
            butt = ((JFXButton) (((HBox) (((GridPane) (mine.getChildren().get(0))).getChildren().get(1))).getChildren().get(0)));
            butt.setOnAction(actionEvent -> {
                try {
                    editedRule = mine.getRule();
                    editRule(actionEvent);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        });
    }

    public void loadES(javafx.event.ActionEvent actionEvent) throws FileNotFoundException {
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

    public void saveES(javafx.event.ActionEvent actionEvent) throws IOException {
        if(currentFile != null){
            ES.save(currentFile);
            refresh();
            return ;
        }
        buttSave.setDisable(true);
    }

    public void saveAsES(javafx.event.ActionEvent actionEvent) throws IOException {
        FileChooser fc = new FileChooser();
        fc.setTitle("Save Expert System File");
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Expert System File (*.es)", "*.es");
        fc.getExtensionFilters().add(extFilter);
        File fileES = fc.showSaveDialog(buttSaveAs.getScene().getWindow());
        if(fileES != null){
            ES.save(fileES);
            currentFile = fileES;
            buttSave.setDisable(false);
            refresh();
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
        function = Function.ADD;
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(AddRuleController.class.getResource("addRule.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Add rule");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());
        stage.showAndWait();

        if(addedRule != null) {
            ES.addRule(addedRule);
            refresh();
        }

        addedRule = null;
    }

    public void editRule(ActionEvent actionEvent) throws IOException {
        function = Function.EDIT;
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(AddRuleController.class.getResource("addRule.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Edit rule");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());
        stage.showAndWait();

        if(editedRule != null) {
            refresh();
            editedRule = null;
        }
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

        this.programDelete();
        this.programEdit();
        this.updateLabels();
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
