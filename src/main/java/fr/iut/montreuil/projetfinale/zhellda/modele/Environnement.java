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
    private ObservableList<Ennemis> obsEnnemis;
    private ObservableList<Projectile> obsProjectile;
    private  ObservableList<Item> obsItemParTerre;
    private static Bfs bfs;

    public Environnement() {
        this.terrain= new Terrain();
        this.j = new Joueur(this);
        this.obsJoueur = FXCollections.observableArrayList();
        this.obsJoueur.add(j);
        this.obsEnnemis = FXCollections.observableArrayList();
        this.obsProjectile = FXCollections.observableArrayList();
        this.obsItemParTerre = FXCollections.observableArrayList();
        bfs = new Bfs();
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

    public static Bfs getBfs (){
        return bfs;
    }

    public static void nouveauBfs(){
        bfs = new Bfs();
    }

    public void ajouterEnnemi (Ennemis ennemi){
        this.obsEnnemis.add(ennemi);
    }
    public void ajouterProjectile (Projectile projectile){
        this.obsProjectile.add(projectile);
    }

    public void ajouterItem(Item item){
        this.obsItemParTerre.add(item);
    }

    public void ennemiMort() {
        for(int i = getObsEnnemis().size()-1; i>=0;i--){
            Acteur a = getObsEnnemis().get(i);
            if(a.getVie().get()==0){
                if (Acteur.reussitProba(Zombie.getPourcentageDropItem())){
                    Item pommeOr = new PommeDor(a.getX(), a.getY());
                    obsItemParTerre.add(pommeOr);
                }
                System.out.println("mort de : " + a);
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

    public void actionItem(){
        for (int i = obsItemParTerre.size() - 1; i >= 0 ; i--) {
            if (getJ().ramasserItem(obsItemParTerre.get(i))) {
                if (obsItemParTerre.get(i) instanceof Arme){
                    getJ().getInventaireArme().ajouterItem(obsItemParTerre.get(i));
                    System.out.println("Arme ajouté à l'inventaire d'arme");
                }
                else {
                    getJ().getInventaireItem().ajouterItem(obsItemParTerre.get(i));
                    System.out.println("Consomable ajouté à l'inventaire");
                }
                obsItemParTerre.remove(obsItemParTerre.get(i));
            }
        }
    }
    
    public  ObservableList<Projectile> getObsProjectile() {
        return obsProjectile;
    }

    public ObservableList<Item> getObsItemParTerre() {
        return obsItemParTerre;
    }

    public static Joueur getJ() {
        return j;
    }
}
