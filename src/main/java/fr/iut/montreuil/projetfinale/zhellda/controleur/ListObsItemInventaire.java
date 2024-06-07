package fr.iut.montreuil.projetfinale.zhellda.controleur;

import fr.iut.montreuil.projetfinale.zhellda.Lancement;
import fr.iut.montreuil.projetfinale.zhellda.modele.Environnement;
import fr.iut.montreuil.projetfinale.zhellda.modele.Item;
import javafx.collections.ListChangeListener;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
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

            int index = getFirstSlot();
            if (index != -1) {
                ImageView imageView = (ImageView) inventaireItem.lookup("#item" + index);
                Label labelItem = (Label) inventaireItem.lookup("#" + item.getLabelItem() + index);

                if (imageView != null && labelItem != null) {
                    imageView.setImage(image);
                    labelItem.setText(item.getNom());
                    item.setIndexInventaire(index);
                }
            }
        }
    }

    public void retirerImageDeInventaire(Item item) {
        int index = item.getIndexInventaire();
        if (index != -1) {// Vide le slot actuel
            ImageView imageView = (ImageView) inventaireItem.lookup("#item" + index);
            Label labelItem = (Label) inventaireItem.lookup("#" + item.getLabelItem() + index);

            if (imageView != null) {
                imageView.setImage(null);
            }
            if (labelItem != null) {
                labelItem.setText("");
            }
            item.setIndexInventaire(-1);// Réinitialise l'index de l'item supprimé

            mettreAjourInventaire();
        }
    }

    public void mettreAjourInventaire() {
        for (int i = 0; i < Environnement.getJ().getInventaireItem().getCapaciteMax(); i++) {// Réinitialise les slots de l'inventaire
            ImageView imageView = (ImageView) inventaireItem.lookup("#item" + i);
            Label labelItem = (Label) inventaireItem.lookup("#labelItem" + i);
            if (imageView != null) {
                imageView.setImage(null);
            }
            if (labelItem != null) {
                labelItem.setText("");
            }
        }

        for (int i = 0; i < Environnement.getJ().getInventaireItem().getListItem().size(); i++) {
            Item currentItem = Environnement.getJ().getInventaireItem().getListItem().get(i);
            ajouterImageVersInventaire(currentItem);
        }
    }

    public int getFirstSlot() {
        for (int i = 0; i < Environnement.getJ().getInventaireItem().getCapaciteMax(); i++) {
            ImageView imageView = (ImageView) inventaireItem.lookup("#item" + i);
            if (imageView != null && imageView.getImage() == null) {
                return i;
            }
        }
        return -1;
    }
}
