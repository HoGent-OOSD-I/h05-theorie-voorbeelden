package domein;

public class Speler {

    private String naam = DEFAULT_STRING;
    private String voornaam = DEFAULT_STRING;
    private String email = DEFAULT_STRING;
    private int geboortejaar;
    private String wachtwoord = DEFAULT_STRING;
    private double krediet = DEFAULT_KREDIET;
    private boolean adminrechten = false;

    private static final String DEFAULT_STRING = "onbekend";
    private static final double DEFAULT_KREDIET = 5.0;
    private static final int HUIDIG_JAAR = 2025;    // momenteel enige oplossing als we de klasse Speler ook zouden willen testen.
    private static final int MINIMUM_LEEFTIJD = 18;

    public Speler(String naam, String voornaam, String email, int geboortejaar, String wachtwoord, String bevestigingWachtwoord) {
        setNaam(naam);
        setVoornaam(voornaam);
        setEmail(email);
        stelWachtwoordIn(wachtwoord, bevestigingWachtwoord);
        setGeboortejaar(geboortejaar);
    }

    private void setNaam(String naam) {
        if(naam!= null && !naam.isBlank())
            this.naam = naam;
    }

    private void setVoornaam(String voornaam) {
        if(voornaam!= null && !voornaam.isBlank())
            this.voornaam = voornaam;
    }

    private void setEmail(String email) {
        // controle op een geldig e-mailadres is met de huidige kennis nog niet mogelijk.
        if(email!= null && !email.isBlank())
            this.email = email;
    }

    private void setGeboortejaar(int geboortejaar) {
        if(HUIDIG_JAAR - geboortejaar >= MINIMUM_LEEFTIJD)
            this.geboortejaar = geboortejaar;
    }

    private void stelWachtwoordIn(String wachtwoord, String bevestigingWachtwoord) {
        if(wachtwoord!= null && !wachtwoord.isBlank() && wachtwoord.equals(bevestigingWachtwoord))
            this.wachtwoord = wachtwoord;
    }

    public String getEmail() {
        return email;
    }
}
