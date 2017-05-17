/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

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
            new Paar("un arbre", "boom.png"),
            new Paar("un garçon", "jongen.jpg"),
            new Paar("une fille", "meisje.jpg"),
            new Paar("une pomme", "appel.jpg"),
            new Paar("une maison", "huis.jpg"),
            new Paar("une balle", "bal.png"),
            new Paar("un chien", "hond.png"),
            new Paar("un chat", "kat.png"),
            new Paar("un cheval", "paard.png"),
            new Paar("un chaise", "stoel.jpg"),
            new Paar("une étoile", "ster.png"),
            new Paar("un manteau", "jas.jpg"),
            new Paar("un bateau", "boot.png"),
            new Paar("la mer", "zee.jpg"),
            new Paar("une poupée", "pop.jpg"),
            new Paar("un livre", "boek.png"),
            new Paar("un poisson", "vis.png"),
            new Paar("le soleil", "zon.png"),
            new Paar("une glace", "ijs.png"),
            new Paar("une fleur", "bloem.png"),
            new Paar("une vache", "koe.jpg"),
            new Paar("une table", "tafel.png"),
            new Paar("un ours", "beer.jpg"),
            new Paar("une chaussette", "kous.png"),
            new Paar("un verre", "glas.jpg"),
            new Paar("rouge", "rood.jpg"),
            new Paar("vert", "groen.png"),
            new Paar("jaune", "geel.jpg"),
            new Paar("bleu", "blauw.jpg"),
            new Paar("un papier", "papier.png"),
            new Paar("un pendule", "klok.png"),
            new Paar("un cochon", "varken.jpg"),
            new Paar("une clef", "sleutel.jpg"),
            new Paar("une armoire", "kast.jpg"),
            new Paar("une chaussure", "schoen.png"),
            new Paar("une voiture", "auto.jpg")
        });
    }

    public List<Paar> getParen() {
        return paren;
    }
}
