package com;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class HQ implements Initializable {
    public TableView<Constituencies> constituency;
    public TableColumn<PollingStation, String> pollingColumn;
    public TableColumn<PollingStation, ProgressBar> progressColumn;
    public TableColumn<Constituencies, String> conColumn;
    ElectionDatabase electionDatabase;
    @FXML
    TableView<PollingStation> pollingStations;
    ObservableList<PollingStation> poll;
    ObservableList<Constituencies> con;
    private ProgressBar progress;
    private Stage window;

    public void displayWindow() throws Exception {
        window = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("hq.fxml"));
        window.setTitle("HQ");
        window.setScene(new Scene(root, 600, 600));
        window.setResizable(false);
        window.show();



    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pollingStations.setStyle("h");
        constituency.getRowFactory();
        conColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        pollingColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        progressColumn.setCellValueFactory(new PropertyValueFactory<>("progressBar"));
        try {
            constituency.setItems(getConList());

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



    private ObservableList<Constituencies> getConList() throws SQLException {
        con = FXCollections.observableArrayList();
        ElectionDatabase electionDatabase = new ElectionDatabase();
        ResultSet resultSet = ElectionDatabase.statement.executeQuery("Select conName from constituenttable");
        while (resultSet.next()){
            con.add(new Constituencies(resultSet.getString(1)));
        }
        return con;
    }


    public ObservableList<PollingStation> getPollList(String s) throws SQLException {

        poll = FXCollections.observableArrayList();
        poll.clear();
        ResultSet resultSet = ElectionDatabase.statement.executeQuery(String.format("select * from pollingstation where ConID = (select ConID from constituenttable where conName = '%s');", s));
        while (resultSet.next()){
            progress = new ProgressBar();
            poll.add(new PollingStation(resultSet.getString(1), progress));
        }

        return poll;
    }

    public void viewCon(MouseEvent mouseEvent) throws SQLException {
        String s = ((Constituencies)((TableView) mouseEvent.getSource()).getSelectionModel().getSelectedItem()).getName();
        pollingStations.setItems(getPollList(s));
    }
}
