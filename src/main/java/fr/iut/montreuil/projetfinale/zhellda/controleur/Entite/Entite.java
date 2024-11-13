package fr.iut.montreuil.projetfinale.zhellda.controleur.Entite;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Entite {
    private IntegerProperty x;
    private IntegerProperty y;
    private String id;
    public Entite(int x, int y, String id) {
        this.x =  new SimpleIntegerProperty(x);
        this.y = new SimpleIntegerProperty(y);
        this.id = id;
    }

    public final int getX() {
        return x.getValue();
    }

    public void setX(int x) {
        this.x.setValue(x);
    }

    public final int getY() {
        return y.getValue();
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setY(int y) {
        this.y.setValue(y);
    }
    public final IntegerProperty getXProperty() {
        return x;
    }

    public final IntegerProperty getYProperty() {
        return y;
    }

}
