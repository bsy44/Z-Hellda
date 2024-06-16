package fr.iut.montreuil.projetfinale.zhellda.modele.item;

import fr.iut.montreuil.projetfinale.zhellda.modele.personnage.Joueur;

public abstract class ItemConsomable extends Item{

    public ItemConsomable(int posX, int posY, String nom) {
        super(posX, posY, nom, "item");
    }

    public abstract void consommerItem(Joueur joueur);
}
