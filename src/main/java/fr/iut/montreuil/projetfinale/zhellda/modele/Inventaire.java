package fr.iut.montreuil.projetfinale.zhellda.modele;

import fr.iut.montreuil.projetfinale.zhellda.modele.item.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventaire {
    private ObservableList<Item> listItem;
    private int capaciteMax;

    public Inventaire(int capaciteMax){
        this.listItem = FXCollections.observableArrayList();
        this.capaciteMax = capaciteMax;
    }

    public ObservableList<Item> getListItem() {
        return listItem;
    }

    public int getCapaciteMax() {
        return capaciteMax;
    }

    public void ajouterItem(Item item){
        if (!estPlein()) {
            listItem.add(item);
        }
    }

    public void supprimerItem(Item i){
        listItem.remove(i);
    }

    public boolean estPlein(){
        return  listItem.size() >= capaciteMax;
    }
}
