package gui_objects.bottom;

import Controls.ProgramState;
import Controls.ProgramStateListener;
import gui_objects.right.RightButtonsEnum;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.io.File;
import java.net.MalformedURLException;

public class Player extends BorderPane implements ProgramStateListener// Player class extend BorderPane
        // in order to divide the media
        // player into regions
{
    Media media;
    MediaPlayer player;
    MediaView view;
    Pane mpane;
    MediaBar bar;
    ProgramState state;

    public Player(ProgramState state) { // Default constructor
        this.state = state;
        this.state.addListener(this);
        initPlayer(state.getCurrentMediaFile());
    }

    private void initPlayer(String file) {
        state.setCompressedSamples(getCompressedSamples());
        media = new Media("file:///" + file);
        player = new MediaPlayer(media);
        view = new MediaView(player);
        mpane = new Pane();
        mpane.getChildren().add(view); // Calling the function getChildren
        // inorder to add the view
        setCenter(mpane);
        bar = new MediaBar(player, state); // Passing the player to MediaBar
        setBottom(bar); // Setting the MediaBar at bottom
        setStyle("-fx-background-color:#bfc2c7"); // Adding color to the mediabar
//        player.play(); // Making the video play
        state.playPlayer();
    }

    private double[] getCompressedSamples() {
        double[] samples = StdAudio.read(state.getCurrentMediaFile());
        int numSamplesCompressed = samples.length / state.getBeatMapHeight();
        double[] compressedSamples = new double[state.getBeatMapHeight()];
        for (int i = 0; i < compressedSamples.length; i++) {
            double sum = 0.0;
            int startPoint = i * numSamplesCompressed;
            for (int j = startPoint; j < startPoint + numSamplesCompressed; j++) {
                sum += Math.abs(samples[j]);
            }
            compressedSamples[i] = sum / numSamplesCompressed;
        }
        return compressedSamples;
    }

    @Override
    public void rightToolBarSelection(RightButtonsEnum buttonPress) {

    }

    @Override
    public void openAudioFile(File audioFile) {
        try {
            state.setCurrentMediaFile(audioFile.toURI().toURL().toExternalForm());
            initPlayer(state.getCurrentMediaFile());
        } catch (MalformedURLException e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public void pausePlayer() {
        this.player.pause();
    }

    @Override
    public void playPlayer() {
        this.player.play();
    }

    @Override
    public void currentTimeUpdated(double newCurrTime){}

    @Override
    public void totalTimeUpdated(double newTotalTime){
        state.setCompressedSamples(getCompressedSamples());
    }

     @Override
    public void scrollBeatmap(double jumpVector){
        bar.stepSongTimeByNoteIncrements(jumpVector);
     }

    public  void load(File dir) {}
}
