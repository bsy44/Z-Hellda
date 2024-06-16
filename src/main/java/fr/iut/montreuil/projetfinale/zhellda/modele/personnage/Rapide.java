package fr.iut.montreuil.projetfinale.zhellda.modele.personnage;

import fr.iut.montreuil.projetfinale.zhellda.modele.Environnement;

public class Rapide extends Ennemis{
    public Rapide(int x, int y, Environnement environnement) {
        super(x, y, 5, 3, 1, 50,30,30, environnement, "rapide");
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
        return 5;
    }

    @Override
    public void agit() {
        seDeplacer();
        attaquer();
    }
}
