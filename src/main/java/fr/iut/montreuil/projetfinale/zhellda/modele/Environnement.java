package fr.iut.montreuil.projetfinale.zhellda.modele;

import fr.iut.montreuil.projetfinale.zhellda.modele.item.Arme;
import fr.iut.montreuil.projetfinale.zhellda.modele.item.Item;
import fr.iut.montreuil.projetfinale.zhellda.modele.personnage.Acteur;
import fr.iut.montreuil.projetfinale.zhellda.modele.personnage.Ennemis;
import fr.iut.montreuil.projetfinale.zhellda.modele.personnage.Joueur;
import fr.iut.montreuil.projetfinale.zhellda.modele.personnage.Villageois;
import fr.iut.montreuil.projetfinale.zhellda.modele.projectile.Projectile;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Environnement {

    private int tourJeu;
    private Vague vague;

    private static Terrain terrain;
    private static Joueur j;
    private Villageois villageois;
    private ObservableList<Joueur> listObsJoueur;
    private ObservableList<Ennemis> listEnnemis;
    private ObservableList<Projectile> listProjectile;
    private  ObservableList<Item> listItemParTerre;
    private ObservableList<Coffre> listCoffre;
    private ObservableList<Villageois> listVillageois;
    private static Bfs bfs;

    public Environnement() {
        this.terrain= new Terrain();
        this.j = new Joueur(this);
        this.villageois = new Villageois(210, 125, this);
        this.listObsJoueur = FXCollections.observableArrayList();
        this.listObsJoueur.add(j);
        this.listEnnemis = FXCollections.observableArrayList();
        this.listProjectile = FXCollections.observableArrayList();
        this.listItemParTerre = FXCollections.observableArrayList();
        this.listCoffre = FXCollections.observableArrayList();
        this.listVillageois = FXCollections.observableArrayList();
        this.bfs = new Bfs();
        this.vague=new Vague(this,20000);
        this.creationCoffre();
        ajouterVillageois(villageois);
    }

    public static Terrain getTerrain() {
        return terrain;
    }

    public ObservableList<Joueur> getListObsJoueur() {
        return listObsJoueur;
    }

    public ObservableList<Ennemis> getListEnnemis(){
        return listEnnemis;
    }

    public  ObservableList<Projectile> getListProjectile() {
        return listProjectile;
    }

    public ObservableList<Item> getListItemParTerre() {
        return listItemParTerre;
    }

    public ObservableList<Coffre> getListCoffre() {
        return listCoffre;
    }

    public ObservableList<Villageois> getListVillageois() {
        return listVillageois;
    }

    public static Bfs getBfs (){
        return bfs;
    }

    public static void nouveauBfs(){
        bfs = new Bfs();
    }

    public void ajouterEnnemi (Ennemis ennemi){
        this.listEnnemis.add(ennemi);
    }

    public void ajouterProjectile (Projectile projectile){
        this.listProjectile.add(projectile);
    }

    public void ajouterItem(Item item){
        this.listItemParTerre.add(item);
    }

    public void ajouterCoffre(Coffre coffre){
        this.listCoffre.add(coffre);
        for (int i = 0; i < coffre.getListSpawn().size(); i++) {
            coffre.getListSpawn().remove(coffre.getListSpawn().get(i));
        }
    }

    public void ajouterVillageois(Villageois villageois){
        listVillageois.add(villageois);
    }

    public void actionProjectile(){
        for (int i = listProjectile.size()-1; i >=0 ; i--) {
            if(!(listProjectile.get(i).tirProjectile()) || listProjectile.get(i).estTouche()){
                listProjectile.remove(i);
                System.out.println("est supprimé");
            }
        }
    }

    public void actionItem(){
        for (int i = 0; i < listItemParTerre.size() ; i++) {
            if (getJ().ramasserItem(listItemParTerre.get(i))) {
                if (listItemParTerre.get(i) instanceof Arme){
                    getJ().getInventaireArme().ajouterItem(listItemParTerre.get(i));
                    System.out.println("Arme ajouté à l'inventaire d'arme");
                }
                else {
                    getJ().getInventaireItem().ajouterItem(listItemParTerre.get(i));
                    System.out.println("Item ajouté à l'inventaire");
                }
                listItemParTerre.remove(listItemParTerre.get(i));
            }
        }
    }
    public void unTour () {
        //appeler les méthode agir
        for (Joueur joueur : listObsJoueur) {
            joueur.agit();
        }
        if (tourJeu % 500==0) {
            for (Ennemis ennemis : listEnnemis) {
                ennemis.agit();
            }
        }
        if (villageois.meurt()){
            vague.agit();
        }
        tourJeu++;
    }

    public int getTourJeu() {
        return tourJeu;
    }

    public void creationCoffre(){
        for (int i = 0; i < 5; i++) {
            Coffre coffre = new Coffre(this);
            ajouterCoffre(coffre);
        }
    }

    public static Joueur getJ() {
        return j;
    }

    public Villageois getVillageois() {
        return villageois;
    }

}
