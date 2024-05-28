package fr.iut.montreuil.projetfinale.zhellda.modele.arme;

import fr.iut.montreuil.projetfinale.zhellda.modele.Environnement;

public class Fleche extends Projectile {
    public Fleche(int x, int y, int xDirection, int yDirection, Environnement environnement) {
        super(15, x, y, xDirection, yDirection, 10, environnement);
    }
}