package com.app.commercial;

import com.expertsystem.ExpertSystem;
import com.expertsystem.Operation;
import com.expertsystem.Statement;
import com.expertsystem.Type;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;

import java.util.ArrayList;

public class CommercialController {
    @FXML
    public JFXComboBox comboCPU, comboRAM, comboGPU;
    public JFXCheckBox cbKeyboard, cbMouse;
    public JFXButton buttBuy;
    public JFXRadioButton rbIntel, rbAMD;
    public ToggleGroup toggleCPU;

    public CommercialController() throws Exception {
    }


    public void initialize(){

    }

    public void buy(ActionEvent actionEvent) throws Exception {

    }

}
