package fr.iut.montreuil.projetfinale.zhellda.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Acteur {
    private IntegerProperty x = new SimpleIntegerProperty();
    private IntegerProperty y = new SimpleIntegerProperty();
    private IntegerProperty vie = new SimpleIntegerProperty();
    private String id;

    public Acteur (int x, int y, int vie, String id){
        this.x.setValue(x);
        this.y.setValue(y);
        this.vie.setValue(vie);
        this.id = id;
    }

    public String getId() {
        return ('#'+id);
    }

    public final int getX() {
        return x.getValue();
    }

    public void setXProperty (int x){
        this.x.setValue(x);
    }

    public final int getY() {
        return y.getValue();
    }

    public void setYProperty (int y){
        this.y.setValue(y);
    }

    public IntegerProperty getXProperty() {
        return x;
    }

    public IntegerProperty getYProperty() {
        return y;
    }

    public IntegerProperty getVie (){
        return this.vie;
    }

    public void setVie(int dmg) {
        this.vie.set((this.vie.get()-dmg));
    }


}
