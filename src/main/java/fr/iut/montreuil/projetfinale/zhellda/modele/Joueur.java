package fr.iut.montreuil.projetfinale.zhellda.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Joueur {
    private IntegerProperty x;
    private IntegerProperty y;
    private int id;
    private Arme arme;

    public Joueur(){
        this.x = new SimpleIntegerProperty(10);
        this.y = new SimpleIntegerProperty(10);
        this.id = 1;
        this.arme=new Epee();
    }

    /*public void deplacerGauche () {
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
    }*/

    public String getId() {
        return (""+id);
    }

    public final int getX() {
        return x.getValue();
    }

    public final int getY() {
        return y.getValue();
    }

    public final IntegerProperty getXProperty () { return x; }

    public final IntegerProperty getYProperty () { return y; }

    public final void deplacement(int x, int y) {
        System.out.println("x :"+(Math.round(getX() + x)/30)  + ", y : "+ Math.round(getY()+ y)/30);

        if (Environnement.getTerrain().dansTerrain((int)Math.ceil((this.getX() + x) / 30.0), (int)Math.ceil((this.getY() + y) / 30.0))) {
            this.x.setValue(getX() + x);
            this.y.setValue(getY() + y);
        }

    }
}
