package fr.iut.montreuil.projetfinale.zhellda.vue;

import fr.iut.montreuil.projetfinale.zhellda.Lancement;
import fr.iut.montreuil.projetfinale.zhellda.modele.Joueur;
import fr.iut.montreuil.projetfinale.zhellda.modele.Projectile;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.net.URL;

public class VueCoeurs {

    private Joueur joueur;
    private HBox coeur;
    private Image coeurPlein;
    private Image coeurVide;


    public VueCoeurs(HBox coeur, Joueur joueur, String urlImg){
        this.joueur =joueur;
        URL url = Lancement.class.getResource(urlImg);
        Image image = new Image(String.valueOf(url));;
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(30);
        imageView.setFitWidth(30);
        coeur.getChildren().add(imageView);
    }
}
