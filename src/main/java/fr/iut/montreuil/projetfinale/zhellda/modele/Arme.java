package fr.iut.montreuil.projetfinale.zhellda.modele;

import java.awt.*;

public abstract class Arme {
    private int portee;
    private int attaque;
    private Environnement env;
//    Image image;

    public Arme (Environnement env, int attaque, int portee){
        this.attaque=attaque;
        this.portee=portee;
        this.env =env;
//        this.image=image;
    }
//
//    public Image getImage() {
//        return image;
//    }

    public Environnement getEnvironnement() {
        return env;
    }

    public abstract void attaquer(Joueur j, int x, int y);


    public int getPortee (){
        return this.portee;
    }

    public int getAttaque() {
        return attaque;
    }
}
