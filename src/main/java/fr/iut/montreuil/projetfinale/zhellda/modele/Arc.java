package fr.iut.montreuil.projetfinale.zhellda.modele;

import javafx.scene.image.Image;

public class Arc extends Arme {
    private Image image;

    public Arc (Environnement environnement){
        super(environnement,50,120);
        this.image= new Image(getClass().getResource("/fr/iut/montreuil/projetfinale/zhellda/bouleDeFeu.png").toExternalForm());
    }
    public void attaquer (Joueur j, int x, int y) {
        Projectile projectile = new Fleche(j.getX(), j.getY(), x,y, this.getEnvironnement());
        getEnvironnement().ajouterProjectile(projectile);
    }
    public Image getImage() {
        return image;
    }

}
