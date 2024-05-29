package fr.iut.montreuil.projetfinale.zhellda.modele;

public class Zombie extends Ennemis {
    public Zombie(int x, int y, Environnement environnement) {
        super(x, y, 10, 2, 1, 30,30, 30, environnement);
    }
    //La vie et la vitesse seront à équilibrer plus tard


    public int getPvMax() {return 10;}

}
