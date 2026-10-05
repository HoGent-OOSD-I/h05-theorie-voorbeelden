package cui;

import domein.DomeinController;

public class DobbelspelApplicatie {
    private DomeinController dc;
	
	public DobbelspelApplicatie(DomeinController dc) {
		this.dc = dc;
	}

    public void startDobbelspelApplicatie(){
        String[] menu = {"Stoppen", "Registreer speler", "Meld aan", "Speel spel"};
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
        IO.println("Deze optie wordt uitgewerkt in UC2.");
    }

    private void meldAan() {
        IO.println("Deze optie wordt uitgewerkt in UC3.");
    }
}