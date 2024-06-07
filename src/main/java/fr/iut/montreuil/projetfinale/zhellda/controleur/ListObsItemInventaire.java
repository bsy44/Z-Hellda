package fr.iut.montreuil.projetfinale.zhellda.controleur;

import fr.iut.montreuil.projetfinale.zhellda.Lancement;
import fr.iut.montreuil.projetfinale.zhellda.modele.Item;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.awt.event.ActionEvent;
import java.net.URL;

public class ListObsItemInventaire implements ListChangeListener<Item> {

    private VBox inventaireItem;

    public ListObsItemInventaire(VBox inventaireItem) {
        this.inventaireItem = inventaireItem;
    }

    @Override
    public void onChanged(Change<? extends Item> change) {
        while (change.next()) {
            if (change.wasAdded()) {
                for (Item item : change.getAddedSubList()) {
                    ajouterImageVersInventaire(item);
                }
            }

            if (change.wasRemoved()) {
                for (Item item : change.getRemoved()) {
                    retirerImageDeInventaire(item);
                }
            }
        }
    }

    public void ajouterImageVersInventaire(Item item) {
        URL url = Lancement.class.getResource(item.getNom() + ".png");
        if (url != null) {
            Image image = new Image(url.toExternalForm());

            int index = getFirstSlot();// Trouver le premier slot disponible
            if (index != -1) {
                ImageView imageView = (ImageView) inventaireItem.lookup("#item" + index);// Récupérer l'ImageView et le Label correspondants
                Label labelItem = (Label) inventaireItem.lookup("#" + item.getLabelItem() +  index);

                if (imageView != null && labelItem != null) {
                    imageView.setImage(image);
                    labelItem.setText(item.getNom());
                    item.setIndexInventaire(index);  // Stocker l'index de l'inventaire dans l'item
                }
            }
        }
    }

    public void retirerImageDeInventaire(Item item) {
        int index = item.getIndexInventaire();
        if (index != -1) {
            ImageView imageView = (ImageView) inventaireItem.lookup("#item" + index);
            Label labelItem = (Label) inventaireItem.lookup("#" + item.getLabelItem() +  index);

            if (imageView != null) {
                imageView.setImage(null);
            }
            if (labelItem != null) {
                labelItem.setText("");
            }
            item.setIndexInventaire(-1);  // Réinitialiser l'index de l'inventaire dans l'item
        }
    }

    public int getFirstSlot() {// Méthode pour trouver le premier slot disponible dans l'inventaire
        for (int i = 0; i < 6; i++) {
            ImageView imageView = (ImageView) inventaireItem.lookup("#item" + i);
            if (imageView != null && imageView.getImage() == null) {
                return i;  // Retourner le premier slot disponible
            }
        }
        return -1;  // Retourner -1 si l'inventaire est plein
    }
}
