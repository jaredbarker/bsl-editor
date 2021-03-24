package Models;

import Utils.Constants;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

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
            double[] xCoors = {col, col + (size / 2.0), col + size};
            double[] yCoors = {row + size, row + (size / 2.0), row + size};
            gc.fillPolygon(xCoors, yCoors, Constants.TRIANGLE_VERTICES);
        }
    },
    NORTHEAST {
        @Override
        public int getInt() {
            return 1;
        }
        @Override
        public void drawDirection(GraphicsContext gc, int row, int col, int size) {
            gc.setFill(Color.WHITE);
            double[] xCoors = {col, col + size, col + size};
            double[] yCoors = {row, row, row + size};
            gc.fillPolygon(xCoors, yCoors, Constants.TRIANGLE_VERTICES);
        }
    },
    EAST {
        @Override
        public int getInt() {
            return 2;
        }
        @Override
        public void drawDirection(GraphicsContext gc, int row, int col, int size) {
            gc.setFill(Color.WHITE);
            double[] xCoors = {col, col + (size / 2.0), col};
            double[] yCoors = {row, row + (size / 2.0), row + size};
            gc.fillPolygon(xCoors, yCoors, Constants.TRIANGLE_VERTICES);
        }
    },
    SOUTHEAST {
        @Override
        public int getInt() {
            return 3;
        }
        @Override
        public void drawDirection(GraphicsContext gc, int row, int col, int size) {
            gc.setFill(Color.WHITE);
            double[] xCoors = {col + size, col + size, col};
            double[] yCoors = {row, row + size, row + size};
            gc.fillPolygon(xCoors, yCoors, Constants.TRIANGLE_VERTICES);
        }
    },
    SOUTH {
        @Override
        public int getInt() {
            return 4;
        }
        @Override
        public void drawDirection(GraphicsContext gc, int row, int col, int size) {
            gc.setFill(Color.WHITE);
            double[] xCoors = {col, col + (size / 2.0), col + size};
            double[] yCoors = {row, row + (size / 2.0), row};
            gc.fillPolygon(xCoors, yCoors, Constants.TRIANGLE_VERTICES);
        }
    },
    SOUTHWEST {
        @Override
        public int getInt() {
            return 5;
        }
        @Override
        public void drawDirection(GraphicsContext gc, int row, int col, int size) {
            gc.setFill(Color.WHITE);
            double[] xCoors = {col, col, col + size};
            double[] yCoors = {row, row + size, row + size};
            gc.fillPolygon(xCoors, yCoors, Constants.TRIANGLE_VERTICES);
        }
    },
    WEST {
        @Override
        public int getInt() {
            return 6;
        }
        @Override
        public void drawDirection(GraphicsContext gc, int row, int col, int size) {
            gc.setFill(Color.WHITE);
            double[] xCoors = {col + size, col + (size / 2.0), col + size};
            double[] yCoors = {row, row + (size / 2.0), row + size};
            gc.fillPolygon(xCoors, yCoors, Constants.TRIANGLE_VERTICES);
        }
    },
    NORTHWEST {
        @Override
        public int getInt() {
            return 7;
        }
        @Override
        public void drawDirection(GraphicsContext gc, int row, int col, int size) {
            gc.setFill(Color.WHITE);
            double[] xCoors = {col, col, col + size};
            double[] yCoors = {row + size, row, row};
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
            gc.fillOval(col + (size / 2.0), row + (size / 2.0), size / 2.0, size / 2.0);
        }
    };

    public abstract int getInt();

    public static CutDirection getDirection(int cutNum) {
        if (cutNum == 0) {
            return CutDirection.NORTH;
        } else if (cutNum == 1) {
            return CutDirection.NORTHEAST;
        } else if (cutNum == 2) {
            return CutDirection.EAST;
        } else if (cutNum == 3) {
            return CutDirection.SOUTHEAST;
        } else if (cutNum == 4) {
            return CutDirection.SOUTH;
        } else if (cutNum == 5) {
            return CutDirection.SOUTHWEST;
        } else if (cutNum == 6) {
            return CutDirection.WEST;
        } else if (cutNum == 7) {
            return CutDirection.NORTHWEST;
        } else {
            return CutDirection.NONE;
        }
    }

    public abstract void drawDirection(GraphicsContext gc, int row, int col, int size);
}
