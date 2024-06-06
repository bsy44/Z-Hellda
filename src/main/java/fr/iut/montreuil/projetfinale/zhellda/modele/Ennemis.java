package fr.iut.montreuil.projetfinale.zhellda.modele;

import java.util.ArrayList;

import static fr.iut.montreuil.projetfinale.zhellda.modele.Bfs.*;

public abstract class Ennemis extends Acteur {
    private static int compteur = 1;
    private int vitesse;
    private int attaque;
    private int portee;
    private int type;//0 pour sol et 1 pour aérien
    private ArrayList<Case> cheminVersJoueur;

    public Ennemis(int x, int y, int vie, int vitesse, int attaque, int portee, int HitBoxW, int HitBoxH, Environnement environnement){
        super(x, y, vie,vitesse,"#"+compteur, HitBoxW, HitBoxH, environnement);
        compteur++;
        this.attaque = attaque;
        this.portee=portee;
        this.type=type;
        this.cheminVersJoueur = Environnement.getBfs().cheminVersSource(x, y);
    }

    public int getPortee() {
        return portee;
    }

    public int getType() {
        return type;
    }

    public int getVitesse() {
        return vitesse;
    }

    public int getAttaque() {
        return attaque;
    }

    public abstract void attaquer();


    public abstract int getPvMax();

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

    public void nouveauChemin (){
      cheminVersJoueur = Environnement.getBfs().cheminVersSource(getX(), getY());
    }

}
