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
import java.util.Random;



public class ReceptionistView extends Application {

    private Stage primaryStage;


    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Patient Portal");

        Label l1 = new Label("Patient Intake Form");
        l1.setFont(Font.font("Arial", FontWeight.BOLD, 14));

        Label l2 = new Label("First Name:");
        TextField tf2 = new TextField();

        tf2.setMinHeight(30);
        tf2.setMinWidth(300);

        Label l3 = new Label("Last Name:");
        TextField tf3 = new TextField();

        tf3.setMinHeight(30);
        tf3.setMinWidth(300);

        Label l4 = new Label("Email:");
        TextField tf4 = new TextField();

        tf4.setMinHeight(30);
        tf4.setMinWidth(300);

        Label l5 = new Label("Phone Number:");
        TextField tf5 = new TextField();

        tf5.setMinHeight(30);
        tf5.setMinWidth(300);

        Label l6 = new Label("Health History:");
        TextField tf6 = new TextField();

        tf6.setMinHeight(30);
        tf6.setMinWidth(300);

        Label l7 = new Label("Insurance ID:");
        TextField tf7 = new TextField();

        tf7.setMinHeight(30);
        tf7.setMinWidth(300);

        Label l8 = new Label("Appointment Date");
        TextField tf8 = new TextField();

        tf8.setMinHeight(30);
        tf8.setMinWidth(300);

        Label l9 = new Label("Appointment Time");
        TextField tf9 = new TextField();

        tf9.setMinHeight(30);
        tf9.setMinWidth(300);

        Button b1 = new Button("Save");
        b1.setMinHeight(40);
        b1.setMinWidth(150);
        b1.setStyle("-fx-background-color: #6CA6CD; -fx-text-fill: white;-fx-font-size: 16px;");

        Button b2 = new Button("Back");
        b2.setMinHeight(40);
        b2.setMinWidth(150);
        b2.setStyle("-fx-background-color: #6CA6CD; -fx-text-fill: white;-fx-font-size: 16px;");


        b1.setOnAction(event ->{
            String firstName = tf2.getText();
            String lastName = tf3.getText();
            String email = tf4.getText();
            String number = tf5.getText();
            String healthHist = tf6.getText();
            String insID = tf7.getText();
            String date = tf8.getText();
            String time = tf9.getText();
            Random random = new Random();
            int patientID = random.nextInt(90000) + 10000;



            // Create the file name using the patient ID
            String fileName = patientID + "_PatientInfo.txt";
            System.out.println("Patient ID: " + patientID);

            // Save the patient information to the file
            try {
                FileWriter writer = new FileWriter(fileName);
                writer.write(firstName + "\n");
                writer.write(lastName + "\n");
                writer.write(email + "\n");
                writer.write(number + "\n");
                writer.write(healthHist + "\n");
                writer.write(insID + "\n");
                writer.write(date + "\n");
                writer.write(time + "\n");
                writer.close();
                System.out.println("Patient information saved to file: " + fileName);
            } catch (IOException e) {
                System.out.println("Error while saving patient information to file.");
                e.printStackTrace();
            }
            //Platform.exit();
        });

        b2.setOnAction(event -> {
            openHomeView();
        });


        GridPane gridPane = new GridPane();
        gridPane.setHgap(20);
        gridPane.setVgap(40);
        gridPane.setPadding(new Insets(20));
        GridPane.setMargin(l1, new Insets(0, 0, 0, 180));

        gridPane.add(l1, 0, 0, 20, 1);
        gridPane.add(l2, 0, 1);
        gridPane.add(tf2, 1, 1);
        gridPane.add(l3, 0, 2);
        gridPane.add(tf3, 1, 2);
        gridPane.add(l4, 0, 3);
        gridPane.add(tf4, 1, 3);
        gridPane.add(l5, 0, 4);
        gridPane.add(tf5, 1, 4);
        gridPane.add(l6, 0, 5);
        gridPane.add(tf6, 1, 5);
        gridPane.add(l7, 0, 6);
        gridPane.add(tf7, 1, 6);
        gridPane.add(l8, 5, 2);
        gridPane.add(tf8, 7, 2);
        gridPane.add(l9, 5, 3);
        gridPane.add(tf9, 7, 3);
        gridPane.add(b1, 5, 6);
        gridPane.add(b2, 7, 6);

        Scene scene = new Scene(gridPane, 1270, 620);
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

