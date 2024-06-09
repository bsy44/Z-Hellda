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

    public Coffre(Environnement environnement) {
        this.environnement = environnement;
        this.listSpawn = new ArrayList<>();
        ajouterSpawn();
        this.x = new SimpleIntegerProperty(spawnAleatoire()[0]);
        this.y = new SimpleIntegerProperty(spawnAleatoire()[1]);
        this.nom = "coffre";
        this.id = nom + "#" + cpt;
        this.ouvert = new SimpleBooleanProperty(false);
        this.item = new Marteau(environnement, getX(), getY());
        cpt++;
    }

    public Item getItem() {
        return item;
    }

    public int getX() {
        return x.getValue();
    }

    public IntegerProperty xProperty() {
        return x;
    }

    public int getY() {
        return y.getValue();
    }

    public IntegerProperty yProperty() {
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

    public void ajouterSpawn() {
        listSpawn.add(new int[]{80, 60});
        listSpawn.add(new int[]{1560, 155});
        listSpawn.add(new int[]{85, 660});
        listSpawn.add(new int[]{1035, 530});
        listSpawn.add(new int[]{710, 30});
    }

    public int[] spawnAleatoire() {
        for (int i = 0; i < listSpawn.size(); i++) {
            int indiceRandom = (int) (Math.random() * listSpawn.size());
            return listSpawn.get(indiceRandom);
        }
        return null;
    }
}

