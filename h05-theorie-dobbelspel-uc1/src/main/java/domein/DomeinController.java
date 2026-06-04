package domein;

public class DomeinController {

	private Spel spel;  
	
	public void startNieuwSpel() { setSpel(new Spel()); }

	public void rolDobbelstenen() { spel.rolDobbelstenen(); } //<1>
	
	public int geefAantalOgenWorp() { return spel.geefAantalOgenWorp();	} //<2>
	
	public int geefScore() { return spel.getScore(); } //<3>
	
	public boolean isEindeSpel(){ return spel.isEindeSpel(); } //<4>
	
	private void setSpel(Spel spel) { this.spel = spel;}
}