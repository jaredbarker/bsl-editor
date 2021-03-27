package Models;

import javafx.scene.paint.Color;

public enum NoteType {
    LEFT {
        @Override
        public int getInt() {
            return 0;
        }

        @Override
        public Color getColor() {
            return Color.RED;
        }
    },
    RIGHT {
        @Override
        public int getInt() {
            return 1;
        }

        @Override
        public Color getColor() {
            return Color.BLUE;
        }
    };

    public abstract int getInt();
    //TODO define this function
    //public static NoteType getType(int typeNum);
    public abstract Color getColor();
}
