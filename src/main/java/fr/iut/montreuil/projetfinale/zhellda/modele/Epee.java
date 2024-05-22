package fr.iut.montreuil.projetfinale.zhellda.modele;

public class Epee extends Arme{
    public Epee(Environnement environnement){
        super(environnement,2,10);
    }


    @Override
    public void attaquer(Joueur j) {
        boolean ennemieTouche = false;
        for (int i = 0; i < getEnvironnement().getObsEnnemis().size() && ennemieTouche==false; i++) {
            Ennemis ennemie = getEnvironnement().getObsEnnemis().get(i);

            double distance = Math.sqrt(Math.pow(ennemie.getXProperty().get() - j.getXProperty().get(), 2) + Math.pow(ennemie.getYProperty().get() - j.getYProperty().get(), 2));
            if (distance <= getPortee() && distance >= 0) {
                ennemie.subirDegats(getAttaque());
                this.getEnvironnement().ennemiMort();
                ennemieTouche=true;
            }
        }
    }
}
