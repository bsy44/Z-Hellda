package fr.iut.montreuil.projetfinale.zhellda.vue;

import fr.iut.montreuil.projetfinale.zhellda.Lancement;
import fr.iut.montreuil.projetfinale.zhellda.modele.Environnement;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class VueTerrain {
    private static Map<Integer, ImageView> tileMap = new HashMap<>();
    private static final int tailleTile = 16;

    public VueTerrain(TilePane tilePane) {
        URL imageTileUrl = Lancement.class.getResource("DecorTileset.png");
        Image imTile = new Image(String.valueOf(imageTileUrl));
        for (int i = 0; i < Environnement.getTerrain().getTerrain().length; i++) {
            for (int j = 0; j < Environnement.getTerrain().getTerrain()[i].length; j++) {
                mettreTile(Environnement.getTerrain().getTerrain()[i][j], imTile, tilePane, i, j);
            }
        }
    }

    private void mettreTile(int id, Image im, TilePane tilePane, int row, int col) {
        ImageView imv = new ImageView(im);
        int tilesPerRow = (int) (im.getWidth() / tailleTile);
        int x = (id % tilesPerRow) * tailleTile;
        int y = (id / tilesPerRow) * tailleTile;
        Rectangle2D imviewport = new Rectangle2D(x, y, tailleTile, tailleTile);
        imv.setViewport(imviewport);
        tilePane.getChildren().add(imv);
        tileMap.put(row * 1000 + col, imv);
    }

    public static void faireClignoterTile(int x, int y) {
        ImageView imv = tileMap.get(y * 1000 + x);
        if (imv != null) {
            Rectangle overlay = new Rectangle(tailleTile, tailleTile);
            overlay.setFill(Color.DARKRED);
            overlay.setOpacity(0);
            imv.setClip(overlay);

            Timeline clignotement = new Timeline(
                    new KeyFrame(Duration.seconds(0), new KeyValue(overlay.opacityProperty(), 0)),
                    new KeyFrame(Duration.seconds(0.5), new KeyValue(overlay.opacityProperty(), 1)),
                    new KeyFrame(Duration.seconds(1), new KeyValue(overlay.opacityProperty(), 0))
            );
            clignotement.setCycleCount(Timeline.INDEFINITE);
            clignotement.play();

            Timeline stopClignotement = new Timeline(
                    new KeyFrame(Duration.seconds(1), e -> {
                        clignotement.stop();
                        imv.setClip(null);
                    })
            );
            stopClignotement.play();
        }
    }

}

