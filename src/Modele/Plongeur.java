/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import static Util.Utils.EtatTuile.ASSECHEE;
import java.util.HashSet;
import java.util.Iterator;

/**
 *
 * @author bassetlu
 */
public class Plongeur extends Aventurier {
        private HashSet AVerifier;
        private HashSet Verifier;   
     
        
        @Override
    public HashSet posAutourPossible(HashSet p, Tuille t) {
        
    }    
        
    @Override
    public void seDeplacer() {
        Tuille t = this.getPos();
        posAutourPossible(AVerifier, t){
            Iterator it = posPossible.iterator();
            for(){
                if(.getEtat() != ASSECHEE) {
               AVerifier.add();
                }
            }
            
            
            
       }
}
