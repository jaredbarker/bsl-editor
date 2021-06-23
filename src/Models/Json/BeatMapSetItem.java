package Models.Json;

import java.util.List;

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
}
