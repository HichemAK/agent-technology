package com.expertsystem;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;

public class Statement{
    private String varName;
    private Type type;
    private Operation operation;
    private Object value;

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
                    return !((Double)S.getValue()).equals((Double)getValue());
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
        return varName + " " + operation.getSymb() + " " + value.toString();
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
