package fr.iut.montreuil.projetfinale.zhellda.modele.projectile;

import fr.iut.montreuil.projetfinale.zhellda.modele.Environnement;
import fr.iut.montreuil.projetfinale.zhellda.modele.personnage.Joueur;

public class BouleDeFeu extends Projectile {
    public BouleDeFeu(int x, int y, int xDirection, int yDirection) {
        super(5, x, y, xDirection, yDirection, 1);
    }

    @Override
    public boolean estTouche() {
        for (int i = 0; i < Environnement.getUniqueInstance().getListObsJoueur().size(); i++) {
            Joueur joueurCible = Environnement.getUniqueInstance().getListObsJoueur().get(i);

            if (this.getX() + 20 >= joueurCible.getHitbox().getX() - 0 &&
                    this.getX() - 20 <= joueurCible.getHitbox().getX() - 5 + joueurCible.getHitbox().getWidth() &&
                    this.getY() + 20 >= joueurCible.getHitbox().getY() - 0 &&
                    this.getY() - 20 <= joueurCible.getHitbox().getY() - 5 + joueurCible.getHitbox().getHeight()) {
                joueurCible.subirDegats(getDegat());
                return true;
            }
        }
        return false;
    }
}
