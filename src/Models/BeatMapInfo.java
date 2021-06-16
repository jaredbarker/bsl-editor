package Models;

import java.util.ArrayList;
import java.util.List;

public class BeatMapInfo {
    private String _version;
    private List<Integer> _events;
    private List<Note> _notes;
    private List<Integer> _waypoints;
    private List<Integer> _obstacles;
    private int _specialEventsKeywordFilters;

    public BeatMapInfo() {
        this._version = "";
        this._events = new ArrayList<>();
        this._notes = new ArrayList<>();
        this._waypoints = new ArrayList<>();
        this._obstacles = new ArrayList<>();
        this._specialEventsKeywordFilters = 0;
    }

    public String get_version() {
        return _version;
    }

    public void set_version(String _version) {
        this._version = _version;
    }

    public List<Integer> get_events() {
        return _events;
    }

    public void set_events(List<Integer> _events) {
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

    public List<Integer> get_obstacles() {
        return _obstacles;
    }

    public void set_obstacles(List<Integer> _obstacles) {
        this._obstacles = _obstacles;
    }

    public int get_specialEventsKeywordFilters() {
        return _specialEventsKeywordFilters;
    }

    public void set_specialEventsKeywordFilters(int _specialEventsKeywordFilters) {
        this._specialEventsKeywordFilters = _specialEventsKeywordFilters;
    }
}
