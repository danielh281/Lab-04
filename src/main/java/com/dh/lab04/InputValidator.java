package com.dh.lab04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.scene.control.TextField;

/**
 *
 * @author Daniel Haddadeen
 */
public class InputValidator {
    /**
     * Checks whether every information field was properly inputted and formatted.
     * @return The list of invalid information fields
     */
    public static List<InformationField> checkFieldsValid() {
        UserInformation userInformation = App.getUserInformation();
        Map<InformationField, TextField> inputFields = userInformation.getInputFields();
        
        List<InformationField> invalidFields = new ArrayList<>();
        
        for (InformationField informationField : InformationField.values()) {
            TextField inputField = inputFields.get(informationField);
            String input = inputField.getText();
            
            // Removes spaces at start and end
            input = input.trim();
            
            // If the field is empty but its optional then skip to the next
            if (informationField.isOptional && input.isEmpty()) {
                continue;
            }
            
            // Attempt to convert input to integer IF the input is for days
            if (informationField.equals(InformationField.DAYS)) {
                try {
                    Integer value = Integer.valueOf(input);
                } catch(NumberFormatException e) {
                    invalidFields.add(informationField);
                }
                
                continue;
            }
            
            // Attempt to convert input to double otherwise
            try {
                Double value = Double.valueOf(input);
            } catch(NumberFormatException e) {
                invalidFields.add(informationField);
            }
        }
        
        return invalidFields;
    }
    
    /**
     * Gets the user input from all the input fields. Defaults to 0 for optional empty fields.
     * @return The map of information field to the user input
     */
    public static Map<InformationField, Number> getUserInput() {
        UserInformation userInformation = App.getUserInformation();
        Map<InformationField, TextField> inputFields = userInformation.getInputFields();
        
        Map<InformationField, Number> userInput = new HashMap<>();
        
        for (InformationField informationField : InformationField.values()) {
            TextField inputField = inputFields.get(informationField);
            String input = inputField.getText();
            
            // Removes spaces at start and end
            input = input.trim();

            // Default to 0.0 for optional fields with no input
            if (informationField.isOptional && input.isEmpty()) {
                userInput.put(informationField, 0.0);
                continue;
            }
            
            if (informationField.equals(InformationField.DAYS)) {
                userInput.put(informationField, Integer.valueOf(input));
                continue;
            }
            
            userInput.put(informationField, Double.valueOf(input));
        }
        
        return userInput;
    }
}
