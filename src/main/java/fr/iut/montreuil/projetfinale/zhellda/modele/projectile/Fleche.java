package fr.iut.montreuil.projetfinale.zhellda.modele.projectile;

import fr.iut.montreuil.projetfinale.zhellda.modele.Environnement;

public class Fleche extends Projectile {
    public Fleche(int x, int y, int xDirection, int yDirection, Environnement environnement) {
        super(15, x, y, xDirection, yDirection, 1, environnement);
    }

    @Override
    public boolean estTouche() {
        for (int i = 0; i < environnement.getObsEnnemis().size(); i++) {
            Ennemis ennemieCible = environnement.getObsEnnemis().get(i);

            if (this.getX() >= ennemieCible.getHitbox().getX() - 10 &&
                    this.getX() <= ennemieCible.getHitbox().getX() - 15 + ennemieCible.getHitbox().getWidth() &&
                    this.getY() >= ennemieCible.getHitbox().getY() - 10 &&
                    this.getY() <= ennemieCible.getHitbox().getY() - 15 + ennemieCible.getHitbox().getHeight()) {
                System.out.println("Ennemi touché");
                ennemieCible.subirDegats(getDegat());
                environnement.ennemiMort();
                return true;
            }
        }
        return false;
    }

}
