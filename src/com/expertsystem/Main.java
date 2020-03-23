package com.expertsystem;

import com.sun.glass.ui.Window;

import java.util.HashSet;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {

        HashSet<Rule> rules = new HashSet<>(Arrays.asList(
                new Rule("Bicycle",
                        new HashSet<Statement>(Arrays.asList(
                                new Statement("vehicleType", Type.STRING, Operation.EQ, "cycle"),
                                new Statement("num_wheels", Type.NUMBER, Operation.EQ, 2),
                                new Statement("motor", Type.BOOLEAN, Operation.EQ, false)
                        )),
                        new HashSet<Statement>(Arrays.asList(
                                new Statement("vehicle", Type.STRING, Operation.EQ, "Bicycle")
                        )))
        ));

        HashSet<Statement> knowledge = new HashSet<>(Arrays.asList(
                new Statement("num_wheels", Type.NUMBER, Operation.EQ, 2),
                new Statement("vehicleType", Type.STRING, Operation.EQ, "cycle"),
                new Statement("motor", Type.BOOLEAN, Operation.EQ, false)
        ));

        Statement goal = new Statement("vehicle", Type.STRING, Operation.EQ, "Bicycle");

        ExpertSystem ES = new ExpertSystem(rules, knowledge);

        System.out.println("=============================BEFORE INFERENCE:=============================");
        System.out.println(ES);
        System.out.println(ES.infer(goal));
        System.out.println("=============================AFTER INFERENCE:=============================");
        System.out.println(ES);

        ES = new ExpertSystem(rules, knowledge);
        String filepath = "haha.es";
        System.out.println("Saving Expert System...");
        ES.save(filepath);
        System.out.println("Reloading Expert System...\n\n\n");
        ES = new ExpertSystem(filepath);
        System.out.println(ES);

        Statement[] test = {
                new Statement("A", Type.NUMBER, Operation.GREAT, 0),
                new Statement("A", Type.NUMBER, Operation.GREAT, 1),
                new Statement("A", Type.NUMBER, Operation.GREAT, 2)
        };

        System.out.println("Before remove redundancies");
        for(Statement S : test){
            System.out.println(S);
        }
        System.out.println("After remove redundancies");
        HashSet<Statement> tested = Statement.removeRedundancies(new HashSet<Statement>(Arrays.asList(test)));
        for(Statement S : tested){
            System.out.println(S);
        }

    }
}
