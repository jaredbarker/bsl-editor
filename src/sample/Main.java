package sample;

import Controls.ProgramState;
import Utils.Constants;
import gui_objects.bottom.BottomPane;
import gui_objects.left.LeftPane;
import gui_objects.right.RightPane;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        ProgramState state = new ProgramState();
        state.setPrimaryStage(primaryStage);
//        primaryStage.setFullScreen(true);

        //Instantiating the BorderPane class
        BorderPane bPane = new BorderPane();
        bPane.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.UP)) {
                    state.scrollBeatmap(Constants.stepRoundoff * LeftPane.noteTime(state));
                } else if (event.getCode().equals(KeyCode.DOWN)) {
                    state.scrollBeatmap(Constants.negStepRoundoff * LeftPane.noteTime(state));
                }

            }
        });

        //Setting the top, bottom, center, right and left nodes to the pane
        bPane.setBottom(new BottomPane(state));
        bPane.setLeft(new LeftPane(state));
        bPane.setRight(new RightPane(state));

        //Creating a scene object
        Scene scene = new Scene(bPane);

        //Setting title to the primaryStage
        primaryStage.setTitle("Beat Saber Level Editor");

        //Adding scene to the primaryStage
        primaryStage.setScene(scene);

        //Displaying the contents of the primaryStage
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
