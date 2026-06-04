package cui;

import domein.DomeinController;

import java.util.Scanner;

public class DobbelspelApplicatie {
	private DomeinController dc;
    private Scanner scanner = new Scanner(System.in);
	
	public DobbelspelApplicatie(DomeinController dc) {
		this.dc = dc;
	}

    public void startDobbelspelApplicatie(){
        String[] menu = {"Stoppen","Speel spel", "Registreer speler"};

        int keuzeMenu = kiesUitMenu(menu);
        while(keuzeMenu != 0){
            switch (keuzeMenu){
                case 1 -> speelSpel();
                case 2 -> registreerSpeler();
            }
            System.out.println();
            keuzeMenu = kiesUitMenu(menu);
        }
    }

    private void speelSpel() {
        dc.startNieuwSpel();
        while(!dc.isEindeSpel()) {
            dc.rolDobbelstenen();

            System.out.printf("Aantal ogen van de worp: %d.%n", dc.geefAantalOgenWorp());
        }
        System.out.printf("Score: %d.%n", dc.geefScore());
    }

    private void registreerSpeler() {
        scanner.nextLine();     // buffer voor inlezen tekst na getal
        String naam = leesTekst("naam");
        String voornaam = leesTekst("voornaam");
        String email = leesTekst("email");
        int geboortejaar = leesGeboortejaar();
        scanner.nextLine();     // buffer voor inlezen tekst na getal

        String wachtwoord, bevestigingWachtwoord;
        boolean wachtwoordenZijnGelijk;
        do{
            wachtwoord = leesTekst("wachtwoord");
            bevestigingWachtwoord = leesTekst("bevestiging wachtwoord");

            wachtwoordenZijnGelijk = wachtwoord.equals(bevestigingWachtwoord);
            if(!wachtwoordenZijnGelijk)
                System.out.println("Wachtwoord en bevestiging wachtwoord moeten gelijk zijn!");
        }while(!wachtwoordenZijnGelijk);

        dc.registreer(naam, voornaam, email, geboortejaar, wachtwoord, bevestigingWachtwoord);

        System.out.println("Speler is geregistreerd als het e-mailadres nog niet in gebruik was!");
    }

    private int leesGeboortejaar() {
        System.out.print("Geef de waarde in voor geboortejaar: ");
        return scanner.nextInt();
    }

    private String leesTekst(String wat) {
        System.out.printf("Geef de waarde in voor %s: ", wat);
        return scanner.nextLine();
    }

    private int kiesUitMenu(String[] menu) {
        System.out.println("Maak uw keuze: ");
        for(int i = 0; i<menu.length; i++){
            System.out.printf("%d. %s%n", i, menu[i]);
        }

        boolean isJuist;
        int keuze;
        do{
            System.out.printf("Kies een optie tussen 0 en %d uit bovenstaand menu: ", menu.length-1);
            keuze = scanner.nextInt();

            isJuist = keuze >= 0 && keuze < menu.length;
        }while(!isJuist);
        return keuze;
    }
}