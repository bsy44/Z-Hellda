package fr.iut.montreuil.projetfinale.zhellda.controleur;

import fr.iut.montreuil.projetfinale.zhellda.modele.Ennemis;
import fr.iut.montreuil.projetfinale.zhellda.modele.Environnement;
import fr.iut.montreuil.projetfinale.zhellda.vue.VueEnnemis;
import fr.iut.montreuil.projetfinale.zhellda.vue.VueJoueur;
import fr.iut.montreuil.projetfinale.zhellda.vue.VueTerrain;
import javafx.animation.Timeline;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.animation.KeyFrame;
import javafx.util.Duration;
import java.net.URL;
import java.util.ResourceBundle;

public class Controleur implements Initializable {
    private Environnement env;
    private Timeline gameLoop;
    private int temps;
    @FXML
    private Pane pane;
    @FXML
    private TilePane tilePane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        this.env = new Environnement(300,300);
        new VueTerrain(env.getTerrain(), tilePane);
        new VueJoueur(pane,env.getJ(),"Joueur.png");
        Ennemis e = new Ennemis(10,10);
        env.ajouterEnnemi(e);
        ListChangeListener<Ennemis> listeEnnemis=new ListObsEnnemis(pane);
        env.getObsEnnemis().addListener(listeEnnemis);
        for (int i = 0; i < env.getObsEnnemis().size(); i++) {
            new VueEnnemis(pane,env.getObsEnnemis().get(i),"ennemi.png");
        }

        initAnimation();
        gameLoop.play();

        /*ListChangeListener<Joueur>listeObsJ = new ObsJoueur(env, pane);
        this.env.getObsJoueur().addListener(listeObsJ);*/
    }
    private void initAnimation() {
        gameLoop = new Timeline();
        temps=0;
        gameLoop.setCycleCount(Timeline.INDEFINITE);

        KeyFrame kf = new KeyFrame(
                // on définit le FPS (nbre de frame par seconde)
                Duration.seconds(0.017),
                // on définit ce qui se passe à chaque frame
                // c'est un eventHandler d'ou le lambda
                (ev ->{
                    if(temps==100){
                        System.out.println("fini");
                        gameLoop.stop();
                    }
                    else if (temps%5==0){
                        System.out.println("un tour");
                    }
                    temps++;
                })
        );
        gameLoop.getKeyFrames().add(kf);
    }

}