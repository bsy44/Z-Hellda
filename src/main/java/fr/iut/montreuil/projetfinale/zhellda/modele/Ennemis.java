package fr.iut.montreuil.projetfinale.zhellda.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Ennemis extends Acteur{
public class Ennemis {

    private IntegerProperty x = new SimpleIntegerProperty();
    private IntegerProperty y = new SimpleIntegerProperty();
    private static int compteur = 1;
    private int id;
    private int vitesse;
    private IntegerProperty vie = new SimpleIntegerProperty();

    public Ennemis(int x, int y, int vie, int vitesse){
        super(x, y, vie);
        compteur++;
        this.vitesse = vitesse;
        this.vie.setValue(vie);
    }
    public String getId() {
        return (""+id);
    }

    public int getVie() {
        return vie.get();
    }

    public IntegerProperty vieProperty() {
        return vie;
    }

    public IntegerProperty getXProperty () { return x; }

    public IntegerProperty getYProperty () { return y; }

    public void degat (int dmg) {
        if ((this.vie.get()-dmg)<=0)
            this.vie.set(0);
        else
            this.vie.set((this.vie.get()-dmg));
        System.out.println(this.vie.get());
    }

}
