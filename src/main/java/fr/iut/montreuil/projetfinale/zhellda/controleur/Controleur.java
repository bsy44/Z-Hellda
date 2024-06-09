package fr.iut.montreuil.projetfinale.zhellda.controleur;

import fr.iut.montreuil.projetfinale.zhellda.Lancement;
import fr.iut.montreuil.projetfinale.zhellda.modele.*;
import fr.iut.montreuil.projetfinale.zhellda.vue.*;
import javafx.animation.Timeline;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.animation.KeyFrame;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controleur implements Initializable {
    private Environnement env;
    private Timeline gameLoop;
    private int temps;
    private int tempsAlteration = 0;
    private int tempsEcoule = 0;
    @FXML
    private Pane pane;
    @FXML
    private TilePane tilePane;
    @FXML
    private HBox coeur;
    @FXML
    private VBox inventaireItem;
    @FXML HBox inventaireArme;

    public void initKeyHandlers(Scene scene) {
        scene.setOnKeyPressed(Clavier::keyPressed);
        scene.setOnKeyReleased(Clavier::keyReleased);
    }

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

        Arc arc = new Arc(320, 110, env);
        Epee epee = new Epee(env, 410, 367);
        Marteau marteau = new Marteau(env, 710, 210);
        env.ajouterItem(arc);
        /*env.ajouterItem(epee);
        env.ajouterItem(marteau);*/


        env.ajouterEnnemi(e);
        env.ajouterEnnemi(e2);
        env.ajouterEnnemi(e3);
        env.ajouterEnnemi(e4);
        env.ajouterEnnemi(e5);
        env.ajouterEnnemi(e6);
        env.ajouterEnnemi(e7);

        ListObsVie listObsVie = new ListObsVie(coeur, env.getJ(), coeur);

        pane.sceneProperty().addListener((obs, oldScene, newScene) -> {
            if (newScene != null) {
                initKeyHandlers(newScene);
            }
        });

        listObsVie.mettreAJourCoeurs();

        ListChangeListener<Ennemis> listeEnnemis = new ListObsEnnemis(pane);
        env.getObsEnnemis().addListener(listeEnnemis);

        ListChangeListener<Joueur> listeJoueur = new ObsJoueur(pane, env);
        env.getObsJoueur().addListener(listeJoueur);

        ListChangeListener<Projectile> listeProjectile = new ListObsProjectile(pane);
        env.getObsProjectile().addListener(listeProjectile);

        ListChangeListener<Item> listObsItem = new ListObsItem(pane);
        env.getObsItemParTerre().addListener(listObsItem);

        ListChangeListener<Item> listObsItemInventaire = new ListObsItemInventaire(inventaireItem);
        Environnement.getJ().getInventaireItem().getListItem().addListener(listObsItemInventaire);

        ListChangeListener<Item> listObsArmeInventaire = new ListObsInventaireArme(inventaireArme);
        Environnement.getJ().getInventaireArme().getListItem().addListener(listObsArmeInventaire);

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

        for (Item item:env.getObsItemParTerre()) {
            new VueItem(pane, item, item.getNom() + ".png");
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
                    if (Environnement.getJ().isEtatAltere()) {
                        tempsAlteration += 10;
                    }
                    if (tempsAlteration == 50000) {
                        tempsAlteration = 0;
                        Environnement.getJ().setEtatAltere(false);
                        Environnement.getJ().buffVitesse(2);
                    }
                    env.actionItem();
                    Environnement.getJ().resetDeplacement();
                    if (tempsEcoule % 10000 == 0) {
                        for (Ennemis ennemi : env.getObsEnnemis()) {
                            //ennemi.seDeplacer();
                            ennemi.attaquer();
                        }
                    }
                    if (tempsEcoule % 500 == 0) {
                        env.actionProjectile();
                    }

                    if (env.mortJoueur()){
                        gameLoop.stop();
                        afficherGameOverScene();
                    }
                })
        );
        gameLoop.getKeyFrames().add(kf);
    }

    @FXML
    public void interactionItem(MouseEvent event) {
        Button sourceButton = (Button) event.getSource();
        ImageView imageView = (ImageView) sourceButton.getGraphic();

        if (imageView.getImage() != null) {
            Button boutonConsommer = new Button("Consommer");
            Button boutonJeter = new Button("Jeter");
            Button boutonAnuler = new Button("X");

            VBox hBox = new VBox();
            hBox.getChildren().add(boutonConsommer);
            hBox.getChildren().add(boutonJeter);
            hBox.getChildren().add(boutonAnuler);
            hBox.setSpacing(5);
            inventaireItem.getChildren().add(hBox);

            boutonConsommer.setOnAction(event1 -> {
                int index = Integer.parseInt(sourceButton.getId().replace("bouton", ""));
                ItemConsomable item = (ItemConsomable) Environnement.getJ().getInventaireItem().getListItem().get(index);
                item.consommerItem(Environnement.getJ());

                inventaireItem.getChildren().remove(hBox);
            });

            boutonJeter.setOnAction(event1 -> {
                int index = Integer.parseInt(sourceButton.getId().replace("bouton", ""));
                Item item = Environnement.getJ().getInventaireItem().getListItem().get(index);
                Environnement.getJ().jeterItem(item);

                inventaireItem.getChildren().remove(hBox);
            });

            boutonAnuler.setOnAction(event1 -> {
                inventaireItem.getChildren().remove(hBox);
            });

            boutonConsommer.getStyleClass().add("bouton-dynamique");
            boutonJeter.getStyleClass().add("bouton-dynamique");
            boutonAnuler.getStyleClass().add("bouton-dynamique");
        }
    }

    public void afficherGameOverScene(){
        FXMLLoader fxmlLoader = new FXMLLoader();
        URL resource = Lancement.class.getResource("VueGameOver.fxml");
        Parent root = null;
        try {
            root = fxmlLoader.load(resource);
        } catch (IOException e) {
            e.printStackTrace();
            return; // Arrêter la méthode si une exception se produit Lors du chargement, du fichier. FxML
        }
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) ((Node) pane).getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}