package fr.iut.montreuil.projetfinale.zhellda.vue;

import fr.iut.montreuil.projetfinale.zhellda.Lancement;
import fr.iut.montreuil.projetfinale.zhellda.modele.Pnj;
import fr.iut.montreuil.projetfinale.zhellda.modele.Projectile;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;

public class VuePnj {

    public class VueProjectile {

        private Pnj pnj;

        public VueProjectile(Pane pane, Projectile projectile, String urlImg){
            this.pnj =projectile;
            URL url = Lancement.class.getResource(urlImg);
            Image image = new Image(String.valueOf(url));;
            ImageView imageView = new ImageView(image);
            imageView.setFitHeight(30);
            imageView.setFitWidth(30);

            imageView.setId(pnj.getId());
            imageView.translateXProperty().bind(pnj.getXProperty());
            imageView.translateYProperty().bind(pnj.getYProperty());
            pane.getChildren().add(imageView);
        }
}
