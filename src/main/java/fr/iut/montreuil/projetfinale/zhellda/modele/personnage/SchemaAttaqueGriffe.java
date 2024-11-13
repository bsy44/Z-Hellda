package fr.iut.montreuil.projetfinale.zhellda.modele.personnage;

import fr.iut.montreuil.projetfinale.zhellda.modele.Case;
import fr.iut.montreuil.projetfinale.zhellda.modele.Environnement;

import java.util.ArrayList;

public class SchemaAttaqueGriffe extends SchemaAttaqueBoss{

    public void faireAttaque (Boss boss, String direction) {

        if (direction.equals("droite")) faireAttaqueDroite(boss);

        else if (direction.equals("gauche")) faireAttaqueGauche(boss);

        else if (direction.equals("bas")) faireAttaqueBas(boss);

        else faireAttaqueHaut(boss);
    }

    private void faireAttaqueDroite (Boss boss){
        getCasesAttaquees().add(new Case(Math.round(boss.getX() / 16)+6, Math.round(boss.getY() / 16)+7));
        getCasesAttaquees().add(new Case(Math.round(boss.getX() / 16)+6, Math.round(boss.getY() / 16)-1));
        for (int i = -1; i <= 7; i++) {
            getCasesAttaquees().add(new Case(Math.round(boss.getX() / 16) + 7, Math.round(boss.getY() / 16) + i));
            if (i + 1 < 7) {
                getCasesAttaquees().add(new Case(Math.round(boss.getX() / 16) + 8, Math.round(boss.getY() / 16) + i + 1));
            }
            if (i + 2 < 6) {
                getCasesAttaquees().add(new Case(Math.round(boss.getX() / 16) + 9, Math.round(boss.getY() / 16) + i + 2));
            }
        }
    }

    private void faireAttaqueGauche (Boss boss){
        getCasesAttaquees().add(new Case(Math.round(boss.getX() / 16)+1, Math.round(boss.getY() / 16)-1));
        getCasesAttaquees().add(new Case(Math.round(boss.getX() / 16)+1, Math.round(boss.getY() / 16)+7));

        for (int i = -1; i <= 7; i++) {
            getCasesAttaquees().add(new Case(Math.round(boss.getX() / 16), Math.round(boss.getY() / 16)+i));
            if (i + 1 < 7) {
                getCasesAttaquees().add(new Case(Math.round(boss.getX() / 16)-1, Math.round(boss.getY() / 16)+i+1));
            }
            if (i + 2 < 6) {
                getCasesAttaquees().add(new Case(Math.round(boss.getX() / 16)-2, Math.round(boss.getY() / 16)+i+2));
            }
        }
    }

    private void faireAttaqueBas (Boss boss){
        getCasesAttaquees().add(new Case(Math.round(boss.getX() / 16) -1, Math.round(boss.getY() / 16)+6));
        getCasesAttaquees().add(new Case(Math.round(boss.getX() / 16)+7, Math.round(boss.getY() / 16)+6));
        for (int i = -1; i <= 7; i++) {
            getCasesAttaquees().add(new Case(Math.round(boss.getX() / 16)+i, Math.round(boss.getY() / 16)+7));
            if (i + 1 < 7) {
                getCasesAttaquees().add(new Case(Math.round(boss.getX() / 16)+i+1, Math.round(boss.getY() / 16)+8));
            }
            if (i + 2 < 6) {
                getCasesAttaquees().add(new Case(Math.round(boss.getX() / 16)+i+2, Math.round(boss.getY() / 16)+9));
            }
        }
    }

    private void faireAttaqueHaut (Boss boss){
        getCasesAttaquees().add(new Case(Math.round(boss.getX() / 16) - 1, Math.round(boss.getY() / 16) + 1));
        getCasesAttaquees().add(new Case(Math.round(boss.getX() / 16) +7, Math.round(boss.getY() / 16) + 1));
        for (int i = -1; i <= 7; i++) {
            getCasesAttaquees().add(new Case(Math.round(boss.getX() / 16) + i, Math.round(boss.getY() / 16)));
            if (i + 1 < 7) {
                getCasesAttaquees().add(new Case(Math.round(boss.getX() / 16) + i + 1, Math.round(boss.getY() / 16) - 1));
            }
            if (i + 2 < 6) {
                getCasesAttaquees().add(new Case(Math.round(boss.getX() / 16) + i + 2, Math.round(boss.getY() / 16) - 2));
            }
        }
    }

}
