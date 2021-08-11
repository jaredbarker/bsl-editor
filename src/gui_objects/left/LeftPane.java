package gui_objects.left;

import Controls.ProgramState;
import Controls.ProgramStateListener;
import Models.Note;
import Models.Note2DPosition;
import Models.NoteType;
import Utils.NoteSpecs;
import gui_objects.right.RightButtonsEnum;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;

import java.io.File;
import java.util.Map;

import static Utils.Constants.*;


public class LeftPane extends BorderPane implements ProgramStateListener {

    private ProgramState state;
    //private ScrollPane mainScrollPane;
    private Canvas canvas;
    private GraphicsContext noteArea;
    private int canvasWidth = 900;
    private int canvasHeight = 750;
    private int currentMouseRow = 0;
    private int currentMouseCol = 0;

    public LeftPane(ProgramState state) {
        super();
        this.state = state;
        this.state.addListener(this);
        this.state.setBeatMapHeight(state.getBeatMapHeight());
        this.setTop(new TextField("                     Audio Strip                       Base Notes      Baritone Notes      Tenor Notes        Obstacles             Events"));


        this.canvas = new Canvas(canvasWidth, canvasHeight);
        //this.mainScrollPane = new ScrollPane();
        this.noteArea = canvas.getGraphicsContext2D();
        refreshBoard(-1, -1);
        //this.mainScrollPane.setContent(this.canvas);

        this.setCenter(this.canvas);

        canvas.addEventFilter(MouseEvent.MOUSE_MOVED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //        System.out.println("X: " + event.getX() + "Y: " + event.getY());
                refreshBoard(event.getX(), event.getY());
            }
        });
        canvas.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //        System.out.println("X: " + event.getX() + "Y: " + event.getY());
                //Left click: primary, right click: secondary
                if (!state.isPlaying()) {
                    if (event.getButton().equals(MouseButton.PRIMARY)) {
                        addNote(noteArea, true);
                    }
                    if (event.getButton().equals(MouseButton.SECONDARY)) {
                        addNote(noteArea, false);
                    }
                }
                refreshBoard(event.getX(), event.getY());
            }
        });

        canvas.addEventFilter(ScrollEvent.SCROLL, new EventHandler<ScrollEvent>() {
            @Override
            public void handle(ScrollEvent event) {
                double vertScroll = event.getDeltaY();
                state.scrollBeatmap(vertScroll / noteSize * noteTime(state));
            }
        });
    }

    private void refreshBoard(double x, double y) {
        int boardStart = getBoardStart((int)state.getCurrentSongTime());
        initCanvas(noteArea);
        drawBoard(noteArea, x, y, getBoardStart((int)state.getCurrentSongTime()));
        drawNotes(noteArea, boardStart);
    }

    @Override
    public void rightToolBarSelection(RightButtonsEnum buttonPress) {

    }

    @Override
    public void openAudioFile(File audioFile) {

    }

    @Override
    public void pausePlayer() {

    }

    @Override
    public void playPlayer() {

    }

    private void initCanvas(GraphicsContext gc) {
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    private void drawBoard(GraphicsContext gc, double mouse_x, double mouse_y, int boardStart) {
        //TODO draw notes as well
        gc.setStroke(Color.DARKGRAY);
        gc.setLineWidth(2);
        int dotWeight = 1;
        int audioStripOffset = noteSize * audioOffsetMultiplier;
        int audioStripCenter = audioStripOffset / 2;
        state.setAudioVisualizerWidth(audioStripOffset); //TODO put this on the state originally

        double[] compressedSamples = state.getCompressedSamples();
        for (int i = boardStart; i < boardStart + canvasHeight && i < compressedSamples.length; i++) {
            // filling image from top to bottom
            int barLimit = Math.abs((int) (compressedSamples[i] * audioStripCenter));
            int vPosition = canvasHeight - i + boardStart;
            gc.strokeLine(audioStripCenter, vPosition, audioStripCenter + barLimit, vPosition);
            gc.strokeLine(audioStripCenter, vPosition, audioStripCenter - barLimit, vPosition);
        }
        for (int row = 0; row < state.getBeatMapHeight(); row += noteSize) {
            int vposition = canvasHeight - row + boardStart;
            if (vposition >= 0 - noteSize && vposition <= canvasHeight) { // only draw what is currently in the viewport
                for (int col = audioStripOffset; col < canvasWidth; col += noteSize) {
                    if (((col - audioStripOffset) % (rowPlusBuffer) != rowNoBuffer) && ((col - audioStripOffset) % (rowPlusBuffer) != rowFirstAndLastDot)) {
//                    gc.strokeRoundRect(col, row, size, size, 2, 2); //This is if you want the whole rectangle to show
                        gc.strokeRect(col + noteSize, vposition + noteSize, dotWeight, dotWeight); //creates dots at the edge of the note rectangle area
                        if ((col - audioStripOffset) % (rowPlusBuffer) == noteSize * 0) {
                            gc.strokeRect(col, vposition + noteSize, dotWeight, dotWeight); //creates a dot on the bottom left for the squares after spaces
                        }

                        // Set the hover fill cover to where the mouse location is:
                        if (mouse_x - col < noteSize && mouse_y - vposition < noteSize && mouse_x - col > 0 && mouse_y - vposition > 0) {
                            currentMouseCol = col;
                            currentMouseRow = vposition;
                            gc.setFill(Color.DARKGRAY);
                            gc.fillRoundRect(col, vposition, noteSize, noteSize, 2, 2);
                        }
                    }
                }
            }
        }
    }

    private void addNote(GraphicsContext gc, boolean isAdd){
        double time = state.getCurrentSongTime() + (canvasHeight - currentMouseRow - noteSize)/ (double) noteSize * noteTime(state);
        if (isAdd) {
            state.addNote(new Note2DPosition((int)time, currentMouseCol), new Note(time , NoteSpecs.getNoteIndex(currentMouseCol), NoteSpecs.getNoteLayer(currentMouseCol), state.getCurrentNoteType().getInt(), state.getCurrentNoteDirection().getInt()));
        } else {
            state.removeNote(new Note2DPosition((int)time, currentMouseCol));
        }
    }

    private void drawNotes(GraphicsContext gc, int boardStart) {

        for (Map.Entry<Note2DPosition,Note> entry : this.state.getNotes().entrySet()) {
            Note2DPosition pos = entry.getKey();
            Note note = entry.getValue();
            if (note.get_type() == NoteType.RIGHT.getInt()) {
                gc.setFill(NoteType.RIGHT.getColor());
            } else {
                gc.setFill(NoteType.LEFT.getColor());
            }

            int worldCoord = getBoardStart((int)note.get_time());
            int vposition = canvasHeight + boardStart - worldCoord - noteSize;

            gc.fillRect(pos.getCol(), vposition, noteSize, noteSize);
            drawNoteDirection(gc, vposition, pos.getCol(), note.get_cutDirection());
        }
    }

    private void drawNoteDirection(GraphicsContext gc, int row, int col, int cutDirection) {
            state.getCutDirection(cutDirection).drawDirection(gc, row, col, noteSize);
    }

        @Override
    public void currentTimeUpdated(double newCurrTime){
        refreshBoard(-1, -1);
    }

        @Override
    public void totalTimeUpdated(double newTotalTime){
        refreshBoard(-1, -1);
    }

    private int getBoardStart(int currTimeInt) {
        return (int) ((currTimeInt / state.getTotalSongTime()) * state.getBeatMapHeight());
    }

    public static double noteTime(ProgramState state) {
        return state.getTotalSongTime() * noteSize / state.getBeatMapHeight();
    }

     @Override
    public void scrollBeatmap(double jumpVector){}

    public  void load(File dir) {}
}
