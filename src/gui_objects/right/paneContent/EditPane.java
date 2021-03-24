package gui_objects.right.paneContent;

import Controls.ProgramState;
import Controls.ProgramStateListener;
import Models.CutDirection;
import gui_objects.right.RightButtonsEnum;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;


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

    public EditPane(ProgramState state) {
        super();
        this.state = state;
        this.state.addListener(this);

        this.north = new Button("North");
        this.northeast = new Button("Northeast");
        this.east = new Button("East");
        this.southeast = new Button("Southeast");
        this.south = new Button("South");
        this.southwest = new Button("Southwest");
        this.west = new Button("West");
        this.northwest = new Button("Northwest");
        this.none = new Button("None");

        this.north.setOnAction(this);
        this.northeast.setOnAction(this);
        this.east.setOnAction(this);
        this.southeast.setOnAction(this);
        this.south.setOnAction(this);
        this.southwest.setOnAction(this);
        this.west.setOnAction(this);
        this.northwest.setOnAction(this);
        this.none.setOnAction(this);

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

        this.setCenter(directionGrid);
    }

    @Override
    public void rightToolBarSelection(RightButtonsEnum buttonPress) {

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
    }
}
