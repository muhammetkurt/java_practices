package org.vaadin.reporter;

public class Reporter {
    private static int IDCounter=0;
    private Integer ID;

    private String name;

    public Reporter() {
        this.ID=IDCounter;
        IDCounter++;
        this.name= this.ID.toString()+". ReporterName";
    }

    public Reporter(Integer ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
