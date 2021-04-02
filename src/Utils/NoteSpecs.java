package Utils;

public class NoteSpecs {
    public static int getNoteLayer(int x_coor) {
        if (x_coor >= Constants.baseLowerBound && x_coor <= Constants.baseUpperBound) {
            return 0;
        } else if (x_coor >= Constants.baritoneLowerBound && x_coor <= Constants.baritoneUpperBound) {
            return 1;
        } else if (x_coor >= Constants.tenorLowerBound && x_coor <= Constants.tenorUpperBound) {
            return 2;
        }
        return -1;
    }

    public static int getNoteIndex(int x_coor) {
        return (((x_coor - Constants.noteSize) - Constants.audioOffsetMultiplier) % (6 * Constants.noteSize)) / Constants.noteSize;
    }
}
