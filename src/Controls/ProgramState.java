package Controls;

import Models.*;
import Models.Json.BeatMapDifficulty;
import Models.Json.BeatMapInfo;
import Models.Json.BeatMapLevelJson;
import Models.Json.BeatMapSetItem;
import Utils.Constants;
import Utils.JsonHandler;
import gui_objects.right.RightButtonsEnum;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import static Utils.Constants.noteSize;
import static Utils.Constants.notesPerBeat;

/**
 * Keeps track of the state of the program, and notifies listeners of changes so that they can perform the appropriate
 * action.
 */
public class ProgramState implements ProgramStateListener{
    private List<ProgramStateListener> listenerList;
    private Map<Note2DPosition, Note> notes;
    private BeatMapLevelJson beatMap;
    private BeatMapInfo beatMapInfo;
    private NoteType currentNoteType;
    private CutDirection currentNoteDirection;
    private String currentMediaFile;
    private File currentLevelDirectory;
    private Stage primaryStage;
    private int beatMapHeight;
    private int audioVisualizerWidth;
    private double[] compressedSamples;
    private HashMap<Integer, CutDirection> intToCutDirection;

    private double totalSongTime;
    private double currentSongTime;
    private int beatsPerMinute;

    private boolean isPlaying;

    public ProgramState() {
        this.beatMap = new BeatMapLevelJson();
        this.beatMapInfo = new BeatMapInfo();
        this.beatMapHeight = 10000;
        this.totalSongTime = 100;
        this.currentSongTime = 0;
        this.beatsPerMinute = 90;
        this.listenerList = new ArrayList<>();
        this.notes = new TreeMap<>();
        this.intToCutDirection = new HashMap<>();
        for (CutDirection dir : CutDirection.values()) {
            this.intToCutDirection.put(dir.getInt(), dir);
        }
        this.currentNoteDirection = CutDirection.SOUTH;
        this.currentNoteType = NoteType.LEFT;
        this.currentMediaFile = "file:///defaultfilepath";
    }

    public String parseMediaFile() {
        for (int i = currentMediaFile.length() - 1; i >= 0; i--) {
            if (currentMediaFile.charAt(i) == '/' || currentMediaFile.charAt(i) == '\\') {
                return currentMediaFile.substring(i + 1, currentMediaFile.length()).replace(".wav", "");
            }
        }
        return currentMediaFile.replace(".wav", "");
    }

    public void save() {
        //TODO: put this first part in a default level creation function
        String levelFileName = "Expert.dat";
        BeatMapDifficulty expert = new BeatMapDifficulty("Expert", 7, levelFileName, 0.0, 0.0);
        BeatMapSetItem set = new BeatMapSetItem("Standard", new ArrayList<>(Arrays.asList(expert)));
        this.beatMapInfo = new BeatMapInfo("2.2.0", parseMediaFile(), "", "", "", this.beatsPerMinute, 0.0, 0.0, 0.5, 0.0, 10.0,
                parseMediaFile() + ".wav", "", "DefaultEnvironment", "GlassDesertEnvironment", new ArrayList<>(Arrays.asList(set)));

        for (Map.Entry<Note2DPosition,Note> entry : this.notes.entrySet()) {
            beatMap.get_notes().add(entry.getValue());
            //TODO add all the other info
        }
        writeObjectToFile(beatMap, levelFileName);
        writeObjectToFile(beatMapInfo, "Info.dat");
    }

    public void load(File dir) {
        this.currentLevelDirectory = dir;
        this.beatMapInfo = this.readObjectFromFile(currentLevelDirectory.getAbsolutePath() + "\\Info.dat", BeatMapInfo.class);
        this.beatsPerMinute = beatMapInfo.get_beatsPerMinute();
        this.currentMediaFile = currentLevelDirectory.getAbsolutePath() + "\\" + beatMapInfo.get_songFilename();
        this.beatMap = this.readObjectFromFile(currentLevelDirectory.getAbsolutePath() + "\\Expert.dat", BeatMapLevelJson.class);
        //TODO read in obstacles and events as well
        this.notes = new HashMap<>();
        for (Note note : beatMap.get_notes()) {
            notes.put(new Note2DPosition((int)note.get_time(), (Constants.audioOffsetMultiplier * noteSize) + (note.get_lineLayer() * Constants.rowPlusBuffer) + note.get_lineIndex() * noteSize), note);
        }
        this.openAudioFile(new File(currentMediaFile));
        for (ProgramStateListener listener : listenerList) {
            listener.load(dir);
        }
    }

    private void writeObjectToFile(Object object, String name) {
        try {
            FileWriter file = new FileWriter("resources/" + name);
            file.write(JsonHandler.toJson(object));
            file.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private <T> T readObjectFromFile(String fileName, Class<T> classOfT) {
        try {
            String input = Files.readString(Path.of(fileName));
            T object = JsonHandler.fromJson(input, classOfT);

            return object;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
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
        this.isPlaying = false;
        for (ProgramStateListener listener : listenerList) {
            listener.pausePlayer();
        }
    }

    @Override
    public void playPlayer() {
        this.isPlaying = true;
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
        double height = this.getBeatsPerMinute() * noteSize * (newTotalTime / 1000 / 60) * notesPerBeat;

        //TODO: make it a double!!!
        this.setBeatMapHeight((int) height);
        for (ProgramStateListener listener : listenerList) {
            listener.totalTimeUpdated(newTotalTime);
        }
    }

    @Override
    public void scrollBeatmap(double jumpVector){
        for (ProgramStateListener listener : listenerList) {
            listener.scrollBeatmap(jumpVector);
        }
    }

    public File getCurrentLevelDirectory() {
        return currentLevelDirectory;
    }

    public void setCurrentLevelDirectory(File currentLevelDirectory) {
        this.currentLevelDirectory = currentLevelDirectory;
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
    public boolean isPlaying() {
        return isPlaying;
    }

    public void setPlaying(boolean playing) {
        isPlaying = playing;
    }

    public CutDirection getCutDirection(int dir) {
        return this.intToCutDirection.get(dir);
    }
}
