package fr.iut.montreuil.projetfinale.zhellda.modele;


public class ChangeurStringEnnemi {
    private Environnement environnement;

    public  ChangeurStringEnnemi (Environnement environnement) {
        this.environnement = environnement;
    }

    public Ennemis choisirEnnemie(Case Case, String typeEnnemie) {

        switch (typeEnnemie) {
            case "zombie":
                return new Zombie(Case.getX(), Case.getY(),this.environnement);

            case "tank":
                return new Tank(Case.getX(), Case.getY(),this.environnement);

            default:
                return new Rapide(Case.getX(), Case.getY(),this.environnement);

        }
    }
}
