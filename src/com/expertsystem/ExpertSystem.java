package com.expertsystem;

public class ExpertSystem {

    private ArrayList<Rule> rules;
    private ArrayList<Statement> knowledgeBase;

    public ExpertSystem(ArrayList<Rule> rules, ArrayList<Statement> statements) {
        this.rules = rules;
        this.knowledgeBase = statements;
    }

    public ExpertSystem() {
        this.rules = new ArrayList<Rule>;
        this.knowledgeBase = new ArrayList<Statement>;
    }

    public ArrayList<Rule> getRules() {
        return rules;
    }

    public ArrayList<Statement> getKnowledgeBase() {
        return knowledgeBase;
    }

    public boolean addStatement(Statement s) {
        for(sts : knowledgeBase) {
            if(s.inferedFrom(sts)) {
                return false;
            }
        }
        knowledgeBase.add(s);
        return true;
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
}
