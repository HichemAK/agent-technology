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

import java.util.ArrayList;

public class CommercialController {
    @FXML
    public JFXComboBox comboCPU, comboRAM, comboGPU;
    public JFXCheckBox cbKeyboard, cbMouse;
    public JFXButton buttBuy;

    private ExpertSystem ES = new ExpertSystem("vehicles.es");

    public CommercialController() throws Exception {
    }


    public void initialize(){
        System.out.println(ES);
        vehicleTypeCB.setItems(FXCollections.observableArrayList("", "Cycle", "Automobile"));
        motorCB.setItems(FXCollections.observableArrayList("", "Yes", "No"));
        numDoorsCB.setItems(FXCollections.observableArrayList("", "2","3","4"));
        numWheelsCB.setItems(FXCollections.observableArrayList("", "2","3","4"));
        sizeCB.setItems(FXCollections.observableArrayList("", "Small", "Medium", "Large"));
    }

    public void evaluate(ActionEvent actionEvent) throws Exception {
        ArrayList<Statement> knowledge = new ArrayList<Statement>();
        String value;
        value = (String)vehicleTypeCB.getValue() == null ? "" : (String)vehicleTypeCB.getValue();
        if(value.equals("Cycle")){
            knowledge.add(new Statement("vehicleType", Type.STRING, Operation.EQ, "cycle"));
        }
        else if(value.equals("Automobile")){
            knowledge.add(new Statement("vehicleType", Type.STRING, Operation.EQ,"automobile"));
        }

        value = (String)motorCB.getValue() == null ? "" : (String)motorCB.getValue();
        if(value.equals("Yes")){
            knowledge.add(new Statement("motor", Type.BOOLEAN, Operation.EQ, true));
        }
        else if(value.equals("No")){
            knowledge.add(new Statement("motor", Type.BOOLEAN, Operation.EQ,false));
        }

        value = (String)numWheelsCB.getValue() == null ? "" : (String)numWheelsCB.getValue();
        if(!value.isEmpty()){
            knowledge.add(new Statement("num_wheels", Type.NUMBER, Operation.EQ, Integer.parseInt(value)));
        }

        value = (String)numDoorsCB.getValue() == null ? "" : (String)numDoorsCB.getValue();
        if(!value.isEmpty()){
            knowledge.add(new Statement("num_doors", Type.NUMBER, Operation.EQ, Integer.parseInt(value)));
        }

        value = (String)sizeCB.getValue() == null ? "" : (String)sizeCB.getValue();
        if(value.equals("Small")){
            knowledge.add(new Statement("size", Type.STRING, Operation.EQ, "small"));
        }
        else if(value.equals("Medium")){
            knowledge.add(new Statement("size", Type.STRING, Operation.EQ,"medium"));
        }
        else if(value.equals("Large")){
            knowledge.add(new Statement("size", Type.STRING, Operation.EQ,"large"));
        }

        ES.clearKnowledgeBase();
        for (Statement S : knowledge){
            ES.addKnowledge(S);
        }

        System.out.println(ES.getKnowledgeBase());

        boolean found = false;
        for (Statement goal : possible_results){
            if(ES.infer(goal)){
                found = true;
                resultLabel.setText("Your vehicle is a " + ((String)(goal.getValue())).replace("_", " "));
                break;
            }
        }

        System.out.println(ES.getKnowledgeBase());

        if(!found){
            resultLabel.setText("Your vehicle can not be inferred from given information.");
        }

    }

}