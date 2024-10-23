package fr.iut.montreuil.projetfinale.zhellda.modele.item;

import fr.iut.montreuil.projetfinale.zhellda.modele.Environnement;
import fr.iut.montreuil.projetfinale.zhellda.modele.personnage.Ennemi;
import fr.iut.montreuil.projetfinale.zhellda.modele.personnage.Joueur;

import static java.lang.Math.sqrt;

public class Epee extends Arme{

    public Epee(int x, int y){
        super(x, y, "épée",2,60);
    }

    @Override
    public void attaquer(Joueur j, int x, int y) {
        System.out.println("attaque Epee");
        boolean ennemieTouche = false;
        for (int i = 0; i < Environnement.getUniqueInstance().getListEnnemis().size() && ennemieTouche==false; i++) {
            Ennemi ennemie = Environnement.getUniqueInstance().getListEnnemis().get(i);
            if (!ennemie.getAerien()){
                if (j.getX()==x) {
                    if ((sqrt(Math.pow(ennemie.getX()- j.getX(),2)))<=6 &&((ennemie.getY() >= j.getY() && ennemie.getY() <= y) || ((ennemie.getY() <= j.getY() && ennemie.getY() >= y)))) {
                        ennemie.subirDegats(getAttaque());
                        ennemie.meurt();
                        ennemieTouche = true;
                    }
                }
                else {
                    if ((sqrt(Math.pow(ennemie.getY() - j.getY(), 2))) <= 6 && (ennemie.getX() >= j.getX() && ennemie.getX() <= x) || ((ennemie.getX() <= j.getX() && ennemie.getX() >= x))) {
                        ennemie.subirDegats(getAttaque());
                        ennemie.meurt();
                        ennemieTouche = true;
                    }
                }
            }
        }
    }
}
