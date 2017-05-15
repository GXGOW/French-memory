/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fiens
 */
public class DomeinController {
    
    private List<Paar> paren;

    public DomeinController() {
        paren = new Initializer().getParen();
    }
    
    public List<String> selecteer(int aantal){
        List<Paar> gekozenParen = new ArrayList<>();
        SecureRandom will = new SecureRandom();
        for (int i = 0; i<aantal; i++){
            int willIndex = will.nextInt(paren.size());
            gekozenParen.add(paren.remove(willIndex));
        }
        
        List<String> uitvoer = new ArrayList<>();
        for(Paar gekozenPaar: gekozenParen){
            uitvoer.add(gekozenPaar.getWoord());
            uitvoer.add(gekozenPaar.getPad());
        }
        
        return uitvoer;
    }
    
    public boolean isPaar(String string1, String string2){
        Paar paar1 = null, paar2 = null;
        for(Paar paar : paren){
            if (paar.getPad().equalsIgnoreCase(string1)||paar.getWoord().equalsIgnoreCase(string1)){
                paar1 = paar;
            }
            if (paar.getPad().equalsIgnoreCase(string2)||paar.getWoord().equalsIgnoreCase(string2)){
                paar2 = paar;
            }
        }
        
        return paar1 == paar2;
    }
}
