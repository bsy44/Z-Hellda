package fr.iut.montreuil.projetfinale.zhellda.modele;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Inventaire {

    private ObservableList<Arme> listArme;
    private ObservableList<Item> listItem;

    public Inventaire(){
        this.listArme = FXCollections.observableArrayList();
        this.listItem = FXCollections.observableArrayList();
    }

    public void ajouterArme(Arme a){
        listArme.add(a);
    }

    public void retirerArme(Arme a){
        listArme.remove(a);
    }

    public void ajouterItem(Item i){
        listItem.add(i);
    }

    public void retirerItem(Item i){listItem.remove(i);}

    public ObservableList<Arme> getListArme() {
        return listArme;
    }

    public ObservableList<Item> getListItem() {
        return listItem;
    }

    public boolean estPlein() {
        return listItem.size() >= 6;
    }
}
