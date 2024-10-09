package fr.iut.montreuil.projetfinale.zhellda.modele.personnage;

import fr.iut.montreuil.projetfinale.zhellda.modele.Environnement;

public class AttaqueRalentissant implements AttaqueEnnemis{

    public void attaqer(Environnement environnement,Ennemis ennemis) {
        for (int i = 0; i < environnement.getListObsJoueur().size(); i++) {
            Joueur j = environnement.getListObsJoueur().get(i);

            double distance = Math.sqrt(Math.pow(ennemis.getXProperty().get() - j.getXProperty().get(), 2) + Math.pow(ennemis.getYProperty().get() - j.getYProperty().get(), 2));
            if (distance <= ennemis.getPortee() && distance >= 0) {
                if (!j.isEtatAltere()) {
                    j.setEtatAltere(true);
                    j.debuffVitesse(2);
                }
                j.subirDegats(ennemis.getAttaque());
                j.meurt();
            }

        }
    }
}
