
import com.HQ;
import com.PollingStationResult;
import com.VoteCounter;
import com.Winning;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class Simulator extends Application implements Initializable {
    public Label counter;
    Timeline simulatorTimeline = new Timeline();
    Timeline timeline = new Timeline();
    private IntegerProperty timeSeconds = new SimpleIntegerProperty(1);
    int remainingSeconds = 1;

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("simulator.fxml"));
        primaryStage.setTitle("Simulator");
        primaryStage.setScene(new Scene(root, 380, 400));
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        counter.textProperty().bind(timeSeconds.asString());
        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1), e -> {
            try {
                tick();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }));
        timeline.setCycleCount(120);
        timeline.setOnFinished(e -> {
            Winning winning = new Winning();
            try {
                winning.displayWindow();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        simulatorTimeline.getKeyFrames().add(
                new KeyFrame(Duration.seconds(120+1),
                        new KeyValue(timeSeconds, 5)));


    }

    private void tick() throws Exception {
        VoteCounter v = new VoteCounter();
        switch (remainingSeconds){
            case 24:
                {

                    v.displayWindow();
                break;}

            case 46:
            {
                com.PollingStationResult pollingStationResult = new PollingStationResult();
                pollingStationResult.displayWindow();
                break;
            }
            case 96:
            {
                com.HQ hq = new HQ();
                hq.displayWindow();
                break;
            }

        }
        remainingSeconds++;
    }

    public void runHandler(ActionEvent actionEvent) {
        timeline.playFromStart();
        simulatorTimeline.playFromStart();
    }
}
