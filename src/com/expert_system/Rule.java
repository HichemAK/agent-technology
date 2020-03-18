package com.expert_system;

public class Rule {

    private String name;
    private ArrayList<Statements> antecedents;
    private ArrayList<Statements> consequences;

    public Rule(String name, ArrayList<Statements> statements, ArrayList<Statements> consequences) {
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

    public ArrayList<Statements> getAntecedents() {
        return antecedents;
    }

    public ArrayList<Statements> getConsequences() {
        return consequences;
    }
}
