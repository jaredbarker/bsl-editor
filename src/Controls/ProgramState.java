package Controls;

import java.util.ArrayList;
import java.util.List;

/**
 * Keeps track of the state of the program, and notifies listeners of changes so that they can perform the appropriate
 * action.
 */
public class ProgramState implements ProgramStateListener{
    List<ProgramStateListener> listenerList;

    public ProgramState() {
        this.listenerList = new ArrayList<>();
    }

    /**
     * Adds a new listener to be notified when the state of the program changes.
     * @param listener the listener to be added.
     */
    public void addListener(ProgramStateListener listener) {
        this.listenerList.add(listener);
    }


    @Override
    public void toolBarSelection(String buttonPress) {

        for (ProgramStateListener listener : listenerList) {
            listener.toolBarSelection(buttonPress);
        }
    }
}
