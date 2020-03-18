package com.expertsystem;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {

        ArrayList<Rule> rules = new ArrayList<>(Arrays.asList(
                new Rule("Bicycle",
                        new ArrayList<Statement>(Arrays.asList(
                                new Statement("vehicleType", Type.STRING, Operation.EQ, "cycle"),
                                new Statement("num_wheels", Type.INTEGER, Operation.GREAT_EQ, 5),
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

        System.out.println(ES.infer(goal));
    }
}
