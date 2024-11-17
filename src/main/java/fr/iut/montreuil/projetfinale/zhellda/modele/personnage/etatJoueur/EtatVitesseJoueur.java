package fr.iut.montreuil.projetfinale.zhellda.modele.personnage.etatJoueur;

import fr.iut.montreuil.projetfinale.zhellda.modele.personnage.Joueur;

public class EtatVitesseJoueur extends EtatTemporaire {

    public EtatVitesseJoueur(Joueur joueur) {
        super(joueur, 7000);
    }

    @Override
    public void agitSurEtat() {
        getJoueur().setVitesse(3);
    }

    @Override
    public String toString() {
        return "Etat vitesse buff";
    }
}