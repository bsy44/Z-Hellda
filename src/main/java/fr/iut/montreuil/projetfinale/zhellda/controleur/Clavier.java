package fr.iut.montreuil.projetfinale.zhellda.controleur;

import fr.iut.montreuil.projetfinale.zhellda.modele.Arc;
import fr.iut.montreuil.projetfinale.zhellda.modele.Environnement;
import fr.iut.montreuil.projetfinale.zhellda.vue.VueJoueur;
import javafx.scene.input.KeyEvent;

import static fr.iut.montreuil.projetfinale.zhellda.modele.Environnement.getJ;

public class Clavier {

    public static void  keyPressed(KeyEvent e) {
        switch (e.getCode()){

            //déplacements
            case Z:
                Environnement.getJ().deplacement(0, -4);
                VueJoueur.modifierImage("Personnage_dos_droit.png");
                break;
            case Q:
                Environnement.getJ().deplacement(-4, 0);
                VueJoueur.modifierImage("perso2.png");
                break;
            case S:
                Environnement.getJ().deplacement(0, 4);
                VueJoueur.modifierImage("Joueur.png");
                break;
            case D:
                Environnement.getJ().deplacement(4, 0);
                VueJoueur.modifierImage("Joueur.png");
                break;

            case UP:
                VueJoueur.modifierImage("Personnage_dos_droit.png");
                if (Environnement.getJ().getArme() instanceof Arc) {
                    ((Arc) Environnement.getJ().getArme()).attaquer(Environnement.getJ(), getJ().getX(), getJ().getY()- getJ().getArme().getPortee());
                }
                Environnement.getJ().getArme().attaquer(Environnement.getJ(), getJ().getX(), getJ().getY()- getJ().getArme().getPortee());
                break;
            case DOWN:
                VueJoueur.modifierImage("Joueur.png");
                if (Environnement.getJ().getArme() instanceof Arc) {
                    ((Arc) Environnement.getJ().getArme()).attaquer(Environnement.getJ(), getJ().getX(), getJ().getY()+ getJ().getArme().getPortee());
                }

                Environnement.getJ().getArme().attaquer(Environnement.getJ(), getJ().getX(), getJ().getY()+getJ().getArme().getPortee());
                break;
            case LEFT:
                VueJoueur.modifierImage("perso2.png");
                if (Environnement.getJ().getArme() instanceof Arc) {
                    ((Arc) Environnement.getJ().getArme()).attaquer(Environnement.getJ(), getJ().getX()- getJ().getArme().getPortee(), getJ().getY());

                }
                Environnement.getJ().getArme().attaquer(Environnement.getJ(), getJ().getX()- getJ().getArme().getPortee(), getJ().getY());
                break;
            case RIGHT:
                VueJoueur.modifierImage("Joueur.png");
                if (Environnement.getJ().getArme() instanceof Arc) {
                    ((Arc) Environnement.getJ().getArme()).attaquer(Environnement.getJ(), getJ().getX()+ getJ().getArme().getPortee(), getJ().getY());

                }

                Environnement.getJ().getArme().attaquer(Environnement.getJ(), getJ().getX()+ getJ().getArme().getPortee(), getJ().getY());
                break;

            default :
                System.out.println("default");
                break;

        }
    }

}
