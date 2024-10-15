package fr.iut.montreuil.projetfinale.zhellda.controleur.listeObservable;

import fr.iut.montreuil.projetfinale.zhellda.modele.personnage.Boss;
import fr.iut.montreuil.projetfinale.zhellda.modele.personnage.Ennemi;
import fr.iut.montreuil.projetfinale.zhellda.vue.VueEnnemis;
import javafx.collections.ListChangeListener;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

public class ListObsEnnemis implements ListChangeListener<Ennemi> {

    private Pane pane;

    public ListObsEnnemis(Pane pane){
        this.pane=pane;
    }
    @Override
    public void onChanged(Change<? extends Ennemi> change) {
        while (change.next()) {
            if (change.wasAdded()){
                for (Ennemi e : change.getAddedSubList()) {
                    new VueEnnemis(pane, e, e.getNom() + ".png");
                    if (e.getNom().equals("boss")) new ObsPaterneBoss((Boss) e);
                }
            }

            for (Ennemi e : change.getRemoved()) {
                Node n = pane.lookup("#" + e.getId());
                this.pane.getChildren().remove(n);

                Node n1 = pane.lookup("#" + e.getId()+1);
                pane.getChildren().remove(n1);
            }
        }
    }
}
