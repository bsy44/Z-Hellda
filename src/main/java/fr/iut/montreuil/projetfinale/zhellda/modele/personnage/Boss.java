package fr.iut.montreuil.projetfinale.zhellda.modele.personnage;

import fr.iut.montreuil.projetfinale.zhellda.modele.Environnement;
import fr.iut.montreuil.projetfinale.zhellda.modele.personnage.schemaAttaque.SchemaAttaqueChangeant;

public class Boss extends Ennemi {

    public Boss(int x, int y, Environnement environnement) {
        super(x, y, 200, 3, 5, 0, 100, 100, environnement, "boss", false , new SchemaAttaqueChangeant());
    }

    @Override
    public int getPvMax() {
        return 200;
    }

}
