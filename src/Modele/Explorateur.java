/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import Util.Utils;
import java.util.HashSet;

/**
 *
 * @author bassetlu
 */
public class Explorateur extends Aventurier{
    
    

    public Explorateur(String nom) {
        super(nom, Utils.Pion.VERT);
    }   
    
    public HashSet posAutourPossible(HashSet p, Tuile t) {
        //rajouter les cases en diagonale
        return p;
    }

    /*@Override
    public void seDeplacer() {
        super.seDeplacer();
    }*/
}

