package Models.Json;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class KeyWordFilters {

    private List<String> _keywords;

    public KeyWordFilters() {
        this._keywords = new ArrayList<>();
    }


    public List<String> get_keywords() {
        return _keywords;
    }

    public void set_keywords(List<String> _keywords) {
        this._keywords = _keywords;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KeyWordFilters that = (KeyWordFilters) o;
        return Objects.equals(_keywords, that._keywords);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_keywords);
    }
}
