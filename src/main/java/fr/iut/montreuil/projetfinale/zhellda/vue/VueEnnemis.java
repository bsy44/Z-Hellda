package fr.iut.montreuil.projetfinale.zhellda.vue;

import fr.iut.montreuil.projetfinale.zhellda.Lancement;
import fr.iut.montreuil.projetfinale.zhellda.modele.personnage.Ennemi;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;

public class VueEnnemis {
        private ProgressBar barreDeVie;

        public VueEnnemis(Pane pane, Ennemi ennemi, String urlImg){
            URL url = Lancement.class.getResource(urlImg);
            Image image = new Image(String.valueOf(url));;
            ImageView imageView = new ImageView(image);
            this.barreDeVie = new ProgressBar();

            imageView.setId(ennemi.getId());
            imageView.translateXProperty().bind(ennemi.getXProperty());
            imageView.translateYProperty().bind(ennemi.getYProperty());
            ennemi.getHitbox().xProperty().bind(ennemi.getXProperty());
            ennemi.getHitbox().yProperty().bind(ennemi.getYProperty());
            if (urlImg.equals("boss.png")){
                imageView.setFitHeight(100);
                imageView.setFitWidth(100);
            }
            else if (urlImg.equals("tank.png")){
                imageView.setFitHeight(50);
                imageView.setFitWidth(50);
            } else if (urlImg.equals("sentinelle.png")){
                imageView.setFitHeight(50);
                imageView.setFitWidth(40);
            } else {
                imageView.setFitHeight(30);
                imageView.setFitWidth(30);
            }

            barreDeVie.translateYProperty().bind(ennemi.getYProperty().subtract(10));
            barreDeVie.translateXProperty().bind(ennemi.getXProperty().subtract(8));
            barreDeVie.setPrefWidth(50);
            barreDeVie.setPrefHeight(10);
            barreDeVie.progressProperty().bind(ennemi.getVie().divide((double) ennemi.getPvMax()));
            barreDeVie.setId(ennemi.getId() + 1);

            pane.getChildren().add(imageView);
            pane.getChildren().add(barreDeVie);
        }
}
