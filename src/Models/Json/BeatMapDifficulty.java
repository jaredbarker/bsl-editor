package Models.Json;

import java.util.Objects;

public class BeatMapDifficulty {
    private String _difficulty;
    private int _difficultyRank;
    private String _beatmapFilename;
    private double _noteJumpMovementSpeed;
    private double _noteJumpStartBeatOffset;

    public BeatMapDifficulty() {
        this._difficulty = "Expert";
        this._difficultyRank = 7;
        this._beatmapFilename = "Expert.dat";
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BeatMapDifficulty that = (BeatMapDifficulty) o;
        return _difficultyRank == that._difficultyRank &&
                Double.compare(that._noteJumpMovementSpeed, _noteJumpMovementSpeed) == 0 &&
                Double.compare(that._noteJumpStartBeatOffset, _noteJumpStartBeatOffset) == 0 &&
                Objects.equals(_difficulty, that._difficulty) &&
                Objects.equals(_beatmapFilename, that._beatmapFilename);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_difficulty, _difficultyRank, _beatmapFilename, _noteJumpMovementSpeed, _noteJumpStartBeatOffset);
    }
}
