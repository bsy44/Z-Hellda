package fr.iut.montreuil.projetfinale.zhellda.modele.personnage;

import fr.iut.montreuil.projetfinale.zhellda.modele.Environnement;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.ArrayList;

public class StrategieAttaqueBoss implements AttaqueEnnemis{
    private ArrayList<AttaqueEnnemis> attaqueEnnemis;
    private static IntegerProperty shemaAttaque = new SimpleIntegerProperty();


    public StrategieAttaqueBoss (){
        shemaAttaque.set(0);
        this.attaqueEnnemis=new ArrayList<>();
        this.attaqueEnnemis.add(new AttaqueClawAtk());
        this.attaqueEnnemis.add(new AttaqueAreaOfEffect());
        this.attaqueEnnemis.add(new AttaqueFireBall());
    }

    public void setShemaAttaque(int shemaAttaque) {
            this.shemaAttaque.set(shemaAttaque);
        }

    public static int getShemaAttaque() {
        return shemaAttaque.get();
    }

    public IntegerProperty shemaAttaqueProperty() {
        return shemaAttaque;
    }

    @Override
    public void attaqer(Environnement environnement, Ennemis ennemis) {
        int random = (int) (Math.random()*4);
        switch(random){

            case 0:
                setShemaAttaque(1);
                this.attaqueEnnemis.get(0).attaqer(environnement, ennemis);
                break;

            case 1:
                setShemaAttaque(2);
                this.attaqueEnnemis.get(1).attaqer(environnement, ennemis);
                break;

            case 2:
                setShemaAttaque(3);
                this.attaqueEnnemis.get(2).attaqer(environnement, ennemis);
                break;

            default:
                break;
        }

    }
}
