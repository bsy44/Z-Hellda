package fr.iut.montreuil.projetfinale.zhellda.controleur;

import fr.iut.montreuil.projetfinale.zhellda.modele.Boss;
import fr.iut.montreuil.projetfinale.zhellda.modele.Ennemis;
import fr.iut.montreuil.projetfinale.zhellda.modele.Environnement;
import fr.iut.montreuil.projetfinale.zhellda.vue.VueTerrain;
import javafx.beans.value.ObservableValue;

public class ObsPaterneBoss {

    private Environnement env;
    private Boss boss;

    public ObsPaterneBoss(Environnement env, Boss boss) {
        this.env = env;
        this.boss = boss;
    }

    public void ajouterListner() {

        boss.getShemaAttaque().addListener((ObservableValue<? extends Number> observableValue, Number number, Number t1) -> {

            switch (boss.getShemaAttaque().getValue()) {

                case 1:
                    vueClawAtk();
                    break;

                case 2:
                    vueAreaOfEffect();
                    break;

                    case 3:
                        vueFireBall();
                        break;

                default:
                    break;
            }

        });

    }

    public void vueClawAtk() {
        if (boss.getDirection().equals("droite")) {

            VueTerrain.faireClignoterTile(Math.round(boss.getX() / 16) + 6, Math.round(boss.getY() / 16) + 7);
            VueTerrain.faireClignoterTile(Math.round(boss.getX() / 16) + 6, Math.round(boss.getY() / 16) - 1);
            for (int i = -1; i <= 7; i++) {
                VueTerrain.faireClignoterTile(Math.round(boss.getX() / 16) + 7, Math.round(boss.getY() / 16) + i);
                if (i + 1 < 7) {
                    VueTerrain.faireClignoterTile(Math.round(boss.getX() / 16) + 8, Math.round(boss.getY() / 16) + i + 1);
                }
                if (i + 2 < 6) {
                    VueTerrain.faireClignoterTile(Math.round(boss.getX() / 16) + 9, Math.round(boss.getY() / 16) + i + 2);
                }
            }

        } else if (boss.getDirection().equals("gauche")) {

            VueTerrain.faireClignoterTile(Math.round(boss.getX() / 16) + 1, Math.round(boss.getY() / 16) + 7);
            VueTerrain.faireClignoterTile(Math.round(boss.getX() / 16) + 1, Math.round(boss.getY() / 16) - 1);
            for (int i = -1; i <= 7; i++) {
                VueTerrain.faireClignoterTile(Math.round(boss.getX() / 16), Math.round(boss.getY() / 16) + i);
                if (i + 1 < 7) {
                    VueTerrain.faireClignoterTile(Math.round(boss.getX() / 16) - 1, Math.round(boss.getY() / 16) + i + 1);
                }
                if (i + 2 < 6) {
                    VueTerrain.faireClignoterTile(Math.round(boss.getX() / 16) - 2, Math.round(boss.getY() / 16) + i + 2);
                }
            }

        } else if (boss.getDirection().equals("bas")) {

            VueTerrain.faireClignoterTile(Math.round(boss.getX() / 16) - 1, Math.round(boss.getY() / 16) + 6);
            VueTerrain.faireClignoterTile(Math.round(boss.getX() / 16) + 7, Math.round(boss.getY() / 16) + 6);
            for (int i = -1; i <= 7; i++) {
                VueTerrain.faireClignoterTile(Math.round(boss.getX() / 16) + i, Math.round(boss.getY() / 16) + 7);
                if (i + 1 < 7) {
                    VueTerrain.faireClignoterTile(Math.round(boss.getX() / 16) + i + 1, Math.round(boss.getY() / 16) + 8);
                }
                if (i + 2 < 6) {
                    VueTerrain.faireClignoterTile(Math.round(boss.getX() / 16) + i + 2, Math.round(boss.getY() / 16) + 9);
                }
            }

        } else {

            VueTerrain.faireClignoterTile(Math.round(boss.getX() / 16) - 1, Math.round(boss.getY() / 16) + 1);
            VueTerrain.faireClignoterTile(Math.round(boss.getX() / 16) + 7, Math.round(boss.getY() / 16) + 1);
            for (int i = -1; i <= 7; i++) {
                VueTerrain.faireClignoterTile(Math.round(boss.getX() / 16) + i, Math.round(boss.getY() / 16));
                if (i + 1 < 7) {
                    VueTerrain.faireClignoterTile(Math.round(boss.getX() / 16) + i + 1, Math.round(boss.getY() / 16) - 1);
                }
                if (i + 2 < 6) {
                    VueTerrain.faireClignoterTile(Math.round(boss.getX() / 16) + i + 2, Math.round(boss.getY() / 16) - 2);
                }
            }
        }
    }

