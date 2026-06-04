package domein;

import dtos.SpelerDTO;

public class DomeinController {

    private Spel spel;
    private SpelerRepository spelerRepository;
    private Speler speler;

    public DomeinController() {
        spelerRepository = new SpelerRepository();
    }

	public void startNieuwSpel() { setSpel(new Spel()); }

	public void rolDobbelstenen() { spel.rolDobbelstenen(); }
	
	public int geefAantalOgenWorp() { return spel.geefAantalOgenWorp();	}
	
	public int geefScore() { return spel.getScore(); }
	
	public boolean isEindeSpel(){ return spel.isEindeSpel(); }

    public void registreer(String naam, String voornaam, String email, int geboortejaar, String wachtwoord, String bevestigingWachtwoord){
        Speler s = new Speler(naam, voornaam, email, geboortejaar, wachtwoord, bevestigingWachtwoord);
        spelerRepository.voegSpelerToe(s);
    }

    public void meldAan(String email, String wachtwoord){
        speler = spelerRepository.geefSpeler(email, wachtwoord);    //<1>
    }

    public SpelerDTO geefSpeler(){
        if(speler != null)  //<2>
            return new SpelerDTO(speler.getNaam(), speler.getVoornaam(), speler.getKrediet(), speler.isAdminrechten());
        return null;
    }
	
	private void setSpel(Spel spel) { this.spel = spel;}
}