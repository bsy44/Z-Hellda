package fr.iut.montreuil.projetfinale.zhellda.modele.personnage;

import fr.iut.montreuil.projetfinale.zhellda.modele.projectile.BouleDeFeu;
import fr.iut.montreuil.projetfinale.zhellda.modele.Case;
import fr.iut.montreuil.projetfinale.zhellda.modele.Environnement;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.util.Duration;

import java.util.ArrayList;

public class Boss extends Ennemis{
    private IntegerProperty shemaAttaque = new SimpleIntegerProperty();
    private String direction;

    public Boss(int x, int y, Environnement environnement) {
        super(x, y, 200, 3, 5, 0, 100, 100, environnement, "boss", false,new StrategieAttaqueBoss());
        direction = null;
    }

    @Override
    public int getPvMax() {
        return 200;
    }

    @Override
    public void agit(){
        seDeplacer();
        attaquer();
        Timeline attendreDeplacement = new Timeline(
                new KeyFrame(Duration.seconds(2), e -> {
                    setShemaAttaque(0);
                })
        );
        attendreDeplacement.play();
    }



    public IntegerProperty getShemaAttaque() {
        return shemaAttaque;
    }
    public String getDirection (){
        return direction;
    }

    public void setShemaAttaque(int shemaAttaque) {
        this.shemaAttaque.set(shemaAttaque);
    }
}
