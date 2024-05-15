package fr.iut.montreuil.projetfinale.zhellda.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Ennemis extends Acteur{
    private static int compteur = 1;
    private int vitesse;

    private int attaque;

    public Ennemis(int x, int y, int vie, int vitesse, int attaque){
        super(x, y, vie,""+compteur);
        compteur++;
        this.vitesse = vitesse;
        this.attaque = attaque;
    }

    public int getAttaque() {
        return attaque;
    }

    public abstract void attaquer (Joueur j);

    public abstract void seDeplacer ();

}
