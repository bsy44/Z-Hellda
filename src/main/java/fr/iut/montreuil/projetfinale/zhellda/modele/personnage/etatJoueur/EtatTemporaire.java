package fr.iut.montreuil.projetfinale.zhellda.modele.personnage.etatJoueur;

import fr.iut.montreuil.projetfinale.zhellda.modele.Environnement;
import fr.iut.montreuil.projetfinale.zhellda.modele.personnage.Joueur;

public abstract class EtatTemporaire extends EtatJoueur{
    private int duree;
    private int tourDebut;

    public EtatTemporaire(Joueur joueur, int duree) {
        super(joueur);
        this.duree = duree;
        tourDebut = Environnement.getUniqueInstance().getTourJeu();
    }

    public int getDuree() {
        return duree;
    }

    @Override
    public void agitSurEtat() {}

    public boolean dureeEffet(int tourActuel){
        return tourActuel - tourDebut >= duree;
    }
}