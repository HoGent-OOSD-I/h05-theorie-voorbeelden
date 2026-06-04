package main;

import cui.DobbelspelApplicatie;
import domein.DomeinController;

public class StartUp {

	public static void main(String[] args) {	
		// creatie aanspreekpunt domeinlaag
		DomeinController dc = new DomeinController();
		// creatie applicatie
		DobbelspelApplicatie da = new DobbelspelApplicatie(dc);
		// oproepen methode om applicatie te starten
		da.startDobbelspel();
		
		// kan ook in 1 instructie:
		// new DobbelsteenApplicatie(new DomeinController()).startDobbelspel();
	}
}
