package fr.iut.montreuil.projetfinale.zhellda.controleur;

import fr.iut.montreuil.projetfinale.zhellda.modele.Item;
import fr.iut.montreuil.projetfinale.zhellda.vue.VueItem;
import javafx.collections.ListChangeListener;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

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
                    new VueItem(pane, item, item.getNom() + ".png");
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