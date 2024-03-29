package Models;

import java.util.Objects;

public class Note2DPosition implements Comparable{
    private int row; //todo change to double, or calculate actual row number in left pane
    private int col;

    public Note2DPosition(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
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
        if (this.row > other.row) {
            return -1;
        } else if (this.row < other.row){
            return 1;
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
        return row == that.row &&
                col == that.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }
}
