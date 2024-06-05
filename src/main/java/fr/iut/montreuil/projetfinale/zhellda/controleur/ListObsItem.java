package fr.iut.montreuil.projetfinale.zhellda.controleur;

import fr.iut.montreuil.projetfinale.zhellda.Lancement;
import fr.iut.montreuil.projetfinale.zhellda.modele.Environnement;
import fr.iut.montreuil.projetfinale.zhellda.modele.Item;
import fr.iut.montreuil.projetfinale.zhellda.vue.VueItem;
import javafx.collections.ListChangeListener;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import java.net.URL;

public class ListObsItem implements ListChangeListener<Item> {

    private Pane pane;
    private VBox inventaireItem;

    public ListObsItem(Pane pane, VBox inventaireItem){
        this.pane = pane;
        this.inventaireItem = inventaireItem;
    }
    @Override
    public void onChanged(Change<? extends Item> change) {
        while (change.next()) {
            if (change.wasAdded()) {
                for (Item item : change.getAddedSubList()) {
                    new VueItem(pane, item, "pommeOr.png");
                }
            }

            if (change.wasRemoved()) {
                for (int i = change.getRemoved().size() - 1; i >= 0; i--) {
                    Item item = change.getRemoved().get(i);
                    System.out.println(item.getId());
                    Node n = pane.lookup("#" + item.getId());
                    System.out.println(n);
                    if (n != null) {
                        this.pane.getChildren().remove(n);
                        ajouterImageVersInventaire(item);
                    }

                    Node itemInventaire = inventaireItem.lookup("#item" + i);
                    if (itemInventaire != null) {
                        inventaireItem.getChildren().remove(itemInventaire);
                    }
                }
            }
        }
    }

    public void ajouterImageVersInventaire(Item item){
        URL url = Lancement.class.getResource(item.getNom().getValue() + ".png");
        if (url != null) {
            Image image = new Image(url.toExternalForm());

            for (int i = 1; i <= Environnement.getJ().getInventaire().getListItem().size(); i++) {
                ImageView imageView = (ImageView) inventaireItem.lookup("#item" + i);
                Label labelItem = (Label) inventaireItem.lookup("#labelItm" + i);

                if (imageView != null && imageView.getImage() == null) {
                    imageView.setImage(image);
                    imageView.setId(item.getId());
                    System.out.println("Image ajoutée");
                    labelItem.textProperty().bind(item.getNom());

                    imageView.setOnMouseClicked(mouseEvent -> {
                        Button boutonConsommer  = new Button();
                        boutonConsommer.setText("Consommer");
                        boutonConsommer.setTranslateX(imageView.getX());
                        boutonConsommer.setTranslateY(imageView.getY());


                        Button boutonRetirer  = new Button();
                        boutonRetirer.setText("Retirer");
                        boutonRetirer.setTranslateX(imageView.getX());
                        boutonRetirer.setTranslateY(imageView.getY());

                        Button buttonAnnuler  = new Button();
                        buttonAnnuler.setText("X");
                        buttonAnnuler.setTranslateX(imageView.getX());
                        buttonAnnuler.setTranslateY(imageView.getY());

                        inventaireItem.getChildren().add(boutonConsommer);
                        inventaireItem.getChildren().add(boutonRetirer);
                        inventaireItem.getChildren().add(buttonAnnuler);

                        boutonConsommer.setOnAction(event -> {
                            item.consommerItem();
                            Environnement.getJ().getInventaire().retirerItem(item);
                        });


                        buttonAnnuler.setOnAction(event -> {
                            inventaireItem.getChildren().remove(boutonRetirer);
                            inventaireItem.getChildren().remove(buttonAnnuler);
                            inventaireItem.getChildren().remove(boutonConsommer);
                        });
                    });
                }
            }
        }
    }
}