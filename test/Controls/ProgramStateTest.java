package Controls;

import Models.Note;
import Models.Note2DPosition;
import Utils.Constants;
import javafx.util.Pair;
import junit.framework.TestCase;

import java.io.File;

public class ProgramStateTest extends TestCase {
    ProgramState testState;
    public void setUp() throws Exception {
        super.setUp();
        testState = new ProgramState();
    }

    public void tearDown() throws Exception {
    }

    public void testGcd() {
        assertTrue(Constants.precision > Math.abs(testState.gcd(0.66, 2.86) - .22));
        assertTrue(Constants.precision > Math.abs(testState.gcd(0.13, 0.07) - .01));
        assertTrue(Constants.precision > Math.abs(testState.gcd(13.0, 7.0) - 1));
        assertTrue(Constants.precision > Math.abs(testState.gcd(1.6042, 2.3446) - .1234));
    }

    public void testTotalTimeUpdated() {
        testState.load(new File("C:\\Users\\jared\\IdeaProjects\\bsl-editor\\test\\testResources"));

        testState.totalTimeUpdated((60.0 * 1000));

        assertEquals(4, testState.getNotesPerBeat());
    }

    public void testGetNoteDiffs() {
        testState.addNote(new Note2DPosition((int)0.0, 0), new Note(0.0 , 0, 0, 0, 0));
        testState.addNote(new Note2DPosition((int)(0.25 * 1000), 0), new Note((0.25 * 1000) , 0, 0, 0, 0));
        testState.addNote(new Note2DPosition((int)(0.5 * 1000), 0), new Note((0.5 * 1000) , 0, 0, 0, 0));
        testState.addNote(new Note2DPosition((int)(0.75 * 1000), 0), new Note((0.75 * 1000) , 0, 0, 0, 0));
        testState.addNote(new Note2DPosition((int)(1.0 * 1000), 0), new Note((1.0 * 1000) , 0, 0, 0, 0));

        Pair<Double, Double> result = testState.getNoteDiffs();
        assertEquals(250.0, result.getValue());
        assertEquals(250.0, result.getKey());
    }

    public void testGetNoteDiffs2() {
        testState.addNote(new Note2DPosition((int)0.0, 0), new Note(0.0 , 0, 0, 0, 0));
        testState.addNote(new Note2DPosition((int)(0.0 * 1000), 2), new Note((0.0 * 1000) , 0, 0, 0, 0));
        testState.addNote(new Note2DPosition((int)(0.5 * 1000), 0), new Note((0.5 * 1000) , 0, 0, 0, 0));
        testState.addNote(new Note2DPosition((int)(0.75 * 1000), 0), new Note((0.75 * 1000) , 0, 0, 0, 0));
        testState.addNote(new Note2DPosition((int)(1.75 * 1000), 0), new Note((1.75 * 1000) , 0, 0, 0, 0));

        Pair<Double, Double> result = testState.getNoteDiffs();
        assertEquals(250.0, result.getValue());
        assertEquals(500.0, result.getKey());
    }
}