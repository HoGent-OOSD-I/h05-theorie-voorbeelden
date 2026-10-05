package main;

import cui.DobbelspelApplicatie;
import domein.DomeinController;

public class StartUp {

	void main() {
		// creatie aanspreekpunt domeinlaag
		DomeinController dc = new DomeinController();
		// creatie applicatie
		DobbelspelApplicatie da = new DobbelspelApplicatie(dc);
		// oproepen methode om applicatie te starten
		da.startDobbelspelApplicatie();
		
		// kan ook in 1 instructie:
		// new DobbelsteenApplicatie(new DomeinController()).startDobbelspelApplicatie();
	}
}
