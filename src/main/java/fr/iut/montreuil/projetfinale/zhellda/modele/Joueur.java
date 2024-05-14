package fr.iut.montreuil.projetfinale.zhellda.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Joueur {
    private IntegerProperty x = new SimpleIntegerProperty();
    private IntegerProperty y = new SimpleIntegerProperty();

    private int id;
    private Arme arme;

    public Joueur(){
        this.x.setValue(10);
        this.y.setValue(10);
        this.id = 1;
        this.arme=new epee();
    }

    public void deplacerGauche () {
        this.x.setValue(this.x.getValue()-10);
    }

    public void deplacerDroite () {
        this.x.setValue(this.x.getValue()+10);
    }

    public void deplacerHaut () {
        this.y.setValue(this.y.getValue()-10);
    }

    public void deplacerBas () {
        this.y.setValue(this.y.getValue()+10);
    }

    public String getId() {
        return (""+id);
    }

    public IntegerProperty getXProperty () { return x; }

    public IntegerProperty getYProperty () { return y; }

}
