package fr.iut.montreuil.projetfinale.zhellda.modele;

public class Zombie extends Ennemis{
    public Zombie(int x, int y) {
        super(x, y, 10, 2, 1);
    }
    //La vie et la vitesse seront à équilibrer plus tard


    @Override
    public void attaquer(Joueur j) {
        j.subirDegats(getAttaque());
    }

    @Override
    public void seDeplacer (){
        //A faire lorsque l'on aura le BFS
    }

}
