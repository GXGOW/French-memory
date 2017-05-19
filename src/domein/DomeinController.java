/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author fiens
 */
public class DomeinController {

    private Paar[] paren;
    private List<Speler> spelers;
    private int huidigeSpeler;

    public DomeinController() {
        paren = new Initializer().getParen();
        spelers = new ArrayList<>();
        huidigeSpeler = 0;
    }

    public List<String> selecteer() {
        List<Paar> gekozenParen = new ArrayList<>();
        List<Paar> teKiezenParen = new ArrayList<>(Arrays.asList(paren));
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < 15; i++) {
            Paar geselecteerdPaar = teKiezenParen.get(random.nextInt(teKiezenParen.size()));
            gekozenParen.add(geselecteerdPaar);
            teKiezenParen.remove(geselecteerdPaar);
        }

        List<String> uitvoer = new ArrayList<>();
        /*for (Paar gekozenPaar : gekozenParen) {
            uitvoer.add(gekozenPaar.getWoord());
            uitvoer.add(gekozenPaar.getPad());
        }*/
        gekozenParen.stream().forEach(o -> {
            uitvoer.add(o.getWoord());
            uitvoer.add(o.getPad());
        });

        return uitvoer;
    }

    public boolean isPaar(String string1, String string2) {
        Paar paar1 = null, paar2 = null;
        for (Paar paar : paren) {
            if (paar.getPad().equalsIgnoreCase(string1) || paar.getWoord().equalsIgnoreCase(string1)) {
                paar1 = paar;
            }
            if (paar.getPad().equalsIgnoreCase(string2) || paar.getWoord().equalsIgnoreCase(string2)) {
                paar2 = paar;
            }
        }

        if (paar1 != null && paar2 != null && paar1 == paar2) {
//            geefHuidigeSpeler().voegPaarToe();
            return true;
        }

        return false;
    }

    public void voegSpelerToe(String naam) {
        spelers.add(new Speler(naam));
    }

    public Speler geefHuidigeSpeler() {
        return spelers.get(huidigeSpeler);
    }

    public void geefBeurtAanVolgendeSpeler() {
        if (huidigeSpeler + 1 > 1) {
            huidigeSpeler = 0;
        } else {
            huidigeSpeler++;
        }
    }

}
