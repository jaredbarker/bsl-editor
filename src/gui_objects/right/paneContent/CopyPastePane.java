package gui_objects.right.paneContent;

import Controls.ProgramState;
import Controls.ProgramStateListener;
import gui_objects.right.RightButtonsEnum;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;


public class CopyPastePane extends BorderPane implements ProgramStateListener {

    ProgramState state;

    public CopyPastePane(ProgramState state) {
        super();
        this.state = state;
        this.state.addListener(this);

        this.setCenter(new TextField(RightButtonsEnum.COPY_PASTE.toString()));
    }

    @Override
    public void rightToolBarSelection(RightButtonsEnum buttonPress) {

    }
}