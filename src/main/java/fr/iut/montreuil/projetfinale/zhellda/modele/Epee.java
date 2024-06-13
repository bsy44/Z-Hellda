package fr.iut.montreuil.projetfinale.zhellda.modele;

import javafx.scene.image.Image;

import static java.lang.Math.sqrt;

public class Epee extends Arme{

    public Epee(Environnement environnement, int x, int y){
        super(x, y, "épée", environnement,2,60);
    }

    @Override
    public void attaquer(Joueur j, int x, int y) {
        System.out.println("attaque Epee");
        boolean ennemieTouche = false;
        for (int i = 0; i < getEnvironnement().getObsEnnemis().size() && ennemieTouche==false; i++) {
            Ennemis ennemie = getEnvironnement().getObsEnnemis().get(i);
            if (ennemie.getType()==0){
                if (j.getX()==x) {
                    if ((sqrt(Math.pow(ennemie.getX()- j.getX(),2)))<=6 &&((ennemie.getY() >= j.getY() && ennemie.getY() <= y) || ((ennemie.getY() <= j.getY() && ennemie.getY() >= y)))) {
                        ennemie.subirDegats(getAttaque());
                        this.getEnvironnement().ennemiMort();
                        ennemieTouche = true;
                    }
                }
                else {
                    if ((sqrt(Math.pow(ennemie.getY() - j.getY(), 2))) <= 6 && (ennemie.getX() >= j.getX() && ennemie.getX() <= x) || ((ennemie.getX() <= j.getX() && ennemie.getX() >= x))) {
                        ennemie.subirDegats(getAttaque());
                        this.getEnvironnement().ennemiMort();
                        ennemieTouche = true;
                    }
                }
            }
        }
    }
}
