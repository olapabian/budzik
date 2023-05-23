package com.example.budzik;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.stage.Stage;

import javax.security.auth.callback.Callback;
import java.io.IOException;
import java.util.ArrayList;

public class HomeController {
    @FXML private ListView<Alarm> listView = new ListView<Alarm>();
    @FXML private ObservableList<Alarm> alarms;


    @FXML
    private void initialize() throws IOException {
        //laczenie z dodajCOntroller
        FXMLLoader fxmlLoader = new FXMLLoader(HomeController.class.getResource("dodaj.fxml"));
        Parent dodajRoot = fxmlLoader.<Parent>load();
        DodajController dodajController = fxmlLoader.getController();
        dodajController.setMainController(this); // Set the HomeController instance

        //wyswietlanie w listView
        //listView.setItems(alarms); //to juz jest w tamtej funkcji
        listView.setCellFactory(param -> new ListCell<Alarm>() {
            @Override
            protected void updateItem(Alarm item, boolean empty) {
                super.updateItem(item, empty);
                System.out.println(item.toString());
                if (item != null) {

                    setText(item.toString());
                } else {
                    setText(null);
                }
            }
        });

    }
//    private void loadData() {
//        // Przykładowe dane
//        ArrayList<Alarm> data = new ArrayList<>();
//        data.add(new Alarm());
//        data.add(new Alarm());
//        data.add(new Alarm());
//
//        alarms.addAll(data);
//    }


    //funkcja ktora przelacza na widok dodawania alarmu po wcisnieciu dodaj
    public void dodajButtonPushed(ActionEvent event) throws IOException {
        Parent dodajParent;
        try {
            dodajParent = FXMLLoader.load(getClass().getResource("dodaj.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene dodajScene = new Scene(dodajParent);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(dodajScene);
        window.show();
    }
    //funkcja ktora wylacza program po kliknieciu zakoncz

    public void zakonczButtonPushed(ActionEvent event) throws IOException {
        System.exit(0);

    }
    //funkcja ktora pobieta info z dodajCOntroler


    public void setListViewData(ArrayList<Alarm> data) {
        alarms = FXCollections.observableArrayList();

        if (data != null) {
            alarms.addAll(data);
        }

        listView.setItems(alarms); // Ustawienie nowych danych w ListView
    }

}