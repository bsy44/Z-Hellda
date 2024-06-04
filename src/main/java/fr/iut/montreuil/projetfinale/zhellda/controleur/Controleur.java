package fr.iut.montreuil.projetfinale.zhellda.controleur;

import fr.iut.montreuil.projetfinale.zhellda.modele.*;
import fr.iut.montreuil.projetfinale.zhellda.modele.Projectile;
import fr.iut.montreuil.projetfinale.zhellda.modele.Ennemis;
import fr.iut.montreuil.projetfinale.zhellda.modele.Joueur;
import fr.iut.montreuil.projetfinale.zhellda.vue.VueEnnemis;
import fr.iut.montreuil.projetfinale.zhellda.vue.VueJoueur;
import fr.iut.montreuil.projetfinale.zhellda.vue.VueTerrain;
import javafx.animation.Timeline;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.animation.KeyFrame;
import javafx.util.Duration;
import java.net.URL;
import java.util.ResourceBundle;

public class Controleur implements Initializable {
    private Environnement env;
    private Timeline gameLoop;
    private int temps;
    private int tempsAlteration=0;
    private int tempsEcoule = 0;
    @FXML
    private Pane pane;
    @FXML
    private TilePane tilePane;
    @FXML
    private HBox coeur;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.env = new Environnement();
        new VueTerrain(tilePane, env);
        new VueJoueur(pane, env.getJ());

        Ennemis e = new Tank(80, 80, this.env);
        Ennemis e2 = new Tank(110, 110, this.env);
        env.ajouterEnnemi(e);
        env.ajouterEnnemi(e2);
        ListObsVie listObsVie = new ListObsVie(coeur, env.getJ(), coeur);

        // Mettre à jour l'affichage initial des cœurs
        listObsVie.mettreAJourCoeurs();

        ListChangeListener<Ennemis> listeEnnemis = new ListObsEnnemis(pane);
        env.getObsEnnemis().addListener(listeEnnemis);

        ListChangeListener<Joueur> listeJoueur = new ObsJoueur(pane);
        env.getObsJoueur().addListener(listeJoueur);

        ListChangeListener<Projectile> listeProjectile = new ListObsProjectile(pane);
        env.getObsProjectile().addListener(listeProjectile);

        /*Environnement.getJ().getXProperty().addListener((observable, old, now )-> {
            this.pane.setTranslateX(pane.getPrefWidth() / 2 - Environnement.getJ().getX());
        });
        Environnement.getJ().getYProperty().addListener((observable, old, now )-> {
            this.pane.setTranslateY(pane.getPrefHeight() / 2 - Environnement.getJ().getY());
        });

        this.pane.setTranslateX(pane.getPrefWidth() / 2 - Environnement.getJ().getX());
        this.pane.setTranslateY(pane.getPrefHeight() / 2 - Environnement.getJ().getY());*/

        for (int i = 0; i < env.getObsEnnemis().size(); i++) {
            new VueEnnemis(pane, env.getObsEnnemis().get(i), "ennemi.png");
        }

        initAnimation();
        gameLoop.play();
    }

    private void initAnimation() {
        gameLoop = new Timeline();
        temps = 0;
        gameLoop.setCycleCount(Timeline.INDEFINITE);

        KeyFrame kf = new KeyFrame(
                Duration.seconds(0.001),
                (ev -> {
                    tempsEcoule += 10;
                    Environnement.getJ().seDeplacer();
                    if (Environnement.getJ().isEtatAltere()){
                        tempsAlteration+=10;
                    }
                    if (tempsAlteration==50000){
                        tempsAlteration=0;
                        Environnement.getJ().setEtatAltere(false);
                        Environnement.getJ().buffVitesse(2);
                    }
                    System.out.println(Environnement.getJ().getVitesse());


                    Environnement.getJ().resetDeplacement();
                    if (tempsEcoule % 10000 == 0) {
                        for (Ennemis ennemi : env.getObsEnnemis()) {
                            ennemi.attaquer();
                        }
                    }
                    if (tempsEcoule % 500 == 0) {
                        env.actionProjectile();
                    }
                })
        );
        gameLoop.getKeyFrames().add(kf);
    }

}