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

    private ExpertSystem ES = new ExpertSystem("PC.es");
    private HashMap<String, Integer> stock = new HashMap<>();
    private ArrayList<String> amd_cpus = new ArrayList<>(Arrays.asList("None", "Ryzen3", "Ryzen5", "Ryzen7"));
    private ArrayList<String> intel_cpus = new ArrayList<>(Arrays.asList("None", "Pentium", "DualCore", "i3", "i5", "i7"));
    private ArrayList<String> gpus = new ArrayList<>(Arrays.asList("None", "RTX", "GTX", "Radeon", "Titan"));
    private ArrayList<String> rams = new ArrayList<>(Arrays.asList("0", "1", "2", "4", "8", "12", "16", "32", "64", "128"));
    private HashMap<String, Integer> price = new HashMap<>();

    public CommercialController() throws Exception {
    }

    public void changeBrandCPU(){

    }

    public void initialize(){
        stock.put("Ryzen3", 10);
        stock.put("Ryzen5", 0);
        stock.put("Ryzen7", 8);
        stock.put("Pentium", 0);
        stock.put("DualCore", 4);
        stock.put("i3", 20);
        stock.put("i5", 20);
        stock.put("RTX", 0);
        stock.put("GTX", 3);
        stock.put("Radeon", 8);
        stock.put("Titan", 0);
        stock.put("mouse", 40);
        stock.put("keyboard", 30);
        stock.put("hdd256", 0);
        stock.put("hdd512", 0);
        stock.put("hdd1024", 30);
        stock.put("ssd256", 12);
        stock.put("ssd512", 8);
        stock.put("ssd1024", 0);
        stock.put("RAM", 96);

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
            
        });
    }

    public void exit(ActionEvent actionEvent){

        Platform.exit();
        System.exit(0);
    }

    public void prepareIntel() {
        comboCPU.getItems().clear();
        comboCPU.getItems().addAll(intel_cpus);
        comboCPU.setValue(comboCPU.getItems().get(0));
    }

    public void prepareAMD() {
        comboCPU.getItems().clear();
        comboCPU.getItems().addAll(amd_cpus);
        comboCPU.setValue(comboCPU.getItems().get(0));
    }

    public void prepareRAM() {
        comboRAM.getItems().clear();
        comboRAM.getItems().addAll(rams);
        comboRAM.setValue(comboRAM.getItems().get(0));
    }

    public void prepareGPU() {
        comboGPU.getItems().add("");
        comboGPU.getItems().addAll(gpus);
    }

    public void buy(ActionEvent actionEvent) throws Exception {
        HashMap<String, Boolean> availability = new HashMap<>();
        for(Map.Entry m : stock.entrySet()){
            if(!m.getKey().equals("RAM") && !m.getKey().equals("hdd"))
        }
        HashSet<Statement> knowledge = new HashSet<Statement>();
        for (Map.Entry m : stock.entrySet()) {
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


    }

}
