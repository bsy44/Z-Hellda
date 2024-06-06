package fr.iut.montreuil.projetfinale.zhellda.controleur;

import fr.iut.montreuil.projetfinale.zhellda.modele.Arme;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ListObsInventaireArme {
    private ObservableList<Arme> inventaire;

    public ListObsInventaireArme() {
        this.inventaire = FXCollections.observableArrayList();
    }

    public ObservableList<Arme> getInventaire() {
        return inventaire;
    }

    public void ajouterArme(Arme arme) {
        inventaire.add(arme);
    }

    public void retirerArme(Arme arme) {
        inventaire.remove(arme);
    }
}
