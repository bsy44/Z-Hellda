package fr.iut.montreuil.projetfinale.zhellda.modele.personnage;

import fr.iut.montreuil.projetfinale.zhellda.modele.Environnement;

public class Tank extends Ennemis{
    public Tank(int x, int y,  Environnement environnement) {
        super(x, y, 20, 1, 2, 35, 50, 50, environnement, "tank");
    }

    @Override
    public void attaquer() {
        for (int i = 0; i < environnement.getListObsJoueur().size(); i++) {
            Joueur j = environnement.getListObsJoueur().get(i);

            double distance = Math.sqrt(Math.pow(this.getXProperty().get() - j.getXProperty().get(), 2) + Math.pow(this.getYProperty().get() - j.getYProperty().get(), 2));
            if (distance <= this.getPortee() && distance >= 0) {
                if (!j.isEtatAltere()){
                    j.setEtatAltere(true);
                    j.debuffVitesse(2);
                }
                j.subirDegats(this.getAttaque());
                Environnement.getJ().meurt();
                this.getX();
            }
        }
    }

    @Override
    public int getPvMax() {
        return 20;
    }
}