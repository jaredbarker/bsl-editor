package gui_objects.bottom;

import Controls.ProgramState;
import Controls.ProgramStateListener;
import gui_objects.right.RightButtonsEnum;
import javafx.scene.layout.BorderPane;

import java.io.File;


public class BottomPane extends BorderPane implements ProgramStateListener {
    private Player player;
    private ProgramState state;

    public BottomPane(ProgramState state) {
        super();
        this.state = state;
        this.state.addListener(this);
        player = new Player(state);
        this.setCenter(player);
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
