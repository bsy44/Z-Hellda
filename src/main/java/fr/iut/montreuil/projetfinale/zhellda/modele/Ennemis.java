package fr.iut.montreuil.projetfinale.zhellda.modele;

import java.util.ArrayList;
import java.util.Random;

import static fr.iut.montreuil.projetfinale.zhellda.modele.Bfs.*;

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

    public abstract void attaquer();

    public abstract int getPvMax();

    public String getNom() {
        return nom;
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

    public Case genererSpawn() {
        Random random = new Random();
        int randomNb = random.nextInt(5)+1;
        if (randomNb == 1) {
            return SommetEnnemie(1);
        }
        if (randomNb == 2) {
            return SommetEnnemie(2);
        }
        if (randomNb == 3) {
            return SommetEnnemie(3);
        }
        if (randomNb == 4) {
            return SommetEnnemie(4);
        }
        if (randomNb == 5) {
            return SommetEnnemie(4);
        }
        return null;
    }
    public Case SommetEnnemie (int spawnEnnemie) {
        switch (spawnEnnemie){
            case 1:
                return new Case(240/30,0);
            case 2:
                return new Case(0,390/30);
            case 3:
                return new Case(240/30,1560/30);
            case 4:
                return new Case(1560/30,1140/30);
            case 5:
                return new Case(1410/30,570/30);
        }
        return null;
    }
}
