package fr.iut.montreuil.projetfinale.zhellda.controleur;

import fr.iut.montreuil.projetfinale.zhellda.modele.Environnement;
import fr.iut.montreuil.projetfinale.zhellda.modele.Joueur;
import fr.iut.montreuil.projetfinale.zhellda.modele.Pnj;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

public class ListObsPnj implements ListChangeListener<Pnj> {
    @FXML
    private Pane pane;
    public ListObsPnj(Pane pane){
        this.pane=pane;
    }
    @Override
    public void onChanged(Change<? extends Pnj> change) {
        while(change.next()) {
            for (Pnj pnj : change.getRemoved()) {
                Node n = pane.lookup("#" + pnj.getId());
                this.pane.getChildren().remove(n);

//                Node n1 = pane.lookup("#" + pnj.getId() + 1);
//                this.pane.getChildren().remove(n1);

            }
        }
    }
}
