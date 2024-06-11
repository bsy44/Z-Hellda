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
    private int tempsAlteration = 0;
    private int tempsEcoule = 0;
    private double posX = 0;
    private double posY = 0;
    private double scrollingVitesse;
    private ChangeurStringEnnemi changeurStringEnnemi;
    private BulleTexte bulleTexte;
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

        this.changeurStringEnnemi=new ChangeurStringEnnemi(env);
        new VueTerrain(tilePane, env);
        new VueJoueur(pane, env.getJ());
        Pnj pnj= new Pnj(250,250,env);
        new VuePnj(pane, pnj,"perso2.png");


        env.ajouterPnj(pnj);

        for (int i = 0; i < 6; i++) {
            env.ajouterEnnemi(changeurStringEnnemi.choisirEnnemie(env.genererSpawn(),env.genenerEnnemie()));

        }

            env.ajouterEnnemi(changeurStringEnnemi.choisirEnnemie(env.genererSpawn(),env.genenerEnnemie()));


        ListObsVie listObsVie = new ListObsVie(coeur, env.getJ(), coeur);
        listObsVie.mettreAJourCoeurs();

        ListChangeListener<Ennemis> listeEnnemis = new ListObsEnnemis(pane);
        env.getObsEnnemis().addListener(listeEnnemis);

        ListChangeListener<Pnj> listePnj = new ListObsPnj(pane);
        env.getObsPnj().addListener(listePnj);


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

        pane.sceneProperty().addListener((obs, oldScene, newScene) -> {
            if (newScene != null) {
                initKeyHandlers(newScene);
            }
        });

        for (int i = 0; i < env.getObsEnnemis().size(); i++) {
            new VueEnnemis(pane, env.getObsEnnemis().get(i), "ennemi.png");
        }

        for (Coffre coffre : env.getListCoffre()) {
            new VueCoffre(pane, coffre, coffre.getNom() + ".png");

            coffre.estOuvert().addListener((observable, oldValue, newValue) -> {
                if (newValue) {
                    Node node = pane.lookup("#" + coffre.getId());
                    if (node != null) {
                        pane.getChildren().remove(node);
                        new VueCoffre(pane, coffre, "coffreOuvert.png");
                    }
                }
            });
        }
        scrollingVitesse = env.getJ().getVitesse();

        initAnimation();
        gameLoop.play();
    }

    private void initAnimation() {
        gameLoop = new Timeline();
        gameLoop.setCycleCount(Timeline.INDEFINITE);

        KeyFrame kf = new KeyFrame(

                Duration.seconds(0.001),
                (ev -> {
                    Pnj pnj=env.getObsPnj().get(0);
                    if (pnj.getX() < Environnement.getJ().getHitbox().getX() + Environnement.getJ().getHitbox().getWidth() + 16 &&
                            pnj.getX() + pnj.getHitbox().getWidth() > Environnement.getJ().getHitbox().getX() - 16 &&
                            pnj.getY() < Environnement.getJ().getHitbox().getY() + Environnement.getJ().getHitbox().getHeight() + 16 &&
                            pnj.getY() + pnj.getHitbox().getHeight() > Environnement.getJ().getHitbox().getY() - 16) {

                        if (bulleTexte == null) {
                            bulleTexte = new BulleTexte("message", pnj, pane);
                            bulleTexte.setTranslateX(pnj.getX());
                            bulleTexte.setTranslateY(pnj.getY() - 50);
                            bulleTexte.setTexte("message");
                        }


                    }
                    else if (bulleTexte != null) {
                        System.out.println("ok");
                        pane.getChildren().remove(bulleTexte);
                        bulleTexte = null;
                    }
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
                    scrollingMap();


//                    Environnement.getJ().getXProperty().addListener((observable, oldValue, newValue) -> {
//                        this.pane.setTranslateX(pane.getPrefWidth() / 2 - Environnement.getJ().getX()-(Environnement.getJ().getHitbox().getWidth()/2));
//                    });
//                    Environnement.getJ().getYProperty().addListener((observable, oldValue, newValue) -> {
//                        this.pane.setTranslateY( pane.getPrefHeight() / 2 - Environnement.getJ().getY()-(Environnement.getJ().getHitbox().getHeight()/2));
//                    });
//                    this.pane.setTranslateX(pane.getPrefWidth() / 2 - Environnement.getJ().getX()-(Environnement.getJ().getHitbox().getWidth()/2));
//                    this.pane.setTranslateY(pane.getPrefHeight() /2 - Environnement.getJ().getY()-(Environnement.getJ().getHitbox().getHeight()/2));
//


                    if (env.mortJoueur()){
                        gameLoop.stop();
                        afficherGameOverScene();
                    }
                })
        );
        gameLoop.getKeyFrames().add(kf);
    }
    private void scrollingMap() {
        Scene scene = pane.getScene();
        if (scene == null) return;

        double largeurScene = scene.getWidth();
        double hauteurScene = scene.getHeight();

        Joueur joueur = env.getJ();

        int joueurX = joueur.getX();
        int joueurY = joueur.getY();

        // Calculer la position du joueur dans la fenêtre
        double joueurScreenX = joueurX - posX;
        double joueurScreenY = joueurY - posY;


        // Si le joueur se déplace vers le bord gauche de la fenêtre
        if (joueurScreenX < largeurScene * 0.2) {
            posX -= scrollingVitesse;
        }
        // Si le joueur se déplace vers le bord droit de la fenêtre
        else if (joueurScreenX > largeurScene * 0.8) {
            posX += scrollingVitesse;
        }

        // Si le joueur se déplace vers le bord supérieur de la fenêtre
        if (joueurScreenY < hauteurScene * 0.2) {
            posY -= scrollingVitesse;
        }
        // Si le joueur se déplace vers le bord inférieur de la fenêtre
        else if (joueurScreenY > hauteurScene * 0.8) {
            posY += scrollingVitesse;
        }

        // Limiter le défilement pour ne pas sortir de la carte
        double maxX = (env.getTerrain().getLargeur() * 16) - largeurScene;
        double maxY = (env.getTerrain().getHauteur() * 16) - hauteurScene;

        posX = clamp(posX, 0, maxX);
        posY = clamp(posY, 0, maxY);


        // Appliquer le décalage de défilement à la TilePane
        pane.setLayoutX(-posX);
        pane.setLayoutY(-posY);
    }

    private double clamp(double value, double min, double max) {
        return Math.max(min, Math.min(max, value));
    }



    @FXML
    public void interactionItemInventaire(MouseEvent event) {
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
            return;
        }
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) ((Node) pane).getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}