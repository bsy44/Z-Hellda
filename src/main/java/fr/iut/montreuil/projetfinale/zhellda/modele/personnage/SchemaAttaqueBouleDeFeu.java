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
    public void attaquer(Environnement environnement, Ennemi ennemi) {

        Timeline lancerBouleDeFeu = new Timeline(
                new KeyFrame(Duration.seconds(1), e -> {
                    if (direction(ennemi).equals("droite")) {
                        environnement.ajouterProjectile(new BouleDeFeu(ennemi.getX() + (int) ennemi.getHitbox().getWidth(), ennemi.getY(),
                                ennemi.getX() + (int) ennemi.getHitbox().getWidth() + 120, ennemi.getY(), environnement));
                        for (int i=0; i <= 12; i++) {
                            for (int j = 0; j <= 4; j++) {
                                ajouterCasesAttaquees(new Case((int) Math.round((ennemi.getX() + (ennemi.getHitbox().getWidth())) / 16) + i, Math.round(ennemi.getY() / 16) + 1 + j));
                            }
                        }
                    } else if (direction(ennemi).equals("gauche")) {
                        environnement.ajouterProjectile(new BouleDeFeu(ennemi.getX() - 80, ennemi.getY(),
                                ennemi.getX() - 200, ennemi.getY(), environnement));
                        for (int i=0; i <= 12; i++) {
                            for (int j = 0; j <= 4; j++) {
                                ajouterCasesAttaquees (new Case ((int) Math.round(ennemi.getX()/ 16) - i, Math.round(ennemi.getY() / 16) + 1 + j));
                            }
                        }
                    } else if (direction(ennemi).equals("bas")) {
                        environnement.ajouterProjectile(new BouleDeFeu(ennemi.getX(), ennemi.getY() + (int) ennemi.getHitbox().getHeight(),
                                ennemi.getX(), ennemi.getY() + (int) ennemi.getHitbox().getHeight() + 120, environnement));
                        for (int i=0; i <= 12; i++) {
                            for (int j = 0; j <= 4; j++) {
                                ajouterCasesAttaquees (new Case (Math.round(ennemi.getX()/ 16)+1+j, (int) Math.round((ennemi.getY()+ennemi.getHitbox().getHeight())/ 16)+i));
                            }
                        }
                    } else {
                        environnement.ajouterProjectile(new BouleDeFeu(ennemi.getX(), ennemi.getY() - 80,
                                ennemi.getX(), ennemi.getY() - 200, environnement));
                        for (int i=0; i <= 12; i++) {
                            for (int j = 0; j <= 4; j++) {
                                ajouterCasesAttaquees (new Case (Math.round(ennemi.getX()/ 16)+1+j, Math.round(ennemi.getY() / 16)-i));
                            }
                        }
                    }
                    mettreAJourCasesAttaqueesProperty();
                })
        );
        lancerBouleDeFeu.play();
    }

}
