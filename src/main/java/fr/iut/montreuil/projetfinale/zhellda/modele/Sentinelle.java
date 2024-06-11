package fr.iut.montreuil.projetfinale.zhellda.modele;

public class Sentinelle extends Ennemis{
    public Sentinelle(int x, int y, Environnement environnement) {
        super(x, y, 15, 2, 5, 40, 40, 40, environnement, "sentinelle");
    }

    @Override
    public int getPvMax() {
        return 15;
    }

    @Override
    public void agir () {
        if (getCheminVersJoueur().size() < 15){
            //seDeplacer();
            attaquer();
        }
    }
}
