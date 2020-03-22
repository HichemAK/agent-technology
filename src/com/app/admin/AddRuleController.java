package com.app.admin;

import com.expertsystem.Operation;
import com.expertsystem.Rule;
import com.expertsystem.Statement;
import com.expertsystem.Type;
import com.jfoenix.controls.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Hashtable;

public class AddRuleController {

    public AnchorPane apBoolean, apNumber;

    public JFXButton buttAddRule;
    public JFXButton buttCancel;
    public JFXButton buttAddConsequences;
    public JFXButton buttAddAntecedents;
    public JFXButton buttRemoveStatement;
    public JFXButton buttClearAll;

    public JFXComboBox<String> cbOperation;

    public JFXRadioButton rbTrue, rbFalse;
    public JFXRadioButton rbBoolean, rbNumber, rbString;
    public ToggleGroup toggleType, toggleBool;

    public TableView consequencesTV;
    public TableView antecedentsTV;
    public TextField tfRuleName;
    public TextField tfVarName;
    public TextField tfValue;

    private Hashtable<String, Type> typeTable = new Hashtable<>();
    private Hashtable<String, Operation> opTable = new Hashtable<>();
    private String varNameRegex = "^[a-zA-Z_$][a-zA-Z_$0-9]*$";
    private String valueIntRegex = "^[0-9]+$";


    private ObservableList<String> operationChoices = FXCollections.observableArrayList("=", "!=", ">", ">=", "<", "<=");

    public void initialize(){
        typeTable.put("Number", Type.INTEGER);
        typeTable.put("String", Type.STRING);
        typeTable.put("Boolean", Type.BOOLEAN);

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

        if(rbBoolean.isSelected()) {
            prepareForBoolean();
        }
        else if(rbNumber.isSelected()) {
            prepareForNumber();
        }
        else if(rbString.isSelected()) {
            prepareForString();
        }
        else {
            System.out.println("wait what ?");
        }

        buttAddAntecedents.setDisable(true);
        buttAddConsequences.setDisable(true);

        if(AdminController.function == Function.EDIT && AdminController.editedRule != null){
            editInstead();
        }
        else {
            buttAddRule.setDisable(true);
        }

        addListeners();
    }

