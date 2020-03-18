package com.expertsystem;

public enum Type {
    STRING(String.class),
    INTEGER(Integer.class),
    BOOLEAN(Boolean.class);

    private final Class<?> type;
    private Type(Class<?> type) {
        this.type = type;
    }

    public Class<?> get(){
        return this.type;
    }

}
