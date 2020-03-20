package com.app.admin;

import com.expertsystem.Operation;
import com.expertsystem.Rule;
import com.expertsystem.Statement;
import com.expertsystem.Type;
import com.jfoenix.controls.*;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Hashtable;

public class AddRuleController {

    public JFXButton addRuleButton;
    public JFXButton cancelButton;
    public JFXButton addConsequenceButton;
    public JFXButton removeStatementButton;
    public JFXButton addAntecedentButton;
    public JFXButton clearAllButton;
    public JFXComboBox<String> operationCB;

    public JFXComboBox<String> typeCB;
    public TableView consequencesTV;
    public TableView antecedentsTV;
    public TextField ruleNameField;
    public TextField varNameField;
    public TextField valueField;

    private Hashtable<String, Type> typeTable = new Hashtable<>();
    private Hashtable<String, Operation> opTable = new Hashtable<>();
    private String varNameRegex = "^[a-zA-Z_$][a-zA-Z_$0-9]*$";

    public void initialize(){
        typeTable.put("INTEGER", Type.INTEGER);
        typeTable.put("STRING", Type.STRING);
        typeTable.put("BOOLEAN", Type.BOOLEAN);

        opTable.put("=", Operation.EQ);
        opTable.put("!=", Operation.NEQ);
        opTable.put("<", Operation.LESS);
        opTable.put("<=", Operation.LESS_EQ);
        opTable.put(">", Operation.GREAT);
        opTable.put(">=", Operation.GREAT_EQ);


        TableColumn<String, Statement> varNameCol = new TableColumn<>("Name");
        TableColumn<String, Statement> operationCol = new TableColumn<>("Op.");
        TableColumn<String, Statement> valueCol = new TableColumn<>("Value");

        TableColumn<String, Statement> varNameCol2 = new TableColumn<>("Name");
        TableColumn<String, Statement> operationCol2 = new TableColumn<>("Op.");
        TableColumn<String, Statement> valueCol2 = new TableColumn<>("Value");

        varNameCol.setCellValueFactory(new PropertyValueFactory<>("varName"));
        operationCol.setCellValueFactory(new PropertyValueFactory<>("operation"));
        valueCol.setCellValueFactory(new PropertyValueFactory<>("value"));

        varNameCol2.setCellValueFactory(new PropertyValueFactory<>("varName"));
        operationCol2.setCellValueFactory(new PropertyValueFactory<>("operation"));
        valueCol2.setCellValueFactory(new PropertyValueFactory<>("value"));

        antecedentsTV.getColumns().addAll(varNameCol, operationCol, valueCol);
        consequencesTV.getColumns().addAll(varNameCol2, operationCol2, valueCol2);


        operationCB.setItems(FXCollections.observableArrayList("=", "!=", ">", ">=", "<", "<="));
        typeCB.setItems(FXCollections.observableArrayList("INTEGER", "BOOLEAN", "STRING"));

    }

    public void addRule(ActionEvent actionEvent) {
        Rule R = new Rule(ruleNameField.getText(), new ArrayList<Statement>(antecedentsTV.getItems()), new ArrayList<Statement>(consequencesTV.getItems()));
        AdminController.addedRule = R;
        Stage s = (Stage) cancelButton.getScene().getWindow();
        s.close();
    }

    public void cancel(ActionEvent actionEvent) {
        Stage s = (Stage) cancelButton.getScene().getWindow();
        s.close();
    }

    public void addAntecedent(ActionEvent actionEvent) throws Exception {
        Object value = retrieveValue();
        Statement antecedent = new Statement(varNameField.getText(), typeTable.get(typeCB.getValue()), opTable.get(operationCB.getValue()), value);
        antecedentsTV.getItems().add(antecedent);
    }
    public void addConsequence(ActionEvent actionEvent) throws Exception {
        Object value = retrieveValue();
        Statement antecedent = new Statement(varNameField.getText(), typeTable.get(typeCB.getValue()), opTable.get(operationCB.getValue()), value);
        consequencesTV.getItems().add(antecedent);
    }

    public void removeStatement(ActionEvent actionEvent) {
        Object selectedItem = antecedentsTV.getSelectionModel().getSelectedItem();
        if(selectedItem != null){
            antecedentsTV.getItems().remove(selectedItem);
            return;
        }
        selectedItem = consequencesTV.getSelectionModel().getSelectedItem();
        if(selectedItem != null){
            consequencesTV.getItems().remove(selectedItem);
        }

    }

    public void clear(ActionEvent actionEvent) {
        consequencesTV.getItems().clear();
        antecedentsTV.getItems().clear();
    }


    public void removeSelectionOnAntecedents(MouseEvent mouseEvent) {
        antecedentsTV.getSelectionModel().clearSelection();
    }

    public void removeSelectionOnConsequences(MouseEvent mouseEvent) {
        consequencesTV.getSelectionModel().clearSelection();
    }

    public Object retrieveValue(){
        Object value = null;
        if (typeTable.get(typeCB.getValue()) == Type.STRING) {
            value = valueField.getText();
        } else if (typeTable.get(typeCB.getValue()) == Type.BOOLEAN) {
            if (valueField.getText().toLowerCase().equals("true")) {
                value = true;
            } else if (valueField.getText().toLowerCase().equals(("false"))) {
                value = false;
            }
        } else if (typeTable.get(typeCB.getValue()) == Type.INTEGER) {
            value = Integer.parseInt(valueField.getText());
        }
        return value;
    }
}
