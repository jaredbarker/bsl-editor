package Models;

import java.util.Objects;

public class Note {
    private double _time;
    private int _lineIndex;
    private int _lineLayer;
    private int _type;
    private int _cutDirection;

    public Note(double _time, int _lineIndex, int _lineLayer, int _type, int _cutDirection) {
        this._time = _time;
        this._lineIndex = _lineIndex;
        this._lineLayer = _lineLayer;
        this._type = _type;
        this._cutDirection = _cutDirection;
    }
    //TODO override compare function

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

    public int get_lineLayer() {
        return _lineLayer;
    }

    public void set_lineLayer(int _lineLayer) {
        this._lineLayer = _lineLayer;
    }

    public int get_type() {
        return _type;
    }

    public void set_type(int _type) {
        this._type = _type;
    }

    public int get_cutDirection() {
        return _cutDirection;
    }

    public void set_cutDirection(int _cutDirection) {
        this._cutDirection = _cutDirection;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return Double.compare(note._time, _time) == 0 &&
                _lineIndex == note._lineIndex &&
                _lineLayer == note._lineLayer &&
                _type == note._type &&
                _cutDirection == note._cutDirection;
    }

    @Override
    public int hashCode() {
        return Objects.hash(_time, _lineIndex, _lineLayer, _type, _cutDirection);
    }
}