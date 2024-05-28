package fr.iut.montreuil.projetfinale.zhellda.vue;

import fr.iut.montreuil.projetfinale.zhellda.Lancement;
import fr.iut.montreuil.projetfinale.zhellda.modele.personnage.Joueur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.net.URL;

public class VueJoueur {
    private Joueur j;
    private static ImageView imageView;

    public VueJoueur(Pane pane, Joueur j, String urlImg) {
        this.j = j;
        URL url = Lancement.class.getResource(urlImg);
        Image image = new Image(String.valueOf(url));
        this.imageView = new ImageView(image);

        j.getHitbox().setFill(Color.TRANSPARENT);
        j.getHitbox().setStroke(Color.RED);
        j.getHitbox().setStrokeWidth(2);

        imageView.setFitHeight(30);
        imageView.setFitWidth(30);

        imageView.setId(j.getId());
        imageView.translateXProperty().bind(j.getXProperty());
        imageView.translateYProperty().bind(j.getYProperty());

        j.getHitbox().xProperty().bind(j.getXProperty());
        j.getHitbox().yProperty().bind(j.getYProperty());

        pane.getChildren().add(imageView);
        pane.getChildren().add(j.getHitbox());
    }

    public static void modifierImage(String urlImg) {
        URL url = Lancement.class.getResource(urlImg);
        Image image = new Image(String.valueOf(url));
        imageView.setImage(image);
    }


}
