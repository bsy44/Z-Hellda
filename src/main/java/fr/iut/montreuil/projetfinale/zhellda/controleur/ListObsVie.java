package fr.iut.montreuil.projetfinale.zhellda.controleur;

import fr.iut.montreuil.projetfinale.zhellda.modele.Joueur;
import fr.iut.montreuil.projetfinale.zhellda.vue.VueCoeurs;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class ListObsVie {
    private HBox coeur;
    private Image coeurPlein;
    private Image coeurVide;
    private Joueur joueur;
    private Pane pane;

    public ListObsVie(Pane pane, Joueur joueur, HBox coeur) {
        this.pane = pane;
        this.joueur = joueur;
        this.coeur=coeur;

        joueur.getVie().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                mettreAJourCoeurs();
            }
        });

        mettreAJourCoeurs();
    }

    void mettreAJourCoeurs() {
        coeur.getChildren().clear();
        int pointsDeVie = joueur.getVie().get();
        int maxPointsDeVie = joueur.getVieMax();

        for (int i = 0; i < maxPointsDeVie; i++) {
            if (i<joueur.getVie().get()) {
                new VueCoeurs(coeur, joueur,"coeurPlein.png");
            }
            else {
                new VueCoeurs(coeur, joueur,"coeurVide.png");
            }
        }
    }
}
