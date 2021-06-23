package Utils;

import Models.Json.BeatMapLevelJson;
import junit.framework.TestCase;

public class JsonHandlerTest extends TestCase {
    private BeatMapLevelJson map;

    public void setUp() throws Exception {
        map = new BeatMapLevelJson();
        super.setUp();
    }

    public void tearDown() throws Exception {
    }

    public void testToJson() {
        System.out.println(JsonHandler.toJson(map));
    }

    public void testFromJson() {
    }
}