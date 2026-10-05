package cui;

import domein.DomeinController;
import dtos.SpelerDTO;

public class DobbelspelApplicatie {
	private DomeinController dc;

	public DobbelspelApplicatie(DomeinController dc) {
		this.dc = dc;
	}

    public void startDobbelspelApplicatie(){
        String[] menu = {"Stoppen", "Registreer speler", "Meld aan"};
        int keuze = kiesUitMenu(menu);
        while (keuze != 0) {
            switch (keuze) {
                case 1 -> registreerSpeler();
                case 2 -> meldAan();
                case 3 -> speelSpel();
            }
            IO.println();
            keuze = kiesUitMenu(menu);
        }
        IO.println("Tot volgende keer!");
    }

    private int kiesUitMenu(String[] menu) {
        IO.println("Maak uw keuze: ");
        for(int i = 0; i<menu.length; i++){
            IO.println(String.format("%d. %s", i, menu[i]));
        }

        boolean isJuist;
        int keuze;
        do{
            keuze = Integer.parseInt(IO.readln(String.format("Kies een optie tussen 0 en %d uit bovenstaand menu: ", menu.length-1)));

            isJuist = keuze >= 0 && keuze < menu.length;
        }while(!isJuist);
        return keuze;
    }

    private void speelSpel() {
        dc.startNieuwSpel();
        while(!dc.isEindeSpel()) {
            dc.rolDobbelstenen();

            IO.println(String.format("Aantal ogen van de worp: %d.", dc.geefAantalOgenWorp()));
        }
        IO.println(String.format("Score: %d.", dc.geefScore()));
    }

    private void registreerSpeler() {
        String naam = leesTekst("naam");
        String voornaam = leesTekst("voornaam");
        String email = leesTekst("email");
        int geboortejaar = leesGeboortejaar();

        String wachtwoord, bevestigingWachtwoord;
        boolean wachtwoordenZijnGelijk;
        do{
            wachtwoord = leesTekst("wachtwoord");
            bevestigingWachtwoord = leesTekst("bevestiging wachtwoord");

            wachtwoordenZijnGelijk = wachtwoord.equals(bevestigingWachtwoord);
            if(!wachtwoordenZijnGelijk)
                IO.println("Wachtwoord en bevestiging wachtwoord moeten gelijk zijn!");
        }while(!wachtwoordenZijnGelijk);

        dc.registreer(naam, voornaam, email, geboortejaar, wachtwoord, bevestigingWachtwoord);

        IO.println("Speler is geregistreerd als het e-mailadres nog niet in gebruik was!");
    }

    private int leesGeboortejaar() {
        return Integer.parseInt(IO.readln("Geef de waarde in voor geboortejaar: "));
    }

    private String leesTekst(String wat) {
        return IO.readln(String.format("Geef de waarde in voor %s: ", wat));
    }

    private void meldAan() {
        String email = leesTekst("email");
        String wachtwoord = leesTekst("wachtwoord");

        dc.meldAan(email, wachtwoord);
        SpelerDTO aangemeldeSpeler = dc.geefSpeler();
        if(aangemeldeSpeler == null)
            IO.println("Aanmelden met deze gegevens is niet mogelijk.");
        else {
            IO.println(String.format("Gebruiker %s %s is aangemeld, heeft %s adminrechten en %.2f krediet.",
                    aangemeldeSpeler.voornaam(), aangemeldeSpeler.naam(),
                    aangemeldeSpeler.adminrechten()? "wel": "geen",
                    aangemeldeSpeler.krediet()));
            startActiesAangemeldeSpeler(aangemeldeSpeler);
        }
    }

    private void startActiesAangemeldeSpeler(SpelerDTO aangemeldeSpeler){
        String[] menu;
        if (aangemeldeSpeler.adminrechten())
            menu = new String[]{"Afmelden", "Speel spel", "Dien kredietaanvraag in", "Behandel kredietaanvraag"};
        else
            menu = new String[]{"Afmelden", "Speel spel", "Dien kredietaanvraag in"};

        int keuzeMenu = kiesUitMenu(menu);
        while (keuzeMenu != 0) {
            switch (keuzeMenu) {
                case 1 -> speelSpel();
                case 2 -> IO.println("Indienen kredietaanvraag is momenteel nog niet mogelijk");
                case 3 -> IO.println("Behandelen kredietaanvraag is momenteel nog niet mogelijk");
            }
            IO.println();
            keuzeMenu = kiesUitMenu(menu);
        }
    }
}