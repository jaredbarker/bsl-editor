package Controls;

import Models.CutDirection;
import Models.Note;
import Models.Note2DPosition;
import Models.NoteType;
import gui_objects.right.RightButtonsEnum;

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

    public ProgramState() {
        this.listenerList = new ArrayList<>();
        this.notes = new TreeMap<>();
        this.currentNoteDirection = CutDirection.SOUTH;
        this.currentNoteType = NoteType.LEFT;
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

}
