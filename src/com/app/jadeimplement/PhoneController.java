package com.app.jadeimplement;

import com.app.admin.Reusables;
import com.expertsystem.ExpertSystem;
import com.expertsystem.Operation;
import com.expertsystem.Statement;
import com.expertsystem.Type;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import jade.wrapper.AgentController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.util.*;

public class PhoneController {
    @FXML
    public JFXButton buttBuy, buttExit;


    public ToggleGroup toggleBrand, toggleGB;

    public TextField tfBudget;

    public Label lblResult;
    public JFXRadioButton rbSamsung;
    public JFXRadioButton rbApple;
    public JFXComboBox comboModel;
    public JFXComboBox comboColor;
    public JFXRadioButton rb32;
    public JFXRadioButton rb64;
    public JFXRadioButton rb128;

    private String clrBlue, clrRed, clrBlack;

    private ExpertSystem ES = new ExpertSystem("examples/phone.es");
    private HashMap<String, Integer> stock = new HashMap<>();
    private ArrayList<String> samsung_models = new ArrayList<>(Arrays.asList("None", "Galaxy S", "Galaxy Fold", "Galaxy Note", "Galaxy A"));
    private ArrayList<String> apple_models = new ArrayList<>(Arrays.asList("None", "iPhone 6s", "iPhone 7 Plus", "iPhone 8", "iPhone 9"));
    private ArrayList<String> colors = new ArrayList<>(Arrays.asList("None", "Black", "White", "Red", "Blue", "Golden"));
    private HashMap<String, Integer> price = new HashMap<>();

    public PhoneController() throws Exception {
    }

    public void initialize(){
        clrBlack = "#000000";
        clrBlue = "#42acff";
        clrRed = "#e03d3d";
        
        stock.put("Galaxy S", 30);
        stock.put("Galaxy Fold", 0);
        stock.put("Galaxy Note", 10);
        stock.put("Galaxy A", 5);
        stock.put("iPhone 6s", 1);
        stock.put("iPhone 7 Plus", 10);
        stock.put("iPhone 8", 0);
        stock.put("iPhone 9", 2);


        price.put("Galaxy S", 30000);
        price.put("Galaxy Fold", 20000);
        price.put("Galaxy Note", 40000);
        price.put("Galaxy A", 20000);
        price.put("iPhone 6s", 32000);
        price.put("iPhone 7 Plus", 40000);
        price.put("iPhone 8", 50000);
        price.put("iPhone 9", 55000);
        price.put("32GB", 0);
        price.put("64GB", 5000);
        price.put("128GB", 10000);
        price.put("None", 0);

        prepareSamsung();
        prepareColor();
        buttBuy.setDisable(false);
        comboModel.getSelectionModel().select(1);
        comboColor.getSelectionModel().select(1);
        tfBudget.setText("80000");

        addListeners();

    }



    private void addListeners() {
        addListenerToggleBrand();
        addListenerBudget();
        addListenerExit();
        addListenerBuy();
    }

