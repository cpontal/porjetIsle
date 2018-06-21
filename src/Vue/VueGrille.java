/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Controleur.*;
import Modele.*;
import Util.Utils;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Label;
import java.util.ArrayList;
import javax.swing.*;
import Util.Utils.*;
import java.awt.Graphics;

public class VueGrille extends Observe {

    private ArrayList<JButton> buttons;
    private static Controleur controleur;
    private JPanel panelGrille;
    private JPanel panelBody;

    public VueGrille(Controleur controleur) {
        
        buttons = new ArrayList<>();
        this.controleur = controleur;
        Grille grille = controleur.getGrille();

        
        panelBody = new JPanel(new BorderLayout());
        panelGrille = new JPanel(new GridLayout(6, 6));
        for (int x = 0; x < 6; x++) {
            for (int y = 0; y < 6; y++) {
                Tuile tuile = grille.getTuileCase(x, y);

                JButton button = new JButton();

                if (tuile != null) {

                    String str = tuile.getNomTuile().toString();
                    JPanel paneltuile = new JPanel(new BorderLayout());
                    JLabel labelnomTuile = new JLabel(str);
                    paneltuile.add(labelnomTuile, BorderLayout.CENTER);

                    if (tuile.getEtat() == Utils.EtatTuile.COULEE) {
                        Color c = new Color(96, 96, 96);
                        paneltuile.setBackground(c);
                        button.setBackground(c);
                        button.add(paneltuile);
                        panelGrille.add(button);
                    } else if (tuile.getEtat() == Utils.EtatTuile.INONDEE) {

                        Color c = new Color(102, 175, 255);
                        button.setBackground(c);
                        paneltuile.setBackground(c);
                        button.add(paneltuile);
                        panelGrille.add(button);

                    } else if (tuile.getEtat() == Utils.EtatTuile.ASSECHEE) {

                        Color c = new Color(255, 255, 153);
                        paneltuile.setBackground(c);
                        button.setBackground(c);
                        button.add(paneltuile);
                        panelGrille.add(button);

                    } else {
                        panelGrille.add(button);
                    }

                    if (tuile.getTypeTresor() == TypeTresor.LA_PIERRE_SACREE) {

                        Label labelTresor = new Label(TypeTresor.LA_PIERRE_SACREE.toString());
                        paneltuile.add(labelTresor, BorderLayout.SOUTH);
                        button.add(paneltuile);

                    } else if (tuile.getTypeTresor() == Utils.TypeTresor.LA_STATUE_DU_ZEPHYR) {

                        Label labelTresor = new Label(TypeTresor.LA_STATUE_DU_ZEPHYR.toString());
                        paneltuile.add(labelTresor, BorderLayout.SOUTH);
                        button.add(paneltuile);

                    } else if (tuile.getTypeTresor() == Utils.TypeTresor.LE_CALICE_DE_LONDE) {

                        Label labelTresor = new Label(TypeTresor.LE_CALICE_DE_LONDE.toString());
                        paneltuile.add(labelTresor, BorderLayout.SOUTH);
                        button.add(paneltuile);

                    } else if (tuile.getTypeTresor() == Utils.TypeTresor.LE_CRISTAL_ARDENT) {

                        Label labelTresor = new Label(TypeTresor.LE_CRISTAL_ARDENT.toString());
                        paneltuile.add(labelTresor, BorderLayout.SOUTH);
                        button.add(paneltuile);

                    } else {
                        panelGrille.add(button);
                    }

                    for (Aventurier joueur: controleur.getAventuriers()) {
                        if (joueur.getTuile() == tuile) {

                            JPanel pion = new JPanel(new GridLayout(2, 1));
                            paneltuile.add(pion, BorderLayout.EAST);
                            
                            Graphics g = panelGrille.getGraphics();
                            CerclePion cerclePion = new CerclePion();
                            cerclePion.setColor(joueur.getCouleur().getCouleur());
                            pion.add(cerclePion);
                            
                            JLabel filler = new JLabel("             ");
                            pion.add(filler);
                            filler.setVisible(false);
                            pion.setBackground(paneltuile.getBackground());
                        }
                    }

                } else {
                    button.setVisible(false);
                    panelGrille.add(button);
                }

            }
//            button.addActionListener((ActionEvent e) -> {
//                Message m = new Message();
//                m.type = TypesMessages.JOUER_COUP;
//                m.no_case = numCase;
//                
//                notifierObservateur(m);

            panelBody.add(panelGrille, BorderLayout.CENTER);
            //this.add(panelBody);
            panelBody.setVisible(true);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("plateau");
        frame.setSize(1000, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new VueGrille(controleur).getPanelBody());
        frame.setVisible(true);
    }

    public JPanel getPanelBody() {
        return panelBody;
    }

    public class CerclePion extends JPanel {

        Color color;

        public void setColor(Color color) {
            this.color = color;
        }

        public void paint(Graphics g) {
            g.setColor(Color.BLACK);
            drawCenteredCircle(g, 20, 20, 27);
            g.setColor(color);
            drawCenteredCircle(g, 20, 20, 25);
        }
    }

    public void drawCenteredCircle(Graphics g, int x, int y, int r) {
        x = x - (r / 2);
        y = y - (r / 2);
        g.fillOval(x, y, r, r);
    }
}
