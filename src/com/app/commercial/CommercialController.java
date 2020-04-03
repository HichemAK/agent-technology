package com.app.commercial;

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
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import com.app.admin.Reusables;
import javafx.scene.paint.Paint;

import java.awt.*;
import java.util.*;

public class CommercialController {
    @FXML
    public JFXComboBox comboCPU, comboRAM, comboGPU;
    public JFXCheckBox cbKeyboard, cbMouse;
    public JFXButton buttBuy, buttExit;

    public JFXRadioButton rbIntel, rbAMD;
    public JFXRadioButton rbHDD, rbSSD;
    public JFXRadioButton rb256, rb512, rb1TB;

    public ToggleGroup toggleCPU, toggleDisk, toggleGB;

    public TextField tfBudget;

    public Label lblResult;

    private String clrBlue, clrRed, clrBlack;

    private ExpertSystem ES = new ExpertSystem("PC.es");
    private HashMap<String, Integer> stock = new HashMap<>();
    private ArrayList<String> amd_cpus = new ArrayList<>(Arrays.asList("None", "Ryzen3", "Ryzen5", "Ryzen7"));
    private ArrayList<String> intel_cpus = new ArrayList<>(Arrays.asList("None", "Pentium", "DualCore", "i3", "i5", "i7"));
    private ArrayList<String> gpus = new ArrayList<>(Arrays.asList("None", "RTX", "GTX", "Radeon", "Titan"));
    private ArrayList<String> rams = new ArrayList<>(Arrays.asList("0", "1", "2", "4", "8", "12", "16", "24", "32", "64", "128"));
    private HashMap<String, Integer> price = new HashMap<>();

    public CommercialController() throws Exception {
    }

    public void initialize(){
        clrBlack = "#000000";
        clrBlue = "#42acff";
        clrRed = "#e03d3d";
        
        stock.put("Ryzen3", 10);
        stock.put("Ryzen5", 0);
        stock.put("Ryzen7", 8);
        stock.put("Pentium", 0);
        stock.put("DualCore", 4);
        stock.put("i3", 20);
        stock.put("i5", 20);
        stock.put("i7", 0);
        stock.put("RTX", 0);
        stock.put("GTX", 3);
        stock.put("Radeon", 8);
        stock.put("Titan", 0);
        stock.put("mouse", 40);
        stock.put("keyboard", 30);
        stock.put("HDD256", 0);
        stock.put("HDD512", 0);
        stock.put("HDD1024", 30);
        stock.put("SSD256", 12);
        stock.put("SSD512", 8);
        stock.put("SSD1024", 0);
        stock.put("RAM", 96);

        price.put("Ryzen3", 16000);
        price.put("Ryzen5", 20000);
        price.put("Ryzen7", 50000);
        price.put("Pentium", 4000);
        price.put("DualCore", 7000);
        price.put("i3", 12000);
        price.put("i5", 22000);
        price.put("i7", 44000);
        price.put("RTX", 120000);
        price.put("GTX", 50000);
        price.put("Radeon", 30000);
        price.put("Titan", 230000);
        price.put("mouse", 1000);
        price.put("keyboard", 1200);
        price.put("HDD256", 2500);
        price.put("HDD512", 5100);
        price.put("HDD1024", 8000);
        price.put("SSD256", 7000);
        price.put("SSD512", 12000);
        price.put("SSD1024", 30000);
        price.put("RAM", 1000);
        price.put("None", 0);

        prepareIntel();
        prepareRAM();
        prepareGPU();
        buttBuy.setDisable(false);

        addListeners();

    }

    private void addListeners() {
        addListenerToggleCPU();
        addListenerBudget();
        addListenerExit();
        addListenerBuy();
    }

