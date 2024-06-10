package fr.iut.montreuil.projetfinale.zhellda.controleur;

import fr.iut.montreuil.projetfinale.zhellda.modele.Villageois;
import fr.iut.montreuil.projetfinale.zhellda.vue.VueVilageois;
import javafx.collections.ListChangeListener;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

public class ObsVillageois implements ListChangeListener<Villageois> {
    private Pane pane;

    public ObsVillageois(Pane pane){
        this.pane = pane;
    }
    @Override
    public void onChanged(Change<? extends Villageois> change) {
        while (change.next()){
            if (change.wasAdded()){
                for (Villageois villageois : change.getAddedSubList()) {
                    new VueVilageois(pane, villageois);
                }
            }
            if (change.wasRemoved()){
                for (Villageois villageois : change.getRemoved()) {
                    Node node = pane.lookup("#" + villageois.getId());
                    pane.getChildren().remove(node);
                }
            }
        }
    }
}
