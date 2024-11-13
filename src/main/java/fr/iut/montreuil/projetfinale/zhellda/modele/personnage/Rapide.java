package fr.iut.montreuil.projetfinale.zhellda.modele.personnage;

import fr.iut.montreuil.projetfinale.zhellda.modele.Environnement;

public class Rapide extends Ennemi {
    public Rapide(int x, int y) {
        super(x, y, 5, 3, 1, 50,30,30, "rapide", true, new SchemaAttaqueClassique());
    }

    @Override
    public int getPvMax() {
        return 5;
    }
}
