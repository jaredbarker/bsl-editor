package gui_objects.right.paneContent;

import Controls.ProgramState;
import Controls.ProgramStateListener;
import gui_objects.right.RightButtonsEnum;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;


public class SongTempoPane extends BorderPane implements ProgramStateListener {

    ProgramState state;

    public SongTempoPane(ProgramState state) {
        super();
        this.state = state;
        this.state.addListener(this);

        this.setCenter(new TextField(RightButtonsEnum.SONG_TEMPO.toString()));
    }

    @Override
    public void rightToolBarSelection(RightButtonsEnum buttonPress) {

    }
}