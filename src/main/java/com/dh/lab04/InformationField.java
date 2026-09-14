package com.dh.lab04;

/**
 *
 * @author Daniel Haddadeen
 */
public enum InformationField {
    DAYS("Number of days on the trip [$]", false),
    AIRFARE("Amount of airfare [$] (Optional)", true),
    CAR_RENTAL("Amount of car rental fees [$] (Optional)", true),
    MILES("Number of miles driven [mi] (Optional)", true),
    PARKING("Amount of parking fees [$] (Optional)", true),
    TAXI("Amount of taxi charges [$] (Optional)", true),
    REGISTRATION("Conference or seminar registration fees [$] (Optional)", true),
    LODGING("Lodging charges per night [$] ", false);
        
    public String fieldText;
    public boolean isOptional;
        
    InformationField(String fieldText, boolean isOptional) {
        this.fieldText = fieldText;
        this.isOptional = isOptional;
    }
}

