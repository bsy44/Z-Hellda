package fr.iut.montreuil.projetfinale.zhellda.modele;

public class Arc extends Arme {

    public Arc (Environnement environnement){
        super(environnement,50,90);
    }
    public void attaquer (Joueur j, int x, int y) {
        Projectile projectile = new Fleche(j.getX(), j.getY(), x,y, this.getEnvironnement());
        getEnvironnement().ajouterProjectile(projectile);
    }

    @Override
    public void attaquer(Joueur j) {
        System.out.println("action impossible, vous avez un arc !! Utilisez les fleche");
    }
}
