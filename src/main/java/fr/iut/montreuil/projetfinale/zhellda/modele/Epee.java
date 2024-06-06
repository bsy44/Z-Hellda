package fr.iut.montreuil.projetfinale.zhellda.modele;

import javafx.scene.image.Image;

import static java.lang.Math.sqrt;

public class Epee extends Arme{
    private Image image;
    public Epee(Environnement environnement){
        super(environnement,2,40);
        this.image=new Image(getClass().getResource("/fr/iut/montreuil/projetfinale/zhellda/bouleDeFeu.png").toExternalForm());
    }


    @Override
    public void attaquer(Joueur j, int x, int y) {
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



//            double distance = Math.sqrt(Math.pow(ennemie.getXProperty().get() - j.getXProperty().get(), 2) + Math.pow(ennemie.getYProperty().get() - j.getYProperty().get(), 2));
//            if (distance <= getPortee() && distance >= 0) {
//                ennemie.subirDegats(getAttaque());
//                this.getEnvironnement().ennemiMort();
//                ennemieTouche=true;
        }
    }
    public Image getImage() {
        return image;
    }
}
