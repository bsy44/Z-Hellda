package fr.iut.montreuil.projetfinale.zhellda.modele;

public abstract class Arme extends Item{
    private int portee;
    private int attaque;
    private Environnement env;
    private int indexInventaire;

    public Arme (int x, int y, String nom, Environnement env, int attaque, int portee){
        super(x, y, nom, "arme");
        this.attaque = attaque;
        this.portee = portee;
        this.env = env;
        this.indexInventaire = -1;
    }

    public Environnement getEnvironnement() {
        return env;
    }

    public abstract void attaquer(Joueur j, int x, int y);

    public int getPortee (){
        return this.portee;
    }

    public int getAttaque() {
        return attaque;
    }

    public int getIndexInventaire() {
        return indexInventaire;
    }

    public void setIndexInventaire(int indexInventaire) {
        this.indexInventaire = indexInventaire;
    }

}
