package com.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Rentals extends Application {

    @Override
    public void start(Stage stage) {
        // GridPane setup [cite: 22, 34, 42]
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setMinSize(600, 500);
        root.setPadding(new Insets(10, 10, 10, 10));
        root.setVgap(10);
        root.setHgap(10);

        // UI Components [cite: 120-127]
        Label customerLabel = new Label("Customer :");
        ComboBox<String> customerBox = new ComboBox<>();
        customerBox.getItems().addAll("Alice", "Bob");
        customerBox.setMaxWidth(Double.MAX_VALUE);

        Label genreLabel = new Label("Genre :");
        ComboBox<String> genreBox = new ComboBox<>();
        genreBox.getItems().addAll("Action", "Comedy");
        genreBox.setMaxWidth(Double.MAX_VALUE);

        Label movieLabel = new Label("Movies :");
        ComboBox<String> movieBox = new ComboBox<>();
        movieBox.setMaxWidth(Double.MAX_VALUE);

        Button saveBtn = new Button("Save Rental");
        saveBtn.setMaxWidth(Double.MAX_VALUE);

        Label borrowedLabel = new Label("Borrowed :");
        ComboBox<String> borrowedCombo = new ComboBox<>();
        borrowedCombo.setMaxWidth(Double.MAX_VALUE);

        Button returnBtn = new Button("Return Movie");
        returnBtn.setMaxWidth(Double.MAX_VALUE);

        Label returnedLabel = new Label("Returned :");
        ComboBox<String> returnedCombo = new ComboBox<>();
        returnedCombo.setMaxWidth(Double.MAX_VALUE);

        // Styling [cite: 55, 56]
        String buttonStyle = "-fx-background-color: darkslateblue; -fx-text-fill: white; -fx-font-size: 13pt;";
        String labelStyle = "-fx-font: normal bold 20px 'serif';";
        
        saveBtn.setStyle(buttonStyle);
        returnBtn.setStyle(buttonStyle);
        customerLabel.setStyle(labelStyle);
        genreLabel.setStyle(labelStyle);
        movieLabel.setStyle(labelStyle);
        borrowedLabel.setStyle(labelStyle);
        returnedLabel.setStyle(labelStyle);
        root.setStyle("-fx-background-color: BEIGE;");

        // Dynamic Movie Loading [cite: 115]
        genreBox.setOnAction(e -> {
            movieBox.getItems().clear();
            if ("Action".equals(genreBox.getValue())) {
                movieBox.getItems().addAll("Fast & Furious", "John Wick");
            } else if ("Comedy".equals(genreBox.getValue())) {
                movieBox.getItems().addAll("Mr Bean", "The Hangover");
            }
        });

        // Layout [cite: 43-54]
        root.add(customerLabel, 0, 0); root.add(customerBox, 1, 0);
        root.add(genreLabel, 0, 1);    root.add(genreBox, 1, 1);
        root.add(movieLabel, 0, 2);    root.add(movieBox, 1, 2);
        root.add(saveBtn, 1, 3);
        root.add(borrowedLabel, 0, 4); root.add(borrowedCombo, 1, 4);
        root.add(returnBtn, 1, 5);
        root.add(returnedLabel, 0, 6); root.add(returnedCombo, 1, 6);

        // Rental logic [cite: 116, 118]
        saveBtn.setOnAction(e -> {
            if (customerBox.getValue() != null && movieBox.getValue() != null) {
                borrowedCombo.getItems().add(movieBox.getValue());
            }
        });

        returnBtn.setOnAction(e -> {
            String selected = borrowedCombo.getSelectionModel().getSelectedItem();
            if (selected != null) {
                borrowedCombo.getItems().remove(selected);
                returnedCombo.getItems().add(selected);
            }
        });

        Scene scene = new Scene(root, 650, 600);
        stage.setTitle("Movie Library System - Rentals");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}