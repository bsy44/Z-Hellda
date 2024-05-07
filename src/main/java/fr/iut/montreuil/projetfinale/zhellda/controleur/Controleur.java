package fr.iut.montreuil.projetfinale.zhellda.controleur;

import fr.iut.montreuil.projetfinale.zhellda.modele.Joueur;
import fr.iut.montreuil.projetfinale.zhellda.modele.Terrain;
import fr.iut.montreuil.projetfinale.zhellda.vue.VueTerrain;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.animation.KeyFrame;
import javafx.util.Duration;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ResourceBundle;

public class Controleur implements Initializable {
    private Terrain terrain;
    public static Joueur j = new Joueur();
    private Timeline gameLoop;
    @FXML
    private Pane pane;
    private int temps;
    @FXML
    private TilePane tilePane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        this.terrain = new Terrain();
        new VueTerrain(terrain, tilePane);
        creerSprite(j);
    }

    private void creerSprite (Joueur j){
        Circle r = new Circle(5);
        r.setFill(Color.RED);
        r.setId(j.getId());
        r.translateXProperty().bind(j.getXProperty());
        r.translateYProperty().bind(j.getYProperty());
        this.tilePane.getChildren().add(r);
        initAnimation();
        gameLoop.play();
    }
    private void initAnimation() {
        gameLoop = new Timeline();
        temps=0;
        gameLoop.setCycleCount(Timeline.INDEFINITE);

        KeyFrame kf = new KeyFrame(
                // on définit le FPS (nbre de frame par seconde)
                Duration.seconds(0.017),
                // on définit ce qui se passe à chaque frame
                // c'est un eventHandler d'ou le lambda
                (ev ->{
                    if(temps==100){
                        System.out.println("fini");
                        gameLoop.stop();
                    }
                    else if (temps%5==0){
                        System.out.println("un tour");
                        leCercle.setLayoutX(leCercle.getLayoutX()+5);
                        leCercle.setLayoutY(leCercle.getLayoutY()+5);

                    }
                    temps++;
                })
        );
        gameLoop.getKeyFrames().add(kf);
    }

}