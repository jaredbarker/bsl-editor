package gui_objects.left;

import Controls.ProgramState;
import Controls.ProgramStateListener;
import gui_objects.right.RightButtonsEnum;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;


public class LeftPane extends BorderPane implements ProgramStateListener {

    private ProgramState state;
    private ScrollPane mainScrollPane;
    private Canvas canvas;
    private GraphicsContext noteArea;
    private int canvasWidth = 900;
    private int canvasHeight = 600;

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
        drawNotes(noteArea);
        this.mainScrollPane.setContent(this.canvas);

        this.setCenter(this.mainScrollPane);
    }

    @Override
    public void rightToolBarSelection(RightButtonsEnum buttonPress) {

    }

    private void drawNotes(GraphicsContext gc) {
        gc.setFill(Color.GREEN);
        gc.setStroke(Color.GREEN);
        gc.setLineWidth(2);
        int size = 15;
        int audioStripOffset = size * 14;

        for (int row = 0; row < canvasWidth; row += size) {
            for (int col = audioStripOffset; col < canvasWidth; col += size) {
                if (((col - audioStripOffset) % (6 * size) != size * 4) && ((col - audioStripOffset) % (6 * size) != size * 5)) {
                    gc.strokeRoundRect(col, row, size, size, 2, 2);
                }
            }
        }
    }

}
