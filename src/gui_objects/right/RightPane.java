package gui_objects.right;

import Controls.ProgramState;
import Controls.ProgramStateListener;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;


public class RightPane extends BorderPane implements ProgramStateListener {

    ProgramState state;


    public RightPane(ProgramState state) {
        super();
        this.state = state;
        this.state.addListener(this);

        this.setTop(new RightToolBar(state));
        this.setCenter(new TextField("Center Right"));
    }

    @Override
    public void rightToolBarSelection(RightButtonsEnum buttonPress) {
        this.setCenter(new TextField(buttonPress.toString()));
    }
}
