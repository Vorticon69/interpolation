package ca.gc.dfo.spine.coordinates;


import ca.gc.dfo.spine.utils.Maths;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LatitudeLongitudeTests {
    @Test
    void testConstructors()
    {
        final LatitudeLongitude ll1 = new LatitudeLongitude(23,-35);
        Assertions.assertEquals(23, ll1.latitude);
        Assertions.assertEquals(-35, ll1.longitude);

        final MercatorEN xy = new MercatorEN(574627.046495924,5007300.2418381022);
        final LatitudeLongitude ll2 = new LatitudeLongitude(xy);
        Assertions.assertTrue(Maths.closeTo(45.2152366, ll2.latitude));
        Assertions.assertTrue(Maths.closeTo(-74.0495747, ll2.longitude));

        //46.745816, -71.289338 - 46.745816, -71.292653 - 251.79

    }
    @Test
    void testDistance()
    {
        //46.745816, -71.289338 - 46.745816, -71.292653 - 253.46744659071715
        final LatitudeLongitude ll1 = new LatitudeLongitude(46.745816, -71.289338);
        final LatitudeLongitude ll2 = new LatitudeLongitude(46.745816, -71.292653);

        final double distance = LatitudeLongitude.distance(ll1, ll2);
        //Assertions.assertEquals(251.79, distance);
        Assertions.assertTrue(Maths.closeTo(253.47, distance, 0.01));
    }
}
