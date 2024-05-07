package fr.iut.montreuil.projetfinale.zhellda.modele;

public class Environnement {
    private final int width;

    private final int height;
    private ObsJoueur obsJoueur;
    private Terrain terrain;

    private Joueur j;

    public Environnement(int width, int height) {
        this.width = width;
        this.height = height;
        this.terrain= new Terrain();
        this.j = new Joueur();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public Joueur getJ() {
        return j;
    }
}
