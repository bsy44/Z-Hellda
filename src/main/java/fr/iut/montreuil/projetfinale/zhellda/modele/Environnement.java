package fr.iut.montreuil.projetfinale.zhellda.modele;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Environnement {
    private int width;

    private int height;
    private ObservableList<Joueur> obsJoueur;
    private Terrain terrain;

    private Joueur j;

    public Environnement(int width, int height) {
        this.width = width;
        this.height = height;
        this.terrain= new Terrain();
        this.j = new Joueur();
        this.obsJoueur = FXCollections.observableArrayList();
        this.obsJoueur.add(j);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public ObservableList<Joueur> getObsJoueur() {
        return obsJoueur;
    }

    public Joueur getJ() {
        for (Joueur j : obsJoueur) {
            return j;
        }
        System.out.println("null");
        return null;
    }
}
