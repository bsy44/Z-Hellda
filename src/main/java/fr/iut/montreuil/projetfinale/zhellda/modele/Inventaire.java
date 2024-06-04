package fr.iut.montreuil.projetfinale.zhellda.modele;

import java.util.ArrayList;

public class Inventaire {

    private ArrayList<Arme> listArme;
    private ArrayList<Item> listItem;

    public Inventaire(){
        this.listArme = new ArrayList<>(4);
        this.listItem = new ArrayList<>();
    }

    public void ajouterArme(Arme a){
        listArme.add(a);
    }

    public void ajouterItem(Item i){
        listItem.add(i);
    }

    public ArrayList<Arme> getListArme() {
        return listArme;
    }

    public ArrayList<Item> getListItem() {
        return listItem;
    }
}
