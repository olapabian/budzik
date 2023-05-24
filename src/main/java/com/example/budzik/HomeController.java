package com.example.budzik;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {
    @FXML private Label Alarmy = new Label("");

    //funkcja ktora przelacza na widok dodawania alarmu po wcisnieciu dodaj
    @FXML public void dodajButtonPushed(ActionEvent event) throws IOException {
        //zaladownie fxml
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("dodaj.fxml"));
        Parent alarmView = fxmlLoader.load();
        //ustaweinie kontrolera
        DodajController dodajController = fxmlLoader.getController();
        dodajController.setMainController(this); // Set the HomeController instance
        //przejcie do widoku dodaj
        Stage newAlarmStage = new Stage();
        Scene scene = new Scene(alarmView, 600, 700);
        newAlarmStage.setScene(scene);
        newAlarmStage.show();
    }

    //funkcja ktora wylacza program po kliknieciu zakoncz

    public void zakonczButtonPushed(ActionEvent event) throws IOException {
        System.exit(0);
    }


    //funkcja ktora pobieta info z dodajCOntroler
    public void setListData(Alarm data) {
        System.out.println(data);
        Alarmy.setText(Alarmy.getText()+data.toString()+'\n');
    }
}