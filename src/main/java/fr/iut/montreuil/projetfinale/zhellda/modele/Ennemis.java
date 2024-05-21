package fr.iut.montreuil.projetfinale.zhellda.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Ennemis extends Acteur{

    private IntegerProperty x = new SimpleIntegerProperty();
    private IntegerProperty y = new SimpleIntegerProperty();
    private static int compteur = 1;
    private int vitesse;
    private IntegerProperty vie = new SimpleIntegerProperty();
    private int attaque;

    private int portee;

    public Ennemis(int x, int y, int vie, int vitesse, int attaque, int portee, Environnement environnement){
        super(x, y, vie,""+compteur, environnement);
        compteur++;
        this.vitesse = vitesse;
        this.attaque = attaque;
        this.portee=portee;
    }

    public int getAttaque() {
        return attaque;
    }

    public void attaquer () {
        for (int i = 0; i < environnement.getObsJoueur().size(); i++) {
            Joueur j = environnement.getObsJoueur().get(i);

            double distance = Math.sqrt(Math.pow(this.getXProperty().get() - j.getXProperty().get(), 2) + Math.pow(this.getYProperty().get() - j.getYProperty().get(), 2));
            if (distance <= this.portee && distance >= 0) {
                j.subirDegats(this.attaque);
                environnement.mortJoueur();this.x.getValue();
            }
        }
    }

    public abstract void seDeplacer ();

}
