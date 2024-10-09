package fr.iut.montreuil.projetfinale.zhellda.modele.personnage;

import fr.iut.montreuil.projetfinale.zhellda.modele.Case;
import fr.iut.montreuil.projetfinale.zhellda.modele.Environnement;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

import java.util.ArrayList;

public class AttaqueClawAtk implements AttaqueEnnemis{

    @Override
    public void attaqer(Environnement environnement, Ennemis ennemis) {
        ArrayList<Case> casesAttaquees = new ArrayList<>();

        if (this.direction(ennemis).equals("droite")) {
            casesAttaquees.add(new Case(Math.round(ennemis.getX() / 16)+6, Math.round(ennemis.getY() / 16)+7));
            casesAttaquees.add(new Case(Math.round(ennemis.getX() / 16)+6, Math.round(ennemis.getY() / 16)-1));
            for (int i = -1; i <= 7; i++) {
                casesAttaquees.add(new Case(Math.round(ennemis.getX() / 16)+7, Math.round(ennemis.getY() / 16)+i));
                if (i + 1 < 7) {
                    casesAttaquees.add(new Case(Math.round(ennemis.getX() / 16)+8, Math.round(ennemis.getY() / 16) + i + 1));
                }
                if (i + 2 < 6) {
                    casesAttaquees.add(new Case(Math.round(ennemis.getX() / 16)+9, Math.round(ennemis.getY() / 16)+i+2));
                }
            }

        } else if (this.direction(ennemis).equals("gauche")) {
            casesAttaquees.add(new Case(Math.round(ennemis.getX() / 16)+1, Math.round(ennemis.getY() / 16)-1));
            casesAttaquees.add(new Case(Math.round(ennemis.getX() / 16)+1, Math.round(ennemis.getY() / 16)+7));

            for (int i = -1; i <= 7; i++) {
                casesAttaquees.add(new Case(Math.round(ennemis.getX() / 16), Math.round(ennemis.getY() / 16)+i));
                if (i + 1 < 7) {
                    casesAttaquees.add(new Case(Math.round(ennemis.getX() / 16)-1, Math.round(ennemis.getY() / 16)+i+1));
                }
                if (i + 2 < 6) {
                    casesAttaquees.add(new Case(Math.round(ennemis.getX() / 16)-2, Math.round(ennemis.getY() / 16)+i+2));
                }
            }

        } else if (this.direction(ennemis).equals("bas")) {
            casesAttaquees.add(new Case(Math.round(ennemis.getX() / 16) -1, Math.round(ennemis.getY() / 16)+6));
            casesAttaquees.add(new Case(Math.round(ennemis.getX() / 16)+7, Math.round(ennemis.getY() / 16)+6));
            for (int i = -1; i <= 7; i++) {
                casesAttaquees.add(new Case(Math.round(ennemis.getX() / 16)+i, Math.round(ennemis.getY() / 16)+7));
                if (i + 1 < 7) {
                    casesAttaquees.add(new Case(Math.round(ennemis.getX() / 16)+i+1, Math.round(ennemis.getY() / 16)+8));
                }
                if (i + 2 < 6) {
                    casesAttaquees.add(new Case(Math.round(ennemis.getX() / 16)+i+2, Math.round(ennemis.getY() / 16)+9));
                }
            }

        } else {
            casesAttaquees.add(new Case(Math.round(ennemis.getX() / 16) - 1, Math.round(ennemis.getY() / 16) + 1));
            casesAttaquees.add(new Case(Math.round(ennemis.getX() / 16) +7, Math.round(ennemis.getY() / 16) + 1));
            for (int i = -1; i <= 7; i++) {
                casesAttaquees.add(new Case(Math.round(ennemis.getX() / 16) + i, Math.round(ennemis.getY() / 16)));
                if (i + 1 < 7) {
                    casesAttaquees.add(new Case(Math.round(ennemis.getX() / 16) + i + 1, Math.round(ennemis.getY() / 16) - 1));
                }
                if (i + 2 < 6) {
                    casesAttaquees.add(new Case(Math.round(ennemis.getX() / 16) + i + 2, Math.round(ennemis.getY() / 16) - 2));
                }
            }
        }

        this.verfificationZone(casesAttaquees, ennemis);


    }
}
