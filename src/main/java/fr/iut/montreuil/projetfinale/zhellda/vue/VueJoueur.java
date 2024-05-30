///*package fr.iut.montreuil.projetfinale.zhellda.vue;
//
//import fr.iut.montreuil.projetfinale.zhellda.Lancement;
//import fr.iut.montreuil.projetfinale.zhellda.modele.Joueur;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import javafx.scene.layout.Pane;
//import javafx.scene.paint.Color;
//import java.net.URL;
//
//public class VueJoueur {
//    private Joueur j;
//    private static ImageView imageView;
//
//    public VueJoueur(Pane pane, Joueur j) {
//        this.j = j;
//        URL url = Lancement.class.getResource("Joueur.png");
//        Image image = new Image(String.valueOf(url));
//        this.imageView = new ImageView(image);
//
//        imageView.setFitHeight(30);
//        imageView.setFitWidth(30);
//        imageView.setId(j.getId());
//        imageView.translateXProperty().bind(j.getXProperty());
//        imageView.translateYProperty().bind(j.getYProperty());
//
//        j.getHitbox().setFill(Color.TRANSPARENT);
//        j.getHitbox().setStroke(Color.BLUE);
//        j.getHitbox().setStrokeWidth(2);
//        j.getHitbox().setId(j.getId() + 1);
//        j.getHitbox().xProperty().bind(j.getXProperty());
//        j.getHitbox().yProperty().bind(j.getYProperty());
//
//        pane.getChildren().add(imageView);
//        pane.getChildren().add(j.getHitbox());
//
//        if (j.getDirections(0)){
//            url = Lancement.class.getResource("Personnage_dos_droit.png");
//            this.imageView.setImage(new Image(String.valueOf(url)));
//        }
//        else if (j.getDirections(1)){
//            url = Lancement.class.getResource("perso2.png");
//            this.imageView.setImage(new Image(String.valueOf(url)));
//        }
//    }
//
//    public void modifierImageDeplacement() {
//
//    }
//}*/
//
//package fr.iut.montreuil.projetfinale.zhellda.vue;
//
//import fr.iut.montreuil.projetfinale.zhellda.Lancement;
//import fr.iut.montreuil.projetfinale.zhellda.modele.Joueur;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import javafx.scene.layout.Pane;
//import javafx.scene.paint.Color;
//import java.net.URL;
//
//public class VueJoueur {
//    private Joueur j;
//    private static ImageView imageView;
//
//    public VueJoueur(Pane pane, Joueur j) {
//        this.j = j;
//        URL url = Lancement.class.getResource("Joueur.png");
//        Image image = new Image(String.valueOf(url));
//        this.imageView = new ImageView(image);
//
//        imageView.setFitHeight(30);
//        imageView.setFitWidth(30);
//        imageView.setId(j.getId());
//        imageView.translateXProperty().bind(j.getXProperty());
//        imageView.translateYProperty().bind(j.getYProperty());
//
//        j.getHitbox().setFill(Color.TRANSPARENT);
//        j.getHitbox().setStroke(Color.BLUE);
//        j.getHitbox().setStrokeWidth(2);
//        j.getHitbox().setId(j.getId() + 1);
//        j.getHitbox().xProperty().bind(j.getXProperty());
//        j.getHitbox().yProperty().bind(j.getYProperty());
//
//        pane.getChildren().add(imageView);
//        pane.getChildren().add(j.getHitbox());
//
//        modifImage();
//    }
//
//    public void modifImage() {
//        URL url = null;
//
//        if (j.getDirections(0)){
//            url = Lancement.class.getResource("Personnage_dos_droit.png");
//        }
//        else if (j.getDirections(1)){
//            url = Lancement.class.getResource("perso2.png");
//        }
//        if (url != null) {
//            this.imageView.setImage(new Image(String.valueOf(url)));
//        }
//    }
//}
package fr.iut.montreuil.projetfinale.zhellda.vue;

import fr.iut.montreuil.projetfinale.zhellda.Lancement;
import fr.iut.montreuil.projetfinale.zhellda.modele.Joueur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import java.net.URL;

public class VueJoueur {
    private Joueur j;
    private static ImageView imageView;

    public VueJoueur(Pane pane, Joueur j) {
        this.j = j;
        URL url = Lancement.class.getResource("Joueur.png");
        Image image = new Image(String.valueOf(url));
        this.imageView = new ImageView(image);

        imageView.setFitHeight(30);
        imageView.setFitWidth(30);
        imageView.setId(j.getId());
        imageView.translateXProperty().bind(j.getXProperty());
        imageView.translateYProperty().bind(j.getYProperty());

        j.getHitbox().setFill(Color.TRANSPARENT);
        j.getHitbox().setStroke(Color.BLUE);
        j.getHitbox().setStrokeWidth(2);
        j.getHitbox().setId(j.getId() + 1);
        j.getHitbox().xProperty().bind(j.getXProperty());
        j.getHitbox().yProperty().bind(j.getYProperty());

        pane.getChildren().add(imageView);
        pane.getChildren().add(j.getHitbox());

        j.directionProperty().addListener((obs, old, nouv) -> {
            modifImage(nouv.intValue());
        });

        modifImage(-1);
    }

    public void modifImage(int direction) {
        URL url = null;

        switch (direction) {
            case 0: // Haut
                url = Lancement.class.getResource("Personnage_dos_droit.png");
                break;
            case 1: // Gauche
                url = Lancement.class.getResource("perso2.png");
                break;
            case 2: // Bas
                url = Lancement.class.getResource("Joueur.png");
                break;
            case 3: // Droite
                url = Lancement.class.getResource("Joueur.png");
                break;
        }
        if (url != null) {
            this.imageView.setImage(new Image(String.valueOf(url)));
        }
    }
}
