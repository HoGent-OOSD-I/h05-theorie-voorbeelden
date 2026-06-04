package domein;

import java.util.ArrayList;
import java.util.List;

public class SpelerRepository {

    private List<Speler> spelers;   //<1>

    public SpelerRepository(){
        spelers = new ArrayList<>();    //<2>
    }

    public void voegSpelerToe(Speler s) {
        boolean emailInGebruik = false;

        for(Speler speler: spelers){    //<3>
            if(speler.getEmail().equals(s.getEmail()))
                emailInGebruik = true;
        }

        if(!emailInGebruik)     //<4>
            spelers.add(s);
    }
}
