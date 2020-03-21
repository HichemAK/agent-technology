package com.expertsystem;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;

public class Statement implements Serializable {
    private String varName;
    private Type type;
    private Operation operation;
    private Object value;

    public Statement(String varName, Type type, Operation operation, Object value) throws Exception {
        if(varName.length() == 0){
            throw new Exception("'varName' must not be empty.");
        }

        if((type == Type.BOOLEAN || type == Type.STRING) && operation != Operation.EQ && operation != Operation.NEQ){
            throw new Exception("BOOLEAN and STRING type can only support EQ (equal) and NEQ (not equal) operations");
        }

        if(!value.getClass().isAssignableFrom(type.get())){
            throw new Exception("'value' type must match 'type'");
        }

        this.varName = varName;
        this.type = type;
        this.operation = operation;
        this.value = value;
    }

    public boolean inferredFrom(Statement S){
        if(!varName.equals(S.varName) || type != S.type || operation != S.operation){
            return false;
        }

        if(operation == Operation.EQ){
            if(type == Type.BOOLEAN){
                return (Boolean)S.value == (Boolean)this.value;
            }
            if(type == Type.INTEGER){
                return (Integer)S.value == (Integer)this.value;
            }
            if(type == Type.STRING){
                return ((String)S.value).equals((String)this.value);
            }
        }

        if(operation == Operation.NEQ){
            if(type == Type.BOOLEAN){
                return !((Boolean)S.value == (Boolean)this.value);
            }
            if(type == Type.INTEGER){
                return !((Integer)S.value == (Integer)this.value);
            }
            if(type == Type.STRING){
                return !((String)S.value).equals((String)this.value);
            }
        }

        if(operation == Operation.GREAT){
            return (Integer)S.value > (Integer)this.value;
        }

        if(operation == Operation.GREAT_EQ){
            return (Integer)S.value >= (Integer)this.value;
        }

        if(operation == Operation.LESS){
            return (Integer)S.value < (Integer)this.value;
        }

        if(operation == Operation.LESS_EQ){
            return (Integer)S.value <= (Integer)this.value;
        }

        return false;
    }

    public static Statement[] removeRedundancies(Statement[] statements){
        ArrayList<Statement> result = new ArrayList<>();
        ArrayList<Statement> toRemove;
        boolean S1inferS2, S2inferS1;
        for(Statement S1 : statements){
            S1inferS2 = false;
            S2inferS1 = false;
            toRemove = new ArrayList<>();
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
        return result.toArray(new Statement[result.size()]);
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
