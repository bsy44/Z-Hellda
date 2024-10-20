package fr.iut.montreuil.projetfinale.zhellda.controleur.listeObservable;

import fr.iut.montreuil.projetfinale.zhellda.modele.personnage.Ennemis;
import fr.iut.montreuil.projetfinale.zhellda.modele.Environnement;
import fr.iut.montreuil.projetfinale.zhellda.modele.personnage.Joueur;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class ObsJoueur implements ListChangeListener<Joueur> {
    @FXML
    private Pane pane;
    private Environnement env;

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

                Node n1 = pane.lookup("#" + j.getId() + 1);
                this.pane.getChildren().remove(n1);
            }
        }
    }

    public void ajouterListners() {
        Environnement.getJ().getXProperty().addListener((ObservableValue<? extends Number> observableValue, Number number, Number t1) -> {
            Environnement.nouveauBfs();
            for (Ennemis e : env.getListEnnemis()) {
                e.nouveauChemin();
            }
        });

        Environnement.getJ().getYProperty().addListener((ObservableValue<? extends Number> observableValue, Number number, Number t1) -> {
            Environnement.nouveauBfs();
            for (Ennemis e : env.getListEnnemis()) {
                e.nouveauChemin();
            }
        });


        Environnement.getJ().transparentProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {// Ajout d'un écouteur pour détecter le changement de l'état altéré du joueur
            if (newValue) {
                clignoterBlanc(pane.lookup("#" + Environnement.getJ().getId()));// Si l'état altéré est activé, faire clignoter l'image du joueur en blanc
            }
        });
    }

    public void clignoterBlanc(Node node) {
        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setInput(node.getEffect());

        double totalDuration = 7.0; // Durée totale en secondes
        double cycleDuration = 1.0; // Durée d'un cycle de clignotement
        int cycleCount = (int) (totalDuration / cycleDuration);

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(colorAdjust.brightnessProperty(), 0.0)),
                new KeyFrame(Duration.seconds(cycleDuration / 2), new KeyValue(colorAdjust.brightnessProperty(), 1.0)),
                new KeyFrame(Duration.seconds(cycleDuration), new KeyValue(colorAdjust.brightnessProperty(), 0.0))
        );

        timeline.setCycleCount(cycleCount); // Nombre de cycles pour couvrir 7 secondes
        timeline.setAutoReverse(false);

        node.setEffect(colorAdjust);

        timeline.play();

        timeline.setOnFinished(event -> {
            node.setEffect(null);
            timeline.stop();
        });
    }
}
