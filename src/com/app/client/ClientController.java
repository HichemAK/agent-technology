package com.app.client;

import com.expertsystem.*;
import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.ChoiceBox;

import java.util.ArrayList;
import com.expertsystem.Type;
import javafx.scene.control.Label;

public class ClientController {
    public ChoiceBox vehicleTypeCB;
    public ChoiceBox motorCB;
    public ChoiceBox numWheelsCB;
    public ChoiceBox numDoorsCB;
    public ChoiceBox sizeCB;
    public JFXButton evalButton;
    public Label resultLabel;
    private ExpertSystem ES = new ExpertSystem("es_vehicle.es");

    private Statement[] possible_results = {
            new Statement("vehicle", Type.STRING, Operation.EQ, "Bicycle"),
            new Statement("vehicle", Type.STRING, Operation.EQ, "Triycle"),
            new Statement("vehicle", Type.STRING, Operation.EQ, "Motorcycle"),
            new Statement("vehicle", Type.STRING, Operation.EQ, "Sports_car"),
            new Statement("vehicle", Type.STRING, Operation.EQ, "Sedan"),
            new Statement("vehicle", Type.STRING, Operation.EQ, "Minivan"),
            new Statement("vehicle", Type.STRING, Operation.EQ, "Sports_Utility_Vehicle")
    };

    public ClientController() throws Exception {
    }


    public void initialize(){
        vehicleTypeCB.setItems(FXCollections.observableArrayList("Cycle", "Automobile"));
        motorCB.setItems(FXCollections.observableArrayList("Yes", "No"));
        numDoorsCB.setItems(FXCollections.observableArrayList("2","3","4"));
        numWheelsCB.setItems(FXCollections.observableArrayList("2","3","4","<4"));
        sizeCB.setItems(FXCollections.observableArrayList("Small", "Medium", "Large"));
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
        if(value.equals("<4")){
            knowledge.add(new Statement("num_wheels", Type.INTEGER, Operation.LESS, 4));
        }
        else if(!value.isEmpty()){
            knowledge.add(new Statement("num_wheels", Type.INTEGER, Operation.EQ, Integer.parseInt(value)));
        }

        value = (String)numDoorsCB.getValue() == null ? "" : (String)numDoorsCB.getValue();
        if(!value.isEmpty()){
            knowledge.add(new Statement("num_doors", Type.INTEGER, Operation.EQ, Integer.parseInt(value)));
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

        for (Statement S : knowledge){
            ES.addKnowledge(S);
        }

        boolean found = false;
        for (Statement goal : possible_results){
            if(ES.infer(goal)){
                found = true;
                if(goal.getVarName().equals("Sports_Utility_Vehicle")){
                    resultLabel.setText("Your vehicle is a " + "'Sports Utility Vehicle'.");
                }
                else{
                    resultLabel.setText("Your vehicle is a " + "'" + goal.getVarName() + "'.");
                }
                break;
            }
        }

        if(!found){
            resultLabel.setText("Your vehicle can not be inferred from given information.");
        }

    }

}
