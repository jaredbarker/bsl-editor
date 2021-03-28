package Controls;

import Models.CutDirection;
import Models.Note;
import Models.Note2DPosition;
import Models.NoteType;
import gui_objects.right.RightButtonsEnum;
import javafx.stage.Stage;

import java.io.File;
import java.util.*;

/**
 * Keeps track of the state of the program, and notifies listeners of changes so that they can perform the appropriate
 * action.
 */
public class ProgramState implements ProgramStateListener{
    private List<ProgramStateListener> listenerList;
    private Map<Note2DPosition, Note> notes;
    private NoteType currentNoteType;
    private CutDirection currentNoteDirection;
    private String currentMediaFile;
    private Stage primaryStage;

    public ProgramState() {
        this.listenerList = new ArrayList<>();
        this.notes = new TreeMap<>();
        this.currentNoteDirection = CutDirection.SOUTH;
        this.currentNoteType = NoteType.LEFT;
        this.currentMediaFile = "file:///defaultfilepath";
    }

    /**
     * Adds a new listener to be notified when the state of the program changes.
     * @param listener the listener to be added.
     */
    public void addListener(ProgramStateListener listener) {
        this.listenerList.add(listener);
    }


    @Override
    public void rightToolBarSelection(RightButtonsEnum buttonPress) {

        for (ProgramStateListener listener : listenerList) {
            listener.rightToolBarSelection(buttonPress);
        }
    }

    @Override
    public void openAudioFile(File audioFile) {
        for (ProgramStateListener listener : listenerList) {
            listener.openAudioFile(audioFile);
        }
    }

    @Override
    public void pausePlayer() {
        for (ProgramStateListener listener : listenerList) {
            listener.pausePlayer();
        }
    }

    @Override
    public void playPlayer() {
        for (ProgramStateListener listener : listenerList) {
            listener.playPlayer();
        }
    }

    public NoteType getCurrentNoteType() {
        return currentNoteType;
    }

    public void setCurrentNoteType(NoteType currentNoteType) {
        this.currentNoteType = currentNoteType;
    }

    public CutDirection getCurrentNoteDirection() {
        return currentNoteDirection;
    }

    public void setCurrentNoteDirection(CutDirection currentNoteDirection) {
        this.currentNoteDirection = currentNoteDirection;
    }

    public Map<Note2DPosition, Note> getNotes() {
        return notes;
    }

    public void addNote(Note2DPosition pos, Note note) {
        this.notes.put(pos, note);
    }

    public void removeNote(Note2DPosition pos) {
        this.notes.remove(pos);
    }

    public String getCurrentMediaFile() {
        return currentMediaFile;
    }

    public void setCurrentMediaFile(String currentMediaFile) {
        this.currentMediaFile = currentMediaFile;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
}
