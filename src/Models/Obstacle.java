package Models;

import java.util.Objects;

public class Obstacle {
    private double _time;
    private int _lineIndex;
    private int _type;
    private double _duration;
    private int _width;

    public Obstacle(double _time, int _lineIndex, int _type, double _duration, int _width) {
        this._time = _time;
        this._lineIndex = _lineIndex;
        this._type = _type;
        this._duration = _duration;
        this._width = _width;
    }

    public double get_time() {
        return _time;
    }

    public void set_time(double _time) {
        this._time = _time;
    }

    public int get_lineIndex() {
        return _lineIndex;
    }

    public void set_lineIndex(int _lineIndex) {
        this._lineIndex = _lineIndex;
    }

    public int get_type() {
        return _type;
    }

    public void set_type(int _type) {
        this._type = _type;
    }

    public double get_duration() {
        return _duration;
    }

    public void set_duration(double _duration) {
        this._duration = _duration;
    }

    public int get_width() {
        return _width;
    }

    public void set_width(int _width) {
        this._width = _width;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Obstacle obstacle = (Obstacle) o;
        return Double.compare(obstacle._time, _time) == 0 &&
                _lineIndex == obstacle._lineIndex &&
                _type == obstacle._type &&
                Double.compare(obstacle._duration, _duration) == 0 &&
                _width == obstacle._width;
    }

    @Override
    public int hashCode() {
        return Objects.hash(_time, _lineIndex, _type, _duration, _width);
    }
}
