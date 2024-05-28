package fr.iut.montreuil.projetfinale.zhellda.controleur;

import fr.iut.montreuil.projetfinale.zhellda.modele.personnage.Joueur;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

public class ObsJoueur implements ListChangeListener<Joueur> {
    @FXML
    Pane pane;

    public ObsJoueur(Pane pane){
        this.pane=pane;
    }

    @Override
    public void onChanged(Change<? extends Joueur> change) {
        while(change.next()){
            for (Joueur j : change.getRemoved()) {
                    System.out.println("#" + j.getId());
                    Node n = pane.lookup("#" + j.getId());
                    this.pane.getChildren().remove(n);
            }
        }
    }
}
