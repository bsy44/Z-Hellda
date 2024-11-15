package fr.iut.montreuil.projetfinale.zhellda.modele.personnage.etatJoueur;

import fr.iut.montreuil.projetfinale.zhellda.modele.personnage.Joueur;

public abstract class EtatJoueur {
    private Joueur joueur;

    public EtatJoueur(Joueur joueur){
        this.joueur = joueur;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public abstract void agitSurEtat();
}