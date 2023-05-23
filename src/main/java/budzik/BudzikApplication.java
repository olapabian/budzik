package budzik;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class BudzikApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(BudzikApplication.class.getResource("/com/example/budzik/budzik.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 1000);
        stage.setTitle("Hej miśki czas wstać!");
        stage.setScene(scene);
        stage.setWidth(582);
        stage.setHeight(635);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}