package fr.iut.montreuil.projetfinale.zhellda.vue;

import fr.iut.montreuil.projetfinale.zhellda.Lancement;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;

public class VueJoueur {

    public VueJoueur(Pane pane, String urlImg){
        URL url = Lancement.class.getResource(urlImg);
        Image image = new Image(String.valueOf(url));;
        ImageView imageView = new ImageView(image);

        imageView.setFitHeight(20);
        imageView.setFitWidth(20);
        pane.getChildren().add(imageView);
    }
}
