package fr.iut.montreuil.projetfinale.zhellda.modele.personnage;

import fr.iut.montreuil.projetfinale.zhellda.modele.Case;
import fr.iut.montreuil.projetfinale.zhellda.modele.Environnement;

public class SchemaAttaqueAttaqueDeZone extends SchemaAttaqueBoss {

    public void faireAttaque (Environnement environnement, Boss boss, String direction) {
            for (int i = -1; i < 8; i++) {
                getCasesAttaquees().add(new Case(Math.round(boss.getX() / 16)+7, Math.round(boss.getY() / 16)+i));
                getCasesAttaquees().add(new Case(Math.round(boss.getX() / 16)-1, Math.round(boss.getY() / 16)+i));
                getCasesAttaquees().add(new Case(Math.round(boss.getX() / 16)+i, Math.round(boss.getY() / 16)+7));
                getCasesAttaquees().add(new Case(Math.round(boss.getX() / 16)+i, Math.round(boss.getY() / 16)-1));
                if (i > -1 && i < 7 ){
                    getCasesAttaquees().add(new Case(Math.round(boss.getX() / 16)+8, Math.round(boss.getY() / 16)+i));
                    getCasesAttaquees().add(new Case(Math.round(boss.getX() / 16)-2, Math.round(boss.getY() / 16)+i));
                    getCasesAttaquees().add(new Case(Math.round(boss.getX() / 16)+i, Math.round(boss.getY() / 16)+8));
                    getCasesAttaquees().add(new Case(Math.round(boss.getX() / 16)+i, Math.round(boss.getY() / 16)-2));
                    if (i > 1 && i < 5){
                        getCasesAttaquees().add(new Case(Math.round(boss.getX() / 16)-3, Math.round(boss.getY() / 16)+i));
                        getCasesAttaquees().add(new Case(Math.round(boss.getX() / 16)+i, Math.round(boss.getY() / 16)+9));
                        getCasesAttaquees().add(new Case(Math.round(boss.getX() / 16)+i, Math.round(boss.getY() / 16)-3));
                    }
                }
            }
        }

}
