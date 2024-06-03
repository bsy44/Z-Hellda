package fr.iut.montreuil.projetfinale.zhellda.vue;

import fr.iut.montreuil.projetfinale.zhellda.Lancement;
import fr.iut.montreuil.projetfinale.zhellda.modele.Environnement;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import java.net.URL;

public class VueTerrain {

    public VueTerrain(TilePane tilePane, Environnement environnement) {
        URL imageTileUrl = Lancement.class.getResource("DecorTileset.png");
        Image imTile = new Image(String.valueOf(imageTileUrl));
        for (int i = 0; i < environnement.getTerrain().getTerrain().length; i++) {
            for (int j = 0; j < environnement.getTerrain().getTerrain()[i].length; j++) {
                mettreTile(environnement.getTerrain().getTerrain()[i][j], imTile, tilePane);
            }
        }
    }

    private void mettreTile(int id, Image im, TilePane tilePane) {
        ImageView imv = new ImageView(im);
        int taille = 16;
        int tilesPerRow = (int) (im.getWidth() / taille);
        int x = (id % tilesPerRow) * taille;
        int y = (id / tilesPerRow) * taille;
        Rectangle2D imviewport = new Rectangle2D(x, y, taille, taille);
        imv.setViewport(imviewport);
        tilePane.getChildren().add(imv);
    }
}

