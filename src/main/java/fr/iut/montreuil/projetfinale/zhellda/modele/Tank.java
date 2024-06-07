package fr.iut.montreuil.projetfinale.zhellda.modele;

public class Tank extends Ennemis{
    public Tank(int x, int y,  Environnement environnement) {
        super(x, y, 20, 1, 2, 35, 30, 30, environnement);
    }

    @Override
    public void attaquer() {
        for (int i = 0; i < environnement.getObsJoueur().size(); i++) {
            Joueur j = environnement.getObsJoueur().get(i);

            double distance = Math.sqrt(Math.pow(this.getXProperty().get() - j.getXProperty().get(), 2) + Math.pow(this.getYProperty().get() - j.getYProperty().get(), 2));
            if (distance <= this.getPortee() && distance >= 0) {
                if (!j.isEtatAltere()){
                    j.setEtatAltere(true);
                    j.debuffVitesse(2);
                }
                j.subirDegats(this.getAttaque());
                environnement.mortJoueur();
                this.getX();
            }
        }
    }

    @Override
    public int getPvMax() {
        return 20;
    }
}