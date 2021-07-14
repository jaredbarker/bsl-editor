package Models;

import java.util.Objects;

public class Event {
    private double _time;
    private int _type;
    private int _value;

    public Event(double _time, int _type, int _value) {
        this._time = _time;
        this._type = _type;
        this._value = _value;
    }

    public double get_time() {
        return _time;
    }

    public void set_time(double _time) {
        this._time = _time;
    }

    public int get_type() {
        return _type;
    }

    public void set_type(int _type) {
        this._type = _type;
    }

    public int get_value() {
        return _value;
    }

    public void set_value(int _value) {
        this._value = _value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Double.compare(event._time, _time) == 0 &&
                _type == event._type &&
                _value == event._value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(_time, _type, _value);
    }
}
