package gui_objects.left;

import Controls.ProgramState;
import Controls.ProgramStateListener;
import Models.CutDirection;
import Models.Note;
import Models.Note2DPosition;
import Models.NoteType;
import gui_objects.right.RightButtonsEnum;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;

import java.util.Map;

import static Utils.Constants.noteSize;


public class LeftPane extends BorderPane implements ProgramStateListener {

    private ProgramState state;
    private ScrollPane mainScrollPane;
    private Canvas canvas;
    private GraphicsContext noteArea;
    private int canvasWidth = 900;
    private int canvasHeight = 600;
    private int currentMouseRow = 0;
    private int currentMouseCol = 0;

    public LeftPane(ProgramState state) {
        super();
        this.state = state;
        this.state.addListener(this);
        this.setMinWidth(500);
        this.setMinHeight(500);
        this.setMaxWidth(canvasWidth);
        this.setMaxHeight(canvasHeight);
        this.setTop(new TextField("Audio Strip            Base Notes      Baritone Notes        Tenor Notes     Obstacles     Events"));


        this.canvas = new Canvas(canvasWidth, canvasHeight);
        this.mainScrollPane = new ScrollPane();
        this.noteArea = canvas.getGraphicsContext2D();
        this.initCanvas(this.noteArea);
        this.drawBoard(noteArea, -1, -1);
        this.mainScrollPane.setContent(this.canvas);

        this.setCenter(this.mainScrollPane);

        canvas.addEventFilter(MouseEvent.MOUSE_MOVED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //        System.out.println("X: " + event.getX() + "Y: " + event.getY());
                initCanvas(noteArea);
                drawBoard(noteArea, event.getX(), event.getY());
                drawNotes(noteArea);
            }
        });
        canvas.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //        System.out.println("X: " + event.getX() + "Y: " + event.getY());
                //Left click: primary, right click: secondary
                if (event.getButton().equals(MouseButton.PRIMARY)) {
                    drawNote(noteArea, true);
                }
                if (event.getButton().equals(MouseButton.SECONDARY)) {
                    drawNote(noteArea, false);
                    initCanvas(noteArea);
                    drawBoard(noteArea, event.getX(), event.getY());
                    drawNotes(noteArea);
                }
            }
        });
    }

    @Override
    public void rightToolBarSelection(RightButtonsEnum buttonPress) {

    }

    private void initCanvas(GraphicsContext gc) {
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    private void drawBoard(GraphicsContext gc, double mouse_x, double mouse_y) {
        //TODO draw notes as well
        gc.setStroke(Color.DARKGRAY);
        gc.setLineWidth(2);
        int dotWeight = 1;
        int audioStripOffset = noteSize * 14;

        for (int row = 0; row < canvasWidth; row += noteSize) {
            for (int col = audioStripOffset; col < canvasWidth; col += noteSize) {
                if (((col - audioStripOffset) % (6 * noteSize) != noteSize * 4) && ((col - audioStripOffset) % (6 * noteSize) != noteSize * 5)) {
//                    gc.strokeRoundRect(col, row, size, size, 2, 2); //This is if you want the whole rectangle to show
                    gc.strokeRect(col + noteSize, row + noteSize, dotWeight,dotWeight); //creates dots at the edge of the note rectangle area
                    if ((col - audioStripOffset) % (6 * noteSize) == noteSize * 0) {
                        gc.strokeRect(col, row + noteSize, dotWeight,dotWeight); //creates a dot on the bottom left for the squares after spaces
                    }

                    // Set the hover fill cover to where the mouse location is:
                    if (mouse_x - col < noteSize && mouse_y - row < noteSize && mouse_x - col > 0 && mouse_y - row > 0) {
                        currentMouseCol = col;
                        currentMouseRow = row;
                        gc.setFill(Color.DARKGRAY);
                        gc.fillRoundRect(col, row, noteSize, noteSize, 2, 2);
                    }
                }
            }
        }
    }

    private void drawNote(GraphicsContext gc, boolean isAdd){
        //TODO: figure out the right info to put into the note.
        if (isAdd) {
            if (state.getCurrentNoteType() == NoteType.RIGHT) {
                gc.setFill(Color.BLUE);
            } else {
                gc.setFill(Color.RED);
            }
            gc.fillRect(currentMouseCol, currentMouseRow, noteSize, noteSize);
            drawNoteDirection(gc, currentMouseRow, currentMouseCol, state.getCurrentNoteDirection().getInt());
            state.addNote(new Note2DPosition(currentMouseRow, currentMouseCol), new Note(0, 0, 0, state.getCurrentNoteType().getInt(), state.getCurrentNoteDirection().getInt()));
        } else {
            state.removeNote(new Note2DPosition(currentMouseRow, currentMouseCol));
        }
    }

    private void drawNotes(GraphicsContext gc) {

        for (Map.Entry<Note2DPosition,Note> entry : this.state.getNotes().entrySet()) {
            Note2DPosition pos = entry.getKey();
            Note note = entry.getValue();
            if (note.get_type() == NoteType.RIGHT.getInt()) {
                gc.setFill(Color.BLUE);
            } else {
                gc.setFill(Color.RED);
            }
            gc.fillRect(pos.getCol(), pos.getRow(), noteSize, noteSize);
            drawNoteDirection(gc, pos.getRow(), pos.getCol(), note.get_cutDirection());
        }
    }

    private void drawNoteDirection(GraphicsContext gc, int row, int col, int cutDirection) {
            CutDirection.getDirection(cutDirection).drawDirection(gc, row, col, noteSize);
    }
}
