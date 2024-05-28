package fr.iut.montreuil.projetfinale.zhellda.modele.personnage;

import fr.iut.montreuil.projetfinale.zhellda.modele.Environnement;
import fr.iut.montreuil.projetfinale.zhellda.modele.personnage.Ennemis;

public class Zombie extends Ennemis {
    public Zombie(int x, int y, Environnement environnement) {
        super(x, y, 10, 2, 1, 5,30, 30, environnement);
    }
    //La vie et la vitesse seront à équilibrer plus tard

    @Override
    public void seDeplacer (){
        //A faire lorsque l'on aura le BFS
    }

}