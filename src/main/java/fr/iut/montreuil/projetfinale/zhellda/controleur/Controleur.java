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
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.animation.KeyFrame;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.awt.event.ActionEvent;
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
    @FXML
    private VBox inventaireItem;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.env = new Environnement();
        new VueTerrain(tilePane, env);
        new VueJoueur(pane, env.getJ());

        Ennemis e = new Zombie(80, 80, this.env);
        Ennemis e2 = new Zombie(410, 110, this.env);
        Ennemis e3 = new Zombie(510, 110, this.env);
        Ennemis e4 = new Zombie(610, 110, this.env);
        Ennemis e5 = new Zombie(510, 210, this.env);
        Ennemis e6 = new Zombie(610, 210, this.env);
        Ennemis e7 = new Zombie(410, 210, this.env);

        env.ajouterEnnemi(e);
        env.ajouterEnnemi(e2);
        env.ajouterEnnemi(e3);
        env.ajouterEnnemi(e4);
        env.ajouterEnnemi(e5);
        env.ajouterEnnemi(e6);
        env.ajouterEnnemi(e7);

        ListObsVie listObsVie = new ListObsVie(coeur, env.getJ(), coeur);

        // Mettre à jour l'affichage initial des cœurs
        listObsVie.mettreAJourCoeurs();

        ListChangeListener<Ennemis> listeEnnemis = new ListObsEnnemis(pane);
        env.getObsEnnemis().addListener(listeEnnemis);

        ListChangeListener<Joueur> listeJoueur = new ObsJoueur(pane);
        env.getObsJoueur().addListener(listeJoueur);

        ListChangeListener<Projectile> listeProjectile = new ListObsProjectile(pane);
        env.getObsProjectile().addListener(listeProjectile);

        ListChangeListener<Item> listObsItem = new ListObsItem(pane);
        env.getObsItemParTerre().addListener(listObsItem);

        ListChangeListener<Item> listObsItemInventaire = new ListObsItemInventaire(inventaireItem);
        Environnement.getJ().getInventaire().getListItem().addListener(listObsItemInventaire);
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
                    env.actionItem();
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