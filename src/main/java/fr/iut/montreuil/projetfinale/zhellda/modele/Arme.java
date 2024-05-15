package fr.iut.montreuil.projetfinale.zhellda.modele;

public abstract class Arme {
    private int portee;
    private int attaque;
    protected Environnement environnement;

    public Arme (int attaque, int portee){
        this.attaque=attaque;
        this.portee=portee;
    }


    public Ennemis attaquer (){
        Joueur j = environnement.getObsJoueur().get(0);
        for (int i = 0; i < environnement.getObsEnnemis().size();i++) {
            Ennemis ennemie = environnement.getObsEnnemis().get(i);

            double distance = Math.sqrt(Math.pow(ennemie.getXProperty().get()- j.getXProperty().get(),2)+Math.pow(ennemie.getYProperty().get() - j.getYProperty().get(),2));
            if (distance <= this.portee && distance >= 0) {
                ennemie.degat(this.attaque);
                return ennemie;
            }
        }
        return null;

    }


    public int getPortee (){
        return this.portee;
    }

    public int getAttaque() {
        return attaque;
    }
}
