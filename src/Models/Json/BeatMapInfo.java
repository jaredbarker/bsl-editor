package Models.Json;

import java.util.ArrayList;
import java.util.List;

public class BeatMapInfo {
    private String _version;
    private String _songName;
    private String _songSubName;
    private String _songAuthorName;
    private String _levelAuthorName;
    private int _beatsPerMinute;
    private double _songTimeOffset;
    private double _shuffle;
    private double _shufflePeriod;
    private double _previewStartTime;
    private double _previewDuration;
    private String _songFilename;
    private String _coverImageFilename;
    private String _environmentName;
    private String _allDirectionsEnvironmentName;
    private List<BeatMapSetItem> _difficultyBeatmapSets;

    public BeatMapInfo() {
        this._version = "";
        this._songName = "";
        this._songSubName = "";
        this._songAuthorName = "";
        this._levelAuthorName = "";
        this._beatsPerMinute = 0;
        this._songTimeOffset = 0.0;
        this._shuffle = 0.0;
        this._shufflePeriod = 0.0;
        this._previewStartTime = 0.0;
        this._previewDuration = 0.0;
        this._songFilename = "";
        this._coverImageFilename = "";
        this._environmentName = "";
        this._allDirectionsEnvironmentName = "";
        this._difficultyBeatmapSets = new ArrayList<>();
    }

    public BeatMapInfo(String _version, String _songName, String _songSubName, String _songAuthorName, String _levelAuthorName, int _beatsPerMinute, double _songTimeOffset, double _shuffle, double _shufflePeriod, double _previewStartTime, double _previewDuration, String _songFilename, String _coverImageFilename, String _environmentName, String _allDirectionsEnvironmentName, List<BeatMapSetItem> _difficultyBeatmapSets) {
        this._version = _version;
        this._songName = _songName;
        this._songSubName = _songSubName;
        this._songAuthorName = _songAuthorName;
        this._levelAuthorName = _levelAuthorName;
        this._beatsPerMinute = _beatsPerMinute;
        this._songTimeOffset = _songTimeOffset;
        this._shuffle = _shuffle;
        this._shufflePeriod = _shufflePeriod;
        this._previewStartTime = _previewStartTime;
        this._previewDuration = _previewDuration;
        this._songFilename = _songFilename;
        this._coverImageFilename = _coverImageFilename;
        this._environmentName = _environmentName;
        this._allDirectionsEnvironmentName = _allDirectionsEnvironmentName;
        this._difficultyBeatmapSets = _difficultyBeatmapSets;
    }

    public String get_version() {
        return _version;
    }

    public void set_version(String _version) {
        this._version = _version;
    }

    public String get_songName() {
        return _songName;
    }

    public void set_songName(String _songName) {
        this._songName = _songName;
    }

    public String get_songSubName() {
        return _songSubName;
    }

    public void set_songSubName(String _songSubName) {
        this._songSubName = _songSubName;
    }

    public String get_songAuthorName() {
        return _songAuthorName;
    }

    public void set_songAuthorName(String _songAuthorName) {
        this._songAuthorName = _songAuthorName;
    }

    public String get_levelAuthorName() {
        return _levelAuthorName;
    }

    public void set_levelAuthorName(String _levelAuthorName) {
        this._levelAuthorName = _levelAuthorName;
    }

    public int get_beatsPerMinute() {
        return _beatsPerMinute;
    }

    public void set_beatsPerMinute(int _beatsPerMinute) {
        this._beatsPerMinute = _beatsPerMinute;
    }

    public double get_songTimeOffset() {
        return _songTimeOffset;
    }

    public void set_songTimeOffset(double _songTimeOffset) {
        this._songTimeOffset = _songTimeOffset;
    }

    public double get_shuffle() {
        return _shuffle;
    }

    public void set_shuffle(double _shuffle) {
        this._shuffle = _shuffle;
    }

    public double get_shufflePeriod() {
        return _shufflePeriod;
    }

    public void set_shufflePeriod(double _shufflePeriod) {
        this._shufflePeriod = _shufflePeriod;
    }

    public double get_previewStartTime() {
        return _previewStartTime;
    }

    public void set_previewStartTime(double _previewStartTime) {
        this._previewStartTime = _previewStartTime;
    }

    public double get_previewDuration() {
        return _previewDuration;
    }

    public void set_previewDuration(double _previewDuration) {
        this._previewDuration = _previewDuration;
    }

    public String get_songFilename() {
        return _songFilename;
    }

    public void set_songFilename(String _songFilename) {
        this._songFilename = _songFilename;
    }

    public String get_coverImageFilename() {
        return _coverImageFilename;
    }

    public void set_coverImageFilename(String _coverImageFilename) {
        this._coverImageFilename = _coverImageFilename;
    }

    public String get_environmentName() {
        return _environmentName;
    }

    public void set_environmentName(String _environmentName) {
        this._environmentName = _environmentName;
    }

    public String get_allDirectionsEnvironmentName() {
        return _allDirectionsEnvironmentName;
    }

    public void set_allDirectionsEnvironmentName(String _allDirectionsEnvironmentName) {
        this._allDirectionsEnvironmentName = _allDirectionsEnvironmentName;
    }

    public List<BeatMapSetItem> get_difficultyBeatmapSets() {
        return _difficultyBeatmapSets;
    }

    public void set_difficultyBeatmapSets(List<BeatMapSetItem> _difficultyBeatmapSets) {
        this._difficultyBeatmapSets = _difficultyBeatmapSets;
    }
}
