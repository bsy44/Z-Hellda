package fr.iut.montreuil.projetfinale.zhellda.modele.arme;

import fr.iut.montreuil.projetfinale.zhellda.modele.personnage.Ennemis;
import fr.iut.montreuil.projetfinale.zhellda.modele.Environnement;
import fr.iut.montreuil.projetfinale.zhellda.modele.personnage.Joueur;

public abstract class Arme {
    private int portee;
    private int attaque;
    private Environnement environnement;

    public Arme (Environnement env, int attaque, int portee){
        this.attaque=attaque;
        this.portee=portee;
        this.environnement=env;
    }

    public Environnement getEnvironnement() {
        return environnement;
    }

    public Ennemis attaquer (Joueur j){
        for (int i = 0; i < environnement.getObsEnnemis().size();i++) {
            Ennemis ennemie = environnement.getObsEnnemis().get(i);

            double distance = Math.sqrt(Math.pow(ennemie.getXProperty().get()- j.getXProperty().get(),2)+Math.pow(ennemie.getYProperty().get() - j.getYProperty().get(),2));
            if (distance <= this.portee && distance >= 0) {
                ennemie.subirDegats(this.attaque);
                environnement.ennemiMort();
                return ennemie;
            }
        }
        return null;

    }


    public int getPortee (){
        return this.portee;
    }

    public int getAttaque() {
        return attaque;
    }
}
