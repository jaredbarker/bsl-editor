package Models.Json;

import java.util.ArrayList;
import java.util.List;

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
}
