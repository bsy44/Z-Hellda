package fr.iut.montreuil.projetfinale.zhellda.modele.item;

import fr.iut.montreuil.projetfinale.zhellda.modele.AttaqueJoueur.ArmeSol;
import fr.iut.montreuil.projetfinale.zhellda.modele.Environnement;
import fr.iut.montreuil.projetfinale.zhellda.modele.personnage.Joueur;

public class Epee extends ArmeSol {

    public Epee(Environnement environnement, int x, int y){
        super(x, y, "épée", environnement,2,60);
    }

    @Override
    public void attaquer(Joueur j, int x, int y) {
        attaqueSol(j,x,y,12,false);
    }
}
