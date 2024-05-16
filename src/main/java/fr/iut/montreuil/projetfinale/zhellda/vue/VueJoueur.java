package fr.iut.montreuil.projetfinale.zhellda.vue;

import fr.iut.montreuil.projetfinale.zhellda.Lancement;
import fr.iut.montreuil.projetfinale.zhellda.modele.Joueur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.awt.*;
import java.net.URL;

public class VueJoueur {
    private Joueur j;

    public VueJoueur(Pane pane, Joueur j, String urlImg){
        this.j = j;
        URL url = Lancement.class.getResource(urlImg);
        Image image = new Image(String.valueOf(url));;
        ImageView imageView = new ImageView(image);

        imageView.setFitHeight(30);
        imageView.setFitWidth(30);

        imageView.setId(j.getId());
        imageView.translateXProperty().bind(j.getXProperty());
        imageView.translateYProperty().bind(j.getYProperty());

        /*Rectangle hitbox = new Rectangle(j.getX(), j.getY(), 30,25);
        hitbox.setFill(Color.BLACK);
        hitbox.setId(j.getId());
        hitbox.xProperty().bind(j.getXProperty());
        hitbox.yProperty().bind(j.getYProperty());*/

        j.getHitbox().xProperty().bind(j.getXProperty());
        j.getHitbox().yProperty().bind(j.getYProperty());

        pane.getChildren().add(imageView);
    }
}
