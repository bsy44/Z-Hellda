package fr.iut.montreuil.projetfinale.zhellda.modele.item;

import fr.iut.montreuil.projetfinale.zhellda.modele.AttaqueJoueur.ArmeSol;
import fr.iut.montreuil.projetfinale.zhellda.modele.Environnement;
import fr.iut.montreuil.projetfinale.zhellda.modele.personnage.Joueur;

public class Marteau extends ArmeSol {
    public Marteau(Environnement environnement, int x, int y) {
        super(x, y, "marteau", environnement, 1, 120);
    }

    @Override
    public void attaquer(Joueur j, int x, int y) {
        attaqueSol(j,x,y,40,true);
    }
}
