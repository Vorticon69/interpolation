package ca.gc.dfo.spine.coordinates;

import ca.gc.dfo.spine.utils.Maths;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MercatorENTests {
    @Test
    void testConstructors()
    {
        MercatorEN xy = new MercatorEN(23,-35);
        Assertions.assertEquals(23, xy.x);
        Assertions.assertEquals(-35, xy.y);

        // Québec bridge
        LatitudeLongitude ll = new LatitudeLongitude(45.2152366,-74.0495747);
        xy = new MercatorEN(ll);
        //noinspection SuspiciousNameCombination
        Assertions.assertTrue(Maths.closeTo(574627.046495924, xy.x));
        Assertions.assertTrue(Maths.closeTo(5007300.2418381022, xy.y));
    }
}
