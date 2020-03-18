package com.expertsystem;

import java.util.ArrayList;

public class Rule {

    private String name;
    private ArrayList<Statement> antecedents;
    private ArrayList<Statement> consequences;

    public Rule(String name, ArrayList<Statement> statements, ArrayList<Statement> consequences) {
        this.name = name;
        this.antecedents = statements;
        this.consequences = consequences;
    }

    public Rule(String name) {
        this.name = name;
        antecedents = new ArrayList<Statement>();
        consequences = new ArrayList<Statement>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Statement> getAntecedents() {
        return antecedents;
    }

    public ArrayList<Statement> getConsequences() {
        return consequences;
    }
}
