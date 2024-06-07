package fr.iut.montreuil.projetfinale.zhellda.controleur;

import fr.iut.montreuil.projetfinale.zhellda.modele.Ennemis;
import fr.iut.montreuil.projetfinale.zhellda.modele.Environnement;
import fr.iut.montreuil.projetfinale.zhellda.modele.Joueur;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.beans.value.ChangeListener;


public class ObsJoueur implements ListChangeListener<Joueur> {
    @FXML
    Pane pane;
    Environnement env;

    public ObsJoueur(Pane pane, Environnement env){
        this.pane=pane;
        this.env=env;
        ajouterListners();
    }

    @Override
    public void onChanged(Change<? extends Joueur> change) {
        while(change.next()){
            for (Joueur j : change.getRemoved()) {
                Node n = pane.lookup("#" + j.getId());
                this.pane.getChildren().remove(n);

                Node n1 = pane.lookup("#" + j.getId());
                this.pane.getChildren().remove(n1);
            }
        }
    }

    public void ajouterListners() {
        Environnement.getJ().getXProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                Environnement.nouveauBfs();
                for (Ennemis e : env.getObsEnnemis()) {
                    e.nouveauChemin();
                }
            }
        });

        Environnement.getJ().getYProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                Environnement.nouveauBfs();
                for (Ennemis e : env.getObsEnnemis()) {
                    e.nouveauChemin();
                }
            }
        });
    }
}
