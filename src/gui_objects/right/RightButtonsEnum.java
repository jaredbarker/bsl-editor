package gui_objects.right;

public enum RightButtonsEnum {
    FILE {
        public String toString() {
            return "File";
        }
    },
    EDIT {
        public String toString() {
            return "Edit";
        }
    },
    COPY_PASTE {
        public String toString() {
            return "Copy/Paste";
        }
    },
    SONG_INFO {
        public String toString() {
            return "Song Info";
        }
    },
    SONG_METADATA {
        public String toString() {
            return "Song Metadata";
        }
    },
    SONG_TEMPO {
        public String toString() {
            return "Song Tempo";
        }
    }
}
