package com;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class PollingStationResult implements Initializable {

    private Stage window;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        }
    public void displayWindow() throws Exception {
        window = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("pResult.fxml"));
        window.setTitle("Vote Counter");
        window.setScene(new Scene(root, 330, 150));
        Font.loadFont(getClass().getResourceAsStream("Raleway-Regular.tff"), 50);
        window.setResizable(false);
        window.show();
    }

}
