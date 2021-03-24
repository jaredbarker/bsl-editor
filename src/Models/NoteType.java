package Models;

public enum NoteType {
    LEFT {
        @Override
        public int getInt() {
            return 0;
        }
    },
    RIGHT {
        @Override
        public int getInt() {
            return 1;
        }
    };

    public abstract int getInt();
    //TODO define this function
    //public static NoteType getType(int typeNum);
}
