package fr.iut.montreuil.projetfinale.zhellda.modele;

public class Zombie extends Ennemis {
    public Zombie(int x, int y, Environnement environnement) {
        super(x, y, 10, 2, 1, 35,30, 30,0,  environnement);
    }
    //La vie et la vitesse seront à équilibrer plus tard


    @Override
    public void attaquer() {
        for (int i = 0; i < environnement.getObsJoueur().size(); i++) {
            Joueur j = environnement.getObsJoueur().get(i);

            double distance = Math.sqrt(Math.pow(this.getXProperty().get() - j.getXProperty().get(), 2) + Math.pow(this.getYProperty().get() - j.getYProperty().get(), 2));
            if (distance <= this.getPortee() && distance >= 0) {
                j.subirDegats(this.getAttaque());
                environnement.mortJoueur();
                this.getX();
            }
        }
    }

    public int getPvMax() {return 10;}

}
