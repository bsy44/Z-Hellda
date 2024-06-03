package fr.iut.montreuil.projetfinale.zhellda.controleur;

import fr.iut.montreuil.projetfinale.zhellda.modele.Arc;
import fr.iut.montreuil.projetfinale.zhellda.modele.Environnement;
import fr.iut.montreuil.projetfinale.zhellda.vue.VueJoueur;
import javafx.scene.input.KeyEvent;

import static fr.iut.montreuil.projetfinale.zhellda.modele.Environnement.getJ;

public class Clavier {

    public static void  keyPressed(KeyEvent e) {
        switch (e.getCode()){


            case Z:
                Environnement.getJ().setDirections(0, true);

                break;
            case Q:
                Environnement.getJ().setDirections(1, true);
                break;
            case S:
                Environnement.getJ().setDirections(2, true);
                break;
            case D:
                Environnement.getJ().setDirections(3, true);
                break;

            case UP:

                Environnement.getJ().getArme().attaquer(Environnement.getJ(), getJ().getX(), getJ().getY()- getJ().getArme().getPortee());
                break;
            case DOWN:
                Environnement.getJ().getArme().attaquer(Environnement.getJ(), getJ().getX(), getJ().getY()+getJ().getArme().getPortee());
                break;
            case LEFT:
                Environnement.getJ().getArme().attaquer(Environnement.getJ(), getJ().getX()- getJ().getArme().getPortee(), getJ().getY());
                break;
            case RIGHT:
                Environnement.getJ().getArme().attaquer(Environnement.getJ(), getJ().getX()+ getJ().getArme().getPortee(), getJ().getY());
                break;

            default :
                System.out.println("default");
                break;

        }
    }

}
