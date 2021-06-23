package Models.Json;

public class BeatMapDifficulty {
    private String _difficulty;
    private int _difficultyRank;
    private String _beatmapFilename;
    private double _noteJumpMovementSpeed;
    private double _noteJumpStartBeatOffset;

    public BeatMapDifficulty() {
        this._difficulty = "";
        this._difficultyRank = 0;
        this._beatmapFilename = "";
        this._noteJumpMovementSpeed = 0.0;
        this._noteJumpStartBeatOffset = 0.0;
    }

    public BeatMapDifficulty(String _difficulty, int _difficultyRank, String _beatmapFilename, double _noteJumpMovementSpeed, double _noteJumpStartBeatOffset) {
        this._difficulty = _difficulty;
        this._difficultyRank = _difficultyRank;
        this._beatmapFilename = _beatmapFilename;
        this._noteJumpMovementSpeed = _noteJumpMovementSpeed;
        this._noteJumpStartBeatOffset = _noteJumpStartBeatOffset;
    }

    public String get_difficulty() {
        return _difficulty;
    }

    public void set_difficulty(String _difficulty) {
        this._difficulty = _difficulty;
    }

    public int get_difficultyRank() {
        return _difficultyRank;
    }

    public void set_difficultyRank(int _difficultyRank) {
        this._difficultyRank = _difficultyRank;
    }

    public String get_beatmapFilename() {
        return _beatmapFilename;
    }

    public void set_beatmapFilename(String _beatmapFilename) {
        this._beatmapFilename = _beatmapFilename;
    }

    public double get_noteJumpMovementSpeed() {
        return _noteJumpMovementSpeed;
    }

    public void set_noteJumpMovementSpeed(double _noteJumpMovementSpeed) {
        this._noteJumpMovementSpeed = _noteJumpMovementSpeed;
    }

    public double get_noteJumpStartBeatOffset() {
        return _noteJumpStartBeatOffset;
    }

    public void set_noteJumpStartBeatOffset(double _noteJumpStartBeatOffset) {
        this._noteJumpStartBeatOffset = _noteJumpStartBeatOffset;
    }
}
