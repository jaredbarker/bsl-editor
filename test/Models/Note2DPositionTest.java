package Models;


import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Note2DPositionTest {

    /**
     * Making sure that the positions are compared correctly, first by row, then column, descending.
     */
    @Test
    public void testComparator() {
        Note2DPosition note1 = new Note2DPosition(0,0);
        Note2DPosition note2 = new Note2DPosition(0,1);
        Note2DPosition note3 = new Note2DPosition(0,2);
        Note2DPosition note4 = new Note2DPosition(1,1);
        Note2DPosition note5 = new Note2DPosition(1,2);
        Note2DPosition note6 = new Note2DPosition(1,3);
        Note2DPosition note7 = new Note2DPosition(2,0);
        Note2DPosition note8 = new Note2DPosition(2,1);
        Note2DPosition note9 = new Note2DPosition(3,0);
        List<Note2DPosition> positions = new ArrayList<>(Arrays.asList(note1, note2, note3, note4, note5, note6, note7, note8, note9));

        Collections.sort(positions);

        List<Note2DPosition> expected = new ArrayList<>(Arrays.asList(note9, note8, note7, note6, note5, note4, note3, note2, note1));

        Assert.assertEquals("Expected the list to be sorted", expected, positions);
    }
}