package com.example.pateintportal;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;

public class TechnicianView extends Application {

    private Stage primaryStage;


    public void start(Stage primaryStage) {

        this.primaryStage = primaryStage;


        primaryStage.setTitle("Patient Portal");

        Label l1 = new Label("Patient ID:");

        Label l2 = new Label("The total Agatston CAC score:");
        TextField tf2 = new TextField();

        tf2.setMinHeight(30);
        tf2.setMinWidth(300);

        Label l3 = new Label("Vessel level Agatston CAC score:");
        TextField tf3 = new TextField();

        l3.setFont(Font.font("Arial", FontWeight.BOLD, 14));

        tf3.setMinHeight(30);
        tf3.setMinWidth(300);

        Label l4 = new Label("LM:");
        TextField tf4 = new TextField();

        tf4.setMinHeight(30);
        tf4.setMinWidth(300);

        Label l5 = new Label("LAD:");
        TextField tf5 = new TextField();

        tf5.setMinHeight(30);
        tf5.setMinWidth(300);

        Label l6 = new Label("LCX:");
        TextField tf6 = new TextField();

        tf6.setMinHeight(30);
        tf6.setMinWidth(300);

        Label l7 = new Label("RCA:");
        TextField tf7 = new TextField();

        tf7.setMinHeight(30);
        tf7.setMinWidth(300);

        Label l8 = new Label("PDA:");
        TextField tf8 = new TextField();

        tf8.setMinHeight(30);
        tf8.setMinWidth(300);

        Button b1 = new Button("Save");
        b1.setMinHeight(40);
        b1.setMinWidth(150);
        b1.setStyle("-fx-background-color: #6CA6CD; -fx-text-fill: white;-fx-font-size: 16px;");

        Button b2 = new Button("Back");
        b2.setMinHeight(40);
        b2.setMinWidth(150);
        b2.setStyle("-fx-background-color: #6CA6CD; -fx-text-fill: white;-fx-font-size: 16px;");


        b1.setOnAction(event -> {
                    // Retrieve technician's input
                    String patientID = tf2.getText();
                    String totalCAC = tf3.getText();
                    String LM = tf4.getText();
                    String LAD = tf5.getText();
                    String LCX = tf6.getText();
                    String RCA = tf7.getText();
                    String PDA = tf8.getText();

                    // Check if any fields are empty
                    if (patientID.isEmpty() || totalCAC.isEmpty() || LM.isEmpty() || LAD.isEmpty() || LCX.isEmpty()) {
                        System.out.println("Error: All fields must be filled.");
                        return;
                    }

                    // Create the file name for CT scan results
                    String fileName = patientID + "CTResults.txt";

                    // Save the CT scan data to the file
                    try {
                        FileWriter writer = new FileWriter(fileName);
                        writer.write("Patient ID: " + patientID + "\n");
                        writer.write(totalCAC + "\n");
                        writer.write(LM + "\n");
                        writer.write(LAD + "\n");
                        writer.write(LCX + "\n");
                        writer.write(RCA  + "\n");
                        writer.write(PDA + "\n");
                        writer.close();
                        System.out.println("CT scan data saved to file: " + fileName);
                    } catch (IOException e) {
                        System.out.println("Error occurred while saving CT scan data to file: " + fileName);
                        e.printStackTrace();
                    }


                });

        b2.setOnAction(event -> {
            openHomeView();
        });


        GridPane gridPane = new GridPane();
        gridPane.setHgap(20);
        gridPane.setVgap(40);
        gridPane.setPadding(new Insets(20));
        GridPane.setMargin(tf2, new Insets(0, 0, 0, 200));
        GridPane.setMargin(tf3, new Insets(0, 0, 0, 200));

        GridPane.setMargin(tf4, new Insets(0, 0, 0, 200));

        GridPane.setMargin(tf5, new Insets(0, 0, 0, 200));

        GridPane.setMargin(tf6, new Insets(0, 0, 0, 200));
        GridPane.setMargin(tf7, new Insets(0, 0, 0, 200));
        GridPane.setMargin(tf8, new Insets(0, 0, 0, 200));


        GridPane.setMargin(l4, new Insets(0, 0, 0, 40));
        GridPane.setMargin(l5, new Insets(0, 0, 0, 40));
        GridPane.setMargin(l6, new Insets(0, 0, 0, 40));
        GridPane.setMargin(l7, new Insets(0, 0, 0, 40));
        GridPane.setMargin(l8, new Insets(0, 0, 0, 40));






        gridPane.add(l1, 0, 0, 10, 1);
        gridPane.add(l2, 0, 1);
        gridPane.add(tf2, 0, 0);
        gridPane.add(l3, 0, 2);
        gridPane.add(tf3, 0, 1);
        gridPane.add(l4, 0, 3);
        gridPane.add(tf4, 0, 3);
        gridPane.add(l5, 0, 4);
        gridPane.add(tf5, 0, 4);
        gridPane.add(l6, 0, 5);
        gridPane.add(tf6, 0, 5);
        gridPane.add(l7, 0, 6);
        gridPane.add(tf7, 0, 6);
        gridPane.add(l8, 0, 7);
        gridPane.add(tf8, 0, 7);
        gridPane.add(b1, 5, 7);
        gridPane.add(b2, 7, 7);

        Scene scene = new Scene(gridPane, 1000, 700);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void openHomeView() {
        SignInPage sign= new SignInPage();
        sign.start(primaryStage);
    }

    public static void main(String[] args) {
        launch();
    }
}

