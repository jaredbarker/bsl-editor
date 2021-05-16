package gui_objects.right;

import Controls.ProgramState;
import Controls.ProgramStateListener;
import gui_objects.right.paneContent.*;
import javafx.scene.layout.BorderPane;

import java.io.File;
import java.util.HashMap;


public class RightPane extends BorderPane implements ProgramStateListener {

    ProgramState state;

    HashMap<RightButtonsEnum, BorderPane> rightPanesMap;


    public RightPane(ProgramState state) {
        super();
        this.state = state;
        this.state.addListener(this);
        rightPanesMap = new HashMap<>();
        rightPanesMap.put(RightButtonsEnum.FILE, new FilePane(state));
        rightPanesMap.put(RightButtonsEnum.EDIT, new EditPane(state));
        rightPanesMap.put(RightButtonsEnum.COPY_PASTE, new CopyPastePane(state));
        rightPanesMap.put(RightButtonsEnum.SONG_INFO, new SongInfoPane(state));
        rightPanesMap.put(RightButtonsEnum.SONG_METADATA, new SongMetadataPane(state));
        rightPanesMap.put(RightButtonsEnum.SONG_TEMPO, new SongTempoPane(state));

        this.setTop(new RightToolBar(state));
        this.setCenter(rightPanesMap.get(RightButtonsEnum.FILE));
    }

    @Override
    public void rightToolBarSelection(RightButtonsEnum buttonPress) {
        this.setCenter(rightPanesMap.get(buttonPress));
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
