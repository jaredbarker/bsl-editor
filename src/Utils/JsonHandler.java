package Utils;

import Models.Json.BeatMapInfo;
import Models.Json.BeatMapLevelJson;
import com.google.gson.Gson;

public class JsonHandler {
    private static Gson gson;
    //this is where the problem is :) object vs T generic
    public static String toJson(Object beatMap) {
        gson = new Gson();
        String res = gson.toJson(beatMap);
        return res;
    }
    /*
    public static BeatMapLevelJson fromJson(String input, BeatMapLevelJson beatMap) {
        gson = new Gson();
        beatMap = gson.fromJson(input, beatMap.getClass());
        return beatMap;
    }

    public static BeatMapInfo fromJson(String input, BeatMapInfo beatMapInfo) {
        gson = new Gson();
        beatMapInfo = gson.fromJson(input, beatMapInfo.getClass());
        return beatMapInfo;
    }
    */
    public static <T> T fromJson(String input, Class<T> classOfT) {
        gson = new Gson();
        T beatMap;
        beatMap = gson.fromJson(input, classOfT);
        return beatMap;
    }
}
