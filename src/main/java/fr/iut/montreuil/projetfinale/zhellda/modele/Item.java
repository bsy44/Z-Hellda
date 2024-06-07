package fr.iut.montreuil.projetfinale.zhellda.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Item {
    private IntegerProperty x;
    private IntegerProperty y;
    private String id;
    private String nom;
    private String labelItem;
    private static int cpt = 0;
    private int indexInventaire;

    public Item(int posX, int posY, String nom, String id){
        this.x = new SimpleIntegerProperty(posX);
        this.y = new SimpleIntegerProperty(posY);
        this.nom = nom;
        this.id = id + cpt;
        this.labelItem = "labelItem";
        this.indexInventaire = -1;
        cpt++;
    }

    public int getX() {
        return x.getValue();
    }

    public int getY() {
        return y.getValue();
    }

    public void setX(int x) {
        this.x.setValue(x);
    }

    public void setY(int y) {
        this.y.setValue(y);
    }

    public final IntegerProperty xProperty(){
        return x;
    }

    public final IntegerProperty yProperty(){
        return y;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public String getLabelItem() {
        return labelItem;
    }

    public int getIndexInventaire() {
        return indexInventaire;
    }

    public void setIndexInventaire(int indexInventaire) {
        this.indexInventaire = indexInventaire;
    }

    @Override
    public String toString() {
        return "id " + getId() + ", pos x : " + getX() + ", pos y : " + getY();
    }
}
