package fr.iut.montreuil.projetfinale.zhellda.modele;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Environnement {
    private int width;
    private int height;
    private static Terrain terrain;
    private static Joueur j;

    private ObservableList<Ennemis> obsEnnemis;

    public Environnement(int width, int height) {
        this.width = width;
        this.height = height;
        this.terrain= new Terrain();
        this.j = new Joueur();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public static Terrain getTerrain() {
        return terrain;
    }

    public static Joueur getJ() {
        return j;
    }
}
