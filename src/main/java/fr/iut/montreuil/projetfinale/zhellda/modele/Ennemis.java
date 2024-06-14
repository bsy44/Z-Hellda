package fr.iut.montreuil.projetfinale.zhellda.modele;

import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Random;

public abstract class Ennemis extends Acteur {
    private static int compteur = 1;
    private int vitesse;
    private int attaque;
    private int portee;
    private String nom;
    private int type;//0 pour sol et 1 pour aérien
    private ArrayList<Case> cheminVersJoueur;

    public Ennemis(int x, int y, int vie, int vitesse, int attaque, int portee, int HitBoxW, int HitBoxH, Environnement environnement, String nom){
        super(x, y, vie,vitesse,"#"+compteur, HitBoxW, HitBoxH, environnement);
        compteur++;
        this.attaque = attaque;
        this.portee=portee;
        this.type=type;
        this.nom = nom;
        this.cheminVersJoueur = Environnement.getBfs().cheminVersSource(x, y);
    }

    public int getPortee() {
        return portee;
    }

    public int getType() {
        return type;
    }

    public int getAttaque() {
        return attaque;
    }

    public abstract int getPvMax();

    public String getNom() {
        return nom;
    }

    public void attaquer() {
        for (int i = 0; i < environnement.getObsJoueur().size(); i++) {
            Joueur j = environnement.getObsJoueur().get(i);

            double distance = Math.sqrt(Math.pow(this.getXProperty().get() - j.getXProperty().get(), 2) + Math.pow(this.getYProperty().get() - j.getYProperty().get(), 2));
            if (distance <= this.getPortee() && distance >= 0) {
                j.subirDegats(this.getAttaque());
                environnement.mortJoueur();
                this.getX();
            }
        }
    }

    public void seDeplacer (){
        Case c;
        for (int i=0; i < this.getVitesse(); i++) {
            if (!cheminVersJoueur.isEmpty()){
                c = cheminVersJoueur.get(0);
                setX(Math.round(c.getX() * 16));
                setY(Math.round(c.getY() * 16));
                cheminVersJoueur.remove(0);
            }
        }
    }

    public boolean reussitProba(double pourcent){
        double x= Math.random();
        double pp=pourcent/100;
        return (x<=pp);
    }

    public void nouveauChemin (){
      cheminVersJoueur = Environnement.getBfs().cheminVersSource(getX(), getY());
    }

    public void agir (){
//        seDeplacer();
        attaquer();
    }

    public ArrayList<Case> getCheminVersJoueur() {
        return cheminVersJoueur;
    }
}
