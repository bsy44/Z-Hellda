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

    public ListObsItem(Pane pane){
        this.pane = pane;
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

                    Node n = pane.lookup("#" + item.getId());
                    System.out.println(n);
                    if (n != null) {
                        this.pane.getChildren().remove(n);
                    }
                }
            }
        }
    }
}