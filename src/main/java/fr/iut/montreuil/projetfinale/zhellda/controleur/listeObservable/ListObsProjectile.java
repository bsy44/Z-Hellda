package fr.iut.montreuil.projetfinale.zhellda.controleur.listeObservable;

import fr.iut.montreuil.projetfinale.zhellda.modele.projectile.Projectile;
import fr.iut.montreuil.projetfinale.zhellda.vue.VueProjectile;
import javafx.collections.ListChangeListener;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

public class ListObsProjectile implements ListChangeListener<Projectile> {

    private Pane pane;

    public ListObsProjectile(Pane pane) {
        this.pane = pane;
    }

    @Override
    public void onChanged(Change<? extends Projectile> change) {
        while (change.next()) {
            if (change.wasAdded()) {
                for (Projectile projectile : change.getAddedSubList()) {
                    if (projectile.getX()>projectile.getxDirection())
                        if (projectile instanceof Fleche)
                            new VueProjectile(pane, projectile, "flecheGauche.png");
                        else
                            new VueProjectile(pane, projectile, "bouleDeFeuGauche.png");
                    else if (projectile.getX()< projectile.getxDirection()) {
                        if (projectile instanceof Fleche)
                            new VueProjectile(pane, projectile, "flecheDroite.png");
                        else
                            new VueProjectile(pane, projectile, "bouleDeFeuDroite.png");
                    }
                    else if (projectile.getY()< projectile.getyDirection()){
                        if (projectile instanceof Fleche)
                            new VueProjectile(pane, projectile, "flecheBas.png");
                        else
                            new VueProjectile(pane, projectile, "bouleDeFeuBas.png");
                    }
                    else {
                        if (projectile instanceof Fleche)
                            new VueProjectile(pane, projectile, "flecheHaut.png");
                        else
                            new VueProjectile(pane, projectile, "bouleDeFeuHaut.png");
                    }

                }
            }
            if (change.wasRemoved()) {
                for (Projectile p : change.getRemoved()) {
                    Node n = pane.lookup( "#"+p.getId());
                    if (n != null) {
                        this.pane.getChildren().remove(n);
                    }
                }
            }
        }
    }
}
