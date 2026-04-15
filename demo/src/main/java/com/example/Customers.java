package com.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Customers extends Application {

    @Override
    public void start(Stage stage) {
        // Set up the GridPane layout and alignment
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER); 
        root.setMinSize(600, 400);
        root.setPadding(new Insets(10, 10, 10, 10));
        root.setVgap(10);
        root.setHgap(10);

        // Create labels and text fields for Name, Phone, and Email
        Label nameLabel = new Label("Name :");
        TextField nameField = new TextField();

        Label phoneLabel = new Label("Phone :");
        TextField phoneField = new TextField();

        Label emailLabel = new Label("Email :");
        TextField emailField = new TextField();

        // Create Buttons
        Button saveBtn = new Button("Save Customer");
        Button removeBtn = new Button("Remove Customer");

        // Create ComboBox for Registered customers
        Label registeredLabel = new Label("Registered :");
        ComboBox<String> registeredCombo = new ComboBox<>();
        registeredCombo.setMaxWidth(Double.MAX_VALUE); // Ensures it fills the column width

        // Styling based on lab requirements
        String buttonStyle = "-fx-background-color: darkslateblue; -fx-text-fill: white; -fx-font-size: 13pt;";
        String labelStyle = "-fx-font: normal bold 20px 'serif';";
        
        saveBtn.setStyle(buttonStyle);
        removeBtn.setStyle(buttonStyle);
        nameLabel.setStyle(labelStyle);
        phoneLabel.setStyle(labelStyle);
        emailLabel.setStyle(labelStyle);
        registeredLabel.setStyle(labelStyle);
        root.setStyle("-fx-background-color: BEIGE;");

        // Arrange all nodes in the grid (Column, Row)
        root.add(nameLabel, 0, 0);
        root.add(nameField, 1, 0);

        root.add(phoneLabel, 0, 1);
        root.add(phoneField, 1, 1);

        root.add(emailLabel, 0, 2);
        root.add(emailField, 1, 2);

        root.add(saveBtn, 1, 3);

        root.add(registeredLabel, 0, 4);
        root.add(registeredCombo, 1, 4);

        root.add(removeBtn, 1, 5);

        // Save Button Logic
        saveBtn.setOnAction(e -> {
            if (!nameField.getText().isEmpty()) {
                registeredCombo.getItems().add(nameField.getText());
                nameField.clear();
                phoneField.clear();
                emailField.clear();
            }
        });

        // Remove Button Logic
        removeBtn.setOnAction(e -> {
            String selected = registeredCombo.getSelectionModel().getSelectedItem();
            if (selected != null) {
                registeredCombo.getItems().remove(selected);
            }
        });

        Scene scene = new Scene(root, 600, 500);
        stage.setTitle("Customer Registration System");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}