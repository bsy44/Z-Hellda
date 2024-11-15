package fr.iut.montreuil.projetfinale.zhellda.modele.AttaqueJoueur;

import fr.iut.montreuil.projetfinale.zhellda.modele.Environnement;
import fr.iut.montreuil.projetfinale.zhellda.modele.item.Arme;
import fr.iut.montreuil.projetfinale.zhellda.modele.personnage.Joueur;
import fr.iut.montreuil.projetfinale.zhellda.modele.projectile.Fleche;
import fr.iut.montreuil.projetfinale.zhellda.modele.projectile.Projectile;

public abstract class ArmeAirSol extends Arme {
    public ArmeAirSol(int x, int y, String nom, int attaque, int portee) {
        super(x, y, nom, attaque, portee);
    }
}
