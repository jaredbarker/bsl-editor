package Controls;

import gui_objects.right.RightButtonsEnum;

import java.io.File;

/**
 * This interface is for any class who needs to know when the state of the program changes, and needs to perform
 * some action when the changes occur.
 */
public interface ProgramStateListener {


    /**
     * Called when the user selects an action from the toolbar.
     * @param buttonPress
     */
    public void rightToolBarSelection(RightButtonsEnum buttonPress);
    public void openAudioFile(File audioFile);
    public void pausePlayer();
    public void playPlayer();
    public void currentTimeUpdated(double newCurrTime);
    public void totalTimeUpdated(double newTotalTime);
}
