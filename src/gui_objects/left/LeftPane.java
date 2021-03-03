package gui_objects.left;

import Controls.ProgramState;
import Controls.ProgramStateListener;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;


public class LeftPane extends BorderPane implements ProgramStateListener {

    ProgramState state;


    public LeftPane(ProgramState state) {
        super();
        this.state = state;
        this.state.addListener(this);
        this.setMinWidth(500);
        this.setMinHeight(500);
        this.setTop(new TextField("Events     Base Notes      Baritone Notes        Tenor Notes     Obstacles"));

        this.setCenter(new TextField("Center Left"));
    }

    @Override
    public void toolBarSelection(String buttonPress) {

    }
}
