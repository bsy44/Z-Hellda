package fr.iut.montreuil.projetfinale.zhellda.modele;

import fr.iut.montreuil.projetfinale.zhellda.modele.Acteur;
import fr.iut.montreuil.projetfinale.zhellda.modele.Environnement;
import fr.iut.montreuil.projetfinale.zhellda.modele.Joueur;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.ArrayList;

public abstract class Ennemis extends Acteur{

    private IntegerProperty x = new SimpleIntegerProperty();
    private IntegerProperty y = new SimpleIntegerProperty();
    private static int compteur = 1;
    private int vitesse;
    private int attaque;
    private int portee;

    private ArrayList<Case> bfs;

    public Ennemis(int x, int y, int vie, int vitesse, int attaque, int portee, int HitBoxW, int HitBoxH, Environnement environnement){
        super(x, y, vie,"#"+compteur, HitBoxW, HitBoxH, environnement);
        compteur++;
        this.vitesse = vitesse;
        this.attaque = attaque;
        this.bfs = new Bfs(Math.round(x/30), Math.round(y/30)).getChemin();
        this.portee=portee;
    }

    public int getAttaque() {
        return attaque;
    }

    public void attaquer () {
        for (int i = 0; i < environnement.getObsJoueur().size(); i++) {
            Joueur j = environnement.getObsJoueur().get(i);

            double distance = Math.sqrt(Math.pow(this.getXProperty().get() - j.getXProperty().get(), 2) + Math.pow(this.getYProperty().get() - j.getYProperty().get(), 2));
            if (distance <= this.portee && distance >= 0) {
                j.subirDegats(this.attaque);
                environnement.mortJoueur();
                this.getX();
            }
        }
    }

    public void seDeplacer (){
        int x;
        int y;
        for (int i=1; i<vitesse+1;i++){
            x = bfs.get(i).getX() - Math.round(getX()/30);
            y = bfs.get(i).getY() - Math.round(getY()/30);
            System.out.println("x :"+ x + ", y:"+y);
            this.setX(Math.round(getX() + x*30));
            this.setY(Math.round(getY() + y*30));
        }
    }

}
