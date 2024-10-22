package com.expertsystem;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.HashSet;

public class ExpertSystem{

    private HashSet<Rule> rules;
    private HashSet<Statement> knowledgeBase;

    public ExpertSystem(HashSet<Rule> rules, HashSet<Statement> statements) {
        this.rules = new HashSet<>(rules);
        this.knowledgeBase = new HashSet<>(statements);
        Statement.removeRedundancies(knowledgeBase);
    }

    public ExpertSystem() {
        this.rules = new HashSet<Rule>();
        this.knowledgeBase = new HashSet<Statement>();
    }

    public ExpertSystem(String filepath) throws FileNotFoundException {
        /**
         * Loads ExpertSystem from file located at 'filepath'
         */
        Gson gson = new Gson();
        ExpertSystem es = gson.fromJson(new FileReader(filepath), ExpertSystem.class);
        this.knowledgeBase = es.knowledgeBase;
        this.rules = es.rules;
    }

    public ExpertSystem(File fileES) throws FileNotFoundException {
        /**
         * Loads ExpertSystem from file 'fileES'
         */
        this(fileES.getAbsolutePath());
    }

    public HashSet<Rule> getRules() {
        return rules;
    }

    public HashSet<Statement> getKnowledgeBase() {
        return knowledgeBase;
    }

    public boolean addKnowledge(Statement s) {
        return Statement.addTo(knowledgeBase, s);
    }

    public void removeRedundancies() {
        for(Rule R : rules){
            R.removeRedundancies();
        }
        knowledgeBase = Statement.removeRedundancies(knowledgeBase);
    }

    public boolean removeKnowledge(Statement S) {
        if(S == null || !knowledgeBase.contains(S)) {
            return false;
        }

        knowledgeBase.remove(S);
        return true;
    }

    public void clearKnowledgeBase() {
        knowledgeBase = new HashSet<Statement>();
    }

    public boolean addRule(Rule r) {
        rules.add(r);
        return true;
    }

    public boolean removeRule(Rule R) {
        rules.remove(R);
        return true;
    }

    public void clearRules() {
        rules = new HashSet<Rule>();
    }

    public boolean infer(Statement goal){
        for(Statement s : knowledgeBase){
            if(goal.inferredFrom(s)){
                return true;
            }
        }
        HashSet<Rule> remainingRules = new HashSet<>(rules);
        HashSet<Rule> toRemove;
        boolean goal_reached = false;
        boolean canApply = true;
        while(canApply){
            toRemove = new HashSet<>();
            canApply = false;
            for(Rule r : remainingRules){
                if(r.appliedFrom(knowledgeBase)){
                    canApply = true;
                    for(Statement s : r.getConsequences()){
                        addKnowledge(s);
                        if(goal.inferredFrom(s)){
                            goal_reached = true;
                        }
                    }
                    if(goal_reached){
                        return true;
                    }
                    toRemove.add(r);
                }
            }
            remainingRules.removeAll(toRemove);
        }
        return false;
    }

    private HashSet<Integer> getRulesIndexes() {
        HashSet<Integer> ret = new HashSet<Integer>();

        for(int i = 0; i < rules.size(); i++) {
            ret.add(i);
        }

        return ret;
    }

    public void save(String filepath) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            Writer writer = new FileWriter(filepath);
            gson.toJson(this, writer);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void save(File file) throws IOException {
        save(file.getAbsolutePath());
    }

    @Override
    public String toString() {
        StringBuffer result = new StringBuffer("Rules: \n======\n");
        for(Rule R : rules){
            result.append(R.toString() + "\n");
        }
        result.append("\nKnowledgeBase:\n==============\n");
        for(Statement S : knowledgeBase){
            result.append(S.toString() + "\n");
        }
        return result.toString();
    }

    public int getNumberOfRules() {
        return this.rules.size();
    }

    public String getStringNumOfRules() {
        return Integer.toString(this.rules.size());
    }
}
