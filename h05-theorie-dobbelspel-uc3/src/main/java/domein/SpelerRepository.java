package domein;

import java.util.ArrayList;
import java.util.List;

public class SpelerRepository {

    private List<Speler> spelers;

    public SpelerRepository(){
        spelers = new ArrayList<>();
    }

    public void voegSpelerToe(Speler s) {
        boolean emailInGebruik = false;

        for(Speler speler: spelers){
            if(speler.getEmail().equals(s.getEmail()))
                emailInGebruik = true;
        }

        if(!emailInGebruik)
            spelers.add(s);
    }

    public Speler geefSpeler(String email, String wachtwoord){
        for(Speler speler: spelers){
            if(speler.getEmail().equals(email) && speler.getWachtwoord().equals(wachtwoord))
                return speler;
        }
        return null;
    }
}
