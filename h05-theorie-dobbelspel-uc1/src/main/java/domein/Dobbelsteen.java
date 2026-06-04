package domein;

import java.security.SecureRandom;

public class Dobbelsteen {
	private int aantalOgen;
	private SecureRandom sr; //<1>

    private static final int AANTAL_ZIJDEN = 6; //<1>

	public Dobbelsteen() {
		this.aantalOgen = 1;
		sr = new SecureRandom(); //<1>
	}

	public void rol() {
        this.aantalOgen = sr.nextInt(1,AANTAL_ZIJDEN+1);//<1>
    }

	public int getAantalOgen() { return aantalOgen; } //<2>
}