package com.example.pateintportal;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PatientView extends Application {


    private Stage primaryStage;


    public void start(Stage primaryStage) {

        this.primaryStage = primaryStage;


        primaryStage.setTitle("Patient Portal");

        Label l1 = new Label("Enter Patient ID");
        TextField tf = new TextField();

        tf.setMinHeight(30);
        tf.setMinWidth(200);

        // Create labels and text fields for displaying patient information

        Label l2 = new Label("The total Agatston CAC score:");
        Label tf2 = new Label();

        tf2.setMinHeight(30);
        tf2.setMinWidth(300);


        Label l4 = new Label("LM:");
        Label tf4 = new Label();

        tf4.setMinHeight(30);
        tf4.setMinWidth(300);

        Label l5 = new Label("LAD:");
        Label tf5 = new Label();

        tf5.setMinHeight(30);
        tf5.setMinWidth(300);

        Label l6 = new Label("LCX:");
        Label tf6 = new Label();

        tf6.setMinHeight(30);
        tf6.setMinWidth(300);

        Label l7 = new Label("RCA:");
        Label tf7 = new Label();

        tf7.setMinHeight(30);
        tf7.setMinWidth(300);

        Label l8 = new Label("PDA:");
        Label tf8 = new Label();

        tf8.setMinHeight(30);
        tf8.setMinWidth(300);

        Button enter = new Button("Enter");
        enter.setMinWidth(150);
        enter.setMinHeight(40);
        enter.setMinWidth(150);
        enter.setStyle("-fx-background-color: #6CA6CD; -fx-text-fill: white;-fx-font-size: 16px;");

        Button b2 = new Button("Back");
        b2.setMinHeight(40);
        b2.setMinWidth(150);
        b2.setStyle("-fx-background-color: #6CA6CD; -fx-text-fill: white;-fx-font-size: 16px;");

        enter.setOnAction(event -> {
            String patientID = tf.getText();

            // Check if the patient ID is entered correctly
            if (!patientID.matches("\\d+")) {
                System.out.println("Error: Wrong patient ID format.");
                return;
            }

            // Create the file names for patient info and CT scan results
            String patientInfoFile = patientID + "_PatientInfo.txt";
            String ctResultsFile = patientID + "CTResults.txt";

            // Retrieve the patient name from the patient info file
            String patientName = retrievePatientName(patientInfoFile);
            l1.setText("HELLO  " + patientName);
            l1.setFont(Font.font("Arial", FontWeight.BOLD, 14));
            GridPane parentGridPane = (GridPane) enter.getParent();

            // Remove the corresponding TextField
            parentGridPane.getChildren().remove(tf);
            parentGridPane.getChildren().remove(enter);

            // Clear the TextField's text
            tf.clear();
            GridPane.setMargin(l1, new Insets(0, 0, 0, 300));




            // Check if the patient name is available
            if (patientName == null) {
                System.out.println("Error: No patient data available for the given ID.");
                return;
            }

            // Read CT scan results from the file

            // Check if CT scan results are available


            // Display the patient data
            System.out.println("Patient ID: " + patientID);
            System.out.println("Patient Name: " + patientName);

            String info[] = retrieveInfo(ctResultsFile);

            tf2.setText(info[1]);
            tf4.setText(info[2]);
            tf5.setText(info[3]);
            tf6.setText(info[4]);
            tf7.setText(info[5]);
            tf8.setText(info[6]);



            // Exit the program

        });
// Set event handler for the "Back" button
        b2.setOnAction(event -> {
            openHomeView();
        });




        GridPane gridPane = new GridPane();
        gridPane.setHgap(20);
        gridPane.setVgap(40);
        gridPane.setPadding(new Insets(20));

        GridPane.setMargin(enter, new Insets(0, 0, 0, 200));

        GridPane.setMargin(tf, new Insets(0, 0, 0, 200));
        GridPane.setMargin(tf2, new Insets(0, 0, 0, 200));
        GridPane.setMargin(tf4, new Insets(0, 0, 0, 200));
        GridPane.setMargin(tf5, new Insets(0, 0, 0, 200));
        GridPane.setMargin(tf6, new Insets(0, 0, 0, 200));
        GridPane.setMargin(tf7, new Insets(0, 0, 0, 200));
        GridPane.setMargin(tf8, new Insets(0, 0, 0, 200));

        GridPane.setMargin(l1, new Insets(0, 0, 0, 20));
        GridPane.setMargin(l4, new Insets(0, 0, 0, 40));
        GridPane.setMargin(l5, new Insets(0, 0, 0, 40));
        GridPane.setMargin(l6, new Insets(0, 0, 0, 40));
        GridPane.setMargin(l7, new Insets(0, 0, 0, 40));
        GridPane.setMargin(l8, new Insets(0, 0, 0, 40));





        gridPane.add(enter, 0, 0,2,3);
        gridPane.add(l1, 0, 0, 10, 1);
        gridPane.add(tf, 0,0,10,1);
        gridPane.add(l2, 0, 2);
        gridPane.add(tf2, 0, 2);
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

        gridPane.add(b2, 6, 7);

        tf.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                GridPane parentGridPane = (GridPane) tf.getParent();
                parentGridPane.getChildren().remove(tf);
            }
        });

        Scene scene = new Scene(gridPane, 1000, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private String retrievePatientName(String fileName) {
        try {
            // Read the file content
            String content = Files.readString(Paths.get(fileName));

            // Split the content by line breaks
            String[] lines = content.split("\\r?\\n");

            // Extract the patient name from the first line
            if (lines.length > 0) {
                return lines[0].trim();
            }

            return null;
        } catch (IOException e) {
            return null;
        }
    }

    private String[] retrieveInfo(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            // Count the number of lines in the file
            long lineCount = reader.lines().count();

            // Create the string array with the appropriate size
            String[] info = new String[(int) lineCount];

            // Reset the reader back to the beginning of the file
            reader.lines().close();
            BufferedReader newReader = new BufferedReader(new FileReader(fileName));

            // Read each line and store it in the array
            for (int i = 0; i < lineCount; i++) {
                info[i] = newReader.readLine();
            }

            return info;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }





    private void openHomeView() {
        SignInPage sign= new SignInPage();
        sign.start(primaryStage);
    }

    public static void main(String[] args) {
        launch();
    }
}

