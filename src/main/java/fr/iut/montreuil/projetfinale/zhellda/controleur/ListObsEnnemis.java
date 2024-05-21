package fr.iut.montreuil.projetfinale.zhellda.controleur;

import fr.iut.montreuil.projetfinale.zhellda.modele.personnage.Ennemis;
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
                System.out.println("#" + e.getId());
                Node n = pane.lookup("#" + e.getId());
                this.pane.getChildren().remove(n);

            }

        }
    }
}
