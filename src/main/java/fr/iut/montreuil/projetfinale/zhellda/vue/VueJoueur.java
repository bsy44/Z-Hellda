package fr.iut.montreuil.projetfinale.zhellda.vue;

import fr.iut.montreuil.projetfinale.zhellda.Lancement;
import fr.iut.montreuil.projetfinale.zhellda.modele.Joueur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;

public class VueJoueur {
    private Joueur j;

    public VueJoueur(Pane pane, Joueur j, String urlImg){
        this.j = j;
        URL url = Lancement.class.getResource(urlImg);
        Image image = new Image(String.valueOf(url));;
        ImageView imageView = new ImageView(image);

        imageView.setFitHeight(20);
        imageView.setFitWidth(20);

        imageView.setId(j.getId());
        imageView.translateXProperty().bind(j.getXProperty());
        imageView.translateYProperty().bind(j.getYProperty());
        pane.getChildren().add(imageView);
    }
}
