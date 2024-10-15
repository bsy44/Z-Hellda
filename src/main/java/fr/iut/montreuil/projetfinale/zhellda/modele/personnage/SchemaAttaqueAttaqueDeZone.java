package fr.iut.montreuil.projetfinale.zhellda.modele.personnage;

import fr.iut.montreuil.projetfinale.zhellda.modele.Environnement;

public class SchemaAttaqueAttaqueDeZone extends SchemaAttaqueBoss {
    @Override
    public void attaquer(Environnement environnement, Ennemi ennemi) {

    }

//    public void attaquer(Environnement environnement, Ennemis ennemis) {
//            ArrayList<Case> casesAttaquees = new ArrayList<>();
//
//            for (int i = -1; i < 8; i++) {
//                casesAttaquees.add(new Case(Math.round(ennemis.getX() / 16)+7, Math.round(ennemis.getY() / 16)+i));
//                casesAttaquees.add(new Case(Math.round(ennemis.getX() / 16)-1, Math.round(ennemis.getY() / 16)+i));
//                casesAttaquees.add(new Case(Math.round(ennemis.getX() / 16)+i, Math.round(ennemis.getY() / 16)+7));
//                casesAttaquees.add(new Case(Math.round(ennemis.getX() / 16)+i, Math.round(ennemis.getY() / 16)-1));
//                if (i > -1 && i < 7 ){
//                    casesAttaquees.add(new Case(Math.round(ennemis.getX() / 16)+8, Math.round(ennemis.getY() / 16)+i));
//                    casesAttaquees.add(new Case(Math.round(ennemis.getX() / 16)-2, Math.round(ennemis.getY() / 16)+i));
//                    casesAttaquees.add(new Case(Math.round(ennemis.getX() / 16)+i, Math.round(ennemis.getY() / 16)+8));
//                    casesAttaquees.add(new Case(Math.round(ennemis.getX() / 16)+i, Math.round(ennemis.getY() / 16)-2));
//                    if (i > 1 && i < 5){
//                        casesAttaquees.add(new Case(Math.round(ennemis.getX() / 16)-3, Math.round(ennemis.getY() / 16)+i));
//                        casesAttaquees.add(new Case(Math.round(ennemis.getX() / 16)+i, Math.round(ennemis.getY() / 16)+9));
//                        casesAttaquees.add(new Case(Math.round(ennemis.getX() / 16)+i, Math.round(ennemis.getY() / 16)-3));
//                    }
//                }
//            }
//            verfificationZone(casesAttaquees, ennemis);
//        }

}
