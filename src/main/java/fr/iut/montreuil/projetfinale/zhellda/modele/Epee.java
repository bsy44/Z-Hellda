package fr.iut.montreuil.projetfinale.zhellda.modele;

import static java.lang.Math.sqrt;

public class Epee extends Arme{
    public Epee(Environnement environnement){
        super(environnement,2,30);
    }


    @Override
    public void attaquer(Joueur j, int x, int y) {
        boolean ennemieTouche = false;
        for (int i = 0; i < getEnvironnement().getObsEnnemis().size() && ennemieTouche==false; i++) {
            Ennemis ennemie = getEnvironnement().getObsEnnemis().get(i);


            if (j.getX()==x) {
                if ((sqrt(Math.pow(ennemie.getX()- j.getX(),2)))<=6 &&((ennemie.getY() >= j.getY() && ennemie.getY() <= y) || ((ennemie.getY() <= j.getY() && ennemie.getY() >= y)))) {
                    ennemie.subirDegats(getAttaque());
                    this.getEnvironnement().ennemiMort();
                    ennemieTouche = true;
                }
            }
            else {
                if ((sqrt(Math.pow(ennemie.getY()- j.getY(),2)))<=6 && (ennemie.getX() >= j.getX() && ennemie.getX() <= x) || ((ennemie.getX() <= j.getX() && ennemie.getX() >= x))) {
                    ennemie.subirDegats(getAttaque());
                    this.getEnvironnement().ennemiMort();
                    ennemieTouche = true;
                }
            }



//            double distance = Math.sqrt(Math.pow(ennemie.getXProperty().get() - j.getXProperty().get(), 2) + Math.pow(ennemie.getYProperty().get() - j.getYProperty().get(), 2));
//            if (distance <= getPortee() && distance >= 0) {
//                ennemie.subirDegats(getAttaque());
//                this.getEnvironnement().ennemiMort();
//                ennemieTouche=true;
        }
    }
}
