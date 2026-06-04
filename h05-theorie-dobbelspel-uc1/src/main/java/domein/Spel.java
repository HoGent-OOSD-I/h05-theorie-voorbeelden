package domein;

import java.util.ArrayList;
import java.util.List;

public class Spel {

	private int score;
	private int eersteWorp;
	private List<Dobbelsteen> dobbelstenen;

    private static final int AANTAL_DOBBELSTENEN = 2;

	public Spel() {
		this.score = -1;
		this.eersteWorp = 0;

		dobbelstenen = new ArrayList<>();
		for (int i = 1; i <= AANTAL_DOBBELSTENEN; i++)
			dobbelstenen.add(new Dobbelsteen());
	}

	public void rolDobbelstenen() { //<1>
		int aantalOgenHuidigeWorp = 0;
		for (Dobbelsteen d : dobbelstenen) {
			d.rol();
			aantalOgenHuidigeWorp += d.getAantalOgen();
		}
		bepaalScore(aantalOgenHuidigeWorp);
		bepaalEersteWorp(aantalOgenHuidigeWorp);
	}

	private void bepaalEersteWorp(int aantalOgenWorp) { //<2>
		if (isEersteWorp()) {
			this.eersteWorp = aantalOgenWorp;
		}
	}

	private void bepaalScore(int aantalOgenWorp) { //<3>
		if (isEersteWorp() && (aantalOgenWorp == 7 || aantalOgenWorp == 11))
			this.score = 2;
		else if (aantalOgenWorp == 7 || aantalOgenWorp == 11)
            this.score = 0;
		else if (aantalOgenWorp == eersteWorp)
            this.score = 1;
	}

    private boolean isEersteWorp(){
        return eersteWorp == 0;
    }

	public int geefAantalOgenWorp() {  //<4>
		int aantalOgenHuidigeWorp = 0;
		for (Dobbelsteen d : dobbelstenen) {
			aantalOgenHuidigeWorp += d.getAantalOgen();
		}
		return aantalOgenHuidigeWorp;
	}

	public int getScore() { //<5>
		return score;
	}
	
	public boolean isEindeSpel(){	//<6>
		return (score >=0 && score <=2);
	}
}