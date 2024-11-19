package fr.iut.montreuil.projetfinale.zhellda.controleur.listeObservable;

import fr.iut.montreuil.projetfinale.zhellda.modele.Case;
import fr.iut.montreuil.projetfinale.zhellda.modele.personnage.Boss;
import fr.iut.montreuil.projetfinale.zhellda.modele.schemaAttaque.SchemaAttaqueBoss;
import fr.iut.montreuil.projetfinale.zhellda.vue.VueTerrain;
import javafx.collections.ListChangeListener;

public class ObsSchemaAtkBoss {
    private fr.iut.montreuil.projetfinale.zhellda.modele.schemaAttaque.SchemaAttaqueBoss paterneAttaqueBoss;

    public ObsSchemaAtkBoss(Boss boss) {
        this.paterneAttaqueBoss = (SchemaAttaqueBoss) boss.getSchemaAttaqueEnnemi();
        ajouterListner();
    }

    public void ajouterListner() {

        paterneAttaqueBoss.getCasesAttaqueesProperty().addListener((ListChangeListener.Change<? extends Case> change) -> {

            for (Case c : change.getList()) {
                VueTerrain.faireClignoterTile(c.getX(), c.getY());
            }

        });

    }

}




