package fr.iut.montreuil.projetfinale.zhellda.modele.personnage;

import fr.iut.montreuil.projetfinale.zhellda.modele.Environnement;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.util.Duration;

public class Boss extends Ennemi {

    public Boss(int x, int y) {
        super(x, y, 200, 3, 5, 0, 100, 100,"boss", false , new SchemaAttaqueChangeant());
    }

    @Override
    public int getPvMax() {
        return 200;
    }

}
