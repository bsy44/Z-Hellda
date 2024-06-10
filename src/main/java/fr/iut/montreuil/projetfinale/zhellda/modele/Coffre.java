package fr.iut.montreuil.projetfinale.zhellda.modele;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.ArrayList;

public class Coffre {
    private IntegerProperty x;
    private IntegerProperty y;
    private String nom;
    private String id;
    private BooleanProperty ouvert;
    private Item item;
    private Environnement environnement;
    private static int cpt = 0;
    private ArrayList<int[]> listSpawn;
    private static ArrayList<int[]> coordonneesPrises = new ArrayList<>();

    public Coffre(Environnement environnement) {
        this.environnement = environnement;
        this.listSpawn = new ArrayList<>();
        this.ajouterSpawn();
        this.nom = "coffre";
        this.id = nom + "#" + cpt;
        this.spawnAleatoire();
        this.item = genererItem();
        this.ouvert = new SimpleBooleanProperty(false);
        cpt++;
    }

    public Item getItem() {
        return item;
    }

    public int getX() {
        return x.getValue();
    }

    public final IntegerProperty xProperty() {
        return x;
    }

    public int getY() {
        return y.getValue();
    }

    public final IntegerProperty yProperty() {
        return y;
    }

    public BooleanProperty estOuvert() {
        return ouvert;
    }

    public void setOuvert(boolean ouvert) {
        this.ouvert.set(ouvert);
    }

    public void supprimerItem() {
        this.item = null;
    }

    public String getNom() {
        return nom;
    }

    public String getId() {
        return id;
    }

    public ArrayList<int[]> getListSpawn() {
        return listSpawn;
    }

    public void ajouterSpawn() {
        listSpawn.add(new int[]{80, 60});
        listSpawn.add(new int[]{1560, 155});
        listSpawn.add(new int[]{85, 660});
        listSpawn.add(new int[]{1035, 530});
        listSpawn.add(new int[]{710, 30});
    }
    public void spawnAleatoire(){
        boolean spawnDispo = false;

        while (!spawnDispo){
            int indiceRandom = (int) (Math.random() * listSpawn.size());
            int[] coordonee = listSpawn.get(indiceRandom);
            boolean etPrise = false;

            for (int i = 0; i < coordonneesPrises.size(); i++) {
                if (coordonee[0] == coordonneesPrises.get(i)[0] && coordonee[1] == coordonneesPrises.get(i)[1]){
                    etPrise = true;
                }
            }
            if (!etPrise){
                this.x = new SimpleIntegerProperty(coordonee[0]);
                this.y = new SimpleIntegerProperty(coordonee[1]);
                coordonneesPrises.add(coordonee);
                spawnDispo = true;
            }
        }
    }

    public Item genererItem() {
        double random = Math.random();
        Item itemGenerer;

        if (random < 0.35){
            double randomItemConsomable = Math.random();
            if (randomItemConsomable < 0.33){
                itemGenerer = new PommeDor(getX(), getY());
            } else if (randomItemConsomable < 0.66) {
                itemGenerer = new PotionMagique(getX(), getY());
            }
            else {
                itemGenerer = new GrimoirArme(getX(), getY());
            }
        }
        else {
            double randomArme = Math.random();
            if (randomArme < 0.33){
                itemGenerer = new Arc(getX(), getY(), environnement);
            }
            else if (randomArme < 0.66){
                itemGenerer = new Marteau(environnement, getX(), getY());
            }
            else {
                itemGenerer = new Epee(environnement, getX(), getY());
            }
        }
        return itemGenerer;
    }

    @Override
    public String toString() {
        return "Coffre{" + "x=" + x + ", y=" + y + ", nom='" + nom + '\'' + ", id='" + id + '\'' + ", ouvert=" + ouvert + ", item=" + item + '}';
    }
}

