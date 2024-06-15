package fr.iut.montreuil.projetfinale.zhellda.modele;

public class BouleDeFeu extends Projectile {
    public BouleDeFeu(int x, int y, int xDirection, int yDirection, Environnement environnement) {
        super(5, x, y, xDirection, yDirection, 1, environnement);
    }

    @Override
    public boolean estTouche() {
        for (int i = 0; i < environnement.getObsJoueur().size(); i++) {
            Joueur joueurCible = environnement.getObsJoueur().get(i);

            if (this.getX() >= joueurCible.getHitbox().getX() - 0 &&
                    this.getX() <= joueurCible.getHitbox().getX() - 5 + joueurCible.getHitbox().getWidth() &&
                    this.getY() >= joueurCible.getHitbox().getY() - 0 &&
                    this.getY() <= joueurCible.getHitbox().getY() - 5 + joueurCible.getHitbox().getHeight()) {
                joueurCible.subirDegats(getDegat());
                return true;
            }
        }
        return false;
    }
}
