package fr.iut.montreuil.projetfinale.zhellda.vue;

import fr.iut.montreuil.projetfinale.zhellda.Lancement;
import fr.iut.montreuil.projetfinale.zhellda.modele.Villageois;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import java.net.URL;

public class VueVilageois {

    public void VueVilageois(Pane pane, Villageois villageois){
        URL url = Lancement.class.getResource("villageois.png");
        Image image = new Image(String.valueOf(url));
        ImageView imageView = new ImageView(image);

        imageView.setFitHeight(30);
        imageView.setFitWidth(30);
        imageView.setId(villageois.getId());
        imageView.translateXProperty().bind(villageois.getXProperty());
        imageView.translateYProperty().bind(villageois.getYProperty());

        pane.getChildren().add(imageView);
    }
}