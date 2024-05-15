package fr.iut.montreuil.projetfinale.zhellda.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Ennemis extends Acteur{
    private static int compteur = 1;
    private int vitesse;

    public Ennemis(int x, int y, int vie, int vitesse){
        super(x, y, vie,""+compteur);
        compteur++;
        this.vitesse = vitesse;
    }
}
