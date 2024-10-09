package fr.iut.montreuil.projetfinale.zhellda.modele.personnage;

import fr.iut.montreuil.projetfinale.zhellda.modele.Environnement;
import fr.iut.montreuil.projetfinale.zhellda.modele.projectile.BouleDeFeu;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class AttaqueFireBall implements AttaqueEnnemis{
    @Override
    public void attaqer(Environnement environnement, Ennemis ennemis) {
        //nouvelleDirection();
        Timeline lancerBouleDeFeu = new Timeline(
                new KeyFrame(Duration.seconds(1), e -> {
                    if (this.direction(ennemis).equals("droite")) {
                        environnement.ajouterProjectile(new BouleDeFeu(ennemis.getX() + (int) ennemis.getHitbox().getWidth(), ennemis.getY(),
                                ennemis.getX() + (int) ennemis.getHitbox().getWidth() + 120, ennemis.getY(), environnement));
                    } else if (direction(ennemis).equals("gauche")) {
                        environnement.ajouterProjectile(new BouleDeFeu(ennemis.getX() - 80, ennemis.getY(),
                                ennemis.getX() - 200, ennemis.getY(), environnement));
                    } else if (direction(ennemis).equals("bas")) {
                        environnement.ajouterProjectile(new BouleDeFeu(ennemis.getX(), ennemis.getY() + (int) ennemis.getHitbox().getHeight(),
                                ennemis.getX(), ennemis.getY() + (int) ennemis.getHitbox().getHeight() + 120, environnement));
                    } else {
                        environnement.ajouterProjectile(new BouleDeFeu(ennemis.getX(), ennemis.getY() - 80,
                                ennemis.getX(), ennemis.getY() - 200, environnement));
                    }

                })
        );
        lancerBouleDeFeu.play();
    }

}
