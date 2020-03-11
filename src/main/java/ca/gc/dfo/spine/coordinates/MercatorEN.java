package ca.gc.dfo.spine.coordinates;

public class MercatorEN {
    public double x, y;

    public MercatorEN(final double _x, final double _y) { x = _x; y = _y; }
    public MercatorEN(final LatitudeLongitude latLon)
    {
        final double Deg2Rad = 180.0 / Math.PI; // Transformation DEG-RAD
        final double Zone = 18.0;
        final double L0 = (183.0 - Zone * 6.0) / Deg2Rad; // Meridien central de la zone UTM
        final double Axe = 6378137.0; // Demi grand axe de l'ellipsoide
        final double Bxe = 6356752.31414; // Demi petit axe
        final double K0 = 0.9996; // Facteur echelle au meridien central
        final double X0 = 500000.0; // Abscisse au meridien central

        final double Axe2 = Axe*Axe;
        final double Bxe2 = Bxe*Bxe;
        final double ep2 = (Axe2 - Bxe2) / Bxe2;
        final double e4 = ep2 * ep2;
        final double e6 = e4 * ep2;
        final double e8 = e4 * e4;
        final double Rp = Axe2 / Bxe;
        final double A0 = 1.0 - 3.0 / 4.0 * ep2 + 45.0 / 64.0 * e4 - 175.0 / 256.0 * e6 + 11025.0 / 16384.0 * e8;
        final double d2 = 1.0 - 5.0 / 4.0 * ep2 + 175.0 / 128.0 * e4 - 735.0 / 512.0 * e6;
        final double d4 = 1.0 - 7.0 / 4.0 * ep2 + 147.0 / 64.0 * e4;
        final double d6 = 1.0 - 9.0 / 4.0 * ep2;

        final double latRad = latLon.latitude / Deg2Rad; // Latitude en RAD
        final double lonRad = Math.abs(latLon.longitude) / Deg2Rad; // Longitude en RAD
        final double FNB = A0 * Rp * latRad - 3.0 / 8.0 * d2 * Rp * ep2 * Math.sin(2.0 * latRad) + 15.0 / 256.0 * d4 * Rp * e4 * Math.sin(4.0 * latRad) - 35.0 / 3072.0 * d6 * Rp * e6 * Math.sin(6.0 * latRad); // longueur de l'arc Meridien
        // Transformation LATLONG-UTM
        final double dl = L0 - lonRad; // Ecart entre le meridien central et la longitude du point
        final double cp2 = Math.pow(Math.cos(latRad), 2.0);
        final double a1 = Rp / Math.sqrt(1.0 / cp2 + ep2);
        final double _x = (a1 * dl + a1 / 6.0 * (2.0 * cp2 - 1.0 + ep2 * Math.pow(cp2, 2.0)) * Math.pow(dl, 3.0) + a1 / 120.0 * (1.0 - 20.0 * cp2 + (24.0 - 58.0 * ep2) * Math.pow(cp2, 2.0) + 72.0 * ep2 * Math.pow(cp2, 3.0)) * Math.pow(dl, 5.0));
        final  double a2 = a1 * Math.sin(latRad) / 2.0;
        final  double _y = (FNB + a2 * Math.pow(dl, 2.0) + a2 / 12.0 * (6.0 * cp2 - 1.0 + 9.0 * ep2 * Math.pow(cp2, 2.0) + 4.0 * e4 * Math.pow(cp2, 3.0)) * Math.pow(dl, 4.0) + a2 / 360.0 * (1.0 - 60.0 * cp2 + 120.0 * Math.pow(cp2, 2.0)) * Math.pow(dl, 6.0));
        x = Math.abs(_x * K0 + X0);
        y = Math.abs(_y * K0);
    }
}
