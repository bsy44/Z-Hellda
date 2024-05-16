package fr.iut.montreuil.projetfinale.zhellda.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.shape.Rectangle;

public abstract class Acteur {
    private IntegerProperty x = new SimpleIntegerProperty();
    private IntegerProperty y = new SimpleIntegerProperty();
    private IntegerProperty vie = new SimpleIntegerProperty();
    private String id;
    Environnement environnement;
    private Rectangle hitbox;

    public Acteur (int x, int y, int vie, String id, Environnement environnement){

        this.x.setValue(x);
        this.y.setValue(y);
        this.vie.setValue(vie);
        this.id = id;
        this.environnement=environnement;
        this.hitbox = new Rectangle(this.getX(), this.getY(), 25, 25);
    }

    public String getId() {
        return ('#'+id);
    }

    public final int getX() {
        return x.getValue();
    }

    public void setX(int x) {
        this.x.setValue(x);
    }

    public void setXProperty (int x){
        this.x.setValue(x);
    }

    public final int getY() {
        return y.getValue();
    }

    public void setY(int y) {
        this.y.setValue(y);
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

    public Rectangle getHitbox() {
        return hitbox;
    }

    public void subirDegats (int dmg) {
        if ((this.vie.get()-dmg)<=0)
            this.vie.set(0);
        else
            this.vie.set((this.vie.get()-dmg));
        System.out.println(this.vie.get());
    }

    public boolean colision(int haut, int bas, int droite, int gauche){
        return  !Environnement.getTerrain().obstacle(gauche, haut) &&
                !Environnement.getTerrain().obstacle(droite, haut) &&
                !Environnement.getTerrain().obstacle(gauche, bas) &&
                !Environnement.getTerrain().obstacle(droite, bas);
    }

}
