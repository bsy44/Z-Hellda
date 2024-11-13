package fr.iut.montreuil.projetfinale.zhellda.modele.item;

import fr.iut.montreuil.projetfinale.zhellda.controleur.Entite.Entite;

public abstract class Item extends Entite {

    private String nom;
    private String labelItem;
    private static int cpt = 0;
    private int indexInventaire;

    public Item(int posX, int posY, String nom, String id){
        super(posX,posY, id+cpt);
        this.nom = nom;
        this.labelItem = "labelItem";
        this.indexInventaire = -1;
        cpt++;
    }

    public String getNom() {
        return nom;
    }

    public String getLabelItem() {
        return labelItem;
    }

    public int getIndexInventaire() {
        return indexInventaire;
    }

    public void setIndexInventaire(int indexInventaire) {
        this.indexInventaire = indexInventaire;
    }

    @Override
    public String toString() {
        return "id " + getId() + ", pos x : " + getX() + ", pos y : " + getY();
    }
}
