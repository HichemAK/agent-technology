package com.expertsystem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class Rule implements Serializable {

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

    @Override
    public String toString() {
        StringBuffer result = new StringBuffer(name + ": ");
        for(Statement S : antecedents){
            result.append(S.toString());
            result.append(" AND ");
        }
        result.delete(result.length() - 4, result.length());

        result.append("THEN ");
        for(Statement S : consequences){
            result.append(S.toString());
            result.append(" AND ");
        }
        result.delete(result.length() - 5, result.length());
        return result.toString();
    }

    public ArrayList<String> antecedentsToString() {
        ArrayList<String> ret = new ArrayList<String>();

        for(Statement s : antecedents) {
            ret.add(s.toString());
        }

        return ret;
    }

    public ArrayList<String> consequencesToString() {
        ArrayList<String> ret = new ArrayList<String>();

        for(Statement s : consequences) {
            ret.add(s.toString());
        }

        return ret;
    }

    public void removeRedundancies(){
        antecedents = Statement.removeRedundancies(antecedents);
        consequences = Statement.removeRedundancies(consequences);
    }
}
