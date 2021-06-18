package Models;

import Utils.Constants;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import static Utils.Constants.notePadding;

/*
Cuts go to the direction, e.g. North is a cut that starts on the bottom of the block and goes up through the block
 */

public enum CutDirection {
    NORTH {
        @Override
        public int getInt() {
            return 0;
        }
        @Override
        public void drawDirection(GraphicsContext gc, int row, int col, int size) {
            gc.setFill(Color.WHITE);
            double[] xCoors = {col + notePadding, col + (size / 2.0), col + size - notePadding};
            double[] yCoors = {row + size - notePadding, row + (size / 2.0), row + size - notePadding};
            gc.fillPolygon(xCoors, yCoors, Constants.TRIANGLE_VERTICES);
        }
    },
    NORTHEAST {
        @Override
        public int getInt() {
            return 5;
        }
        @Override
        public void drawDirection(GraphicsContext gc, int row, int col, int size) {
            gc.setFill(Color.WHITE);
            double[] xCoors = {col + notePadding, col + size - notePadding, col + size - notePadding};
            double[] yCoors = {row + notePadding, row + notePadding, row + size - notePadding};
            gc.fillPolygon(xCoors, yCoors, Constants.TRIANGLE_VERTICES);
        }
    },
    EAST {
        @Override
        public int getInt() {
            return 3;
        }
        @Override
        public void drawDirection(GraphicsContext gc, int row, int col, int size) {
            gc.setFill(Color.WHITE);
            double[] xCoors = {col + notePadding, col + (size / 2.0), col + notePadding};
            double[] yCoors = {row + notePadding, row + (size / 2.0), row + size - notePadding};
            gc.fillPolygon(xCoors, yCoors, Constants.TRIANGLE_VERTICES);
        }
    },
    SOUTHEAST {
        @Override
        public int getInt() {
            return 7;
        }
        @Override
        public void drawDirection(GraphicsContext gc, int row, int col, int size) {
            gc.setFill(Color.WHITE);
            double[] xCoors = {col + size - notePadding, col + size - notePadding, col + notePadding};
            double[] yCoors = {row + notePadding, row + size - notePadding, row + size - notePadding};
            gc.fillPolygon(xCoors, yCoors, Constants.TRIANGLE_VERTICES);
        }
    },
    SOUTH {
        @Override
        public int getInt() {
            return 1;
        }
        @Override
        public void drawDirection(GraphicsContext gc, int row, int col, int size) {
            gc.setFill(Color.WHITE);
            double[] xCoors = {col + notePadding, col + (size / 2.0), col + size - notePadding};
            double[] yCoors = {row + notePadding, row + (size / 2.0), row + notePadding};
            gc.fillPolygon(xCoors, yCoors, Constants.TRIANGLE_VERTICES);
        }
    },
    SOUTHWEST {
        @Override
        public int getInt() {
            return 6;
        }
        @Override
        public void drawDirection(GraphicsContext gc, int row, int col, int size) {
            gc.setFill(Color.WHITE);
            double[] xCoors = {col + notePadding, col + notePadding, col + size - notePadding};
            double[] yCoors = {row + notePadding, row + size - notePadding, row + size - notePadding};
            gc.fillPolygon(xCoors, yCoors, Constants.TRIANGLE_VERTICES);
        }
    },
    WEST {
        @Override
        public int getInt() {
            return 2;
        }
        @Override
        public void drawDirection(GraphicsContext gc, int row, int col, int size) {
            gc.setFill(Color.WHITE);
            double[] xCoors = {col + size - notePadding, col + (size / 2.0), col + size - notePadding};
            double[] yCoors = {row + notePadding, row + (size / 2.0), row + size - notePadding};
            gc.fillPolygon(xCoors, yCoors, Constants.TRIANGLE_VERTICES);
        }
    },
    NORTHWEST {
        @Override
        public int getInt() {
            return 4;
        }
        @Override
        public void drawDirection(GraphicsContext gc, int row, int col, int size) {
            gc.setFill(Color.WHITE);
            double[] xCoors = {col + notePadding, col + notePadding, col + size - notePadding};
            double[] yCoors = {row + size - notePadding, row + notePadding, row + notePadding};
            gc.fillPolygon(xCoors, yCoors, Constants.TRIANGLE_VERTICES);
        }
    },
    NONE {
        @Override
        public int getInt() {
            return 8;
        }
        //TODO fix the oval to put it in the center
        @Override
        public void drawDirection(GraphicsContext gc, int row, int col, int size) {
            gc.setFill(Color.WHITE);
            gc.fillOval(col + (size / 4.0), row + (size / 4.0), size / 2.0, size / 2.0);
        }
    };

    public abstract int getInt();

    public abstract void drawDirection(GraphicsContext gc, int row, int col, int size);
}
