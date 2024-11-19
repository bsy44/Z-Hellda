package fr.iut.montreuil.projetfinale.zhellda.modele.personnage.etatJoueur;

import fr.iut.montreuil.projetfinale.zhellda.modele.personnage.Joueur;

public class EtatTransparent extends EtatTemporaire{

    public EtatTransparent() {
        super(7000);
    }

    @Override
    public void agitSurEtat(Joueur joueur) {
        joueur.setTransparent(true);
    }

    @Override
    public String toString() {
        return "Etat transparent";
    }
}