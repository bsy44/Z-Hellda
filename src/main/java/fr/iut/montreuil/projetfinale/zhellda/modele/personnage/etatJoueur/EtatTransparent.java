package fr.iut.montreuil.projetfinale.zhellda.modele.personnage.etatJoueur;

import fr.iut.montreuil.projetfinale.zhellda.modele.personnage.Joueur;

public class EtatTransparent extends EtatTemporaire{

    public EtatTransparent(Joueur joueur) {
        super(joueur, 7000);
    }

    @Override
    public void agitSurEtat() {
        getJoueur().setTransparent(true);
    }

    @Override
    public String toString() {
        return "Etat transparent";
    }
}