    private void addListenerToggleBrand() {
        toggleBrand.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                RadioButton rb = (RadioButton) toggleBrand.getSelectedToggle();

                if(rb != null) {
                    String s = rb.getText();

                    switch (s) {
                        case "Samsung":
                            prepareSamsung();
                            break;

                        case "Apple":
                            prepareApple();
                            break;

                        default:
                            System.out.println("ok... this is weird");
                    }
                }
            }
        });
    }

    private void addListenerBudget() {
        tfBudget.textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                if(!Reusables.isNumber(newValue)) {
                    if(Reusables.isNumber(oldValue)) {
                        tfBudget.setText(oldValue);
                    }
                    else {
                        tfBudget.setText("");
                    }
                }
            }
        });
    }

    private void addListenerExit() {
        buttExit.setOnAction(this::exit);
    }

    private void addListenerBuy() {
        buttBuy.setOnAction(actionEvent -> {
            try {
                buy(actionEvent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private void exit(ActionEvent actionEvent){
        final Node source = (Node) actionEvent.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    private void prepareSamsung() {
        comboModel.getItems().clear();
        comboModel.getItems().addAll(samsung_models);
        comboModel.setValue(comboModel.getItems().get(0));
    }

    private void prepareApple() {
        comboModel.getItems().clear();
        comboModel.getItems().addAll(apple_models);
        comboModel.setValue(comboModel.getItems().get(0));
    }

    private void prepareColor() {
        comboColor.getItems().clear();
        comboColor.getItems().addAll(colors);
        comboColor.setValue(comboColor.getItems().get(0));
    }

    private double calculatePrice() {
        double finalPrice = 0;

        finalPrice += price.get(comboModel.getValue());
        finalPrice += getDiskValue();

        return finalPrice;
    }

    private double getDiskValue() {

        String capacity = ((RadioButton)(toggleGB.getSelectedToggle())).getText();
        switch(capacity) {
            case "32GB":
                return price.get("32GB");
            case "64GB":
                return price.get("64GB");
            case "128GB":
                return price.get("128GB");
            default:
                System.out.println("capacity... HDD");
        }
        return 0;
    }

    public void buy(ActionEvent actionEvent) throws Exception {
        if(tfBudget.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Please fill the budget field");
            alert.showAndWait();
            return;
        }
        if(comboModel.getSelectionModel().getSelectedItem() == "None"){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Please choose a model.");
            alert.showAndWait();
            return;
        }

        if(comboColor.getSelectionModel().getSelectedItem() == "None"){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Please choose a color.");
            alert.showAndWait();
            return;
        }

        HashMap<String, Boolean> availability = new HashMap<>();
        for(Map.Entry m : stock.entrySet()){
            availability.put((String) m.getKey(), (Integer)(m.getValue()) > 0);
        }
        // HDD SSD etc...
        HashSet<Statement> knowledge = new HashSet<Statement>();
        for (Map.Entry m : availability.entrySet()) {
            Statement s = new Statement(
                    m.getKey() + "_A",
                    Type.BOOLEAN,
                    Operation.EQ,
                    m.getValue()
            );
            Statement.addTo(knowledge, s);
        }

        Statement s = new Statement(
                "model",
                Type.STRING,
                Operation.EQ,
                comboModel.getSelectionModel().getSelectedItem()
        );
        Statement.addTo(knowledge, s);

        s = new Statement(
                "color",
                Type.STRING,
                Operation.EQ,
                comboColor.getSelectionModel().getSelectedItem()
        );
        Statement.addTo(knowledge, s);
        
        s = new Statement(
                "HD",
                Type.STRING,
                Operation.EQ,
                ((RadioButton)toggleGB.getSelectedToggle()).getText()
        );
        Statement.addTo(knowledge, s);

        Statement enough_budget = new Statement(
                "enough_budget",
                Type.BOOLEAN,
                Operation.EQ,
                calculatePrice() <= Double.parseDouble(tfBudget.getText())
        );
        Statement.addTo(knowledge, enough_budget);

        Statement goal = new Statement(
                "purchase_possible",
                Type.BOOLEAN,
                Operation.EQ,
                true
        );

        ES.clearKnowledgeBase();
        for(Statement S : knowledge){
            ES.addKnowledge(S);
        }
        AgentClientInterface agent = new AgentClientInterface();
        agent.statements = knowledge.toArray(new Statement[knowledge.size()]);
        agent.goal = goal;
        agent.centralID = Main.central.getName();
        agent.type = "phone";
        AgentController ac = Main.mc.acceptNewAgent("client", agent);
        ac.start();
        while(!agent.finished){
            Thread.sleep(100);
        }
        ac.kill();
        lblResult.setText(agent.result);
        if(agent.positive){
            lblResult.setTextFill(Paint.valueOf(clrBlue));
        }
        else{
            lblResult.setTextFill(Paint.valueOf(clrRed));
        }
        lblResult.setVisible(true);
    }

}
