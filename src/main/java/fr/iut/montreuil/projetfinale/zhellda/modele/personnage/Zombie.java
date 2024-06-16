package fr.iut.montreuil.projetfinale.zhellda.modele.personnage;

import fr.iut.montreuil.projetfinale.zhellda.modele.Environnement;

public class Zombie extends Ennemis {

    private static double pourcentageDropItem = 100;
    public Zombie(int x, int y, Environnement environnement) {
        super(x, y, 10, 2, 1, 35,30, 30, environnement, "zombie");
    }

    @Override
    public void attaquer() {
        for (int i = 0; i < environnement.getListObsJoueur().size(); i++) {
            Joueur j = environnement.getListObsJoueur().get(i);

            double distance = Math.sqrt(Math.pow(this.getXProperty().get() - j.getXProperty().get(), 2) + Math.pow(this.getYProperty().get() - j.getYProperty().get(), 2));
            if (distance <= this.getPortee() && distance >= 0) {
                j.subirDegats(this.getAttaque());
                Environnement.getJ().meurt();
                this.getX();
            }
        }
    }

    public int getPvMax() {return 10;}

    public static double getPourcentageDropItem() {
        return pourcentageDropItem;
    }
}
