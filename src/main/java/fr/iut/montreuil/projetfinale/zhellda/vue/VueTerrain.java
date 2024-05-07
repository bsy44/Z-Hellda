package fr.iut.montreuil.projetfinale.zhellda.vue;

import fr.iut.montreuil.projetfinale.zhellda.Lancement;
import fr.iut.montreuil.projetfinale.zhellda.modele.Terrain;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;

import java.net.URL;

public class VueTerrain {
    public VueTerrain(Terrain t, TilePane tp){
        System.out.println("Dans vu terrain");
        for (int i = 0; i < t.getTerrain().length;i++) {

            for (int j = 0; j < t.getTerrain()[i].length;j++) {
                URL image = Lancement.class.getResource("img" + t.getTerrain()[i][j] + ".png");
                Image im = new Image(String.valueOf(image));
                ImageView imv = new ImageView(im);
                imv.setFitHeight(30);
                imv.setFitWidth(30);

                tp.getChildren().add(imv);
            }
        }
    }
}
