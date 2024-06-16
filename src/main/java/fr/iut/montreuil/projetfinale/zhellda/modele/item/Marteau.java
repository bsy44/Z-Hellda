package fr.iut.montreuil.projetfinale.zhellda.modele.item;

import fr.iut.montreuil.projetfinale.zhellda.modele.Environnement;
import fr.iut.montreuil.projetfinale.zhellda.modele.personnage.Ennemis;
import fr.iut.montreuil.projetfinale.zhellda.modele.personnage.Joueur;

import static java.lang.Math.sqrt;

public class Marteau extends Arme {
    public Marteau(Environnement environnement, int x, int y) {
        super(x, y, "marteau", environnement, 1, 120);
    }

    @Override
    public void attaquer(Joueur j, int x, int y) {
        Ennemis ennemie = null;
        for (int i = 0; i < getEnvironnement().getListEnnemis().size(); i++) {
            ennemie = getEnvironnement().getListEnnemis().get(i);
            if (ennemie.getType()==0) {
                if (j.getX() == x) {
                    if ((sqrt(Math.pow(ennemie.getX() - j.getX(), 2))) <= 40 && ((ennemie.getY() >= j.getY() && ennemie.getY() <= y) || ((ennemie.getY() <= j.getY() && ennemie.getY() >= y)))) {
                        ennemie.subirDegats(getAttaque());
                    }
                }
                else {
                    if ((sqrt(Math.pow(ennemie.getY() - j.getY(), 2))) <= 40 && ((ennemie.getX() >= j.getX() && ennemie.getX() <= x) || ((ennemie.getX() <= j.getX() && ennemie.getX() >= x)))) {
                        ennemie.subirDegats(getAttaque());
                    }
                }
            }
            ennemie.meurt();
        }
    }
}
