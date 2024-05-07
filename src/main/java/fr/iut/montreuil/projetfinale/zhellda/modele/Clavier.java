package fr.iut.montreuil.projetfinale.zhellda.modele;

import javafx.scene.input.KeyEvent;

import static fr.iut.montreuil.projetfinale.zhellda.controleur.Controleur.j;

public class Clavier {

    public static void  keyPressed(KeyEvent e) {
        switch (e.getCode()){

            //déplacements
            case Z:
                j.deplacerHaut();
                break;
            case Q:
                j.deplacerGauche();
                break;
            case S:
                j.deplacerBas();
                break;
            case D:
                j.deplacerDroite();
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
