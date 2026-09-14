/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.dh.lab04;

/**
 *
 * @author Daniel Haddadeen
 */
public enum InformationField {
    DAYS("Number of days on the trip [$]"),
    AIRFARE("Amount of airfare [$] (Optional)"),
    CAR_RENTAL("Amount of car rental fees [$] (Optional)"),
    MILES("Number of miles driven [mi] (Optional)"),
    PARKING("Amount of parking fees [$] (Optional)"),
    TAXI("Amount of taxi charges [$] (Optional)"),
    REGISTRATION("Conference or seminar registration fees [$] (Optional)"),
    LODGING("Lodging charges per night [$] ");
        
    public String fieldText;
        
    InformationField(String fieldText) {
        this.fieldText = fieldText;
    }
}

