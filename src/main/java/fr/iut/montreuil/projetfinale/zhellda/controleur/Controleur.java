package fr.iut.montreuil.projetfinale.zhellda.controleur;

import fr.iut.montreuil.projetfinale.zhellda.modele.Joueur;
import fr.iut.montreuil.projetfinale.zhellda.modele.Terrain;
import fr.iut.montreuil.projetfinale.zhellda.vue.VueTerrain;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ResourceBundle;

public class Controleur implements Initializable {
    private Terrain terrain;
    public static Joueur j = new Joueur();
    @FXML
    private Pane pane;
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
    }
}