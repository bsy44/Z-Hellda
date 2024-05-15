package fr.iut.montreuil.projetfinale.zhellda.controleur;

import fr.iut.montreuil.projetfinale.zhellda.modele.Ennemis;
import fr.iut.montreuil.projetfinale.zhellda.modele.Environnement;
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
        System.out.println("on changed");
        while (change.next()) {
            for (Ennemis e : change.getRemoved()) {
                Node n = pane.lookup("#" + e.getId());
                this.pane.getChildren().remove(n);

            }

        }
    }
}
