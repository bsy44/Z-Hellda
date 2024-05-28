package fr.iut.montreuil.projetfinale.zhellda.modele.personnage;

import fr.iut.montreuil.projetfinale.zhellda.modele.Environnement;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.shape.Rectangle;

public abstract class Acteur {
    private IntegerProperty x;
    private IntegerProperty y;
    private IntegerProperty vie;
    private String id;
    protected Environnement environnement;
    private Rectangle hitbox;

    public Acteur (int x, int y, int vie, String id, int tailleHx, int tailleHy, Environnement environnement){
        this.x =  new SimpleIntegerProperty(x);
        this.y = new SimpleIntegerProperty(y);
        this.vie= new SimpleIntegerProperty(vie);
        this.id = id;
        this.environnement = environnement;
        this.hitbox = new Rectangle(this.getX(), this.getY(), tailleHx, tailleHy);
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

    public final int getY() {
        return y.getValue();
    }

    public void setY(int y) {
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
    }
}
