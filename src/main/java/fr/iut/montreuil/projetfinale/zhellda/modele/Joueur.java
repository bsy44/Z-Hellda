package fr.iut.montreuil.projetfinale.zhellda.modele;

import javafx.beans.property.IntegerProperty;

public class Joueur extends Acteur {
    private Arme arme;

    public Joueur(Environnement environnement){
       super(10,10, 10,"joueur");
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

    public void deplacerHaut () {
        this.y.setValue(this.y.getValue()-10);
    }

    public void deplacerBas () {
        this.y.setValue(this.y.getValue()+10);
    }*/

    public final void deplacement(int x, int y) {
        System.out.println("x :"+(Math.round(getX() + x)/30)  + ", y : "+ Math.round(getY()+ y)/30);
        double posX = (this.getX() + x) / 30.0;
        double posY = (this.getY() + y) / 30.0;

        if (Environnement.getTerrain().dansTerrain((int)Math.ceil((this.getX() + x) / 30.0), (int)Math.ceil((this.getY() + y) / 30.0))) {
            this.setXProperty(getX() + x);
            this.setYProperty(getY() + y);
        }

    }
}
