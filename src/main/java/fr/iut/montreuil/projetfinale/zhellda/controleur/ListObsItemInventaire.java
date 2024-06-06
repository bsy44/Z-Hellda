package fr.iut.montreuil.projetfinale.zhellda.controleur;

import fr.iut.montreuil.projetfinale.zhellda.Lancement;
import fr.iut.montreuil.projetfinale.zhellda.modele.Environnement;
import fr.iut.montreuil.projetfinale.zhellda.modele.Item;
import javafx.collections.ListChangeListener;
import javafx.scene.control.Button;
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
                for (int i = change.getRemoved().size() - 1; i >= 0; i--) {
                    Item item = change.getRemoved().get(i);
                    ImageView imageView = (ImageView) inventaireItem.lookup("#" + item.getId());
                    interactionItem(item, imageView);
                    imageView.setImage(null);
                }
            }
        }
    }

    public void ajouterImageVersInventaire(Item item) {
        URL url = Lancement.class.getResource(item.getNom().getValue() + ".png");
        if (url != null) {
            Image image = new Image(url.toExternalForm());
            for (int i = 0; i < Environnement.getJ().getInventaire().getListItem().size(); i++) {
                ImageView imageView = (ImageView) inventaireItem.lookup("#" + Environnement.getJ().getInventaire().getListItem().get(i).getId());
                Label labelItem = (Label) inventaireItem.lookup("#labelItm" + i);

                if (imageView != null && imageView.getImage() == null) {
                    imageView.setImage(image);
                    labelItem.textProperty().bind(item.getNom());
                    interactionItem(item, imageView);
                }
            }
        }
    }

    public void interactionItem(Item item, ImageView imageView) {
        imageView.setOnMouseClicked(mouseEvent -> {
            Button boutonConsommer = new Button();
            boutonConsommer.setText("Consommer");
            boutonConsommer.setTranslateX(imageView.getX());
            boutonConsommer.setTranslateY(imageView.getY());

            Button boutonRetirer = new Button();
            boutonRetirer.setText("Retirer");
            boutonRetirer.setTranslateX(imageView.getX());
            boutonRetirer.setTranslateY(imageView.getY());

            Button buttonAnnuler = new Button();
            buttonAnnuler.setText("X");
            buttonAnnuler.setTranslateX(imageView.getX());
            buttonAnnuler.setTranslateY(imageView.getY());

            inventaireItem.getChildren().addAll(boutonConsommer, boutonRetirer, buttonAnnuler);

            boutonConsommer.setOnAction(event -> {
                item.consommerItem();
                Environnement.getJ().getInventaire().retirerItem(item);
                disableAndRemoveButtons(boutonConsommer, boutonRetirer, buttonAnnuler);
            });

            boutonRetirer.setOnAction(event -> {
                Environnement.getJ().getInventaire().retirerItem(item);
                disableAndRemoveButtons(boutonConsommer, boutonRetirer, buttonAnnuler);
            });

            buttonAnnuler.setOnAction(event -> {
                disableAndRemoveButtons(boutonConsommer, boutonRetirer, buttonAnnuler);
            });
        });
    }

    private void disableAndRemoveButtons(Button... buttons) {
        for (Button button : buttons) {
            button.setDisable(true);
            inventaireItem.getChildren().remove(button);
        }
    }

}