    public void vueAreaOfEffect() {

        for (int i = -1; i < 8; i++) {
                VueTerrain.faireClignoterTile(Math.round(boss.getX() / 16) + 7, Math.round(boss.getY() / 16) + i);
                VueTerrain.faireClignoterTile(Math.round(boss.getX() / 16) - 1, Math.round(boss.getY() / 16) + i);
                VueTerrain.faireClignoterTile(Math.round(boss.getX() / 16) + i, Math.round(boss.getY() / 16) + 7);
                VueTerrain.faireClignoterTile(Math.round(boss.getX() / 16) + i, Math.round(boss.getY() / 16) - 1);
            if (i > -1 && i < 7 ){
                VueTerrain.faireClignoterTile(Math.round(boss.getX() / 16) + 8, Math.round(boss.getY() / 16) + i);
                VueTerrain.faireClignoterTile(Math.round(boss.getX() / 16) - 2, Math.round(boss.getY() / 16) + i);
                VueTerrain.faireClignoterTile(Math.round(boss.getX() / 16) + i, Math.round(boss.getY() / 16) + 8);
                VueTerrain.faireClignoterTile(Math.round(boss.getX() / 16) + i, Math.round(boss.getY() / 16) - 2);
                if (i > 1 && i < 5){
                    VueTerrain.faireClignoterTile(Math.round(boss.getX() / 16) + 9, Math.round(boss.getY() / 16) + i);
                    VueTerrain.faireClignoterTile(Math.round(boss.getX() / 16) - 3, Math.round(boss.getY() / 16) + i);
                    VueTerrain.faireClignoterTile(Math.round(boss.getX() / 16) + i, Math.round(boss.getY() / 16) + 9);
                    VueTerrain.faireClignoterTile(Math.round(boss.getX() / 16) + i, Math.round(boss.getY() / 16) - 3);
                }
            }
        }
    }

    public void vueFireBall (){

        if (boss.getDirection().equals("droite")) {
            for (int i=0; i <= 12; i++) {
                for (int j = 0; j <= 4; j++) {
                    VueTerrain.faireClignoterTile((int) Math.round((boss.getX() + (boss.getHitbox().getWidth())) / 16) + i, Math.round(boss.getY() / 16) + 1 + j);
                }
            }
        } else if (boss.getDirection().equals("gauche")) {

            for (int i=0; i <= 12; i++) {
                for (int j = 0; j <= 4; j++) {
                    VueTerrain.faireClignoterTile((int) Math.round(boss.getX()/ 16) - i, Math.round(boss.getY() / 16) + 1 + j);
                }
            }

        } else if (boss.getDirection().equals("bas")) {

            for (int i=0; i <= 12; i++) {
                for (int j = 0; j <= 4; j++) {
                    VueTerrain.faireClignoterTile(Math.round(boss.getX()/ 16)+1+j, (int) Math.round((boss.getY()+boss.getHitbox().getHeight())/ 16)+i);
                }
            }

        } else {

            for (int i=0; i <= 12; i++) {
                for (int j = 0; j <= 4; j++) {
                    VueTerrain.faireClignoterTile(Math.round(boss.getX()/ 16)+1+j, Math.round(boss.getY() / 16)-i);
                }
            }

        }

    }
}




