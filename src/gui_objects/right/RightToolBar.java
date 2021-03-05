package gui_objects.right;

import Controls.ProgramState;
import Controls.ProgramStateListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;

import java.util.Arrays;

public class RightToolBar extends ToolBar implements EventHandler<ActionEvent>, ProgramStateListener {
    Button file;
    Button editNotes;
    Button songInfo;
    Button songMetaData;
    Button copyPaste;
    Button songTempo;
    ProgramState state;

    public RightToolBar(Button file, Button editNotes, Button songInfo, Button songMetaData, Button copyPaste, Button songTempo) {
        super();
        this.file = file;
        this.editNotes = editNotes;
        this.songInfo = songInfo;
        this.songMetaData = songMetaData;
        this.copyPaste = copyPaste;
        this.songTempo = songTempo;
    }

    public RightToolBar(ProgramState state) {
        this.file = new Button(RightButtonsEnum.FILE.toString());
        this.editNotes = new Button(RightButtonsEnum.EDIT.toString());
        this.songInfo = new Button(RightButtonsEnum.SONG_INFO.toString());
        this.songMetaData = new Button(RightButtonsEnum.SONG_METADATA.toString());
        this.copyPaste = new Button(RightButtonsEnum.COPY_PASTE.toString());
        this.songTempo = new Button(RightButtonsEnum.SONG_TEMPO.toString());
        this.getItems().addAll(Arrays.asList(this.file, this.editNotes, this.songInfo, this.songMetaData,
                                             this.copyPaste, this.songTempo));
        this.state = state;
        this.state.addListener(this);
        file.setOnAction(this);
        editNotes.setOnAction(this);
        songInfo.setOnAction(this);
        songMetaData.setOnAction(this);
        copyPaste.setOnAction(this);
        songTempo.setOnAction(this);
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (actionEvent.getSource() == file) {
            state.rightToolBarSelection(RightButtonsEnum.FILE);
        }
        if (actionEvent.getSource() == songInfo) {
            state.rightToolBarSelection(RightButtonsEnum.SONG_INFO);
        }
        if (actionEvent.getSource() == songTempo) {
            state.rightToolBarSelection(RightButtonsEnum.SONG_TEMPO);
        }
        if (actionEvent.getSource() == songMetaData) {
            state.rightToolBarSelection(RightButtonsEnum.SONG_METADATA);
        }
        if (actionEvent.getSource() == editNotes) {
            state.rightToolBarSelection(RightButtonsEnum.EDIT);
        }
        if (actionEvent.getSource() == copyPaste) {
            state.rightToolBarSelection(RightButtonsEnum.COPY_PASTE);
        }
    }

    @Override
    public void rightToolBarSelection(RightButtonsEnum buttonPress) {

    }
}
