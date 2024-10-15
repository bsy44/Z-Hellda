package fr.iut.montreuil.projetfinale.zhellda.modele.personnage;

import fr.iut.montreuil.projetfinale.zhellda.modele.Case;
import fr.iut.montreuil.projetfinale.zhellda.modele.Environnement;
import fr.iut.montreuil.projetfinale.zhellda.modele.projectile.BouleDeFeu;
import fr.iut.montreuil.projetfinale.zhellda.vue.VueTerrain;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class SchemaAttaqueBouleDeFeu extends SchemaAttaqueBoss {

    @Override
    public void attaquer (Environnement environnement, Ennemi ennemi){
        faireAttaque(environnement, (Boss) ennemi, direction(ennemi));
        System.out.println("boule de feu");
    }

    @Override
    public void faireAttaque (Environnement environnement, Boss boss, String direction) {

        Timeline lancerBouleDeFeu = new Timeline(
                new KeyFrame(Duration.seconds(1), e -> {
                    if (direction.equals("droite")) {
                        environnement.ajouterProjectile(new BouleDeFeu(boss.getX() + (int) boss.getHitbox().getWidth(), boss.getY(),
                                boss.getX() + (int) boss.getHitbox().getWidth() + 120, boss.getY(), environnement));
                        for (int i=0; i <= 12; i++) {
                            for (int j = 0; j <= 4; j++) {
                                ajouterCasesAttaquees(new Case((int) Math.round((boss.getX() + (boss.getHitbox().getWidth())) / 16) + i, Math.round(boss.getY() / 16) + 1 + j));
                            }
                        }
                    } else if (direction.equals("gauche")) {
                        environnement.ajouterProjectile(new BouleDeFeu(boss.getX() - 80, boss.getY(),
                                boss.getX() - 200, boss.getY(), environnement));
                        for (int i=0; i <= 12; i++) {
                            for (int j = 0; j <= 4; j++) {
                                ajouterCasesAttaquees (new Case ((int) Math.round(boss.getX()/ 16) - i, Math.round(boss.getY() / 16) + 1 + j));
                            }
                        }
                    } else if (direction.equals("bas")) {
                        environnement.ajouterProjectile(new BouleDeFeu(boss.getX(), boss.getY() + (int) boss.getHitbox().getHeight(),
                                boss.getX(), boss.getY() + (int) boss.getHitbox().getHeight() + 120, environnement));
                        for (int i=0; i <= 12; i++) {
                            for (int j = 0; j <= 4; j++) {
                                ajouterCasesAttaquees (new Case (Math.round(boss.getX()/ 16)+1+j, (int) Math.round((boss.getY()+boss.getHitbox().getHeight())/ 16)+i));
                            }
                        }
                    } else {
                        environnement.ajouterProjectile(new BouleDeFeu(boss.getX(), boss.getY() - 80,
                                boss.getX(), boss.getY() - 200, environnement));
                        for (int i=0; i <= 12; i++) {
                            for (int j = 0; j <= 4; j++) {
                                ajouterCasesAttaquees (new Case (Math.round(boss.getX()/ 16)+1+j, Math.round(boss.getY() / 16)-i));
                            }
                        }
                    }
                    mettreAJourCasesAttaqueesProperty();
                })
        );
        lancerBouleDeFeu.play();
    }

}
