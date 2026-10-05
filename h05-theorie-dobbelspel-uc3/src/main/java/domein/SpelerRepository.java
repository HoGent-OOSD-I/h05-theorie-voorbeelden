package domein;

import java.util.ArrayList;
import java.util.List;

public class SpelerRepository {

    private List<Speler> spelers;

    public SpelerRepository(){
        spelers = new ArrayList<>();
    }

    public void voegSpelerToe(Speler s) {
        for(Speler speler: spelers){
            if(speler.getEmail().equals(s.getEmail()))
                throw new IllegalArgumentException("Email is al in gebruik!");
        }

        spelers.add(s);
    }

    public Speler geefSpeler(String email, String wachtwoord){
        for(Speler speler: spelers){
            if(speler.getEmail().equals(email) && speler.getWachtwoord().equals(wachtwoord))
                return speler;
        }
        throw new IllegalArgumentException("Geen gebruiker gevonden met deze combinatie van email & wachtwoord!");
    }
}
