/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import Util.Utils;
import Util.Utils.TypeCarteTresor;
import static Util.Utils.TypeCarteTresor.HELICOPTERE;

/**
 *
 * @author pontalc
 */
public class Carte_Helico extends Carte_Tirage_Tresor {
    
    public Carte_Helico(TypeCarteTresor type) {
        super(HELICOPTERE);
    }

    @Override
    public void action() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
