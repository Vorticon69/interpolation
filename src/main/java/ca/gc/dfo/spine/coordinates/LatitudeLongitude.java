package ca.gc.dfo.spine.coordinates;

public class LatitudeLongitude {
    public double latitude, longitude;

    public LatitudeLongitude(final double _latitude, final double _longitude) { latitude = _latitude; longitude = _longitude; }
    public LatitudeLongitude(final MercatorEN mercator)
    {
        final double k0 = 0.9996;
        final double a = 6378137.0;
        final double b = 6356752.31414;
        final double a2 = a*a;
        final double eccSquared = (a2 - (b * b)) / a2;
        final double eccPrimeSquared = (eccSquared) / (1 - eccSquared);
        final double rad2deg = 180.0 / Math.PI;
        final double ZoneNumber = 18;
        final double LongOrigin = (ZoneNumber - 1) * 6 - 180 + 3; // +3 puts origin in middle of zone

        final double e1 = (1 - Math.sqrt(1 - eccSquared)) / (1 + Math.sqrt(1 - eccSquared));

        final double x = mercator.x - 500000.0; // remove 500,000 meter offset for longitude
        final double y = mercator.y;

        final double M = y / k0;
        final double mu = M / (a * (1 - eccSquared / 4 - 3 * eccSquared * eccSquared / 64 - 5 * eccSquared * eccSquared * eccSquared / 256));
        final double phiRad = mu + (3 * e1 / 2 - 27 * e1 * e1 * e1 / 32) * Math.sin(2 * mu) + (21 * e1 * e1 / 16 - 55 * e1 * e1 * e1 * e1 / 32) * Math.sin(4 * mu) + (151 * e1 * e1 * e1 / 96) * Math.sin(6 * mu);

        final double sinPhiRad = Math.sin(phiRad);
        final double sinPhiRad2 = Math.pow(sinPhiRad, 2);
        final double cosPhiRad = Math.cos(phiRad);
        final double cosPhiRad2 = Math.pow(cosPhiRad, 2);
        final double tanPhiRad = Math.tan(phiRad);
        final double tanPhiRad2 = Math.pow(tanPhiRad, 2);

        final double N1 = a / Math.sqrt(1 - eccSquared * sinPhiRad2);
        final double C1 = eccPrimeSquared * cosPhiRad2;
        final double R1 = a * (1 - eccSquared) / Math.pow(1 - eccSquared * sinPhiRad2, 1.5);
        final double D = x / (N1 * k0);

        final double lat = phiRad - (N1 * tanPhiRad / R1) * (D * D / 2 - (5 + 3 * tanPhiRad2 + 10 * C1 - 4 * C1 * C1 - 9 * eccPrimeSquared) * D * D * D * D / 24 + (61 + 90 * tanPhiRad2 + 298 * C1 + 45 * tanPhiRad2 * tanPhiRad2 - 252 * eccPrimeSquared - 3 * C1 * C1) * D * D * D * D * D * D / 720);

        final double lon = (D - (1 + 2 * tanPhiRad2 + C1) * D * D * D / 6 + (5 - 2 * C1 + 28 * tanPhiRad2 - 3 * C1 * C1 + 8 * eccPrimeSquared + 24 * tanPhiRad2 * tanPhiRad2) * D * D * D * D * D / 120) / cosPhiRad;
        latitude = lat*rad2deg;
        longitude = LongOrigin + lon*rad2deg;
    }
}
