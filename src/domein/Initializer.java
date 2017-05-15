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
            new Paar("woord1", "pad1"),
            new Paar("woord2", "pad2")
        });
    }

    public List<Paar> getParen() {
        return paren;
    }
}
