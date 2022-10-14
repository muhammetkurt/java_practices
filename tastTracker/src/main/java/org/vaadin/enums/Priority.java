package org.vaadin.enums;

public enum Priority {

    LOW("LOW"),
    MEDIUM("MEDIUM"),
    HIGH("HIGH"),
    TRIVIAL("TRIVIAL")
    ;

    private String value;


    public String getValue() {
        return this.value;
    }

    Priority(String value){
        this.value=value;
    }
}
