package ca.gc.dfo.spine.coordinates;

import ca.gc.dfo.spine.utils.Maths;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MercatorENTests {
    @Test
    void testConstructors() {
        final MercatorEN xy1 = new MercatorEN(23, -35);
        Assertions.assertEquals(23, xy1.x);
        Assertions.assertEquals(-35, xy1.y);

        final LatitudeLongitude ll = new LatitudeLongitude(45.2152366, -74.0495747);
        final MercatorEN xy2 = new MercatorEN(ll);
        //noinspection SuspiciousNameCombination
        Assertions.assertTrue(Maths.closeTo(574627.046495924, xy2.x));
        Assertions.assertTrue(Maths.closeTo(5007300.2418381022, xy2.y));
    }

    @Test
    void testDistance() {
        //46.745816, -71.289338 - 46.745816, -71.292653 - 253.46744659071715
        final LatitudeLongitude ll1 = new LatitudeLongitude(46.745816, -71.289338);
        final LatitudeLongitude ll2 = new LatitudeLongitude(46.745816, -71.292653);

        final MercatorEN xy1 = new MercatorEN(ll1);
        final MercatorEN xy2 = new MercatorEN(ll2);

        final double distance = MercatorEN.distance(xy1, xy2);
        //Assertions.assertEquals(251.79, distance);
        Assertions.assertTrue(Maths.closeTo(253.47, distance, 0.01));
    }
}