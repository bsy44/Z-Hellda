package fr.iut.montreuil.projetfinale.zhellda.modele.arme;

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


//    public boolean estTouche() {
//        Ennemis ennemieCible;
//        for (int i = 0; i < environnement.getObsEnnemis().size(); i++) {
//            ennemieCible = environnement.getObsEnnemis().get(i);
////            if (this.getX() >= ennemieCible.getX() && this.getY() <= (ennemieCible.getHitbox().getX() + ennemieCible.getHitbox().getWidth()) && this.getY() >= ennemieCible.getHitbox().getY() && this.getY() <= (ennemieCible.getHitbox().getY() + ennemieCible.getHitbox().getHeight())) {
//            if (!(this.getX()>=ennemieCible.getHitbox().getX()+ ennemieCible.getHitbox().getWidth() && this.getY()>=ennemieCible.getHitbox().getY()+ ennemieCible.getHitbox().getHeight())){
//                System.out.println("cest la merde");
//                ennemieCible.subirDegats(degat);
//                return true;
//            }
//        }
//                return false;
//
//    }

    public boolean estTouche() {
        for (int i = 0; i < environnement.getObsEnnemis().size(); i++) {
            Ennemis ennemieCible = environnement.getObsEnnemis().get(i);

            if (this.getX() >= ennemieCible.getHitbox().getX() - 6 &&
                    this.getX() <= ennemieCible.getHitbox().getX() - 6 + ennemieCible.getHitbox().getWidth() &&
                    this.getY() >= ennemieCible.getHitbox().getY() - 6 &&
                    this.getY() <= ennemieCible.getHitbox().getY() - 6 + ennemieCible.getHitbox().getHeight()) {
                System.out.println("Ennemi touché");
                ennemieCible.subirDegats(degat);
                environnement.ennemiMort();
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

}

