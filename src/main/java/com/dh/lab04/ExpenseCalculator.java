package com.dh.lab04;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 *
 * @author danie
 */
public class ExpenseCalculator {
    private GridPane root;
    private Label totalExpenses;
    private Label totalAllowedExpenses;
    private Label excessExpenses;
    private Label savedExpenses;
    private Button calculateButton;
    
    public ExpenseCalculator() {
        root = new GridPane(1, 5);
        totalExpenses = new Label();
        totalAllowedExpenses = new Label();
        excessExpenses = new Label();
        savedExpenses = new Label();
        calculateButton = new Button("Calculate Expenses");
        
        // Update the label text for all expenses
        calculateButton.setOnAction(e -> {
            List<Double> expenses = calculateExpenses();
            
            totalExpenses.setText(String.format("Total expenses incurred by the businessperson: $%.2f", expenses.get(0)));
            totalAllowedExpenses.setText(String.format("Total allowable expenses for the trip: $%.2f", expenses.get(1)));
            excessExpenses.setText(String.format("Excess expenses that must be paid by the businessperson: $%.2f", expenses.get(2)));
            savedExpenses.setText(String.format("Saved expenses: $%.2f", expenses.get(3)));
            
            System.out.println(expenses);
        });
        
        // Center all the labels inside of their grids
        GridPane.setHalignment(totalExpenses, HPos.CENTER);
        GridPane.setValignment(totalExpenses, VPos.CENTER);
        
        GridPane.setHalignment(totalAllowedExpenses, HPos.CENTER);
        GridPane.setValignment(totalAllowedExpenses, VPos.CENTER);

        GridPane.setHalignment(excessExpenses, HPos.CENTER);
        GridPane.setValignment(excessExpenses, VPos.CENTER);

        GridPane.setHalignment(savedExpenses, HPos.CENTER);
        GridPane.setValignment(savedExpenses, VPos.CENTER);
        
        GridPane.setHalignment(calculateButton, HPos.CENTER);
        GridPane.setValignment(calculateButton, VPos.CENTER);
        
        // Put the grid at the bottom center and set padding
        root.setAlignment(Pos.BOTTOM_CENTER);
        root.setVgap(5);
        root.setPadding(new Insets(20));
        
        // Adding all the labels and button to the grid
        root.add(totalExpenses, 0, 0);
        root.add(totalAllowedExpenses, 0, 1);
        root.add(excessExpenses, 0, 2);
        root.add(savedExpenses, 0, 3);
        root.add(calculateButton, 0, 4);
    }
    
    /**
     * Calculates all the expenses
     * @return List containing in order; Total Expenses Incurred, Total Allowed Expenses, Excess Expenses and Saved Expenses
     */
    private static List<Double> calculateExpenses() {
        List<InformationField> invalidFields = InputValidator.checkFieldsValid();
        
        // If there is invalid fields then do not calculate
        if (!invalidFields.isEmpty()) {
            return null;
        }
        
        Map<InformationField, Number> userInput = InputValidator.getUserInput();
        
        List<Double> expenses = new ArrayList<>();
        
        UserInformation userInformation = App.getUserInformation();
        Map<InformationField, TextField> inputFields = userInformation.getInputFields();
        
        double totalExpenses = 0;
        double totalAllowedExpenses = 0;
        double excessExpenses = 0;
        double savedExpenses = 0;
        
        // Calculate the total allowed expenses
        String numOfDaysInput = inputFields.get(InformationField.DAYS).getText();
        
        int numOfDays = (int) userInput.get(InformationField.DAYS);
        double airFare = (double) userInput.get(InformationField.AIRFARE);
        double carRentalFees = (double) userInput.get(InformationField.CAR_RENTAL);
        double milesDriven = (double) userInput.get(InformationField.MILES);
        double parkingFees = (double) userInput.get(InformationField.PARKING);
        double taxiFees = (double) userInput.get(InformationField.TAXI);
        double registrationFees = (double) userInput.get(InformationField.REGISTRATION);
        double lodgingCharges = (double) userInput.get(InformationField.LODGING);
        
        // Calculate total expenses
        totalExpenses += (airFare + carRentalFees + parkingFees + taxiFees
                + registrationFees + lodgingCharges * numOfDays);
        
        // Calculate total allowed expenses;
        double foodReimbursement = 37 * numOfDays;
        double parkingReimbursement = 10 * numOfDays;
        double taxiReimbursement = 20 * numOfDays;
        double lodgingReimbursement = 95 * numOfDays;
        double vehicleReimbursement = 0.27 * milesDriven;
        
        totalAllowedExpenses += (foodReimbursement + parkingReimbursement + 
                taxiReimbursement + lodgingReimbursement + vehicleReimbursement);
        
        // Calculate total excess expenses;
        excessExpenses = Math.max(totalExpenses - totalAllowedExpenses, 0);
        savedExpenses = Math.max(totalAllowedExpenses - totalExpenses, 0);
        
        expenses.add(totalExpenses);
        expenses.add(totalAllowedExpenses);
        expenses.add(excessExpenses);
        expenses.add(savedExpenses);
        
        return expenses;
    }
    
    public GridPane getRoot() {
        return root;
    }
}
