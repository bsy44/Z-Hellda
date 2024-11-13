package fr.iut.montreuil.projetfinale.zhellda.modele.projectile;

import fr.iut.montreuil.projetfinale.zhellda.modele.Environnement;
import fr.iut.montreuil.projetfinale.zhellda.modele.personnage.Ennemi;

public class Fleche extends Projectile {
    public Fleche(int x, int y, int xDirection, int yDirection) {
        super(15, x, y, xDirection, yDirection, 1);
    }

    @Override
    public boolean estTouche() {
        for (int i = 0; i < Environnement.getUniqueInstance().getListEnnemis().size(); i++) {
            Ennemi ennemieCible = Environnement.getUniqueInstance().getListEnnemis().get(i);

            if (this.getX() >= ennemieCible.getHitbox().getX() - 10 &&
                    this.getX() <= ennemieCible.getHitbox().getX() - 15 + ennemieCible.getHitbox().getWidth() &&
                    this.getY() >= ennemieCible.getHitbox().getY() - 10 &&
                    this.getY() <= ennemieCible.getHitbox().getY() - 15 + ennemieCible.getHitbox().getHeight()) {
                System.out.println("Ennemi touché");
                ennemieCible.subirDegats(getDegat());
                ennemieCible.meurt();
                return true;
            }
        }
        return false;
    }

}
