package com.dh.lab04;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javafx.scene.control.TextField;

/**
 *
 * @author Daniel Haddadeen
 */
public class InputValidator {
    public static InformationField[] checkFieldsValid() {
        UserInformation userInformation = App.getUserInformation();
        Map<InformationField, TextField> inputFields = userInformation.getInputFields();
        
        List<InformationField> invalidFields = new ArrayList<>();
        
        for (InformationField informationField : InformationField.values()) {
            TextField inputField = inputFields.get(informationField);
            
            String input = inputField.getText();
            
            // Removes spaces at start and end
            input.trim();
            
            try {
                Double value = Double.valueOf(input);
            } catch(NumberFormatException e) {
                System.out.println("Invalid field" + informationField);
            }
        }
        
        return null;
    }
}
