package cui;

import domein.DomeinController;

import java.util.Scanner;

public class DobbelspelApplicatie {
    private Scanner invoer = new Scanner(System.in);
    private DomeinController dc;
	
	public DobbelspelApplicatie(DomeinController dc) {
		this.dc = dc;
	}

    public void startDobbelspel(){
        String[] menu = {"Registreer speler", "Speel spel", "Stoppen"};
        int keuze = invoerKeuze(menu);
        while (keuze != menu.length)
        {
            switch (keuze) {
                case 1 -> registreerSpeler();
                case 2 -> speelSpel();
            }
            System.out.println();
            keuze = invoerKeuze(menu);
        }
        System.out.println("Tot volgende keer!");
    }

    private int invoerKeuze(String[] menu)
    {
        int keuze;
        boolean isGeldig;
        do {
            for(int nrMenu = 0; nrMenu < menu.length; nrMenu++){
                System.out.printf("%d. %s%n", nrMenu+1, menu[nrMenu]);
            }
            System.out.printf("Geef je keuze (%d-%d): ", 1, menu.length);
            keuze = invoer.nextInt();
            isGeldig = keuze >= 1 && keuze <= menu.length;
        } while (!isGeldig);
        return keuze;
    }

    private void registreerSpeler() {
        invoer.nextLine();  // buffer voor inlezen tekst na getal
        String voornaam = leesTekst("voornaam");
        String naam = leesTekst("naam");
        String email = leesTekst("email");
    }

    private String leesTekst(String naam) {
        System.out.printf("Geef %s in: ", naam);
        return invoer.nextLine();
    }

    private void speelSpel() {
		dc.startNieuwSpel();
		while(!dc.isEindeSpel()) {
			dc.rolDobbelstenen();
			
			System.out.printf("Aantal ogen van de worp: %d.%n", dc.geefAantalOgenWorp());
		}
		System.out.printf("Score: %d.%n", dc.geefScore());		
	}
}