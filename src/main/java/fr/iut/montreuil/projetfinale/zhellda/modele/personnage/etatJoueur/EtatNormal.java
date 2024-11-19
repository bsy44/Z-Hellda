package fr.iut.montreuil.projetfinale.zhellda.modele.personnage.etatJoueur;

import fr.iut.montreuil.projetfinale.zhellda.modele.personnage.Joueur;

public class EtatNormal extends EtatJoueur{

    @Override
    public void agitSurEtat(Joueur joueur) { // réinitialise les stats du joueur à celle de base
        joueur.setVitesse(5);
        joueur.setTransparent(false);
    }

    @Override
    public String toString() {
        return "Etat normal";
    }
}
