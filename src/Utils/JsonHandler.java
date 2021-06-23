package Utils;

import Models.Json.BeatMapLevelJson;
import com.google.gson.Gson;

public class JsonHandler {
    private static Gson gson;
    public static String toJson(Object beatMap) {
        gson = new Gson();
        String res = gson.toJson(beatMap);
        return res;
    }

    public static BeatMapLevelJson fromJson(String input, BeatMapLevelJson beatMap) {
        gson = new Gson();
        beatMap = gson.fromJson(input, beatMap.getClass());
        return beatMap;
    }
}
