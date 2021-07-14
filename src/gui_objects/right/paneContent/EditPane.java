package gui_objects.right.paneContent;

import Controls.ProgramState;
import Controls.ProgramStateListener;
import Models.CutDirection;
import Models.NoteType;
import gui_objects.right.RightButtonsEnum;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.io.File;

import static Utils.Constants.noteSize;


public class EditPane extends BorderPane implements ProgramStateListener, EventHandler<ActionEvent> {

    private ProgramState state;
    private Button north;
    private Button northeast;
    private Button east;
    private Button southeast;
    private Button south;
    private Button southwest;
    private Button west;
    private Button northwest;
    private Button none;
    private GridPane directionGrid;

    private Button left;
    private Button right;

    public EditPane(ProgramState state) {
        super();
        this.state = state;
        this.state.addListener(this);

        this.north = new Button("", this.setUpIcon(CutDirection.NORTH, null));
        this.northeast = new Button("", this.setUpIcon(CutDirection.NORTHEAST, null));
        this.east = new Button("", this.setUpIcon(CutDirection.EAST, null));
        this.southeast = new Button("", this.setUpIcon(CutDirection.SOUTHEAST, null));
        this.south = new Button("", this.setUpIcon(CutDirection.SOUTH, null));
        this.southwest = new Button("", this.setUpIcon(CutDirection.SOUTHWEST, null));
        this.west = new Button("", this.setUpIcon(CutDirection.WEST, null));
        this.northwest = new Button("", this.setUpIcon(CutDirection.NORTHWEST, null));
        this.none = new Button("", this.setUpIcon(CutDirection.NONE, null));

        this.left = new Button("", this.setUpIcon(null, NoteType.LEFT));
        this.right = new Button("", this.setUpIcon(null, NoteType.RIGHT));

        this.north.setOnAction(this);
        this.northeast.setOnAction(this);
        this.east.setOnAction(this);
        this.southeast.setOnAction(this);
        this.south.setOnAction(this);
        this.southwest.setOnAction(this);
        this.west.setOnAction(this);
        this.northwest.setOnAction(this);
        this.none.setOnAction(this);
        this.left.setOnAction(this);
        this.right.setOnAction(this);

        this.directionGrid = new GridPane();
        directionGrid.add(this.north, 1, 0);
        directionGrid.add(this.northeast, 2, 0);
        directionGrid.add(this.east, 2, 1);
        directionGrid.add(this.southeast, 2, 2);
        directionGrid.add(this.south, 1, 2);
        directionGrid.add(this.southwest, 0, 2);
        directionGrid.add(this.west, 0, 1);
        directionGrid.add(this.northwest, 0, 0);
        directionGrid.add(this.none, 1, 1);
        directionGrid.add(this.left, 0, 3);
        directionGrid.add(this.right, 1, 3);

        this.setTop(directionGrid);
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

    @Override
    public void handle(ActionEvent actionEvent) {
        if (actionEvent.getSource() == this.north) {
            state.setCurrentNoteDirection(CutDirection.NORTH);
        }
        if (actionEvent.getSource() == this.northeast) {
            state.setCurrentNoteDirection(CutDirection.NORTHEAST);
        }
        if (actionEvent.getSource() == this.east) {
            state.setCurrentNoteDirection(CutDirection.EAST);
        }
        if (actionEvent.getSource() == this.southeast) {
            state.setCurrentNoteDirection(CutDirection.SOUTHEAST);
        }
        if (actionEvent.getSource() == this.south) {
            state.setCurrentNoteDirection(CutDirection.SOUTH);
        }
        if (actionEvent.getSource() == this.southwest) {
            state.setCurrentNoteDirection(CutDirection.SOUTHWEST);
        }
        if (actionEvent.getSource() == this.west) {
            state.setCurrentNoteDirection(CutDirection.WEST);
        }
        if (actionEvent.getSource() == this.northwest) {
            state.setCurrentNoteDirection(CutDirection.NORTHWEST);
        }
        if (actionEvent.getSource() == this.none) {
            state.setCurrentNoteDirection(CutDirection.NONE);
        }
        if (actionEvent.getSource() == this.left) {
            state.setCurrentNoteType(NoteType.LEFT);
        }
        if (actionEvent.getSource() == this.right) {
            state.setCurrentNoteType(NoteType.RIGHT);
        }
    }


    /**
     * Provide either a cut direction OR a note type, not both.
     * This will draw the arrow if it is a cut direction, or it will fill the color if it is a note type.
     * @param dir
     * @param type
     * @return
     */
    private Canvas setUpIcon(CutDirection dir, NoteType type) {
        Canvas icon = new Canvas(noteSize, noteSize);
        GraphicsContext gc = icon.getGraphicsContext2D();
        initCanvas(gc, icon, dir, type);
        return icon;
    }

    private void initCanvas(GraphicsContext gc, Canvas canvas, CutDirection dir, NoteType type) {
        if (dir != null) {
            gc.setFill(Color.BLACK);
            gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
            dir.drawDirection(gc, 0, 0, noteSize);
        } else if (type != null) {
            gc.setFill(type.getColor());
            gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        }
    }

        @Override
    public void currentTimeUpdated(double newCurrTime){}

        @Override
    public void totalTimeUpdated(double newTotalTime){}

     @Override
    public void scrollBeatmap(double jumpVector){}

    public  void load(File dir) {}
}
