
import javafx.application.Application;
import javafx.beans.Observable;
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
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class HQ extends Application implements Initializable {
    public TableView<Constituencies> constituency;
    public TableColumn<PollingStation, String> pollingColumn;
    public TableColumn<PollingStation, ProgressBar> progressColumn;
    public TableColumn<Constituencies, String> conColumn;
    @FXML
    TableView<PollingStation> pollingStations;
    ObservableList<PollingStation> poll;
    ObservableList<Constituencies> con;


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("hq.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 600, 500));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        conColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        pollingColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        progressColumn.setCellValueFactory(new PropertyValueFactory<>("progressBar"));
        constituency.setItems(getConList());
        pollingStations.setItems(getPollList());
        System.out.println(pollingStations.getColumns());
        System.out.println(constituency.getColumns());
    }

    private ObservableList<Constituencies> getConList() {
        con = FXCollections.observableArrayList();
        con.add(new Constituencies());
        con.add(new Constituencies());
        con.add(new Constituencies());
        con.add(new Constituencies());
        con.add(new Constituencies());
        return con;
    }

    public ObservableList<PollingStation> getPollList(){
        poll = FXCollections.observableArrayList();
        poll.add(new PollingStation());
        poll.add(new PollingStation());
        poll.add(new PollingStation());
        poll.add(new PollingStation());
        poll.add(new PollingStation());
        poll.add(new PollingStation());
        poll.add(new PollingStation());
        poll.add(new PollingStation());
        poll.add(new PollingStation());
        poll.add(new PollingStation());
        poll.add(new PollingStation());
        poll.add(new PollingStation());
        poll.add(new PollingStation());
        poll.add(new PollingStation());
        poll.add(new PollingStation());
        poll.add(new PollingStation());
        poll.add(new PollingStation());
        poll.add(new PollingStation());
        poll.add(new PollingStation());
        poll.add(new PollingStation());
        poll.add(new PollingStation());
        poll.add(new PollingStation());
        poll.add(new PollingStation());
        poll.add(new PollingStation());
        poll.add(new PollingStation());
        poll.add(new PollingStation());
        poll.add(new PollingStation());
        poll.add(new PollingStation());
        poll.add(new PollingStation());
        poll.add(new PollingStation());
        poll.add(new PollingStation());
        poll.add(new PollingStation());
        poll.add(new PollingStation());
        poll.add(new PollingStation());

        return poll;
    }

}
