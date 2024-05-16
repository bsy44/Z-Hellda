package fr.iut.montreuil.projetfinale.zhellda.modele;

import javafx.scene.shape.Rectangle;

public class Joueur extends Acteur {
    private Arme arme;


    public Joueur(Environnement environnement){
       super(10,10, 10,"joueur", environnement);
       this.arme=new Epee(environnement);
    }

    public Arme getArme() {
        return arme;
    }
    /*public void deplacerGauche () {
        this.x.setValue(this.x.getValue()-10);
    }

    public void deplacerDroite () {
        this.x.setValue(this.x.getValue()+10);
    }

    public void deplacement(int x, int y) {
        System.out.println("x :" + (Math.round(getX() + x) / 30) + ", y : " + Math.round(getY() + y) / 30);

        int hitboxWidth = (int) getHitbox().getWidth();
        int hitboxHeight = (int) getHitbox().getHeight();

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
            this.setX(posX);
            this.setY(posY);
        }
    }
}
