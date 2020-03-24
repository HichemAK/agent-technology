package com.app.commercial;

import com.expertsystem.ExpertSystem;
import com.expertsystem.Operation;
import com.expertsystem.Statement;
import com.expertsystem.Type;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import java.awt.*;
import java.util.*;

public class CommercialController {
    @FXML
    public JFXComboBox comboCPU, comboRAM, comboGPU;
    public JFXCheckBox cbKeyboard, cbMouse;
    public JFXButton buttBuy;

    private ExpertSystem ES = new ExpertSystem("PC.es");
    private HashMap<String, Boolean> availability = new HashMap<>();
    private ArrayList<String> amd_cpus = new ArrayList<>(Arrays.asList("Ryzen3", "Ryzen5", "Ryzen7"));
    private ArrayList<String> intel_cpus = new ArrayList<>(Arrays.asList("Pentium", "DualCore", "i3", "i5", "i7"));
    private ArrayList<String> gpus = new ArrayList<>(Arrays.asList("RTX", "GTX", "Radeon", "Titan"));
    private ArrayList<String> rams = new ArrayList<>(Arrays.asList("0", "1", "2", "4", "8", "12", "16", "32", "64", "128"));

    public CommercialController() throws Exception {
    }

    public void changeBrandCPU(){

    }

    public void initialize(){
        availability.put("Ryzen3", true);
        availability.put("Ryzen5", false);
        availability.put("Ryzen7", true);
        availability.put("Pentium", false);
        availability.put("DualCore", true);
        availability.put("i3", true);
        availability.put("i5", true);
        availability.put("RTX", false);
        availability.put("GTX", true);
        availability.put("Radeon", true);
        availability.put("Titan", false);

        comboCPU.getItems().addAll(intel_cpus);
        comboRAM.getItems().addAll(rams);
        comboGPU.getItems().addAll(gpus);
    }

    public void buy(ActionEvent actionEvent) throws Exception {
        HashSet<Statement> knowledge = new HashSet<Statement>();
        for(Map.Entry m: availability.entrySet()){
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
