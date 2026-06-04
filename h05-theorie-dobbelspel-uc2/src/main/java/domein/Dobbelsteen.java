package domein;

import java.security.SecureRandom;

public class Dobbelsteen {
    private int aantalOgen;
    private SecureRandom sr;

    private static final int AANTAL_ZIJDEN = 6;

    public Dobbelsteen() {
        this.aantalOgen = 1;
        sr = new SecureRandom();
    }

    public void rol() {
        this.aantalOgen = sr.nextInt(1,AANTAL_ZIJDEN+1);
    }

    public int getAantalOgen() { return aantalOgen; }
}