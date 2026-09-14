package com.dh.lab04;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

// GitHub Repository Link: https://github.com/danielh281/Lab-04/

/**
 * JavaFX App
 */
public class App extends Application {
    private static BorderPane root;
    private static UserInformation userInformation;
    private static ExpenseCalculator expenseCalculator;
    
    public void start(Stage stage) {
        root = new BorderPane();
        userInformation = new UserInformation();
        expenseCalculator = new ExpenseCalculator();
        
        root.setCenter(userInformation.getRoot());
        root.setBottom(expenseCalculator.getRoot());
        
        Scene scene = new Scene(root, 640, 480);
        
        scene.getStylesheets().add("default.css");
        scene.getStylesheets().add("buttons.css");
        
        stage.setScene(scene);
        stage.setTitle("Trip Expenses Calculator");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public static BorderPane getRoot() {
        return root;
    }
    
    public static UserInformation getUserInformation() {
        return userInformation;
    }
}