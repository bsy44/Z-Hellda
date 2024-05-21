package fr.iut.montreuil.projetfinale.zhellda.modele;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Environnement {

    private ObservableList<Joueur> obsJoueur;
    private static Terrain terrain;
    private static Joueur j;
    private ObservableList<Ennemis> obsEnnemis;

    public Environnement() {
        this.terrain= new Terrain();
        this.j = new Joueur(this);
        this.obsJoueur = FXCollections.observableArrayList();
        this.obsJoueur.add(j);
        this.obsEnnemis = FXCollections.observableArrayList();
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
    }

    public void ennemiMort(){
        for (int i = 0; i < getObsEnnemis().size(); i++) {
            if (getObsEnnemis().get(i).getVie().getValue()==0){
                getObsEnnemis().remove(i);
            }

        }
    }

    public void mortJoueur(){
        if (getObsJoueur().get(0).getVie().getValue()==0) {
            getObsJoueur().remove(0);
            System.out.println("Vous avez perdu.");
        }
    }



    public static Joueur getJ() {
        return j;
    }
}
