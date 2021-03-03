package gui_objects.right;

import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;

import java.util.Arrays;

public class RightToolBar extends ToolBar {
    Button file;
    Button editNotes;
    Button songInfo;
    Button songMetaData;
    Button copyPaste;

    public RightToolBar(Button file, Button editNotes, Button songInfo, Button songMetaData, Button copyPaste) {
        super();
        this.file = file;
        this.editNotes = editNotes;
        this.songInfo = songInfo;
        this.songMetaData = songMetaData;
        this.copyPaste = copyPaste;
    }

    public RightToolBar() {
        super();
        this.file = new Button("File");
        this.editNotes = new Button("Edit Notes");
        this.songInfo = new Button("Song Info");
        this.songMetaData = new Button("Song Meta Data");
        this.copyPaste = new Button("Copy Paste");
        this.getItems().addAll(Arrays.asList(this.file, this.editNotes, this.songInfo, this.songMetaData, this.copyPaste));
    }

}
