
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class VoteCounter extends Application implements Initializable {

    public Label redLabel;
    public Label yellowLabel;
    public Label greenLabel;
    int r, y, g;
    StringProperty red, yellow, green;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("voteCounter.fxml"));
        primaryStage.setTitle("Vote Counter");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    public void redButtonHandler(ActionEvent actionEvent) {
        r++;
        red.set(String.format("%04d", r));
    }

    public void yellowButtonHandler(ActionEvent actionEvent) {
        y++;
        yellow.set(String.format("%04d", y));
    }

    public void greenButtonHandler(ActionEvent actionEvent) {
        g++;
        green.set(String.format("%04d", g));
    }

    public void faultyHandler(ActionEvent actionEvent) {
    }

    public void invalidHandler(ActionEvent actionEvent) {

    }

    public void redSubHandler(ActionEvent actionEvent) {
        r--;
        red.set(String.format("%04d", r));
    }

    public void yellowSubHandler(ActionEvent actionEvent) {
        y--;
        yellow.set(String.format("%04d", y));
    }

    public void greenSubHandler(ActionEvent actionEvent) {
        g--;
        green.set(String.format("%04d", g));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        red = new SimpleStringProperty(String.format("%04d", 0));
        yellow = new SimpleStringProperty(String.format("%04d", 0));
        green = new SimpleStringProperty(String.format("%04d", 0));
        redLabel.textProperty().bind(red);
        yellowLabel.textProperty().bind(yellow);
        greenLabel.textProperty().bind(green);
    }


}
