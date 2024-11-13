package fr.iut.montreuil.projetfinale.zhellda.modele.item;

import fr.iut.montreuil.projetfinale.zhellda.modele.Environnement;
import fr.iut.montreuil.projetfinale.zhellda.modele.projectile.Fleche;
import fr.iut.montreuil.projetfinale.zhellda.modele.projectile.Projectile;
import fr.iut.montreuil.projetfinale.zhellda.modele.personnage.Joueur;

public class Arc extends Arme {
    public Arc (int x, int y){
        super(x, y, "arc",50,120);
    }

    @Override
    public void attaquer (Joueur j, int x, int y) {
        System.out.println("attaque Arc");
        Projectile projectile = new Fleche(j.getX(), j.getY(), x,y);
        Environnement.getUniqueInstance().ajouterProjectile(projectile);
    }
}
