package com.expertsystem;

import com.sun.glass.ui.Window;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {

        ArrayList<Rule> rules = new ArrayList<>(Arrays.asList(
                new Rule("Bicycle",
                        new ArrayList<Statement>(Arrays.asList(
                                new Statement("vehicleType", Type.STRING, Operation.EQ, "cycle"),
                                new Statement("num_wheels", Type.INTEGER, Operation.GREAT_EQ, 3),
                                new Statement("motor", Type.BOOLEAN, Operation.EQ, false)
                        )),
                        new ArrayList<Statement>(Arrays.asList(
                                new Statement("vehicle", Type.STRING, Operation.EQ, "bicycle")
                        )))
        ));

        ArrayList<Statement> knowledge = new ArrayList<>(Arrays.asList(
                new Statement("vehicleType", Type.STRING, Operation.EQ, "cycle"),
                new Statement("num_wheels", Type.INTEGER, Operation.GREAT_EQ, 4),
                new Statement("motor", Type.BOOLEAN, Operation.EQ, false)
        ));

        Statement goal = new Statement("vehicle", Type.STRING, Operation.EQ, "bicycle");

        ExpertSystem ES = new ExpertSystem(rules, knowledge);

        System.out.println("=============================BEFORE INFERENCE:=============================");
        System.out.println(ES);
        ES.infer(goal);
        System.out.println("=============================AFTER INFERENCE:=============================");
        System.out.println(ES);

        String filepath = "C:\\Users\\dell\\Desktop\\haha.es";
        System.out.println("Saving Expert System...");
        ES.save(filepath);
        System.out.println("Reloading Expert System...\n\n\n");
        ES = new ExpertSystem(filepath);
        System.out.println(ES);

        Statement[] test = {
                new Statement("A", Type.INTEGER, Operation.GREAT, 0),
                new Statement("A", Type.INTEGER, Operation.GREAT, 1),
                new Statement("A", Type.INTEGER, Operation.GREAT, 2)
        };

        System.out.println("Before remove redundancies");
        for(Statement S : test){
            System.out.println(S);
        }
        System.out.println("After remove redundancies");
        ArrayList<Statement> tested = Statement.removeRedundancies(new ArrayList<Statement>(Arrays.asList(test)));
        for(Statement S : tested){
            System.out.println(S);
        }
    }
}
