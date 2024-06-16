package fr.iut.montreuil.projetfinale.zhellda.modele.projectile;

import fr.iut.montreuil.projetfinale.zhellda.modele.Environnement;
import fr.iut.montreuil.projetfinale.zhellda.modele.personnage.Ennemis;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Projectile {
    private int vitesse;
    private String id;
    private static int compteur;
    private int xDirection;
    private int yDirection;
    private int degat;
    private IntegerProperty x;
    private IntegerProperty y;
    Environnement environnement;

    public Projectile(int vitesse, int x, int y, int xDirection, int yDirection, int degat, Environnement environnement) {
        this.id = "P" + compteur;
        compteur++;
        this.vitesse = vitesse;
        this.x = new SimpleIntegerProperty(x);
        this.y = new SimpleIntegerProperty(y);
        this.xDirection= xDirection;
        this.yDirection=yDirection;
        this.degat=degat;
        this.environnement=environnement;

    }

    public boolean tirProjectile (){
        if (this.getX() < this.xDirection || this.getY()<this.yDirection) {
            if (this.x.getValue() < this.xDirection)
                this.setX(vitesse);
            else
                this.setY(vitesse);
            return true;
        }
        else if (this.getX() > this.xDirection || this.getY()>this.yDirection){
            if (this.x.getValue() > this.xDirection)
                this.setX(-vitesse);
            else
                this.setY(-vitesse);
            return true;
        }
        return false;
    }

    public boolean estTouche() {
        for (int i = 0; i < environnement.getListEnnemis().size(); i++) {
            Ennemis ennemieCible = environnement.getListEnnemis().get(i);

            if (this.getX() >= ennemieCible.getHitbox().getX() - 10 &&
                    this.getX() <= ennemieCible.getHitbox().getX() - 15 + ennemieCible.getHitbox().getWidth() &&
                    this.getY() >= ennemieCible.getHitbox().getY() - 10 &&
                    this.getY() <= ennemieCible.getHitbox().getY() - 15 + ennemieCible.getHitbox().getHeight()) {
                System.out.println("Ennemi touché");
                ennemieCible.subirDegats(degat);
                ennemieCible.meurt();
                return true;
            }
        }
        return false;
    }

    public String getId () {
        return this.id;
    }
    public IntegerProperty getXProperty() {
        return x;
    }

    public IntegerProperty getYProperty() {
        return y;
    }

    public void setX(int x) {
        this.x.set(this.x.getValue()+x);
    }

    public void setY(int y) {
        this.y.set(this.y.getValue()+y);
    }

    public int getX() {
        return this.x.get();
    }

    public int getY() {
        return this.y.get();
    }

    public int getxDirection() {
        return xDirection;
    }

    public int getyDirection() {
        return yDirection;
    }
}

