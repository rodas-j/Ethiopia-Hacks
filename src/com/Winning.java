package com;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Winning implements Initializable {

    public Label totalVotes;
    private Stage window;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            ElectionDatabase electionDatabase = new ElectionDatabase();
            ResultSet resultSet = ElectionDatabase.statement.executeQuery("select cast_vote, max(vote) from (select cast_vote, count(*) as vote from ballottable group by cast_vote) as voting;");
            resultSet.next();
            totalVotes.setText(String.valueOf(resultSet.getInt(2)));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        }
    public void displayWindow() throws Exception {
        window = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("winning.fxml"));
        window.setTitle("Vote Counter");
        window.setScene(new Scene(root, 600, 400));
        Font.loadFont(getClass().getResourceAsStream("Raleway-Regular.tff"), 50);
        window.setResizable(false);
        window.show();
    }

}
