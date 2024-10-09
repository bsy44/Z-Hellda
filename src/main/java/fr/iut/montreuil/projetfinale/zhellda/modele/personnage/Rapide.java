package fr.iut.montreuil.projetfinale.zhellda.modele.personnage;

import fr.iut.montreuil.projetfinale.zhellda.modele.Environnement;

public class Rapide extends Ennemis{
    public Rapide(int x, int y, Environnement environnement) {
        super(x, y, 5, 3, 1, 50,30,30, environnement, "rapide", true, new AttaqueClassique());
    }

    @Override
    public int getPvMax() {
        return 5;
    }

    @Override
    public void agit() {
        seDeplacer();
        attaquer();
    }
}
