package fr.iut.montreuil.projetfinale.zhellda.modele;

public class Rapide extends Ennemis{
    public Rapide(int x, int y, Environnement environnement) {
        super(x, y, 5, 3, 1, 50,30,30, environnement, "rapide");
    }

    @Override
    public int getPvMax() {
        return 5;
    }

}
