package fr.iut.montreuil.projetfinale.zhellda.modele.personnage;

import fr.iut.montreuil.projetfinale.zhellda.modele.Environnement;

public class SchemaAttaqueRalentissant implements SchemaAttaqueEnnemi {

    public void attaquer(Environnement environnement, Ennemi ennemi) {
        for (int i = 0; i < environnement.getListObsJoueur().size(); i++) {
            Joueur j = environnement.getListObsJoueur().get(i);

            double distance = Math.sqrt(Math.pow(ennemi.getXProperty().get() - j.getXProperty().get(), 2) + Math.pow(ennemi.getYProperty().get() - j.getYProperty().get(), 2));
            if (distance <= ennemi.getPortee() && distance >= 0) {
                if (!j.isEtatAltere()) {
                    j.setEtatAltere(true);
                    j.debuffVitesse(2);
                }
                j.subirDegats(ennemi.getAttaque());
                j.meurt();
            }

        }
    }
}
