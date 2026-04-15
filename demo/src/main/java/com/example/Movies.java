package com.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Movies extends Application {

    @Override
    public void start(Stage stage) {
        // GridPane setup [cite: 22, 34, 42]
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setMinSize(600, 400);
        root.setPadding(new Insets(10, 10, 10, 10));
        root.setVgap(10);
        root.setHgap(10);

        // UI Components [cite: 97-102]
        Label genreLabel = new Label("Genre :");
        ComboBox<String> genreBox = new ComboBox<>();
        genreBox.getItems().addAll("Action", "Comedy", "Drama");
        genreBox.setMaxWidth(Double.MAX_VALUE);

        Label titleLabel = new Label("Name :");
        TextField titleField = new TextField();

        Button saveBtn = new Button("Save Movie");
        saveBtn.setMaxWidth(Double.MAX_VALUE);

        Label registeredLabel = new Label("Registered :");
        ComboBox<String> registeredCombo = new ComboBox<>();
        registeredCombo.setMaxWidth(Double.MAX_VALUE);

        Button removeBtn = new Button("Remove Movie");
        removeBtn.setMaxWidth(Double.MAX_VALUE);

        // Styling [cite: 55, 56]
        String buttonStyle = "-fx-background-color: darkslateblue; -fx-text-fill: white; -fx-font-size: 13pt;";
        String labelStyle = "-fx-font: normal bold 20px 'serif';";
        
        saveBtn.setStyle(buttonStyle);
        removeBtn.setStyle(buttonStyle);
        genreLabel.setStyle(labelStyle);
        titleLabel.setStyle(labelStyle);
        registeredLabel.setStyle(labelStyle);
        root.setStyle("-fx-background-color: BEIGE;");

        // Layout [cite: 43-54]
        root.add(genreLabel, 0, 0);
        root.add(genreBox, 1, 0);
        root.add(titleLabel, 0, 1);
        root.add(titleField, 1, 1);
        root.add(saveBtn, 1, 2);
        root.add(registeredLabel, 0, 3);
        root.add(registeredCombo, 1, 3);
        root.add(removeBtn, 1, 4);

        // Logic
        saveBtn.setOnAction(e -> {
            if (!titleField.getText().isEmpty() && genreBox.getValue() != null) {
                registeredCombo.getItems().add(genreBox.getValue() + ": " + titleField.getText());
                titleField.clear();
            }
        });

        Scene scene = new Scene(root, 600, 500);
        stage.setTitle("Movie Library System - Movies");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}