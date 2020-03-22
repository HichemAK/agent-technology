package com.expertsystem;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;

public class ExpertSystem implements Serializable{

    private ArrayList<Rule> rules;
    private ArrayList<Statement> knowledgeBase;

    public ExpertSystem(ArrayList<Rule> rules, ArrayList<Statement> statements) {
        this.rules = rules;
        this.knowledgeBase = statements;
    }

    public ExpertSystem() {
        this.rules = new ArrayList<Rule>();
        this.knowledgeBase = new ArrayList<Statement>();
    }

    public ExpertSystem(String filepath) {
        /**
         * Loads ExpertSystem from file located at 'filepath'
         */
        try {
            FileInputStream fileIn = new FileInputStream(filepath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            ExpertSystem ES = (ExpertSystem) objectIn.readObject();
            objectIn.close();

            this.knowledgeBase = ES.knowledgeBase;
            this.rules = ES.rules;
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ExpertSystem(File fileES) {
        /**
         * Loads ExpertSystem from file 'fileES'
         */
        this(fileES.getAbsolutePath());
    }

    public ArrayList<Rule> getRules() {
        return rules;
    }

    public ArrayList<Statement> getKnowledgeBase() {
        return knowledgeBase;
    }

    public boolean addKnowledge(Statement s) {
        for(Statement sts : this.knowledgeBase) {
            if(s.inferredFrom(sts)) {
                return false;
            }
        }
        knowledgeBase.add(s);
        return true;
    }

    public void removeRedundancies() {
        for(Rule R : rules){
            R.removeRedundancies();
        }
        knowledgeBase = Statement.removeRedundancies(knowledgeBase);
    }

    public boolean removeStatement(int index) {
        if(index < 0 || index >= knowledgeBase.size()) {
            return false;
        }

        knowledgeBase.remove(index);
        return true;
    }

    public void clearKnowledgeBase() {
        knowledgeBase = new ArrayList<Statement>();
    }

    public boolean addRule(Rule r) {
        rules.add(r);
        return true;
    }

    public boolean removeRule(int index) {
        if(index < 0 || index >= rules.size()) {
            return false;
        }

        rules.remove(index);
        return true;
    }

    public void clearRules() {
        rules = new ArrayList<Rule>();
    }

    public boolean infer(Statement goal) {
        ArrayList<Integer> rulesIndexes = getRulesIndexes();
        ArrayList<Integer> removables = new ArrayList<Integer>();
        boolean changed = true;
        boolean result = false;
        boolean resultRule = true;

        while(true) {
            for(Statement knowledge : knowledgeBase) {
                if(goal.inferredFrom(knowledge)) {
                    return true;
                }
            }

            if(rulesIndexes.size() == 0) {
                return false;
            }

            if(!changed) {
                return false;
            }

            changed = false;

            for(Integer index : rulesIndexes) {
                Rule currentRule = rules.get(index);
                resultRule = true;

                ArrayList<Statement> antecedents = currentRule.getAntecedents();

                for(Statement s : antecedents) {
                    for(Statement k : knowledgeBase) {
                        result = true;
                        if(s.inferredFrom(k)) {
                            break;
                        }
                        result = false;
                    }
                    if(!result) {
                        resultRule = false;
                        break;
                    }
                }

                if(resultRule) {
                    for(Statement c : currentRule.getConsequences()) {
                        this.addKnowledge(c);
                    }

                    removables.add(rulesIndexes.indexOf(index));
                    changed = true;
                }
            }

            rulesIndexes.removeAll(removables);
        }

    }

    private ArrayList<Integer> getRulesIndexes() {
        ArrayList<Integer> ret = new ArrayList<Integer>();

        for(int i = 0; i < rules.size(); i++) {
            ret.add(i);
        }

        return ret;
    }

    public void save(String filepath) {
        try {
            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(this);
            objectOut.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void save(File file){
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
}
