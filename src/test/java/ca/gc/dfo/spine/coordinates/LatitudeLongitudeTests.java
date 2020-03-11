package ca.gc.dfo.spine.coordinates;


import ca.gc.dfo.spine.utils.Maths;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LatitudeLongitudeTests {
    @Test
    void testConstructors()
    {
        LatitudeLongitude ll = new LatitudeLongitude(23,-35);
        Assertions.assertEquals(23, ll.latitude);
        Assertions.assertEquals(-35, ll.longitude);

        // Québec bridge
        MercatorEN xy = new MercatorEN(574627.046495924,5007300.2418381022);
        ll = new LatitudeLongitude(xy);
        Assertions.assertTrue(Maths.closeTo(45.2152366, ll.latitude));
        Assertions.assertTrue(Maths.closeTo(-74.0495747, ll.longitude));
    }
}
