package org.vaadin.enums;

public enum Fields {
    DEADLINE("DEADLINE")
    ;


    private String value;

    public String getValue() {
        return value;
    }

    Fields(String value) {
        this.value = value;
    }
}
