package domein;

import java.util.ArrayList;
import java.util.List;

public class SpelerRepository {

    private List<Speler> spelers;   //<1>

    public SpelerRepository(){
        spelers = new ArrayList<>();    //<2>
    }

    public void voegSpelerToe(Speler s) {
        for(Speler speler: spelers){    //<3>
            if(speler.getEmail().equals(s.getEmail()))
                throw new IllegalArgumentException("Email is al in gebruik!");      //<4>
        }

        spelers.add(s);     //<5>
    }
}
