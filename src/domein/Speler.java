/*
 * Copyright by Nico
 */
package domein;

/**
 *
 * @author Nicolas
 */
public class Speler {

    private final String naam;
    private int aantalParen;

    public Speler(String naam) {
        if(naam == null || naam.equals("")){
            throw new IllegalArgumentException("Je moet een naam invullen.");
        }
        this.naam = naam;
        this.aantalParen = 0;
    }

    public String getNaam() {
        return naam;
    }

    public void voegPaarToe() {
        aantalParen++;
    }

    public int getAantalParen() {
        return aantalParen;
    }

}
