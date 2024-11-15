package fr.iut.montreuil.projetfinale.zhellda.modele.personnage;

public class Tank extends Ennemi {
    public Tank(int x, int y) {
        super(x, y, 20, 1, 2, 35, 50, 50, "tank", false, new SchemaAttaqueRalentissant());
    }

    @Override
    public int getPvMax() {
        return 20;
    }
}