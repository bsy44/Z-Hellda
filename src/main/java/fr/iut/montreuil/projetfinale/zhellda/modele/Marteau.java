package fr.iut.montreuil.projetfinale.zhellda.modele;

import static java.lang.Math.sqrt;

public class Marteau extends Arme {
    public Marteau(Environnement environnement) {
        super(environnement, 1, 40);
    }

    @Override
    public void attaquer(Joueur j, int x, int y) {
        for (int i = 0; i < getEnvironnement().getObsEnnemis().size(); i++) {
            Ennemis ennemie = getEnvironnement().getObsEnnemis().get(i);
            if (ennemie.getType()==0) {


                if (j.getX() == x) {
                    if ((sqrt(Math.pow(ennemie.getX() - j.getX(), 2))) <= 40 && ((ennemie.getY() >= j.getY() && ennemie.getY() <= y) || ((ennemie.getY() <= j.getY() && ennemie.getY() >= y)))) {
                        ennemie.subirDegats(getAttaque());
                    }
                } else {
                    if ((sqrt(Math.pow(ennemie.getY() - j.getY(), 2))) <= 40 && ((ennemie.getX() >= j.getX() && ennemie.getX() <= x) || ((ennemie.getX() <= j.getX() && ennemie.getX() >= x)))) {
                        ennemie.subirDegats(getAttaque());
                    }
                }
            }



        }
        this.getEnvironnement().ennemiMort();
    }
}