package fr.iut.montreuil.projetfinale.zhellda.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Ennemis {

    private IntegerProperty x = new SimpleIntegerProperty();
    private IntegerProperty y = new SimpleIntegerProperty();
    private static int compteur = 1;
    private int id;
    private int vitesse;
    private IntegerProperty vie = new SimpleIntegerProperty();

    public Ennemis(int vitesse, int vie){
        this.x.setValue(100);
        this.y.setValue(100);
        this.id = compteur;
        compteur++;
        this.vitesse = vitesse;
        this.vie.setValue(vie);
    }
    public String getId() {
        return (""+id);
    }

    public IntegerProperty getXProperty () { return x; }

    public IntegerProperty getYProperty () { return y; }

    public void degat (int dmg) {
        this.vie.set((this.vie.get()-dmg));
    }

}
