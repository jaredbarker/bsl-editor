package Controls;

/**
 * This interface is for any class who needs to know when the state of the program changes, and needs to perform
 * some action when the changes occur.
 */
public interface ProgramStateListener {


    /**
     * Called when the user selects an action from the toolbar.
     * @param buttonPress
     */
    public void toolBarSelection(String buttonPress);

}
