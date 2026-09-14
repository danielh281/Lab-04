package com.dh.lab04;

import java.util.Map;
import java.util.LinkedHashMap;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Daniel Haddadeen
 */
public class UserInformation {
    private GridPane root;
    private Map<InformationField, TextField> inputFields = new LinkedHashMap<>();
    
    public UserInformation() {
        root = new GridPane();
        
        InformationField[] informationFields = InformationField.values();
        
        for (int i = 0; i < informationFields.length; i++) {
            InformationField informationField = informationFields[i];
            
            Label infoLbl = new Label(informationField.fieldText);
            TextField infoField = new TextField();
            
            inputFields.put(informationField, infoField);
            
            root.add(infoLbl, 0, i);
            root.add(infoField, 1, i);
        }
        
        root.setHgap(5);
        root.setVgap(5);
        root.setAlignment(Pos.TOP_CENTER);
        root.setPadding(new Insets(20));
    }
    
    public GridPane getRoot() {
        return root;
    }
    
    public Map<InformationField, TextField> getInputFields() {
        return inputFields;
    }
}
