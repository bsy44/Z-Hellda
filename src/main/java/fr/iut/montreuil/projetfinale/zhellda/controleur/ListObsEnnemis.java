package fr.iut.montreuil.projetfinale.zhellda.controleur;

import fr.iut.montreuil.projetfinale.zhellda.modele.Ennemis;
import javafx.collections.ListChangeListener;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

public class ListObsEnnemis implements ListChangeListener<Ennemis> {

    private Pane pane;

    public ListObsEnnemis(Pane pane){
        this.pane=pane;
    }
    @Override
    public void onChanged(Change<? extends Ennemis> change) {
        while (change.next()) {
            for (Ennemis e : change.getRemoved()) {
                Node n = pane.lookup("#" + e.getId());
                this.pane.getChildren().remove(n);

                Node n1 = pane.lookup("#" + e.getId()+1);
                pane.getChildren().remove(n1);

                Node n2 = pane.lookup("#" + e.getId()+2);
                pane.getChildren().remove(n2);
            }
        }
    }
}
