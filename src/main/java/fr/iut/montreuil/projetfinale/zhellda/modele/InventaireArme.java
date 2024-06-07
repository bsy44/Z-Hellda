package fr.iut.montreuil.projetfinale.zhellda.modele;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class InventaireArme {
        private ObservableList<Arme> armes;

        public InventaireArme() {
            armes = FXCollections.observableArrayList();
        }

        public ObservableList<Arme> getArmes() {
            return armes;
        }

        public boolean ajouterArme(Arme arme) {
            if (armes.size() < 3) {
                armes.add(arme);
                return true;
            }
            return false;
        }


    public void retirerArme(Arme arme) {
            armes.remove(arme);
        }

}
