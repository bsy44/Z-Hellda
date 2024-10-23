package fr.iut.montreuil.projetfinale.zhellda.modele.item;

import fr.iut.montreuil.projetfinale.zhellda.modele.Environnement;
import fr.iut.montreuil.projetfinale.zhellda.modele.personnage.Joueur;

public abstract class Arme extends Item{
    private int portee;
    private int attaque;
    private int indexInventaire;

    public Arme (int x, int y, String nom, int attaque, int portee){
        super(x, y, nom, "arme");
        this.attaque = attaque;
        this.portee = portee;
        this.indexInventaire = -1;
    }

    public abstract void attaquer(Joueur joueur, int x, int y);

    public int getPortee (){
        return this.portee;
    }

    public int getAttaque() {
        return attaque;
    }

    public int getIndexInventaire() {
        return indexInventaire;
    }

    public void setIndexInventaire(int indexInventaire) {
        this.indexInventaire = indexInventaire;
    }

    public void setAttaque(int attaque) {
        this.attaque = attaque;
    }

    @Override
    public String toString() {
        return "nom : "+ getNom() + "Dégat : " + getAttaque() + ", portée : " + getPortee();
    }
}
