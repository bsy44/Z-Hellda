package fr.iut.montreuil.projetfinale.zhellda.modele.personnage;

import fr.iut.montreuil.projetfinale.zhellda.modele.Environnement;

public class Sentinelle extends Ennemis{
    public Sentinelle(int x, int y, Environnement environnement) {
        super(x, y, 15, 2, 4, 40, 40, 50, environnement, "sentinelle");
    }

    @Override
    public void attaquer() {
        for (int i = 0; i < environnement.getListObsJoueur().size(); i++) {
            Joueur j = environnement.getListObsJoueur().get(i);

            double distance = Math.sqrt(Math.pow(this.getXProperty().get() - j.getXProperty().get(), 2) + Math.pow(this.getYProperty().get() - j.getYProperty().get(), 2));
            if (distance <= this.getPortee() && distance >= 0) {
                j.subirDegats(this.getAttaque());
                j.meurt();
            }
        }
    }

    @Override
    public int getPvMax() {
        return 15;
    }

    @Override
    public void agit() {
        if (getCheminVersJoueur().size() < 15){
            seDeplacer();
            attaquer();
        }
    }
}
