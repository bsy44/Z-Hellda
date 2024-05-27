package fr.iut.montreuil.projetfinale.zhellda.modele;

public class Epee extends Arme{
    public Epee(Environnement environnement){
        super(environnement,2,30);
    }


    @Override
    public void attaquer(Joueur j, int x, int y) {
        boolean ennemieTouche = false;
        for (int i = 0; i < getEnvironnement().getObsEnnemis().size() && ennemieTouche==false; i++) {
            Ennemis ennemie = getEnvironnement().getObsEnnemis().get(i);

            System.out.println(x + " j : "+ j.getX());

            if (j.getX()==x) {
                System.out.println("x=x");
                if ((ennemie.getY() >= j.getY() && ennemie.getY() <= y) || ((ennemie.getY() <= j.getY() && ennemie.getY() >= y))) {
                    ennemie.subirDegats(getAttaque());
                    this.getEnvironnement().ennemiMort();
                    ennemieTouche = true;
                }
            }
            else {
                if ((ennemie.getX() >= j.getX() && ennemie.getX() <= x) || ((ennemie.getX() <= j.getX() && ennemie.getX() >= x))) {
                    System.out.println("dzdz");
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
