package fr.iut.montreuil.projetfinale.zhellda.modele.personnage;

import fr.iut.montreuil.projetfinale.zhellda.modele.Case;
import fr.iut.montreuil.projetfinale.zhellda.modele.Environnement;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

import java.util.ArrayList;

public interface AttaqueEnnemis {
    default String direction(Ennemis ennemis){

        double yBas = Environnement.getJ().getY() - (ennemis.getY() + ennemis.getHitbox().getHeight());
        double yHaut = ennemis.getY() - (Environnement.getJ().getY() + Environnement.getJ().getHitbox().getHeight());
        double xDroite = Environnement.getJ().getX() - (ennemis.getX() + ennemis.getHitbox().getWidth());
        double xGauche = ennemis.getX() - (Environnement.getJ().getX() + Environnement.getJ().getHitbox().getWidth());

        String direciton = "bas";
        double max = yBas;

        if (yHaut > max) {
            max = yHaut;
            direciton = "haut";
        }
        if (xDroite > max) {
            max = xDroite;
            direciton = "droite";
        }
        if (xGauche > max) {
            direciton = "gauche";
        }

        return direciton;
    }

    default void verfificationZone(ArrayList<Case> casesAttaquees, Ennemis ennemis){
        int taille = (int) Math.round(Environnement.getJ().getHitbox().getHeight()/16);
        Timeline attaque = new Timeline(
                new KeyFrame(Duration.seconds(1), e -> {
                    boolean degatSubis = false;
                    ArrayList<Case> caseJ = new ArrayList<>();
                    caseJ.add(new Case(Math.round(Environnement.getJ().getX()/16), Math.round(Environnement.getJ().getY()/16)));
                    caseJ.add(new Case(Math.round(Environnement.getJ().getX()/16), Math.round(Environnement.getJ().getY()/16)+taille));
                    caseJ.add(new Case(Math.round(Environnement.getJ().getX()/16)+taille, Math.round(Environnement.getJ().getY()/16)));
                    caseJ.add(new Case(Math.round(Environnement.getJ().getX()/16)+taille, Math.round(Environnement.getJ().getY()/16)+taille));
                    for (Case c : caseJ)
                        if (!degatSubis && casesAttaquees.contains(c)) {
                            Environnement.getJ().subirDegats(ennemis.getAttaque());
                            degatSubis = true;
                        }
                })
        );
        attaque.play();
    }
    void attaqer(Environnement environnement, Ennemis ennemis);
}
