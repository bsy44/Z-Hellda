package fr.iut.montreuil.projetfinale.zhellda.controleur;

import fr.iut.montreuil.projetfinale.zhellda.modele.Environnement;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;

import java.util.HashSet;
import java.util.Set;

public class Clavier {

    private static final Set<KeyCode> currentlyPressedKeys = new HashSet<>();

    public static void keyPressed(KeyEvent e) {
        currentlyPressedKeys.add(e.getCode());
        deplacerPersonnage(currentlyPressedKeys);
        gererAttaques(e);
    }

    public static void keyReleased(KeyEvent e) {
        currentlyPressedKeys.remove(e.getCode());
    }

    private static void deplacerPersonnage(Set<KeyCode> directions) {
        boolean haut = directions.contains(KeyCode.Z);
        boolean bas = directions.contains(KeyCode.S);
        boolean gauche = directions.contains(KeyCode.Q);
        boolean droite = directions.contains(KeyCode.D);

        if (haut && gauche) {
            Environnement.getJ().setDoubleDirections(0, 1); // Diagonale haut-gauche
        } else if (haut && droite) {
            Environnement.getJ().setDoubleDirections(0, 3); // Diagonale haut-droite
        } else if (bas && gauche) {
            Environnement.getJ().setDoubleDirections(2, 1); // Diagonale bas-gauche
        } else if (bas && droite) {
            Environnement.getJ().setDoubleDirections(2, 3); // Diagonale bas-droite
        } else if (haut) {
            Environnement.getJ().setDirections(0); // Haut
        } else if (bas) {
            Environnement.getJ().setDirections(2); // Bas
        } else if (gauche) {
            Environnement.getJ().setDirections(1); // Gauche
        } else if (droite) {
            Environnement.getJ().setDirections(3); // Droite
        }
    }

    private static void gererAttaques(KeyEvent e) {
        switch (e.getCode()) {
            case UP:
                Environnement.getJ().getArme().attaquer(Environnement.getJ(), Environnement.getJ().getX(), Environnement.getJ().getY() - Environnement.getJ().getArme().getPortee());
                break;
            case DOWN:
                Environnement.getJ().getArme().attaquer(Environnement.getJ(), Environnement.getJ().getX(), Environnement.getJ().getY() + Environnement.getJ().getArme().getPortee());
                break;
            case LEFT:
                Environnement.getJ().getArme().attaquer(Environnement.getJ(), Environnement.getJ().getX() - Environnement.getJ().getArme().getPortee(), Environnement.getJ().getY());
                break;
            case RIGHT:
                Environnement.getJ().getArme().attaquer(Environnement.getJ(), Environnement.getJ().getX() + Environnement.getJ().getArme().getPortee(), Environnement.getJ().getY());
                break;
            case AMPERSAND:
                System.out.println("arme 1");
                Environnement.getJ().setNumArmeUtilise(1);
                break;
            case UNDEFINED:
                System.out.println("arme 2");
                Environnement.getJ().setNumArmeUtilise(2);
                break;
            case QUOTEDBL:
                System.out.println("arme 3");
                Environnement.getJ().setNumArmeUtilise(3);
                break;

            case E:
                System.out.println("interaction");
                Environnement.getJ().interagirAvecCoffre();
                break;
            case G:
                Environnement.getJ().jeterArme(Environnement.getJ().getArme());
                break;
            default:
                break;
        }
    }
}
