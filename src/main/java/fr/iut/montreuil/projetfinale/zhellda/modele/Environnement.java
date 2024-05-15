package fr.iut.montreuil.projetfinale.zhellda.modele;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Environnement {
    private int width;

    private int height;
    private ObservableList<Joueur> obsJoueur;
    private static Terrain terrain;
    private static Joueur j;

    private ObservableList<Ennemis> obsEnnemis;

    public Environnement(int width, int height) {
        this.width = width;
        this.height = height;
        this.terrain= new Terrain();
        this.j = new Joueur(this);
        this.obsJoueur = FXCollections.observableArrayList();
        this.obsJoueur.add(j);
        this.obsEnnemis = FXCollections.observableArrayList();
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

    public ObservableList<Joueur> getObsJoueur() {
        return obsJoueur;
    }

    public ObservableList<Ennemis> getObsEnnemis(){
        return obsEnnemis;
    }

    public void ajouterEnnemi (Ennemis ennemi){
        this.obsEnnemis.add(ennemi);
        System.out.println("ajouter");
    }

    public void ennemiMort(){
        for (int i = 0; i < getObsEnnemis().size(); i++) {
            if (getObsEnnemis().get(i).getVie()==0){
                getObsEnnemis().remove(i);
            }

        }
    }



    public static Joueur getJ() {
        return j;
    }
}
