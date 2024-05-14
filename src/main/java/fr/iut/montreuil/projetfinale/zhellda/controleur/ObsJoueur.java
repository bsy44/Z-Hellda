package fr.iut.montreuil.projetfinale.zhellda.controleur;

import fr.iut.montreuil.projetfinale.zhellda.modele.Joueur;
import fr.iut.montreuil.projetfinale.zhellda.vue.VueJoueur;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

/*public class ObsJoueur implements ListChangeListener<Joueur> {
    @FXML
    Pane pane;

    Environnement env;

    public ObsJoueur(Environnement env, Pane pane){
        this.env = env;
        this.pane=pane;
    }

    @Override
    public void onChanged(Change<? extends Joueur> change) {
        while(change.next()){
            for (Joueur j : change.getAddedSubList()) {
                new VueJoueur(pane, env.getJ(), "Joueur.png");
            }
        }

    }
}*/
