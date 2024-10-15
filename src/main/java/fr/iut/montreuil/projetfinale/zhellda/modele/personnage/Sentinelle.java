package fr.iut.montreuil.projetfinale.zhellda.modele.personnage;

import fr.iut.montreuil.projetfinale.zhellda.modele.Environnement;

public class Sentinelle extends Ennemi {
    public Sentinelle(int x, int y, Environnement environnement) {
        super(x, y, 15, 2, 3, 40, 40, 50, environnement, "sentinelle", false, new SchemaAttaqueClassique());
    }

    @Override
    public int getPvMax() {
        return 15;
    }

    @Override
    public void agit() {
        if (getCheminVersJoueur().size() < 15){
            seDeplacer();
            attaquer();
        }
    }
}
