package domein;

public class Speler {

    private String naam;
    private String voornaam;
    private String email;
    private int geboortejaar;
    private String wachtwoord;
    private double krediet;
    private boolean adminrechten;

    private static final double DEFAULT_KREDIET = 5.0;
    private static final int HUIDIG_JAAR = 2026;    // momenteel enige oplossing als we de klasse Speler ook zouden willen testen.
    private static final int MINIMUM_LEEFTIJD = 18;

    public Speler(String naam, String voornaam, String email, int geboortejaar, String wachtwoord, String bevestigingWachtwoord) {
        setNaam(naam);
        setVoornaam(voornaam);
        setEmail(email);
        stelWachtwoordIn(wachtwoord, bevestigingWachtwoord);
        setGeboortejaar(geboortejaar);
        krediet = DEFAULT_KREDIET;
        adminrechten = false;
    }

    private void setNaam(String naam) {
        controleerTekstIngevuld(naam);
        this.naam = naam;
    }

    private void setVoornaam(String voornaam) {
        controleerTekstIngevuld(voornaam);
        this.voornaam = voornaam;
    }

    private void setEmail(String email) {
        // controle op een geldig e-mailadres is met de huidige kennis nog niet mogelijk, we controleren hier nu alleen of email ingevuld is.
        controleerTekstIngevuld(email);
        this.email = email;
    }

    private void setGeboortejaar(int geboortejaar) {
        if(HUIDIG_JAAR - geboortejaar >= MINIMUM_LEEFTIJD)
            this.geboortejaar = geboortejaar;
    }

    private void stelWachtwoordIn(String wachtwoord, String bevestigingWachtwoord) {
        controleerTekstIngevuld(wachtwoord);
        if(!wachtwoord.equals(bevestigingWachtwoord))       // controle gebeurt al in applicatie, maar MOET sowieso in domein staan.
            throw new IllegalArgumentException("Wachtwoord en wachtwoord bevestiging moeten gelijk zijn!");
        this.wachtwoord = wachtwoord;
    }

    private void controleerTekstIngevuld(String teControlerenWaarde){
        if(teControlerenWaarde == null || teControlerenWaarde.isBlank())
            throw new IllegalArgumentException("Gevraagde waarde mag niet leeg zijn!");
    }

    public String getEmail() {
        return email;
    }
    public String getNaam() {
        return naam;
    }
    public String getVoornaam() {
        return voornaam;
    }
    public String getWachtwoord() {
        return wachtwoord;
    }
    public double getKrediet() {
        return krediet;
    }
    public boolean isAdminrechten() {
        return adminrechten;
    }
}
