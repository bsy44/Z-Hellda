package fr.iut.montreuil.projetfinale.zhellda.controleur.listeObservable;

import fr.iut.montreuil.projetfinale.zhellda.modele.Case;
import fr.iut.montreuil.projetfinale.zhellda.modele.personnage.Boss;
import fr.iut.montreuil.projetfinale.zhellda.modele.personnage.SchemaAttaqueBoss;
import fr.iut.montreuil.projetfinale.zhellda.vue.VueTerrain;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;

public class ObsPaterneBoss {
    private Boss boss;
    private SchemaAttaqueBoss paterneAttaqueBoss;

    public ObsPaterneBoss(Boss boss) {
        this.boss = boss;
        this.paterneAttaqueBoss = (SchemaAttaqueBoss) boss.getSchemaAttaqueEnnemi();
        ajouterListner();
    }

    public void ajouterListner() {

        paterneAttaqueBoss.getCasesAttaqueesProperty().addListener((ListChangeListener.Change<? extends Case> change) -> {

            System.out.println("changement vue");

            for (Case c : change.getList()) {
                VueTerrain.faireClignoterTile(c.getX(), c.getY());
            }

//            switch (paterneAttaqueBoss.getShemaAttaque()) {
//
//                case 0:
//                    vueClawAtk();
//                    break;
//
//                case 1:
//                    vueAreaOfEffect();
//                    break;
//
//                case 2:
//                    vueFireBall();
//                    break;
//
//                default:
//                    break;
//            }

        });

    }

//    public void vueClawAtk() {
//        if (paterneAttaqueBoss.direction(boss).equals("droite")) {
//
//            VueTerrain.faireClignoterTile(Math.round(boss.getX() / 16) + 6, Math.round(boss.getY() / 16) + 7);
//            VueTerrain.faireClignoterTile(Math.round(boss.getX() / 16) + 6, Math.round(boss.getY() / 16) - 1);
//            for (int i = -1; i <= 7; i++) {
//                VueTerrain.faireClignoterTile(Math.round(boss.getX() / 16) + 7, Math.round(boss.getY() / 16) + i);
//                if (i + 1 < 7) {
//                    VueTerrain.faireClignoterTile(Math.round(boss.getX() / 16) + 8, Math.round(boss.getY() / 16) + i + 1);
//                }
//                if (i + 2 < 6) {
//                    VueTerrain.faireClignoterTile(Math.round(boss.getX() / 16) + 9, Math.round(boss.getY() / 16) + i + 2);
//                }
//            }
//
//        } else if (paterneAttaqueBoss.direction(boss).equals("gauche")) {
//
//            VueTerrain.faireClignoterTile(Math.round(boss.getX() / 16) + 1, Math.round(boss.getY() / 16) + 7);
//            VueTerrain.faireClignoterTile(Math.round(boss.getX() / 16) + 1, Math.round(boss.getY() / 16) - 1);
//            for (int i = -1; i <= 7; i++) {
//                VueTerrain.faireClignoterTile(Math.round(boss.getX() / 16), Math.round(boss.getY() / 16) + i);
//                if (i + 1 < 7) {
//                    VueTerrain.faireClignoterTile(Math.round(boss.getX() / 16) - 1, Math.round(boss.getY() / 16) + i + 1);
//                }
//                if (i + 2 < 6) {
//                    VueTerrain.faireClignoterTile(Math.round(boss.getX() / 16) - 2, Math.round(boss.getY() / 16) + i + 2);
//                }
//            }
//
//        } else if (paterneAttaqueBoss.direction(boss).equals("bas")) {
//
//            VueTerrain.faireClignoterTile(Math.round(boss.getX() / 16) - 1, Math.round(boss.getY() / 16) + 6);
//            VueTerrain.faireClignoterTile(Math.round(boss.getX() / 16) + 7, Math.round(boss.getY() / 16) + 6);
//            for (int i = -1; i <= 7; i++) {
//                VueTerrain.faireClignoterTile(Math.round(boss.getX() / 16) + i, Math.round(boss.getY() / 16) + 7);
//                if (i + 1 < 7) {
//                    VueTerrain.faireClignoterTile(Math.round(boss.getX() / 16) + i + 1, Math.round(boss.getY() / 16) + 8);
//                }
//                if (i + 2 < 6) {
//                    VueTerrain.faireClignoterTile(Math.round(boss.getX() / 16) + i + 2, Math.round(boss.getY() / 16) + 9);
//                }
//            }
//
//        } else {
//
//            VueTerrain.faireClignoterTile(Math.round(boss.getX() / 16) - 1, Math.round(boss.getY() / 16) + 1);
//            VueTerrain.faireClignoterTile(Math.round(boss.getX() / 16) + 7, Math.round(boss.getY() / 16) + 1);
//            for (int i = -1; i <= 7; i++) {
//                VueTerrain.faireClignoterTile(Math.round(boss.getX() / 16) + i, Math.round(boss.getY() / 16));
//                if (i + 1 < 7) {
//                    VueTerrain.faireClignoterTile(Math.round(boss.getX() / 16) + i + 1, Math.round(boss.getY() / 16) - 1);
//                }
//                if (i + 2 < 6) {
//                    VueTerrain.faireClignoterTile(Math.round(boss.getX() / 16) + i + 2, Math.round(boss.getY() / 16) - 2);
//                }
//            }
//        }
//    }
//
//    public void vueAreaOfEffect() {
//
//        for (int i = -1; i < 8; i++) {
//                VueTerrain.faireClignoterTile(Math.round(boss.getX() / 16) + 7, Math.round(boss.getY() / 16) + i);
//                VueTerrain.faireClignoterTile(Math.round(boss.getX() / 16) - 1, Math.round(boss.getY() / 16) + i);
//                VueTerrain.faireClignoterTile(Math.round(boss.getX() / 16) + i, Math.round(boss.getY() / 16) + 7);
//                VueTerrain.faireClignoterTile(Math.round(boss.getX() / 16) + i, Math.round(boss.getY() / 16) - 1);
//            if (i > -1 && i < 7 ){
//                VueTerrain.faireClignoterTile(Math.round(boss.getX() / 16) + 8, Math.round(boss.getY() / 16) + i);
//                VueTerrain.faireClignoterTile(Math.round(boss.getX() / 16) - 2, Math.round(boss.getY() / 16) + i);
//                VueTerrain.faireClignoterTile(Math.round(boss.getX() / 16) + i, Math.round(boss.getY() / 16) + 8);
//                VueTerrain.faireClignoterTile(Math.round(boss.getX() / 16) + i, Math.round(boss.getY() / 16) - 2);
//                if (i > 1 && i < 5){
//                    VueTerrain.faireClignoterTile(Math.round(boss.getX() / 16) + 9, Math.round(boss.getY() / 16) + i);
//                    VueTerrain.faireClignoterTile(Math.round(boss.getX() / 16) - 3, Math.round(boss.getY() / 16) + i);
//                    VueTerrain.faireClignoterTile(Math.round(boss.getX() / 16) + i, Math.round(boss.getY() / 16) + 9);
//                    VueTerrain.faireClignoterTile(Math.round(boss.getX() / 16) + i, Math.round(boss.getY() / 16) - 3);
//                }
//            }
//        }
//    }
//
//    public void vueFireBall (){
//
//        if (paterneAttaqueBoss.direction(boss).equals("droite")) {
//            for (int i=0; i <= 12; i++) {
//                for (int j = 0; j <= 4; j++) {
//                    VueTerrain.faireClignoterTile((int) Math.round((boss.getX() + (boss.getHitbox().getWidth())) / 16) + i, Math.round(boss.getY() / 16) + 1 + j);
//                }
//            }
//        } else if (paterneAttaqueBoss.direction(boss).equals("gauche")) {
//
//            for (int i=0; i <= 12; i++) {
//                for (int j = 0; j <= 4; j++) {
//                    VueTerrain.faireClignoterTile((int) Math.round(boss.getX()/ 16) - i, Math.round(boss.getY() / 16) + 1 + j);
//                }
//            }
//
//        } else if (paterneAttaqueBoss.direction(boss).equals("bas")) {
//
//            for (int i=0; i <= 12; i++) {
//                for (int j = 0; j <= 4; j++) {
//                    VueTerrain.faireClignoterTile(Math.round(boss.getX()/ 16)+1+j, (int) Math.round((boss.getY()+boss.getHitbox().getHeight())/ 16)+i);
//                }
//            }
//
//        } else {
//
//            for (int i=0; i <= 12; i++) {
//                for (int j = 0; j <= 4; j++) {
//                    VueTerrain.faireClignoterTile(Math.round(boss.getX()/ 16)+1+j, Math.round(boss.getY() / 16)-i);
//                }
//            }
//
//        }
//
//    }
}




