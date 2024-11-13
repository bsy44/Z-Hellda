package fr.iut.montreuil.projetfinale.zhellda.modele.personnage;

import fr.iut.montreuil.projetfinale.zhellda.modele.Environnement;

public class SchemaAttaqueClassique implements SchemaAttaqueEnnemi {


    @Override
    public void attaquer(Ennemi ennemi) {
        for (int i = 0; i < Environnement.getUniqueInstance().getListObsJoueur().size(); i++) {
            Joueur j = Environnement.getUniqueInstance().getListObsJoueur().get(i);

            double distance = Math.sqrt(Math.pow(ennemi.getXProperty().get() - j.getXProperty().get(), 2) + Math.pow(ennemi.getYProperty().get() - j.getYProperty().get(), 2));
            if (distance <= ennemi.getPortee() && distance >= 0) {
                j.subirDegats(ennemi.getAttaque());
                j.meurt();
            }
        }
    }
}