    private void addListenerToggleCPU() {
        toggleCPU.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                RadioButton rb = (RadioButton)toggleCPU.getSelectedToggle();

                if(rb != null) {
                    String s = rb.getText();

                    switch (s) {
                        case "Intel":
                            prepareIntel();
                            break;

                        case "AMD":
                            prepareAMD();
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

        Platform.exit();
        System.exit(0);
    }

    private void prepareIntel() {
        comboCPU.getItems().clear();
        comboCPU.getItems().addAll(intel_cpus);
        comboCPU.setValue(comboCPU.getItems().get(0));
    }

    private void prepareAMD() {
        comboCPU.getItems().clear();
        comboCPU.getItems().addAll(amd_cpus);
        comboCPU.setValue(comboCPU.getItems().get(0));
    }

    private void prepareRAM() {
        comboRAM.getItems().clear();
        comboRAM.getItems().addAll(rams);
        comboRAM.setValue(comboRAM.getItems().get(0));
    }

    private void prepareGPU() {
        comboGPU.getItems().addAll(gpus);
        comboGPU.setValue(comboGPU.getItems().get(0));
    }

    private double calculatePrice() {
        double finalPrice = 0;

        finalPrice += price.get(comboCPU.getValue());
        finalPrice += price.get("RAM") * Integer.parseInt((String) comboRAM.getValue());
        finalPrice += price.get(comboGPU.getValue());
        finalPrice += getDiskValue();
        if(cbKeyboard.isSelected()){
            finalPrice += price.get("keyboard");
        }
        if(cbMouse.isSelected()){
            finalPrice += price.get("mouse");
        }

        return finalPrice;
    }

    private double getDiskValue() {

        String type = ((RadioButton)(toggleDisk.getSelectedToggle())).getText();
        String capacity = ((RadioButton)(toggleGB.getSelectedToggle())).getText();

        switch(type) {
            case "HDD":
                switch(capacity) {
                    case "256GB":
                        return price.get("HDD256");
                    case "512GB":
                        return price.get("HDD512");
                    case "1TB":
                        return price.get("HDD1024");
                    default:
                        System.out.println("capacity... HDD");
                }
                break;

            case "SSD":
                switch(capacity) {
                    case "256GB":
                        return price.get("SSD256");
                    case "512GB":
                        return price.get("SSD512");
                    case "1TB":
                        return price.get("SSD1024");
                    default:
                        System.out.println("capacity... SSD");
                }
                break;

            default:
                System.out.println("capacity... ALL");
        }

        return 0;
    }

    private String getDisk() {

        String type = ((RadioButton)(toggleDisk.getSelectedToggle())).getText();
        String capacity = ((RadioButton)(toggleGB.getSelectedToggle())).getText();

        switch(type) {
            case "HDD":
                switch(capacity) {
                    case "256GB":
                        return "HDD256";
                    case "512GB":
                        return "HDD512";
                    case "1TB":
                        return "HDD1024";
                    default:
                        System.out.println("capacity... HDD");
                }
                break;

            case "SSD":
                switch(capacity) {
                    case "256GB":
                        return "SSD256";
                    case "512GB":
                        return "SSD512";
                    case "1TB":
                        return "SSD1024";
                    default:
                        System.out.println("capacity... SSD");
                }
                break;

            default:
                System.out.println("capacity... ALL");
        }

        return null;
    }

    public void buy(ActionEvent actionEvent) throws Exception {
        if(tfBudget.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Please fill the budget field");
            alert.showAndWait();
            return;
        }

        HashMap<String, Boolean> availability = new HashMap<>();
        //HashSet<String> specialCases = new HashSet<>(Arrays.asList("HDD256", "HDD512", "HDD1024", "SSD256", "SSD512", "SSD1024", "RAM"));
        HashSet<String> specialCases = new HashSet<>(Arrays.asList("RAM"));
        for(Map.Entry m : stock.entrySet()){
            if(!specialCases.contains(m.getKey())){
                availability.put((String) m.getKey(), (Integer)(m.getValue()) > 0);
            }
        }
        availability.put("RAM", stock.get("RAM") > Integer.parseInt((String) comboRAM.getSelectionModel().getSelectedItem()));
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
                "CPU",
                Type.STRING,
                Operation.EQ,
                comboCPU.getSelectionModel().getSelectedItem()
        );
        Statement.addTo(knowledge, s);

        s = new Statement(
                "GPU",
                Type.STRING,
                Operation.EQ,
                comboGPU.getSelectionModel().getSelectedItem()
        );
        Statement.addTo(knowledge, s);

        s = new Statement(
                "RAM",
                Type.NUMBER,
                Operation.EQ,
                Integer.parseInt((String) comboRAM.getSelectionModel().getSelectedItem())
        );
        Statement.addTo(knowledge, s);

        s = new Statement(
                "mouse",
                Type.BOOLEAN,
                Operation.EQ,
                cbMouse.isSelected()
        );
        Statement.addTo(knowledge, s);

        s = new Statement(
                "keyboard",
                Type.BOOLEAN,
                Operation.EQ,
                cbKeyboard.isSelected()
        );
        Statement.addTo(knowledge, s);
        
        s = new Statement(
                "HD",
                Type.STRING,
                Operation.EQ,
                getDisk()
        );
        Statement.addTo(knowledge, s);

        s = new Statement(
                "enough_budget",
                Type.BOOLEAN,
                Operation.EQ,
                calculatePrice() <= Double.parseDouble(tfBudget.getText())
        );
        Statement.addTo(knowledge, s);

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
        System.out.println(ES.getKnowledgeBase());
        if(ES.infer(goal)){
            lblResult.setText("Your order has been registered successfully!");
            lblResult.setTextFill(Paint.valueOf(clrBlue));
        }
        else{
            lblResult.setText("Sorry, we were unable to fulfill the wishes of your command");
            lblResult.setTextFill(Paint.valueOf(clrRed));
        }
        System.out.println(ES.getKnowledgeBase());
        lblResult.setVisible(true);
    }

}
