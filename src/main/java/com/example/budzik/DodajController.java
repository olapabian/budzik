package com.example.budzik;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DodajController implements Initializable {

    @FXML private Spinner<Integer> hourSpinner;
    @FXML private Spinner<Integer> minuteSpinner;
    @FXML private CheckBox ponCheckBox;
    @FXML private CheckBox wtCheckBox;
    @FXML private CheckBox srCheckBox;
    @FXML private CheckBox czwCheckBox;
    @FXML private CheckBox ptCheckBox;
    @FXML private CheckBox sobCheckBox;
    @FXML private CheckBox ndzCheckBox;
    @FXML private RadioButton takRadioButton; //czy powtarzac
    @FXML private RadioButton nieRadioButton; //czy powtarzac
    @FXML private Label glosnoscLabel = new Label("0");
    @FXML private  Slider volumeSlider = new Slider(0, 100, 1);
    @FXML private TextField nazwa = new TextField();
    @FXML private Button zapiszButton;
    @FXML private Button anulujButton;
    private ToggleGroup  Group; //grupa guziczkow ktore moze byc jeden z nich wcisniety
    private HomeController homeController;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //tworzenie spinnera godziny
        SpinnerValueFactory<Integer> hourValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,23);
        hourValueFactory.setValue(7);
        hourSpinner.setValueFactory(hourValueFactory);

        //tworzenie spinnera minuty
        SpinnerValueFactory<Integer> minuteValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,59);
        minuteValueFactory.setValue(0);
        minuteSpinner.setValueFactory(minuteValueFactory);
        minuteSpinner.setEditable(true);

        //Ustawianie guzikow tak/nie zeby nie byly oba wzisniete nigdy
        Group = new ToggleGroup();
        this.takRadioButton.setToggleGroup(Group);
        this.nieRadioButton.setToggleGroup(Group);
        //nie domyslnie
        this.nieRadioButton.setSelected(true);

//        //ustawienia slidera zbey sie glosnosc pokazywala na bierzaco
        glosnoscLabel.setText(String.valueOf(volumeSlider.getValue()));
        volumeSlider.valueProperty().addListener((observable,oldValue,newValue) ->{
            glosnoscLabel.setText(String.valueOf(newValue));
        });
    }
    //funkcja po nacisnieciu zapisz
    @FXML public void zapiszButtonPushed(ActionEvent event) throws IOException {

        sendInfoToHomeController();
        Stage stage = (Stage) zapiszButton.getScene().getWindow();
        stage.close();
    }

    //funkcja po nacisnieciu zapisz, ktora przelacza na widok dodawania alarmu
    public void anulujButtonPushed(ActionEvent event) throws IOException {
        Stage stage = (Stage) anulujButton.getScene().getWindow();
        stage.close();
    }

    public void setMainController(HomeController controller) {
        homeController = controller;//instancja homecontroler
    }
    //wysylanie info do HomeController

    private void sendInfoToHomeController() {
        Alarm pomAlarm = new Alarm();

        //pobieranie godziny
        pomAlarm.setGodzina(this.hourSpinner.getValue());

        //pobieranie minuty
        pomAlarm.setMinuta(this.minuteSpinner.getValue());

        //pobieranie dni tygodnia
        if(ponCheckBox.isSelected())
        {
            if(pomAlarm.dniTygodnia=="")
            {
                pomAlarm.dniTygodnia="poniedzialek ";
            }
            else pomAlarm.dniTygodnia+="poniedzialek ";
        }
        if(wtCheckBox.isSelected())
        {
            if(pomAlarm.dniTygodnia=="")
            {
                pomAlarm.dniTygodnia="wtorek ";
            }
            else pomAlarm.dniTygodnia+="wtorek ";
        }
        if(srCheckBox.isSelected())
        {
            if(pomAlarm.dniTygodnia=="")
            {
                pomAlarm.dniTygodnia="środa ";
            }
            else pomAlarm.dniTygodnia+="środa ";
        }
        if(czwCheckBox.isSelected())
        {
            if(pomAlarm.dniTygodnia=="")
            {
                pomAlarm.dniTygodnia="czwartek ";
            }
            else pomAlarm.dniTygodnia+="czwartek ";
        }
        if(ptCheckBox.isSelected())
        {
            if(pomAlarm.dniTygodnia=="")
            {
                pomAlarm.dniTygodnia="piątek ";
            }
            else pomAlarm.dniTygodnia+="piątek ";
        }
        if(sobCheckBox.isSelected())
        {
            if(pomAlarm.dniTygodnia=="")
            {
                pomAlarm.dniTygodnia="sobota ";
            }
            else pomAlarm.dniTygodnia+="sobota ";
        }
        if(ndzCheckBox.isSelected())
        {
            if(pomAlarm.dniTygodnia=="")
            {
                pomAlarm.dniTygodnia="niedziela ";
            }
            else pomAlarm.dniTygodnia+="niedziela ";
        }

        //sprawdzanie czy ma sie powtarzac
        if(takRadioButton.isSelected())
        {
            pomAlarm.czyPowtarzac=true;
        }else pomAlarm.czyPowtarzac=false;

        //slider glosnosci
        pomAlarm.Glosnosc=volumeSlider.getValue();

        //nazwa
        pomAlarm.Nazwa=nazwa.getText();

        if(homeController!=null)
        {
            homeController.setListData(pomAlarm); //wysylanie
        }

    }
}
