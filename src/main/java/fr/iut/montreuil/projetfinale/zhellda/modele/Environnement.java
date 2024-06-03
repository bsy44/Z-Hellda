package fr.iut.montreuil.projetfinale.zhellda.modele;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Iterator;

public class Environnement {
    private int width;

    private int height;
    private ObservableList<Joueur> obsJoueur;
    private static Terrain terrain;
    private static Joueur j;
    private static ObservableList<Ennemis> obsEnnemis;
    private ObservableList<Projectile> obsProjectile;

    public Environnement() {
        this.terrain= new Terrain();
        this.j = new Joueur(this);
        this.obsJoueur = FXCollections.observableArrayList();
        this.obsJoueur.add(j);
        this.obsEnnemis = FXCollections.observableArrayList();
        this.obsProjectile = FXCollections.observableArrayList();
    }

    public static Terrain getTerrain() {
        return terrain;
    }

    public ObservableList<Joueur> getObsJoueur() {
        return obsJoueur;
    }

    public static ObservableList<Ennemis> getObsEnnemis(){
        return obsEnnemis;
    }

    public void ajouterEnnemi (Ennemis ennemi){
        this.obsEnnemis.add(ennemi);
    }
    public void ajouterProjectile (Projectile projectile){
        this.obsProjectile.add(projectile);
    }

    public void ennemiMort() {
        for(int i=getObsEnnemis().size()-1; i>=0;i--){
            Acteur a = getObsEnnemis().get(i);
        if(a.getVie().get()==0){
            System.out.println("mort de : " + a);
            getObsEnnemis().remove(i);
        }
    }
    }

    public void mortJoueur(){
        if (getObsJoueur().get(0).getVie().getValue()==0) {
            getObsJoueur().remove(0);
        }
    }
    public void actionProjectile(){
        for (int i = obsProjectile.size()-1; i >=0 ; i--) {
            if(!(obsProjectile.get(i).tirProjectile()) || obsProjectile.get(i).estTouche()){
                ennemiMort();
                obsProjectile.remove(i);
            }
        }

    }


    public ObservableList<Projectile> getObsProjectile() {
        return obsProjectile;
    }

    public static Joueur getJ() {
        return j;
    }
}
