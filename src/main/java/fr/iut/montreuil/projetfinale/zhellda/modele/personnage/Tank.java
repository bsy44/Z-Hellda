package fr.iut.montreuil.projetfinale.zhellda.modele.personnage;

import fr.iut.montreuil.projetfinale.zhellda.modele.Environnement;

public class Tank extends Ennemis{
    public Tank(int x, int y,  Environnement environnement) {
        super(x, y, 20, 1, 2, 35, 50, 50, environnement, "tank", false, new AttaqueRalentissant());
    }

    @Override
    public int getPvMax() {
        return 20;
    }

    @Override
    public void agit() {
        seDeplacer();
        attaquer();
    }
}