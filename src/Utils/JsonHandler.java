package Utils;

import Models.BeatMapInfo;
import com.google.gson.Gson;

public class JsonHandler {
    private static Gson gson;
    public static String toJson(BeatMapInfo beatMap) {
        gson = new Gson();
        String res = gson.toJson(beatMap);
        return res;
    }

    public static BeatMapInfo fromJson(String input, BeatMapInfo beatMap) {
        gson = new Gson();
        beatMap = gson.fromJson(input, beatMap.getClass());
        return beatMap;
    }
}
