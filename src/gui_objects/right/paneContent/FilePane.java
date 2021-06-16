package gui_objects.right.paneContent;

import Controls.ProgramState;
import Controls.ProgramStateListener;
import gui_objects.right.RightButtonsEnum;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;

import java.io.File;


public class FilePane extends BorderPane implements ProgramStateListener {
    private Button openAudioFile;
    private Button save;
    private ProgramState state;
    private FileChooser fileChooser;

    public FilePane(ProgramState state) {
        super();
        this.state = state;
        this.state.addListener(this);
        this.fileChooser = new FileChooser();
        this.save = new Button("Save");
        save.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                state.save();
            }
        });
        this.openAudioFile = new Button("Open Audio");
        openAudioFile.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                // Pausing the video while switching
                state.pausePlayer();
                File file = fileChooser.showOpenDialog(state.getPrimaryStage());

                // Choosing the file to play
                if (file != null) {
                    state.openAudioFile(file);
                }
            }
        });
        this.setCenter(this.openAudioFile);
        this.setTop(this.save);
    }

    @Override
    public void rightToolBarSelection(RightButtonsEnum buttonPress) {

    }

    @Override
    public void openAudioFile(File audioFile) {

    }

    @Override
    public void pausePlayer() {

    }

    @Override
    public void playPlayer() {

    }

        @Override
    public void currentTimeUpdated(double newCurrTime){}

        @Override
    public void totalTimeUpdated(double newTotalTime){}
}
