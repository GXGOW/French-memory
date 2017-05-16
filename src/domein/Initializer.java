/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author fiens
 */
public class Initializer {
    
    private List<Paar> paren;

    public Initializer() {
        paren  = Arrays.asList(new Paar[]{
            new Paar("un arbre", ""),
            new Paar("un garçon", ""),
            new Paar("une fille", ""),
            new Paar("une pomme", ""),
            new Paar("une maison", ""),
            new Paar("une balle", ""),
            new Paar("un chien", ""),
            new Paar("un chat", ""),
            new Paar("un cheval", ""),
            new Paar("un chaise", ""),
            new Paar("une étoile", ""),
            new Paar("un manteau", ""),
            new Paar("un bateau", ""),
            new Paar("la mer", ""),
            new Paar("une poupée", ""),
            new Paar("un livre", ""),
            new Paar("un poisson", ""),
            new Paar("le soleil", ""),
            new Paar("une glace", ""),
            new Paar("une fleur", ""),
            new Paar("une vache", ""),
            new Paar("une table", ""),
            new Paar("un ours", ""),
            new Paar("une chaussette", ""),
            new Paar("un verre", ""),
            new Paar("rouge", ""),
            new Paar("vert", ""),
            new Paar("jaune", ""),
            new Paar("bleu", ""),
            new Paar("un papier", ""),
            new Paar("un pendule", ""),
            new Paar("un cochon", ""),
            new Paar("une clef", ""),
            new Paar("une armoire", ""),
            new Paar("une chaussure", ""),
            new Paar("une voiture", "")
        });
    }

    public List<Paar> getParen() {
        return paren;
    }
}
