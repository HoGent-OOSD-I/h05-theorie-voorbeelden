package domein;

public class DomeinController {

    private Spel spel;
    private SpelerRepository spelerRepository;  //<1>

    public DomeinController() {
        spelerRepository = new SpelerRepository();  //<2>
    }

	public void startNieuwSpel() { setSpel(new Spel()); }

	public void rolDobbelstenen() { spel.rolDobbelstenen(); }
	
	public int geefAantalOgenWorp() { return spel.geefAantalOgenWorp();	}
	
	public int geefScore() { return spel.getScore(); }
	
	public boolean isEindeSpel(){ return spel.isEindeSpel(); }

    public void registreer(String naam, String voornaam, String email, int geboortejaar, String wachtwoord, String bevestigingWachtwoord){
        Speler s = new Speler(naam, voornaam, email, geboortejaar, wachtwoord, bevestigingWachtwoord); //<1>
        spelerRepository.voegSpelerToe(s);  //<2>
    }
	
	private void setSpel(Spel spel) { this.spel = spel;}
}