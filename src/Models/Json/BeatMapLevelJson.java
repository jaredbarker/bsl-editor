package Models.Json;

import Models.Event;
import Models.Note;
import Models.Obstacle;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BeatMapLevelJson {
    private String _version;
    private List<Event> _events;
    private List<Note> _notes;
    private List<Integer> _waypoints;
    private List<Obstacle> _obstacles;
    private KeyWordFilters _specialEventsKeywordFilters;

    public BeatMapLevelJson() {
        this._version = "2.2.0";
        this._events = new ArrayList<Event>();
        this._notes = new ArrayList<>();
        this._waypoints = new ArrayList<>();
        this._obstacles = new ArrayList<Obstacle>();
        this._specialEventsKeywordFilters = new KeyWordFilters();
    }

    public String get_version() {
        return _version;
    }

    public void set_version(String _version) {
        this._version = _version;
    }

    public List<Event> get_events() {
        return _events;
    }

    public void set_events(List<Event> _events) {
        this._events = _events;
    }

    public List<Note> get_notes() {
        return _notes;
    }

    public void set_notes(List<Note> _notes) {
        this._notes = _notes;
    }

    public List<Integer> get_waypoints() {
        return _waypoints;
    }

    public void set_waypoints(List<Integer> _waypoints) {
        this._waypoints = _waypoints;
    }

    public List<Obstacle> get_obstacles() {
        return _obstacles;
    }

    public void set_obstacles(List<Obstacle> _obstacles) {
        this._obstacles = _obstacles;
    }

    public KeyWordFilters get_specialEventsKeywordFilters() {
        return _specialEventsKeywordFilters;
    }

    public void set_specialEventsKeywordFilters(KeyWordFilters _specialEventsKeywordFilters) {
        this._specialEventsKeywordFilters = _specialEventsKeywordFilters;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BeatMapLevelJson that = (BeatMapLevelJson) o;
        return Objects.equals(_version, that._version) &&
                Objects.equals(_events, that._events) &&
                Objects.equals(_notes, that._notes) &&
                Objects.equals(_waypoints, that._waypoints) &&
                Objects.equals(_obstacles, that._obstacles) &&
                Objects.equals(_specialEventsKeywordFilters, that._specialEventsKeywordFilters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_version, _events, _notes, _waypoints, _obstacles, _specialEventsKeywordFilters);
    }
}
