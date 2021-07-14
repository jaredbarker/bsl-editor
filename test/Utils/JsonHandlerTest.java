package Utils;

import Models.Event;
import Models.Json.BeatMapInfo;
import Models.Json.BeatMapLevelJson;
import Models.Note;
import Models.Note2DPosition;
import Models.Obstacle;
import junit.framework.TestCase;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class JsonHandlerTest extends TestCase {
    private BeatMapLevelJson map;
    private BeatMapInfo info;

    public void setUp() throws Exception {
        map = new BeatMapLevelJson();
        HashMap<Note2DPosition, Note> notes = new HashMap<>();
        map.set_notes(new ArrayList<>(Collections.singleton(new Note(22, 3, 2, 0, 0))));
        map.set_events(new ArrayList<>(Collections.singleton(new Event(22, 0, 1))));
        map.set_obstacles(new ArrayList<>(Collections.singleton(new Obstacle(22, 0, 1, 22.0, 2))));

        info = new BeatMapInfo();
        info.set_songFilename("test_file.wav");
        info.set_songName("test_file");

    }

    public void tearDown() throws Exception {
    }

    public void testToJsonBeatMapLevel() {
        BeatMapLevelJson in = map;
        String input = JsonHandler.toJson(in);
        BeatMapLevelJson out = JsonHandler.fromJson(input, BeatMapLevelJson.class);

        System.out.println(JsonHandler.toJson(in));
        System.out.println(JsonHandler.toJson(out));
        Assert.assertEquals(in, out);
    }


    public void testToJsonInfo() {
        BeatMapInfo in = info;
        String input = JsonHandler.toJson(in);
        BeatMapInfo out = JsonHandler.fromJson(input, BeatMapInfo.class);

        System.out.println(JsonHandler.toJson(in));
        System.out.println(JsonHandler.toJson(out));
        Assert.assertEquals(in, out);
    }

    public void testFromJson() {
    }
}