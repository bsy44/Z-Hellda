package fr.iut.montreuil.projetfinale.zhellda.modele;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Environnement {
    private static Terrain terrain;
    private static Joueur j;
    private ObservableList<Joueur> obsJoueur;
    private ObservableList<Ennemis> obsEnnemis;
    private ObservableList<Projectile> obsProjectile;
    private  ObservableList<Item> obsItemParTerre;
    private ObservableList<Coffre> listCoffre;
    private ObservableList<Villageois> obsVillageois;
    private static Bfs bfs;

    public Environnement() {
        this.terrain= new Terrain();
        this.j = new Joueur(this);
        this.obsJoueur = FXCollections.observableArrayList();
        this.obsJoueur.add(j);
        this.obsEnnemis = FXCollections.observableArrayList();
        this.obsProjectile = FXCollections.observableArrayList();
        this.obsItemParTerre = FXCollections.observableArrayList();
        this.listCoffre = FXCollections.observableArrayList();
        this.obsVillageois = FXCollections.observableArrayList();
        this.bfs = new Bfs();
        Coffre coffre1 = new Coffre(this);
        Coffre coffre2 = new Coffre(this);
        Coffre coffre3 = new Coffre(this);
        ajouterCoffre(coffre1);
        ajouterCoffre(coffre2);
        ajouterCoffre(coffre3);
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

    public  ObservableList<Projectile> getObsProjectile() {
        return obsProjectile;
    }

    public ObservableList<Item> getObsItemParTerre() {
        return obsItemParTerre;
    }

    public ObservableList<Coffre> getListCoffre() {
        return listCoffre;
    }

    public ObservableList<Villageois> getObsVillageois() {
        return obsVillageois;
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

    public void ajouterCoffre(Coffre coffre){
        this.listCoffre.add(coffre);
        for (int i = 0; i < coffre.getListSpawn().size(); i++) {
            coffre.getListSpawn().remove(coffre.getListSpawn().get(i));
        }
    }

    public void ennemiMort() {
        for(int i = getObsEnnemis().size()-1; i>=0;i--){
            Ennemis e = getObsEnnemis().get(i);
            if(e.getVie().get()==0){
                if (e.reussitProba(Zombie.getPourcentageDropItem())){
                    Item item;
                    double random = Math.random();
                    if (random < 0.33) {
                         item = new PommeDor(e.getX(), e.getY());
                    }
                    else if (random < 0.66){
                        item = new PotionMagique(e.getX(), e.getY());
                    }
                    else {
                        item = new GrimoirArme(e.getX(), e.getY());
                    }
                    obsItemParTerre.add(item);
                }
                System.out.println("mort de : " + e);
                getObsEnnemis().remove(i);
            }
        }
    }

    public boolean mortJoueur(){
        if (getJ().getVie().getValue()<=0) {
            getObsJoueur().remove(getJ());
            return true;
        }
        return false;
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
        for (int i = 0; i < obsItemParTerre.size() ; i++) {
            if (getJ().ramasserItem(obsItemParTerre.get(i))) {
                if (obsItemParTerre.get(i) instanceof Arme){
                    getJ().getInventaireArme().ajouterItem(obsItemParTerre.get(i));
                    System.out.println("Arme ajouté à l'inventaire d'arme");
                }
                else {
                    getJ().getInventaireItem().ajouterItem(obsItemParTerre.get(i));
                    System.out.println("Item ajouté à l'inventaire");
                }
                obsItemParTerre.remove(obsItemParTerre.get(i));
            }
        }
    }

    public static Joueur getJ() {
        return j;
    }
}
