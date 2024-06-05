package fr.iut.montreuil.projetfinale.zhellda.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Item {

    private IntegerProperty x;
    private IntegerProperty y;
    private String id;
    private StringProperty nom;
    private static int cpt = 0;

    public Item(int posX, int posY, String nom){
        this.x = new SimpleIntegerProperty(posX);
        this.y = new SimpleIntegerProperty(posY);
        this.nom = new SimpleStringProperty(nom);
        this.id = nom + "#" + cpt;
        cpt++;
    }

    public int getX() {
        return x.getValue();
    }

    public int getY() {
        return y.getValue();
    }

    public final IntegerProperty xProperty(){
        return x;
    }

    public final IntegerProperty yProperty(){
        return y;
    }

    public void setX(int x) {
        this.x.setValue(x);
    }

    public void setY(int y) {
        this.y.setValue(y);
    }

    public String getId() {
        return id;
    }

    public StringProperty getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return "id " + getId() + ", pos x : " + getX() + ", pos y : " + getY();
    }
}
