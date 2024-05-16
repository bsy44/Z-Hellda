package fr.iut.montreuil.projetfinale.zhellda.controleur;

import fr.iut.montreuil.projetfinale.zhellda.modele.Environnement;
import fr.iut.montreuil.projetfinale.zhellda.vue.VueJoueur;
import javafx.scene.input.KeyEvent;

import static fr.iut.montreuil.projetfinale.zhellda.modele.Environnement.getJ;

public class Clavier {

    public static void  keyPressed(KeyEvent e) {
        switch (e.getCode()){

            //déplacements
            case Z:
                Environnement.getJ().deplacement(0, -10);
                VueJoueur.modifierImage("Personnage_dos_droit.png");
                break;
            case Q:
                Environnement.getJ().deplacement(-10, 0);
                VueJoueur.modifierImage("perso2.png");
                break;
            case S:
                Environnement.getJ().deplacement(0, 10);
                VueJoueur.modifierImage("Joueur.png");
                break;
            case D:
                Environnement.getJ().deplacement(10, 0);
                VueJoueur.modifierImage("Joueur.png");
                break;

            //attaques
//            case UP:
//                System.out.println("Attaque haut");
//                break;
//            case DOWN:
//                System.out.println("Attaque bas");
//                break;
//            case LEFT:
//                System.out.println("Attaque gauche");
//                break;
//            case RIGHT:
//                System.out.println("Attaque droit");
//                break;

            case K:
                System.out.println("k press");
                Environnement.getJ().getArme().attaquer(Environnement.getJ());

                System.out.println("Attaque");
                break;

            default :
                System.out.println("default");
                break;

        }
    }

}
