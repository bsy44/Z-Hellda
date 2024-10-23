package fr.iut.montreuil.projetfinale.zhellda.modele;


import fr.iut.montreuil.projetfinale.zhellda.modele.personnage.*;

public class ChangeurStringEnnemi {

    public Ennemi choisirEnnemie(Case Case, String typeEnnemie) {

        switch (typeEnnemie) {
            case "zombie":
                return new Zombie(Case.getX(), Case.getY());

            case "tank":
                return new Tank(Case.getX(), Case.getY());

            case "sentinelle":
                return new Sentinelle(Case.getX(), Case.getY());

            default:
                return new Rapide(Case.getX(), Case.getY());
        }
    }
}
