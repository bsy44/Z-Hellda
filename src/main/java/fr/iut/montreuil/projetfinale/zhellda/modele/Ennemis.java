package fr.iut.montreuil.projetfinale.zhellda.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.ArrayList;

public abstract class Ennemis extends Acteur{

    private IntegerProperty x = new SimpleIntegerProperty();
    private IntegerProperty y = new SimpleIntegerProperty();
    private static int compteur = 1;
    private int id;
    private int vitesse;
    private IntegerProperty vie = new SimpleIntegerProperty();
    private int attaque;

    private ArrayList<Case> bfs;

    public Ennemis(int x, int y, int vie, int vitesse, int attaque){
        super(x, y, vie,""+compteur);
        compteur++;
        this.vitesse = vitesse;
        this.attaque = attaque;
        this.bfs = new Bfs(Math.round(x/30), Math.round(y/30)).getChemin();
    }

    public int getAttaque() {
        return attaque;
    }

    public abstract void attaquer (Joueur j);

    public void seDeplacer (){
        int x;
        int y;
        for (int i=1; i<vitesse+1;i++){
            x = bfs.get(i).getX() - getX();
            y = bfs.get(i).getY() - getY();
            System.out.println("x :"+(Math.round((getX() + x)/30))  + ", y : "+ Math.round((getY()+ y)/30));

        }
    }

}
