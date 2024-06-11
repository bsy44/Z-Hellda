package fr.iut.montreuil.projetfinale.zhellda.modele;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Zombie extends Ennemis {

    private static double pourcentageDropItem = 100;
    public Zombie(int x, int y, Environnement environnement) {
        super(x, y, 10, 2, 1, 35,30, 30, environnement, "zombie");
    }

    public int getPvMax() {return 10;}

    public static double getPourcentageDropItem() {
        return pourcentageDropItem;
    }
}
