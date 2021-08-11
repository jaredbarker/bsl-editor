package Models;

import java.util.Objects;

public class Note2DPosition implements Comparable{
    private int roundedMilliseconds; //should be fine to round, milliseconds are accurate enough
    private int col;

    public Note2DPosition(int roundedMilliseconds, int col) {
        this.roundedMilliseconds = roundedMilliseconds;
        this.col = col;
    }

    public int getRoundedMilliseconds() {
        return roundedMilliseconds;
    }

    public void setRoundedMilliseconds(int roundedMilliseconds) {
        this.roundedMilliseconds = roundedMilliseconds;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

/**
 * Compares this object with the specified object for order.  Returns a
 * negative integer, zero, or a positive integer as this object is less
 * than, equal to, or greater than the specified object.
 * */
    @Override
    public int compareTo(Object o) {
        Note2DPosition other = (Note2DPosition) o;
        if (this.roundedMilliseconds > other.roundedMilliseconds) {
            return 1;
        } else if (this.roundedMilliseconds < other.roundedMilliseconds){
            return -1;
        } else { // row is equal, compare col
            //shouldn't get here...duplicate note..so they are equal
            return Integer.compare(other.col, this.col);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note2DPosition that = (Note2DPosition) o;
        return roundedMilliseconds == that.roundedMilliseconds &&
                col == that.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roundedMilliseconds, col);
    }
}
