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
    
    private Paar[] paren;

    public Initializer() {
        paren  = new Paar[]{
            new Paar("/images/unarbre.jpg", "/images/boom.png"),
            new Paar("/images/ungarçon.jpg", "/images/jongen.jpg"),
            new Paar("/images/unefille.jpg", "/images/meisje.jpg"),
            new Paar("/images/unepomme.jpg", "/images/appel.jpg"),
            new Paar("/images/unemaison.jpg", "/images/huis.jpg"),
            new Paar("/images/uneballe.jpg", "/images/bal.png"),
            new Paar("/images/unchien.jpg", "/images/hond.png"),
            new Paar("/images/unchat.jpg", "/images/kat.png"),
            new Paar("/images/uncheval.jpg", "/images/paard.png"),
            new Paar("/images/unchaise.jpg", "/images/stoel.jpg"),
            new Paar("/images/uneétoile.jpg", "/images/ster.png"),
            new Paar("/images/unmanteau.jpg", "/images/jas.jpg"),
            new Paar("/images/unbateau.jpg", "/images/boot.png"),
            new Paar("/images/lamer.jpg", "/images/zee.jpg"),
            new Paar("/images/unepoupée.jpg", "/images/pop.jpg"),
            new Paar("/images/unlivre.jpg", "/images/boek.png"),
            new Paar("/images/unpoisson.jpg", "/images/vis.png"),
            new Paar("/images/lesoleil.jpg", "/images/zon.png"),
            new Paar("/images/uneglace.jpg", "/images/ijs.png"),
            new Paar("/images/unefleur.jpg", "/images/bloem.png"),
            new Paar("/images/unevache.jpg", "/images/koe.jpg"),
            new Paar("/images/unetable.jpg", "/images/tafel.png"),
            new Paar("/images/unours.jpg", "/images/beer.jpg"),
            new Paar("/images/unechaussette.jpg", "/images/kous.png"),
            new Paar("/images/unverre.jpg", "/images/glas.jpg"),
            new Paar("/images/rouge.jpg", "/images/rood.jpg"),
            new Paar("/images/vert.jpg", "/images/groen.png"),
            new Paar("/images/jaune.jpg", "/images/geel.jpg"),
            new Paar("/images/bleu.jpg", "/images/blauw.jpg"),
            new Paar("/images/unpapier.jpg", "/images/papier.png"),
            new Paar("/images/unpendule.jpg", "/images/klok.png"),
            new Paar("/images/uncochon.jpg", "/images/varken.jpg"),
            new Paar("/images/unecle.jpg", "/images/sleutel.jpg"),
            new Paar("/images/unearmoire.jpg", "/images/kast.jpg"),
            new Paar("/images/unechaussure.jpg", "/images/schoen.png"),
            new Paar("/images/unevoiture.jpg", "/images/auto.jpg")     
        };
    }

    public Paar[] getParen() {
        return paren;
    }
}
