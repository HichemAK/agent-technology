package com.expertsystem;

import java.io.Serializable;
import java.util.HashSet;
import java.util.HashSet;

public class Rule{

    private String name;
    private HashSet<Statement> antecedents;
    private HashSet<Statement> consequences;

    public Rule(String name, HashSet<Statement> statements, HashSet<Statement> consequences, boolean optimize) {
        this.name = name;
        this.antecedents = statements;
        this.consequences = consequences;
        if(optimize){
            removeRedundancies();
        }
    }

    public Rule(String name, HashSet<Statement> statements, HashSet<Statement> consequences){
        this(name, statements, consequences, false);
    }

    public Rule(String name) {
        this.name = name;
        antecedents = new HashSet<Statement>();
        consequences = new HashSet<Statement>();
    }

    public String getName() {
        return name;
    }

    public HashSet<Statement> getAntecedents() {
        return antecedents;
    }

    public HashSet<Statement> getConsequences() {
        return consequences;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAntecedents(HashSet<Statement> antecedents) {
        this.antecedents = antecedents;
    }

    public void setConsequences(HashSet<Statement> consequences) {
        this.consequences = consequences;
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

    public HashSet<String> antecedentsToString() {
        HashSet<String> ret = new HashSet<String>();

        for(Statement s : antecedents) {
            ret.add(s.toString());
        }

        return ret;
    }

    public HashSet<String> consequencesToString() {
        HashSet<String> ret = new HashSet<String>();

        for(Statement s : consequences) {
            ret.add(s.toString());
        }

        return ret;
    }

    public void removeRedundancies(){
        antecedents = Statement.removeRedundancies(antecedents);
        consequences = Statement.removeRedundancies(consequences);
    }

    public HashSet<String> getVarNames() {
        HashSet<String> strs = new HashSet<>();
        HashSet<String> ret = new HashSet<>();

        HashSet<Statement> sts = getConsequences();
        sts.addAll(getAntecedents());

        for(Statement s : sts) {
            strs.add(s.getVarName());
        }

        for(String str : strs) {
            ret.add(str);
        }

        return ret;
    }

    public boolean appliedFrom(HashSet<Statement> statements){
        boolean isInferred;
        for(Statement antecedant : antecedents){
            isInferred = false;
            for(Statement s : statements){
                if(antecedant.inferredFrom(s)){
                    isInferred = true;
                    break;
                }
            }
            if(!isInferred){
                return false;
            }
        }
        return true;
    }

    public boolean addAntecedent(Statement s){
        return Statement.addTo(antecedents, s);
    }

    public boolean addConsequence(Statement s){
        return Statement.addTo(consequences, s);
    }
}
