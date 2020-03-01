package com;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class VoteCounter implements Initializable {
    @FXML
    public Label redLabel;

    public Label yellowLabel;
    public Label greenLabel;
    int r = 0;
    int y = 0;
    int g = 0;
    StringProperty red, yellow, green;
    private Stage window;
    private Timeline redTime;
    private Timeline yellowTime;
    private Timeline blueTime;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        red = new SimpleStringProperty(String.format("%04d", r));
        yellow = new SimpleStringProperty(String.format("%04d", y));
        green = new SimpleStringProperty(String.format("%04d", g));

        redLabel.textProperty().bind(red);
        yellowLabel.textProperty().bind(yellow);
        greenLabel.textProperty().bind(green);

        simulate();

    }

    public void displayWindow() throws Exception {
        window = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("voteCounter.fxml"));
        window.setTitle("Vote Counter");
        window.setScene(new Scene(root, 600, 400));
        Font.loadFont(getClass().getResourceAsStream("Raleway-Regular.tff"), 50);
        window.setResizable(false);
        window.show();



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

    private void simulate() {
        r = 0;
        y = 0;
        g = 0;

        redTime = new Timeline();
        yellowTime = new Timeline();
        blueTime = new Timeline();

        redTime.getKeyFrames().add(new KeyFrame(Duration.millis(20), e-> {tokR(r);}));
        yellowTime.getKeyFrames().add(new KeyFrame(Duration.millis(90), e-> {tokY(y);}));
        blueTime.getKeyFrames().add(new KeyFrame(Duration.millis(50), e-> {tokG(g);}));

        redTime.setCycleCount(1000);
        yellowTime.setCycleCount(1000);
        blueTime.setCycleCount(1000);

        redTime.setOnFinished(e-> {this.close();});

        redTime.playFromStart();
        yellowTime.playFromStart();
        blueTime.playFromStart();




    }

    private void tokG(int k) {
        this.g++;
        System.out.println(red);
        green.set(String.format("%04d", g));
    }

    private void tokY(int k) {
        this.y++;
        System.out.println(yellow);
        yellow.set(String.format("%04d", y));
    }

    private void tokR(int k) {
        this.r++;
        System.out.println();
        red.set(String.format("%04d", r));
    }


    public void close() {
        blueTime.stop();
        redTime.stop();
        yellowTime.stop();
        ((Stage)redLabel.getScene().getWindow()).close();
    }
}
