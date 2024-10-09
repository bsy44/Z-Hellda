package fr.iut.montreuil.projetfinale.zhellda.modele.personnage;

import fr.iut.montreuil.projetfinale.zhellda.modele.Environnement;

public class Zombie extends Ennemis {

    private static double pourcentageDropItem = 100;
    public Zombie(int x, int y, Environnement environnement) {
        super(x, y, 10, 2, 1, 35,30, 30, environnement, "zombie", false, new AttaqueClassique());
    }

    public int getPvMax() {return 10;}

    public static double getPourcentageDropItem() {
        return pourcentageDropItem;
    }

    @Override
    public void agit() {
        seDeplacer();
        attaquer();
    }
}
