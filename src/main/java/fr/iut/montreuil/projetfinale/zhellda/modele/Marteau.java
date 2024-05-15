package fr.iut.montreuil.projetfinale.zhellda.modele;

public class Marteau extends Arme{
    public Marteau() {
        super(20,20);
    }

    public void Attaquer (){
        Joueur j = environnement.getObsJoueur().get(0);
        for (int i = 0; i < environnement.getObsEnnemis().size();i++) {
            Ennemis ennemie = environnement.getObsEnnemis().get(i);

            double distance = Math.sqrt(Math.pow(ennemie.getXProperty().get()- j.getXProperty().get(),2)+Math.pow(ennemie.getYProperty().get() - j.getYProperty().get(),2));
            if (distance <= this.getPortee() && distance >= 0) {
                ennemie.degat(this.getAttaque());
            }
        }
    }
}
