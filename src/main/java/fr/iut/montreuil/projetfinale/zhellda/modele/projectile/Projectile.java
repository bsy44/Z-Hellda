package fr.iut.montreuil.projetfinale.zhellda.modele.projectile;

import fr.iut.montreuil.projetfinale.zhellda.modele.Environnement;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Projectile extends Entite {
    private int vitesse;
    private static int compteur;
    private int xDirection;
    private int yDirection;
    private int degat;

    public Projectile(int vitesse, int x, int y, int xDirection, int yDirection, int degat) {
        super(x,y,"P" + compteur);
        compteur++;
        this.vitesse = vitesse;
        this.xDirection= xDirection;
        this.yDirection=yDirection;
        this.degat=degat;

    }

    public boolean tirProjectile (){
        if (this.getX() < this.xDirection || this.getY()<this.yDirection) {
            if (this.getX() < this.xDirection)
                this.setX(this.getX()+vitesse);
            else
                this.setY(this.getY()+vitesse);
            return true;
        }
        else if (this.getX() > this.xDirection || this.getY()>this.yDirection){
            if (this.getX()> this.xDirection)
                this.setX(this.getX()-vitesse);
            else
                this.setY(this.getY()-vitesse);
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

    public abstract boolean estTouche();

    public int getDegat() {
        return degat;
    }

    public int getxDirection() {
        return xDirection;
    }

    public int getyDirection() {
        return yDirection;
    }
}

