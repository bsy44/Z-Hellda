package fr.iut.montreuil.projetfinale.zhellda.modele;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.Random;

public class Environnement {

    private static Terrain terrain;
    private static Joueur j;
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
        this.listObsJoueur = FXCollections.observableArrayList();
        this.listObsJoueur.add(j);
        this.listEnnemis = FXCollections.observableArrayList();
        this.listProjectile = FXCollections.observableArrayList();
        this.listItemParTerre = FXCollections.observableArrayList();
        this.listCoffre = FXCollections.observableArrayList();
        this.listVillageois = FXCollections.observableArrayList();
        this.bfs = new Bfs();
        this.creationCoffre();
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

    public void actionProjectile(){
        for (int i = listProjectile.size()-1; i >=0 ; i--) {
            if(!(listProjectile.get(i).tirProjectile()) || listProjectile.get(i).estTouche()){
                System.out.println(listProjectile.get(i).getX()+ listProjectile.get(i).getY());
                System.out.println("supprimerP");
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

    public Case genererSpawn() {
        Random random = new Random();
        int randomNb = random.nextInt(5)+1;
        if (randomNb == 1) {
            return caseEnnemi(1);
        }
        if (randomNb == 2) {
            return caseEnnemi(2);
        }
        if (randomNb == 3) {
            return caseEnnemi(3);
        }
        if (randomNb == 4) {
            return caseEnnemi(4);
        }
        if (randomNb == 5) {
            return caseEnnemi(4);
        }
        return null;
    }

    public Case caseEnnemi(int spawnEnnemie) {
        switch (spawnEnnemie){
            case 1:
                return new Case(240,0);
            case 2:
                return new Case(0,390);
            case 3:
                return new Case(240,1560);
            case 4:
                return new Case(1560,1140);
            case 5:
                return new Case(1410,570);
        }
        return null;
    }

    public  String genenerEnnemie() {
        Random random = new Random();
        int randomNb = random.nextInt(3)+1;
        if (randomNb == 1) {
            return "Tank";
        }
        if (randomNb == 2) {
            return "Rapide";
        }
        if (randomNb == 3) {
            return "Zombie";
        }
        return null;
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
}