    private void addListeners() {
        addListenerToggleType();

        buttCancel.setOnAction(this::cancel);
        buttAddRule.setOnAction(this::addRule);
        buttAddConsequences.setOnAction(actionEvent -> {
            try {
                addConsequence(actionEvent);
                checkRuleAdding();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        buttAddAntecedents.setOnAction(actionEvent -> {
            try {
                addAntecedent(actionEvent);
                checkRuleAdding();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        buttClearAll.setOnAction(this::clear);
        buttRemoveStatement.setOnAction(this::removeStatement);

        tfRuleName.textProperty().addListener((observableValue, s, t1) -> {
            checkRuleAdding();
        });

        tfVarName.textProperty().addListener((observableValue, s, t1) -> {
            checkStatementAdding();
        });

        tfValue.textProperty().addListener((observableValue, s, t1) -> {
            checkStatementAdding();
        });
    }

    private void disableAdding() {
        buttAddAntecedents.setDisable(true);
        buttAddConsequences.setDisable(true);
    }

    private void enableAdding() {
        buttAddAntecedents.setDisable(false);
        buttAddConsequences.setDisable(false);
    }

    private void checkStatementAdding() {
        if(validateAdding()) {
            enableAdding();
            return;
        }
        disableAdding();
    }

    private void checkRuleAdding() {
        if(validateTables() && validateRuleName()) {
            buttAddRule.setDisable(false);
            return;
        }
        buttAddRule.setDisable(true);
    }

    private boolean validateAdding() {
        return validateVarName() && validateValue();
    }

    private boolean validateVarName() {
        return tfVarName.getText().matches(varNameRegex);
    }

    private boolean validateValue() {
        return !rbNumber.isSelected() || tfValue.getText().matches(valueIntRegex);
    }

    private boolean validateTables() {
        return consequencesTV.getItems().size() > 0 && antecedentsTV.getItems().size() > 0;
    }

    private boolean validateRuleName() {
        return !tfRuleName.getText().isEmpty();
    }

    private void addListenerToggleType() {
        toggleType.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                RadioButton rb = (RadioButton)toggleType.getSelectedToggle();

                if(rb != null) {
                    String s = rb.getText();

                    switch (s) {
                        case "Boolean":
                            prepareForBoolean();
                            break;

                        case "Number":
                            prepareForNumber();
                            break;

                        case "String":
                            prepareForString();
                            break;

                        default:
                            System.out.println("ok... this is weird");
                    }
                    checkStatementAdding();
                }
            }
        });
    }

    private void editInstead() {
        buttAddRule.setText("Finish Editing");
        antecedentsTV.getItems().addAll(AdminController.editedRule.getAntecedents());
        consequencesTV.getItems().addAll(AdminController.editedRule.getConsequences());
        tfRuleName.setText(AdminController.editedRule.getName());
    }

    private void prepareForString() {
        apBoolean.setVisible(false);
        apNumber.setVisible(true);
        cbOperation.setItems(FXCollections.observableArrayList("=", "!="));
        cbOperation.setValue("=");
        tfValue.setPromptText("String");
        tfValue.setText("");
    }

    private void prepareForNumber() {
        apBoolean.setVisible(false);
        apNumber.setVisible(true);
        cbOperation.setItems(FXCollections.observableArrayList(operationChoices));
        cbOperation.setValue("=");
        tfValue.setPromptText("Value");
        tfValue.setText("");
    }

    private void prepareForBoolean() {
        apNumber.setVisible(false);
        apBoolean.setVisible(true);
    }

    public void addRule(ActionEvent actionEvent) {

        if(tfRuleName.getText().isEmpty()) {
            buttAddRule.setDisable(true);
            return ;
        }

        if(AdminController.function == Function.ADD){
            Rule R = new Rule(tfRuleName.getText(), new ArrayList<Statement>(antecedentsTV.getItems()), new ArrayList<Statement>(consequencesTV.getItems()));
            AdminController.addedRule = R;
        }
        else if(AdminController.function == Function.EDIT){
            AdminController.editedRule.setName(tfRuleName.getText());
            AdminController.editedRule.setAntecedents(new ArrayList<Statement>(antecedentsTV.getItems()));
            AdminController.editedRule.setConsequences(new ArrayList<Statement>(consequencesTV.getItems()));
        }

        Stage s = (Stage) buttCancel.getScene().getWindow();
        s.close();
    }

    public void cancel(ActionEvent actionEvent) {
        Stage s = (Stage) buttCancel.getScene().getWindow();
        s.close();
    }

    public void addAntecedent(ActionEvent actionEvent) throws Exception {
        Object value = retrieveValue();
        Statement antecedent = new Statement(
                tfVarName.getText(),
                typeTable.get(((RadioButton)(toggleType.getSelectedToggle())).getText()),
                opTable.get(cbOperation.getValue()), value);
        antecedentsTV.getItems().add(antecedent);
    }
    public void addConsequence(ActionEvent actionEvent) throws Exception {
        Object value = retrieveValue();
        Statement consequence = new Statement(
                tfVarName.getText(),
                typeTable.get(((RadioButton)(toggleType.getSelectedToggle())).getText()),
                opTable.get(cbOperation.getValue()), value);
        consequencesTV.getItems().add(consequence);
    }

    public void removeStatement(ActionEvent actionEvent) {
        Object selectedItem = antecedentsTV.getSelectionModel().getSelectedItem();
        if(selectedItem != null){
            antecedentsTV.getItems().remove(selectedItem);
        }
        else {
            selectedItem = consequencesTV.getSelectionModel().getSelectedItem();
            if(selectedItem != null){
                consequencesTV.getItems().remove(selectedItem);
            }
        }

        checkRuleAdding();
    }

    public void clear(ActionEvent actionEvent) {
        consequencesTV.getItems().clear();
        antecedentsTV.getItems().clear();

        checkRuleAdding();
    }


    public void removeSelectionOnAntecedents(MouseEvent mouseEvent) {
        antecedentsTV.getSelectionModel().clearSelection();
    }

    public void removeSelectionOnConsequences(MouseEvent mouseEvent) {
        consequencesTV.getSelectionModel().clearSelection();
    }

    public Object retrieveValue(){
        Object value = null;
        Type type = typeTable.get(((RadioButton)(toggleType.getSelectedToggle())).getText());

        if (type == Type.STRING) {
            value = tfValue.getText();
        }
        else if (type == Type.BOOLEAN) {
            value = rbTrue.isSelected();
        }
        else if (type == Type.INTEGER) {
            value = Integer.parseInt(tfValue.getText());
        }
        return value;
    }
}
