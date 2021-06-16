package Utils;

import Models.BeatMapInfo;
import junit.framework.TestCase;

public class JsonHandlerTest extends TestCase {
    private BeatMapInfo map;

    public void setUp() throws Exception {
        map = new BeatMapInfo();
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