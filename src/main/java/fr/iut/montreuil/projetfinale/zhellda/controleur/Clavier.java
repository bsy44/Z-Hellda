package fr.iut.montreuil.projetfinale.zhellda.controleur;

import fr.iut.montreuil.projetfinale.zhellda.modele.Environnement;
import javafx.scene.input.KeyEvent;

import static fr.iut.montreuil.projetfinale.zhellda.modele.Environnement.getJ;

public class Clavier {

    public static void  keyPressed(KeyEvent e) {
        switch (e.getCode()){

            //déplacements
            case Z:
                Environnement.getJ().deplacerHaut();
                break;
            case Q:
                Environnement.getJ().deplacerGauche();
                break;
            case S:
                Environnement.getJ().deplacerBas();
                break;
            case D:
                Environnement.getJ().deplacerDroite();
                break;

            //attaques
            case UP:
                System.out.println("Attaque haut");
                break;
            case DOWN:
                System.out.println("Attaque bas");
                break;
            case LEFT:
                System.out.println("Attaque gauche");
                break;
            case RIGHT:
                System.out.println("Attaque droit");
                break;


            default :
                System.out.println("default");
                break;

        }
    }

}
