package fr.iut.montreuil.projetfinale.zhellda.modele;

public abstract class Ennemis extends Acteur {
    private static int compteur = 1;
    private int vitesse;
    private int attaque;
    private int portee;
    private int type;//0 pour sol et 1 pour aérien

    public Ennemis(int x, int y, int vie, int vitesse, int attaque, int portee, int HitBoxW, int HitBoxH,int type, Environnement environnement){
        super(x, y, vie,vitesse,"#"+compteur, HitBoxW, HitBoxH, environnement);
        compteur++;
        this.attaque = attaque;
        this.portee=portee;
        this.type=type;
    }

    public int getPortee() {
        return portee;
    }

    public int getType() {
        return type;
    }

    public int getVitesse() {
        return vitesse;
    }

    public int getAttaque() {
        return attaque;
    }

    public abstract void attaquer();


    public abstract int getPvMax();

}
