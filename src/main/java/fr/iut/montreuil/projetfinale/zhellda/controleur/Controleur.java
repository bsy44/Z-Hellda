package fr.iut.montreuil.projetfinale.zhellda.controleur;

import fr.iut.montreuil.projetfinale.zhellda.modele.Terrain;
import fr.iut.montreuil.projetfinale.zhellda.vue.VueTerrain;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;

import java.net.URL;
import java.util.ResourceBundle;

public class Controleur implements Initializable {
    private Terrain terrain;
    @FXML
    private Pane pane;
    @FXML
    private TilePane tilePane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.terrain = new Terrain();
        new VueTerrain(terrain, tilePane);
    }
}