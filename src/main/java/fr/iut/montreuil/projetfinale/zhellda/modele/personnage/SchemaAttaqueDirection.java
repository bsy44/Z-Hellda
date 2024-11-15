package fr.iut.montreuil.projetfinale.zhellda.modele.personnage;

import fr.iut.montreuil.projetfinale.zhellda.modele.Environnement;

public abstract class SchemaAttaqueDirection extends SchemaAttaqueBoss {

    @Override
    public void faireAttaque (Boss boss) {
        String direction = direction(boss);

        if (direction.equals("droite")) faireAttaqueDroite(boss);

        else if (direction.equals("gauche")) faireAttaqueGauche(boss);

        else if (direction.equals("bas")) faireAttaqueBas(boss);

        else faireAttaqueHaut(boss);
    }

    public String direction(Ennemi ennemi){
        // Est à 0 si on est collé à la hitbox du boss et augmente plus on s'en éloigne
        // Passe en négatif si on est dans la direction opposé
        double yBas = Environnement.getJ().getY() - (ennemi.getY() + ennemi.getHitbox().getHeight());
        double yHaut = ennemi.getY() - (Environnement.getJ().getY() + Environnement.getJ().getHitbox().getHeight());
        double xDroite = Environnement.getJ().getX() - (ennemi.getX() + ennemi.getHitbox().getWidth());
        double xGauche = ennemi.getX() - (Environnement.getJ().getX() + Environnement.getJ().getHitbox().getWidth());

        String direction = "bas";
        double max = yBas;

        if (yHaut > max) {
            max = yHaut;
            direction = "haut";
        }
        if (xDroite > max) {
            max = xDroite;
            direction = "droite";
        }
        if (xGauche > max) direction = "gauche";

        return direction;
    }

    public abstract void faireAttaqueDroite(Boss boss);
    public abstract void faireAttaqueGauche(Boss boss);
    public abstract void faireAttaqueHaut(Boss boss);
    public abstract void faireAttaqueBas(Boss boss);
}
