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
    private int beatMapHeight;
    private int audioVisualizerWidth;
    private double[] compressedSamples;

    private double totalSongTime;
    private double currentSongTime;
    private int beatsPerMinute;

    public ProgramState() {
        this.beatMapHeight = 10000;
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

    @Override
    public void currentTimeUpdated(double newCurrentTime) {
        this.setCurrentSongTime(newCurrentTime);
        for (ProgramStateListener listener : listenerList) {
            listener.currentTimeUpdated(newCurrentTime);
        }
    }

    @Override
    public void totalTimeUpdated(double newTotalTime) {
        this.setTotalSongTime(newTotalTime);
        for (ProgramStateListener listener : listenerList) {
            listener.totalTimeUpdated(newTotalTime);
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

    public int getBeatMapHeight() {
        return beatMapHeight;
    }

    public void setBeatMapHeight(int beatMapHeight) {
        this.beatMapHeight = beatMapHeight;
    }

    public int getAudioVisualizerWidth() {
        return audioVisualizerWidth;
    }

    public void setAudioVisualizerWidth(int audioVisualizerWidth) {
        this.audioVisualizerWidth = audioVisualizerWidth;
    }
    public double[] getCompressedSamples() {
        return compressedSamples;
    }

    public void setCompressedSamples(double[] compressedSamples) {
        this.compressedSamples = compressedSamples;
    }


    public double getTotalSongTime() {
        return totalSongTime;
    }

    private void setTotalSongTime(double totalSongTime) {
        this.totalSongTime = totalSongTime;
    }

    public double getCurrentSongTime() {
        return currentSongTime;
    }

    private void setCurrentSongTime(double currentSongTime) {
        this.currentSongTime = currentSongTime;

    }

    public int getBeatsPerMinute() {
        return beatsPerMinute;
    }

    public void setBeatsPerMinute(int beatsPerMinute) {
        this.beatsPerMinute = beatsPerMinute;
    }
}
