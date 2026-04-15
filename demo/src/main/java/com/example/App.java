package com.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javafx.scene.text.Text;
import javafx.scene.control.ComboBox;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

@Override
    public void start(Stage stage) {

        // 1. Create root node
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);

        //create label Name
        Text text1 = new Text("Name:");

        //create label Registered
        Text text2 = new Text("Registered:");

        //create Text Field for name
        TextField textField1 = new TextField();

        //create Combo Box for Registered
        ComboBox comboBox = new ComboBox();

        // Create Buttons
        Button button1 = new Button("Save");
        Button button2 = new Button("Remove");


        // Set up size for the pane
        gridPane.setMinSize(600, 400);

        //Set padding
        gridPane.setPadding(new Insets(10, 10, 10, 10));

        //Set the vertical and horizontal gaps between the columns
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        //Set the Grid alignment
        gridPane.setAlignment(Pos.CENTER);

        //Arrange all the nodes in the grid
        gridPane.add(text1, 0, 0);
        gridPane.add(textField1, 1, 0);
        gridPane.add(button1, 1, 1);

        gridPane.add(text2, 0, 2);
        gridPane.add(comboBox, 1, 2);

        gridPane.add(button2, 1, 3);

        //Style nodes be creative and add more styles
        button1.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white; -fx-font-size:13pt;");
        button2.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white; -fx-font-size:13pt;");

        text1.setStyle("-fx-font: normal bold 20px 'serif' ");
        text2.setStyle("-fx-font: normal bold 20px 'serif' ");
        gridPane.setStyle("-fx-background-color: BEIGE;");

        //Creating a scene object
        scene = new Scene(gridPane);

        stage.setTitle("Movie Library System");
        
        // Scene scene= new Scene(gridPane);

        stage.setScene(scene);
        stage.show();

    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch(args);
    }

}