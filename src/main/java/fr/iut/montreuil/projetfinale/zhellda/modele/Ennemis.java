package fr.iut.montreuil.projetfinale.zhellda.modele;

import java.util.ArrayList;
import java.util.Random;

public abstract class Ennemis extends Acteur {
    private static int compteur = 0;
    private int attaque;
    private int portee;
    private String nom;
    private int type;//0 pour sol et 1 pour aérien
    private ArrayList<Case> cheminVersJoueur;

    public Ennemis(int x, int y, int vie, int vitesse, int attaque, int portee, int HitBoxW, int HitBoxH, Environnement environnement, String nom){
        super(x, y, vie,vitesse,nom+"#"+compteur, HitBoxW, HitBoxH, environnement);
        this.attaque = attaque;
        this.portee=portee;
        this.type = type;
        this.nom = nom;
        this.cheminVersJoueur = Environnement.getBfs().cheminVersSource(x, y);
        compteur++;
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

    @Override
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

    @Override
    public boolean meurt() {
        for(int i = environnement.getListEnnemis().size()-1; i>=0;i--){
            Ennemis e = environnement.getListEnnemis().get(i);
            if(e.getVie().get()==0){
                if (e.reussitProba(Zombie.getPourcentageDropItem())){
                    Item item;
                    double random = Math.random();
                    if (random < 0.33) {
                        item = new PommeDor(e.getX(), e.getY());
                    }
                    else if (random < 0.66){
                        item = new PotionMagique(e.getX(), e.getY());
                    }
                    else {
                        item = new GrimoirArme(e.getX(), e.getY());
                    }
                    environnement.getListItemParTerre().add(item);
                }
                System.out.println("mort de : " + e);
                environnement.getListEnnemis().remove(i);
                return true;
            }
        }
        return false;
    }
}
