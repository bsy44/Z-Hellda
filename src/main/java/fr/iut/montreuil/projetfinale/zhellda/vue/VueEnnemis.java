package fr.iut.montreuil.projetfinale.zhellda.vue;

import fr.iut.montreuil.projetfinale.zhellda.Lancement;
import fr.iut.montreuil.projetfinale.zhellda.modele.personnage.Ennemis;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.net.URL;

public class VueEnnemis {
        private ProgressBar barreDeVie;

        public VueEnnemis(Pane pane, Ennemis ennemis, String urlImg){
            URL url = Lancement.class.getResource(urlImg);
            Image image = new Image(String.valueOf(url));;
            ImageView imageView = new ImageView(image);
            this.barreDeVie = new ProgressBar();

            imageView.setId(ennemis.getId());
            imageView.translateXProperty().bind(ennemis.getXProperty());
            imageView.translateYProperty().bind(ennemis.getYProperty());
            if (urlImg.equals("boss.png")){
                imageView.setFitHeight(100);
                imageView.setFitWidth(100);
            }
            /*else if (urlImg.equals("tank.png")){
                imageView.setFitHeight(50);
                imageView.setFitWidth(50);
            } */else if (urlImg.equals("sentinelle.png")){
                imageView.setFitHeight(50);
                imageView.setFitWidth(40);
            } else {
                imageView.setFitHeight(30);
                imageView.setFitWidth(30);
            }

            barreDeVie.translateYProperty().bind(ennemis.getYProperty().subtract(10));
            barreDeVie.translateXProperty().bind(ennemis.getXProperty().subtract(8));
            barreDeVie.setPrefWidth(50);
            barreDeVie.setPrefHeight(10);
            barreDeVie.progressProperty().bind(ennemis.getVie().divide((double)ennemis.getPvMax()));
            barreDeVie.setId(ennemis.getId() + 1);

            pane.getChildren().add(imageView);
            pane.getChildren().add(barreDeVie);
        }
}
