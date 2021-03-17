package gui_objects.left;

import Controls.ProgramState;
import Controls.ProgramStateListener;
import gui_objects.right.RightButtonsEnum;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;




public class LeftPane extends BorderPane implements ProgramStateListener, EventHandler<MouseEvent> {

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
        this.initCanvas(this.noteArea);
        this.drawNotes(noteArea, -1, -1);
        this.mainScrollPane.setContent(this.canvas);

        this.setCenter(this.mainScrollPane);

        canvas.addEventFilter(MouseEvent.MOUSE_MOVED, this);
    }

    @Override
    public void rightToolBarSelection(RightButtonsEnum buttonPress) {

    }

    private void initCanvas(GraphicsContext gc) {
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    private void drawNotes(GraphicsContext gc, double mouse_x, double mouse_y) {
        gc.setStroke(Color.GRAY);
        gc.setLineWidth(2);
        int size = 15;
        int audioStripOffset = size * 14;

        for (int row = 0; row < canvasWidth; row += size) {
            for (int col = audioStripOffset; col < canvasWidth; col += size) {
                gc.setFill(Color.BLACK);
                gc.fillRoundRect(col, row, size, size, 2, 2);
                if (((col - audioStripOffset) % (6 * size) != size * 4) && ((col - audioStripOffset) % (6 * size) != size * 5)) {
//                    gc.strokeRoundRect(col, row, size, size, 2, 2); //This is if you want the whole rectangle to show
                    gc.strokeRect(col + size, row + size, 2,2); //creates dots at the edge of the note rectangle area
                    //TODO: fix edge cases where dots are not showing up on the first corners

                    // Set the hover fill cover to where the mouse location is:
                    if (mouse_x - col < size && mouse_y - row < size && mouse_x - col > 0 && mouse_y - row > 0) {
                        gc.setFill(Color.GRAY);
                        gc.fillRoundRect(col, row, size, size, 2, 2);
                    }
                }
            }
        }
    }

    @Override
    public void handle(MouseEvent event) {
//        System.out.println("X: " + event.getX() + "Y: " + event.getY());
        drawNotes(this.noteArea, event.getX(), event.getY());

    }
}
