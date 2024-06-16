package fr.iut.montreuil.projetfinale.zhellda.vue;

import fr.iut.montreuil.projetfinale.zhellda.Lancement;
import fr.iut.montreuil.projetfinale.zhellda.modele.projectile.Projectile;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;

public class VueProjectile {

    private Projectile p;

    public VueProjectile(Pane pane, Projectile projectile, String urlImg){
        this.p =projectile;
        URL url = Lancement.class.getResource(urlImg);
        Image image = new Image(String.valueOf(url));;
        ImageView imageView = new ImageView(image);
        if (urlImg == "bouleDeFeuBas.png" || urlImg == "bouleDeFeuHaut.png"){
            imageView.setFitHeight(100);
            imageView.setFitWidth(75);
        } else if (urlImg == "bouleDeFeuGauche.png" || urlImg == "bouleDeFeuDroite.png"){
            imageView.setFitHeight(75);
            imageView.setFitWidth(100);
        } else {
            imageView.setFitHeight(30);
            imageView.setFitWidth(30);
        }

        imageView.setId(p.getId());
        imageView.translateXProperty().bind(p.getXProperty());
        imageView.translateYProperty().bind(p.getYProperty());
        pane.getChildren().add(imageView);
    }
}
