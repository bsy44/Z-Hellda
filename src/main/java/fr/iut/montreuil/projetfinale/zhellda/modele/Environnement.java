package fr.iut.montreuil.projetfinale.zhellda.modele;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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

    public void ennemiMort(){
        for (int i = getObsEnnemis().size()-1; i >=0 ; i--) {
            if (getObsEnnemis().get(i).getVie().get()==0){
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
    public void actionProjectile(){
        for (int i = obsProjectile.size()-1; i >=0 ; i--) {
            if(!(obsProjectile.get(i).tirProjectile()) || obsProjectile.get(i).estTouche()){
                ennemiMort();
                System.out.println(obsProjectile.get(i).getX()+obsProjectile.get(i).getY());
                System.out.println("supprimerP");
                obsProjectile.remove(i);

                System.out.println("est supprimé");
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
