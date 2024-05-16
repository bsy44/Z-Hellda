package fr.iut.montreuil.projetfinale.zhellda.modele;

import javafx.scene.shape.Rectangle;

public class Joueur extends Acteur {
    private Arme arme;
    private Rectangle hitbox;

    public Joueur(Environnement environnement){
       super(10,10, 10,"joueur");
       this.arme = new Epee(environnement);
       this.hitbox = new Rectangle(this.getX(), this.getY(), 25, 25);
    }

    public Arme getArme() {
        return arme;
    }

    public Rectangle getHitbox() {
        return hitbox;
    }

    public void deplacement(int x, int y) {
        System.out.println("x :" + (Math.round(getX() + x) / 30) + ", y : " + Math.round(getY() + y) / 30);

        int hitboxWidth = (int) hitbox.getWidth();
        int hitboxHeight = (int) hitbox.getHeight();

        int posX = getX() + x;
        int posY = getY() + y;

        int gauche = posX / 30;
        int droite = (posX + hitboxWidth) / 30;
        int haut = posY / 30;
        int bas = (posY + hitboxHeight) / 30;

        if (Environnement.getTerrain().dansTerrain(gauche, haut) &&
                Environnement.getTerrain().dansTerrain(droite, haut) &&
                Environnement.getTerrain().dansTerrain(gauche, bas) &&
                Environnement.getTerrain().dansTerrain(droite, bas) &&
                (colision(haut, bas, droite, gauche))){
            this.getX()x.setValue(posX);
            this.getY()y.setValue(posY);
        }
    }

    public boolean colision(int haut, int bas, int droite, int gauche){
        return  !Environnement.getTerrain().obstacle(gauche, haut) &&
                !Environnement.getTerrain().obstacle(droite, haut) &&
                !Environnement.getTerrain().obstacle(gauche, bas) &&
                !Environnement.getTerrain().obstacle(droite, bas);
    }
}
