package fr.iut.montreuil.projetfinale.zhellda.vue;

import fr.iut.montreuil.projetfinale.zhellda.Lancement;
import fr.iut.montreuil.projetfinale.zhellda.modele.Coffre;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;

public class VueCoffre {
    private Coffre coffre;

    public VueCoffre(Pane pane, Coffre coffre, String urlImg){
        this.coffre = coffre;
        URL url = Lancement.class.getResource(urlImg);
        Image image = new Image(String.valueOf(url));
        ImageView imageView = new ImageView(image);

        imageView.xProperty().bind(coffre.xProperty());
        imageView.yProperty().bind(coffre.yProperty());
        imageView.setId(coffre.getId());
        imageView.setFitWidth(32);
        imageView.setFitHeight(32);

        pane.getChildren().add(imageView);
    }
}
