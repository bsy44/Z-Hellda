package fr.iut.montreuil.projetfinale.zhellda.controleur;

import fr.iut.montreuil.projetfinale.zhellda.modele.Joueur;
import fr.iut.montreuil.projetfinale.zhellda.vue.VueJoueur;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
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
            if (change.wasAdded()){
                new VueJoueur(pane, "Joueur.png");
            }
        }

    }
}
