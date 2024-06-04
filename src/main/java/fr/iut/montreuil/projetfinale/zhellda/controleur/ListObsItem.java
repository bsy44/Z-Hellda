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
        while (change.next()){
            if (change.wasAdded()){
                for (Item i : change.getAddedSubList()) {
                    new VueItem(pane, i, "pommeOr.png");
                }
            }

            if (change.wasRemoved()){
                for (Item i : change.getRemoved()) {
                    System.out.println(i.getId());
                    Node n = pane.lookup("#" + i.getId());
                    System.out.println(n);
                    if (n != null) {
                        this.pane.getChildren().remove(n);
                    }
                }
            }
        }
    }
}
