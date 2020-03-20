package com.expertsystem;

public enum Operation {
    EQ("="),
    NEQ("!="),
    LESS("<"),
    GREAT(">"),
    LESS_EQ("<="),
    GREAT_EQ(">=");

    private String symb;

    Operation(String symb){
        this.symb = symb;
    }

    public String getSymb(){
        return symb;
    }

    @Override
    public String toString() {
        return symb;
    }
}
