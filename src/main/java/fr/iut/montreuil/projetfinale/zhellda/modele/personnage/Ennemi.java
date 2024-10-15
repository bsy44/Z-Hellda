package fr.iut.montreuil.projetfinale.zhellda.modele.personnage;

import fr.iut.montreuil.projetfinale.zhellda.modele.*;
import fr.iut.montreuil.projetfinale.zhellda.modele.item.GrimoirArme;
import fr.iut.montreuil.projetfinale.zhellda.modele.item.Item;
import fr.iut.montreuil.projetfinale.zhellda.modele.item.PommeDor;
import fr.iut.montreuil.projetfinale.zhellda.modele.item.PotionMagique;

import java.util.ArrayList;

public abstract class Ennemi extends Acteur {
    private static int compteur = 0;
    private int attaque;
    private int portee;
    private String nom;
    private boolean aerien;
    private ArrayList<Case> cheminVersJoueur;
    private SchemaAttaqueEnnemi schemaAttaqueEnnemi;

    public Ennemi(int x, int y, int vie, int vitesse, int attaque, int portee, int HitBoxW, int HitBoxH, Environnement environnement, String nom, boolean aerien, SchemaAttaqueEnnemi schemaAttaqueEnnemi){
        super(x, y, vie,vitesse,nom+"#"+compteur, HitBoxW, HitBoxH, environnement);
        this.attaque = attaque;
        this.portee=portee;
        this.aerien = aerien;
        this.nom = nom;
        this.cheminVersJoueur = Environnement.getBfs().cheminVersSource(x, y);
        this.schemaAttaqueEnnemi = schemaAttaqueEnnemi;
        compteur++;
    }

    public int getPortee() {
        return portee;
    }

    public boolean getAerien() {
        return aerien;
    }

    public int getAttaque() {
        return attaque;
    }

    public void attaquer(){
        getSchemaAttaqueEnnemi().attaquer(environnement, this);
    }

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

    @Override
    public void agit() {
        seDeplacer();
        attaquer();
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
            Ennemi e = environnement.getListEnnemis().get(i);
            if(e.getVie().get()==0){
                this.dropItem(e);
                System.out.println("mort de : " + e);
                environnement.getListEnnemis().remove(i);
                return true;
            }
        }
        return false;
    }

    public Item dropItem(Ennemi e){
        Item item = null;
        if (e.reussitProba(Zombie.getPourcentageDropItem())){
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
        return item;
    }

    public ArrayList<Case> getCheminVersJoueur() {
        return cheminVersJoueur;
    }

    public SchemaAttaqueEnnemi getSchemaAttaqueEnnemi() {
        return schemaAttaqueEnnemi;
    }
}
