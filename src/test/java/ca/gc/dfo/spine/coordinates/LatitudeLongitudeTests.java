package ca.gc.dfo.spine.coordinates;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LatitudeLongitudeTests {
    @Test
    void testConstructors()
    {
        LatitudeLongitude ll = new LatitudeLongitude(23,-35);
        Assertions.assertEquals(23, ll.latitude);
        Assertions.assertEquals(-35, ll.longitude);
    }
}
