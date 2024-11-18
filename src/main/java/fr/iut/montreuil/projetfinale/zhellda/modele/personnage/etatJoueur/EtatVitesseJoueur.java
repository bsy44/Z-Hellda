package fr.iut.montreuil.projetfinale.zhellda.modele.personnage.etatJoueur;

import fr.iut.montreuil.projetfinale.zhellda.modele.personnage.Joueur;

public class EtatVitesseJoueur extends EtatTemporaire {

    public EtatVitesseJoueur() {
        super(7000);
    }

    @Override
    public void agitSurEtat(Joueur joueur) {
        joueur.setVitesse(3);
    }

    @Override
    public String toString() {
        return "Etat vitesse buff";
    }
}