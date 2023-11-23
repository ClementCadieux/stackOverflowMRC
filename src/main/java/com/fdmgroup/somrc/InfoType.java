package com.fdmgroup.somrc;

public enum InfoType {
    ADDRESS("Address"),
    PERSONAL_EMAIL("Personal Email"),
    WORK_EMAIL("Work Email"),
    OTHER_EMAIL("Other Email"),
    HOME_PHONE("Home Phone"),
    CELL_PHONE("Cell Phone"),
    WORK_PHONE("Work Phone"),
    OTHER_PHONE("Other Phone"); 

    private final String infoTypeString;

    private InfoType(String infoTypeString){
        this.infoTypeString = infoTypeString;
    }

    public String getInfoTypeString(){
        return infoTypeString;
    }
}
