package gui_objects.bottom;

import Controls.ProgramState;
import Utils.Constants;
import gui_objects.left.LeftPane;
import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;

public class MediaBar extends HBox { // MediaBar extends Horizontal Box
    ProgramState state;
    // introducing Sliders
    Slider time = new Slider(); // Slider for time
    Slider vol = new Slider(); // Slider for volume
    Button PlayButton = new Button("||"); // For pausing the player
    Button faster = new Button("  >>  ");
    Button slower = new Button("  <<  ");
    Label rate = new Label("   1.0   ");
    Label volume = new Label("Volume: ");
    MediaPlayer player;

    public MediaBar(MediaPlayer play, ProgramState state) { // Default constructor taking
        this.state = state;
//        this.state.addListener(this); //CANNOT call this method right now...concurrent editing exception
        // the MediaPlayer object
        player = play;

        setAlignment(Pos.CENTER); // setting the HBox to center
        setPadding(new Insets(5, 10, 5, 10));
        // Settih the preference for volume bar
        vol.setPrefWidth(70);
        vol.setMinWidth(30);
        vol.setValue(100);
        HBox.setHgrow(time, Priority.ALWAYS);
        PlayButton.setPrefWidth(30);

        // Adding the components to the bottom

        getChildren().add(PlayButton); // Playbutton
        getChildren().add(rate);
        getChildren().add(slower);
        getChildren().add(faster);
        getChildren().add(time); // time slider
        getChildren().add(volume); // volume slider
        getChildren().add(vol);

        slower.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (player.getRate() > Constants.rateIncrement) {
                    player.setRate(player.getRate() - Constants.rateIncrement);
                    rate.setText("   " + Double.toString(player.getRate()) + "   ");
                }
            }
        });

        faster.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (player.getRate() < Constants.defaultRate) {
                    player.setRate(player.getRate() + Constants.rateIncrement);
                    rate.setText("   " + Double.toString(player.getRate()) + "   ");
                }
            }
        });
        // Adding Functionality
        // to play the media player
        PlayButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                Status status = player.getStatus(); // To get the status of Player
                if (status == status.PLAYING) {

                    // If the status is Video playing
                    if (player.getCurrentTime().greaterThanOrEqualTo(player.getTotalDuration())) {

                        // If the player is at the end of video
                        player.seek(player.getStartTime()); // Restart the video
                        state.playPlayer();
                    } else {
                        // Pausing the player
                        state.pausePlayer();

                        PlayButton.setText(">");
                    }
                } // If the video is stopped, halted or paused
                if (status == Status.HALTED || status == Status.STOPPED || status == Status.PAUSED) {
                    //player.play(); // Start the video
                    state.playPlayer();
                    PlayButton.setText("||");
                }
            }
        });

        //Brian and Jared: jumping to the start of a note when the player pauses
        player.statusProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                Status status = player.getStatus(); // To get the status of Player
                if (status == Status.HALTED || status == Status.STOPPED || status == Status.PAUSED) {
                    double jumpTime = Math.round(player.getCurrentTime().toMillis() / LeftPane.noteTime(state)) * LeftPane.noteTime(state);
                    time.setValue(jumpTime / player.getTotalDuration().toMillis() * 100);
                    player.seek(player.getMedia().getDuration().multiply(time.getValue() / 100));
                    state.currentTimeUpdated(player.getCurrentTime().toMillis());
                }
            }
        });

        // Providing functionality to time slider
        player.currentTimeProperty().addListener(new InvalidationListener() {
            public void invalidated(Observable ov) {
                updatesValues();
            }
        });

        // Inorder to jump to the certain part of video
        time.valueProperty().addListener(new InvalidationListener() {
            public void invalidated(Observable ov) {
                if (time.isPressed()) { // It would set the time
                    // as specified by user by pressing
                    //jumpVector is the number of milliseconds to move forward or backward in the song
                    double jumpVector = (time.getValue()/100 * player.getTotalDuration().toMillis()) - state.getCurrentSongTime();
                    stepSongTimeByNoteIncrements(jumpVector);
                }
            }
        });

        // providing functionality to volume slider
        vol.valueProperty().addListener(new InvalidationListener() {
            public void invalidated(Observable ov) {
                if (vol.isPressed()) {
                    player.setVolume(vol.getValue() / 100); // It would set the volume
                    // as specified by user by pressing
                }
            }
        });
    }

    public void stepSongTimeByNoteIncrements(double jumpVector) {
        //jumpTime rounds the jump amount to be to the nearest note
        double jumpTime = Math.round(jumpVector / LeftPane.noteTime(state)) * LeftPane.noteTime(state);
        setTimeOnProgramState();
        player.seek(player.getMedia().getDuration().multiply((state.getCurrentSongTime() + jumpTime) / player.getTotalDuration().toMillis()));
    }

    // Outside the constructor
    protected void updatesValues() {
        Platform.runLater(new Runnable() {
            public void run() {
                setTimeOnProgramState();
                // Updating to the new time value
                // This will move the slider while running your video
                time.setValue(player.getCurrentTime().toMillis()/
                        player.getTotalDuration()
                                .toMillis()
                                * 100);
            }
        });
    }

    private void setTimeOnProgramState() {
        double currTotalTime = state.getTotalSongTime();
        double newTotalTime = player.getTotalDuration().toMillis();
        if (newTotalTime != currTotalTime) {
            //total time updated here, since it is null when media is initialized...
            state.totalTimeUpdated(newTotalTime);

        }

        state.currentTimeUpdated(player.getCurrentTime().toMillis());
    }
}