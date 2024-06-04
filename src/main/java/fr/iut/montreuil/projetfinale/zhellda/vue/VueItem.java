package fr.iut.montreuil.projetfinale.zhellda.vue;

import fr.iut.montreuil.projetfinale.zhellda.Lancement;
import fr.iut.montreuil.projetfinale.zhellda.modele.Item;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;

public class VueItem {

    public VueItem(Pane pane, Item item, String urlImg){
        URL url = Lancement.class.getResource(urlImg);
        Image image = new Image(String.valueOf(url));;
        ImageView imageView = new ImageView(image);

        imageView.translateXProperty().bind(item.xProperty());
        imageView.translateYProperty().bind(item.yProperty());
        imageView.setId(item.getId());

        imageView.setFitWidth(16);
        imageView.setFitHeight(16);

        pane.getChildren().add(imageView);
    }
}
