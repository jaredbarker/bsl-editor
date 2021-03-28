package sample;

import Controls.ProgramState;
import gui_objects.bottom.BottomPane;
import gui_objects.left.LeftPane;
import gui_objects.right.RightPane;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
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
