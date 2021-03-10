package gui_objects.bottom;

import Controls.ProgramState;
import Controls.ProgramStateListener;
import gui_objects.right.RightButtonsEnum;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;


public class BottomPane extends BorderPane implements ProgramStateListener {

    ProgramState state;

    public BottomPane(ProgramState state) {
        super();
        this.state = state;
        this.state.addListener(this);

        this.setCenter(new TextField("Bottom"));
    }

    @Override
    public void rightToolBarSelection(RightButtonsEnum buttonPress) {

    }
}
