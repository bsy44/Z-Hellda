package fr.iut.montreuil.projetfinale.zhellda.modele.personnage.etatJoueur;

import fr.iut.montreuil.projetfinale.zhellda.modele.personnage.Joueur;

public class EtatNormal extends EtatJoueur{

    public EtatNormal(Joueur joueur) {
        super(joueur);
    }

    @Override
    public void agitSurEtat() { // réinitialise les stats du joueur à celle de base
        getJoueur().setVitesse(5);
        getJoueur().setTransparent(false);
    }

    @Override
    public String toString() {
        return "Etat normal";
    }
}
