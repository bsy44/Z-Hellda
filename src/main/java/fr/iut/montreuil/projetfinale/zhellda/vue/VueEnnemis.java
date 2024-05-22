package fr.iut.montreuil.projetfinale.zhellda.vue;

import fr.iut.montreuil.projetfinale.zhellda.Lancement;
import fr.iut.montreuil.projetfinale.zhellda.modele.Ennemis;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;

public class VueEnnemis {
        private Ennemis e;
        private ProgressBar barreDeVie;

        public VueEnnemis(Pane pane, Ennemis ennemis, String urlImg){
            this.e =ennemis;
            URL url = Lancement.class.getResource(urlImg);
            Image image = new Image(String.valueOf(url));;
            ImageView imageView = new ImageView(image);
            this.barreDeVie = new ProgressBar();
            barreDeVie.translateYProperty().bind(ennemis.getYProperty().subtract(10));
            barreDeVie.translateXProperty().bind(ennemis.getXProperty().subtract(8));
            barreDeVie.setPrefWidth(50);
            barreDeVie.setPrefHeight(10);



            barreDeVie.progressProperty().bind(ennemis.getVie().divide((double)ennemis.getPvMax()));
            barreDeVie.setId(ennemis.getId() + 1);

            imageView.setFitHeight(30);
            imageView.setFitWidth(30);

            imageView.setId(e.getId());
            imageView.translateXProperty().bind(e.getXProperty());
            imageView.translateYProperty().bind(e.getYProperty());

            ennemis.getHitbox().xProperty().bind(ennemis.getXProperty());
            ennemis.getHitbox().yProperty().bind(ennemis.getYProperty());

            pane.getChildren().add(imageView);
            pane.getChildren().add(barreDeVie);
        }
}
