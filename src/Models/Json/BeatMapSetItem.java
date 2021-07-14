package Models.Json;

import java.util.List;
import java.util.Objects;

public class BeatMapSetItem {
    private String _beatmapCharacteristicName;
    private List<BeatMapDifficulty> _difficultyBeatmaps;

    public BeatMapSetItem(String _beatmapCharacteristicName, List<BeatMapDifficulty> _difficultyBeatmaps) {
        this._beatmapCharacteristicName = _beatmapCharacteristicName;
        this._difficultyBeatmaps = _difficultyBeatmaps;
    }

    public String get_beatmapCharacteristicName() {
        return _beatmapCharacteristicName;
    }

    public void set_beatmapCharacteristicName(String _beatmapCharacteristicName) {
        this._beatmapCharacteristicName = _beatmapCharacteristicName;
    }

    public List<BeatMapDifficulty> get_difficultyBeatmaps() {
        return _difficultyBeatmaps;
    }

    public void set_difficultyBeatmaps(List<BeatMapDifficulty> _difficultyBeatmaps) {
        this._difficultyBeatmaps = _difficultyBeatmaps;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BeatMapSetItem that = (BeatMapSetItem) o;
        return Objects.equals(_beatmapCharacteristicName, that._beatmapCharacteristicName) &&
                Objects.equals(_difficultyBeatmaps, that._difficultyBeatmaps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_beatmapCharacteristicName, _difficultyBeatmaps);
    }
}
