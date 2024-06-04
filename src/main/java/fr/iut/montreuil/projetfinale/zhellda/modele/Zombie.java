package fr.iut.montreuil.projetfinale.zhellda.modele;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Zombie extends Ennemis {

    private static DoubleProperty pourcentageDropItem = new SimpleDoubleProperty(100);
    public Zombie(int x, int y, Environnement environnement) {
        super(x, y, 10, 2, 1, 35,30, 30, environnement);
    }
    //La vie et la vitesse seront à équilibrer plus tard


    public int getPvMax() {return 10;}

    public static double getPourcentageDropItem() {
        return pourcentageDropItem.getValue();
    }
}
