module com.example.budzik {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.budzik to javafx.fxml;
    exports com.example.budzik;
    opens budzik to javafx.fxml;
    exports budzik;
}