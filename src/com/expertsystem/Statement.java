package com.expertsystem;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashSet;

public class Statement implements Serializable {
    private String varName;
    private Type type;
    private Operation operation;
    private Object value;
    private static String regex = "^[0|1|2][a-zA-Z_$][a-zA-Z_$0-9]* [=|<|<=|!=|>|>=] .*$";

    public Statement(String varName, Type type, Operation operation, Object value) throws Exception {
        if(varName.length() == 0){
            throw new Exception("'varName' must not be empty.");
        }

        if(type == Type.STRING && operation != Operation.EQ && operation != Operation.NEQ){
            throw new Exception("STRING type can only support EQ (equal) and NEQ (not equal) operations");
        }

        if(type == Type.BOOLEAN && operation != Operation.EQ){
            throw new Exception("BOOLEAN type can only support EQ (equal) operation");
        }
        Object value2;
        if(value instanceof Integer){
            value2 = Double.valueOf((Integer)value);
        }
        else{
            value2 = value;
        }

        if(!value2.getClass().isAssignableFrom(type.get())){
            throw new Exception("'value' type must match 'type'");
        }

        this.varName = varName;
        this.type = type;
        this.operation = operation;
        this.value = value2;
    }

    public Statement(String str) throws Exception {
        if(!str.matches(regex)){
            throw new Exception("The given String does not match the statement regular expression");
        }
        Operation op;
        Type type;
        Object value;
        if(str.charAt(0) == '0'){
            type = Type.NUMBER;
        }
        else if(str.charAt(0) == '1'){
            type = Type.BOOLEAN;
        }
        else if(str.charAt(0) == '2'){
            type = Type.STRING;
        }
    }

    public boolean inferredFrom(Statement S){
        if(!varName.equals(S.varName) || type != S.type){
            return false;
        }
        if(operation == S.operation){
            if(S.value.equals(this.value)){
                return true;
            }

            if(operation == Operation.GREAT){
                return (Double)S.value > (Double)this.value;
            }

            if(operation == Operation.GREAT_EQ){
                return (Double)S.value >= (Double)this.value;
            }

            if(operation == Operation.LESS){
                return (Double)S.value < (Double)this.value;
            }

            if(operation == Operation.LESS_EQ){
                return (Double)S.value <= (Double)this.value;
            }
        }
        else{
            // Not the same operation
            if(S.operation == Operation.EQ){
                if(operation == Operation.NEQ){
                    return !(S.getValue()).equals(getValue());
                }
                if(operation == Operation.LESS){
                    return (Double)S.getValue() < (Double)getValue();
                }
                if(operation == Operation.LESS_EQ){
                    return (Double)S.getValue() <= (Double)getValue();
                }
                if(operation == Operation.GREAT){
                    return (Double)S.getValue() > (Double)getValue();
                }
                if(operation == Operation.GREAT_EQ){
                    return (Double)S.getValue() >= (Double)getValue();
                }
            }
            if(S.operation == Operation.NEQ){
                if(operation == Operation.EQ && type == Type.BOOLEAN){
                    return ((Boolean)S.getValue()).equals(!(Boolean)getValue());
                }
            }
            if(S.operation == Operation.GREAT){
                if(operation == Operation.NEQ || operation == Operation.GREAT_EQ){
                    return (Double)S.getValue() >= (Double)getValue();
                }
            }
            if(S.operation == Operation.LESS){
                if(operation == Operation.NEQ || operation == Operation.LESS_EQ){
                    return (Double)S.getValue() <= (Double)getValue();
                }
            }
            if(S.operation == Operation.GREAT_EQ){
                if(operation == Operation.NEQ || operation == Operation.GREAT){
                    return (Double)S.getValue() > (Double)getValue();
                }
            }
            if(S.operation == Operation.LESS_EQ || S.operation == Operation.LESS){
                if(operation == Operation.NEQ){
                    return (Double)S.getValue() < (Double)getValue();
                }
            }
        }


        return false;
    }

    public static boolean addTo(HashSet<Statement> statements, Statement s){
        /*
        Supposing that 'statements' is already optimized
         */
        Statement toRemove = null;
        for(Statement sts : statements) {
            if(s.inferredFrom(sts)) {
                return false;
            }
            if(sts.inferredFrom(s)){
                toRemove = sts;
                break;
            }
        }
        statements.add(s);
        if(toRemove != null){
            statements.remove(toRemove);
        }
        return true;
    }

    public static HashSet<Statement> removeRedundancies(HashSet<Statement> statements){
        HashSet<Statement> result = new HashSet<>();
        HashSet<Statement> toRemove;
        boolean S1inferS2, S2inferS1;
        for(Statement S1 : statements){
            S1inferS2 = false;
            S2inferS1 = false;
            toRemove = new HashSet<>();
            for(Statement S2 : result){
                if(S1.inferredFrom(S2)){
                    S2inferS1 = true;
                    break;
                }
                if(S2.inferredFrom(S1)){
                    S1inferS2 = true;
                    toRemove.add(S2);
                }
            }
            if(!S2inferS1 || S1inferS2){
                result.add(S1);
            }
            result.removeAll(toRemove);
        }
        return result;
    }

    @Override
    public String toString() {
        String str = value.toString();
        if(type == Type.NUMBER){
            String temp = String.valueOf((double) value);
            if(temp.substring(temp.length()-2).equals(".0")){
                str = temp.substring(0, temp.length()-2);
            }
        }
        return varName + " " + operation.getSymb() + " " + str;
    }

    public String getVarName() {
        return varName;
    }

    public Object getValue() {
        return value;
    }

    public Operation getOperation() {
        return operation;
    }

    public Type getType() {
        return type;
    }


}
