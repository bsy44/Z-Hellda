package fr.iut.montreuil.projetfinale.zhellda.modele.personnage;

import fr.iut.montreuil.projetfinale.zhellda.controleur.Entite.Entite;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.shape.Rectangle;

public abstract class Acteur extends Entite {
    private IntegerProperty vie;
    private String id;
    private Rectangle hitbox;
    int vitesse;

    public Acteur(int x, int y, int vie, int vitesse, String id, int tailleHx, int tailleHy){
        super(x,y,id);
        this.vie= new SimpleIntegerProperty(vie);
        this.vitesse=vitesse;
        this.id = id;
        this.hitbox = new Rectangle(this.getX(), this.getY(), tailleHx, tailleHy);
    }

    public void setVie(int vie) {
        this.vie.setValue(this.vie.getValue() + vie);
    }
    public final IntegerProperty getVie (){
        return this.vie;
    }

    public Rectangle getHitbox() {
        return hitbox;
    }

    public int getVitesse() {
        return vitesse;
    }

    public void subirDegats (int dmg) {
        if ((this.vie.get()-dmg)<=0)
            this.vie.set(0);
        else
            this.vie.set((this.vie.get()-dmg));
    }

    public abstract void agit();

    public abstract boolean meurt();
}
