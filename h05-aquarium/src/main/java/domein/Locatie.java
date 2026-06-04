package domein;

public class Locatie {

	private String postcode;
	private String naam;

	public Locatie(String postcode, String naam) {
		throw new UnsupportedOperationException();
	}
	
	public String getNaam() {
		return this.naam;
	}

	private void setNaam(String naam) {
		this.naam = naam;
	}

}