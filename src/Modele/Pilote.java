/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import Util.Utils;

/**
 *
 * @author bassetlu
 */
public class Pilote extends Aventurier {
    
    public Pilote(String nom, Tuile tuile) {
        super(nom, Utils.Pion.ROUGE, null);
    }
}
