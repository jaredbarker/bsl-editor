package Utils;

public class Constants {
    public static final int TRIANGLE_VERTICES = 3;
    public static final int noteSize = 15;
    public static final double notePadding = noteSize / 5.0;
    public static final int audioOffsetMultiplier = 14;
    public static final int baseLowerBound = noteSize * audioOffsetMultiplier;
    public static final int baseUpperBound = baseLowerBound + (4 * noteSize);
    public static final int baritoneLowerBound = baseUpperBound + (2 * noteSize);
    public static final int baritoneUpperBound = baritoneLowerBound + (4 * noteSize);
    public static final int tenorLowerBound = baritoneUpperBound + (2 * noteSize);
    public static final int tenorUpperBound = tenorLowerBound + (4 * noteSize);
    public static final int notesPerBeat = 4;
    public static final int rowPlusBuffer = noteSize * 6;
    public static final int rowNoBuffer = noteSize * 4;
    public static final int rowFirstAndLastDot = noteSize * 5;
}
