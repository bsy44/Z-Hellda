package fr.iut.montreuil.projetfinale.zhellda.controleur;

import fr.iut.montreuil.projetfinale.zhellda.modele.arme.Projectile;
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
                        new VueProjectile(pane, projectile, "flecheGauche.png");
                    else if (projectile.getX()< projectile.getxDirection()) {
                        new VueProjectile(pane, projectile, "flecheDroite.png");
                    }
                    else if (projectile.getY()< projectile.getyDirection()){
                            new VueProjectile(pane, projectile, "flecheBas.png");
                    }
                    else
                        new VueProjectile(pane, projectile, "flecheHaut.png");
                }
            }
            if (change.wasRemoved()) {
                for (Projectile p : change.getRemoved()) {
                    System.out.println("P#" + p.getId());
                    Node n = pane.lookup( "#"+p.getId());
                    if (n != null) {
                        this.pane.getChildren().remove(n);
                    }
                }
            }
        }
    }
}
