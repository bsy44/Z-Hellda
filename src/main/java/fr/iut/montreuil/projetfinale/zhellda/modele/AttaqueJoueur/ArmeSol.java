package fr.iut.montreuil.projetfinale.zhellda.modele.AttaqueJoueur;

import fr.iut.montreuil.projetfinale.zhellda.modele.Environnement;
import fr.iut.montreuil.projetfinale.zhellda.modele.item.Arme;
import fr.iut.montreuil.projetfinale.zhellda.modele.personnage.Ennemi;
import fr.iut.montreuil.projetfinale.zhellda.modele.personnage.Joueur;

import static java.lang.Math.sqrt;

public abstract class ArmeSol extends Arme {


    public ArmeSol(int x, int y, String nom, int attaque, int portee) {
        super(x, y, nom, attaque, portee);
    }

    public void attaqueSol(Joueur j, int x, int y, double maxDistance, boolean toucherPlusieurs) {
        boolean ennemieTouche = false;

        for (int i = 0; i < Environnement.getUniqueInstance().getListEnnemis().size(); i++) {
            if (ennemieTouche && !toucherPlusieurs) {
                break;
            }

            Ennemi ennemie = Environnement.getUniqueInstance().getListEnnemis().get(i);
            if (!ennemie.getAerien()) {
                double distance;
                if (j.getX() == x) {
                    distance = sqrt(Math.pow(ennemie.getX() - j.getX(), 2));
                    if (distance <= maxDistance && ((ennemie.getY() >= j.getY() && ennemie.getY() <= y) || (ennemie.getY() <= j.getY() && ennemie.getY() >= y))) {
                        ennemie.subirDegats(getAttaque());
                        ennemie.meurt();
                        ennemieTouche = true;
                    }
                } else {
                    distance = sqrt(Math.pow(ennemie.getY() - j.getY(), 2));
                    if (distance <= maxDistance && ((ennemie.getX() >= j.getX() && ennemie.getX() <= x) || (ennemie.getX() <= j.getX() && ennemie.getX() >= x))) {
                        ennemie.subirDegats(getAttaque());
                        ennemie.meurt();
                        ennemieTouche = true;
                    }
                }
            }
        }
    }

}
