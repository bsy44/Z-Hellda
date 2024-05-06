package fr.iut.montreuil.projetfinale.zhellda.modele;

public class Terrain {

    private int tab[][];

    public Terrain(){
        this.tab = new int[][]{
                {0,1,0,0,0,0,0,0,1,0},
                {0,1,0,0,0,1,1,1,1,0},
                {0,1,0,0,0,1,0,0,0,0},
                {0,1,0,0,0,1,0,0,0,0},
                {0,1,1,1,1,1,1,1,1,1},
                {0,0,0,0,0,1,0,0,0,0},
                {0,0,0,0,0,1,0,0,0,0},
                {0,0,0,0,0,1,0,0,0,0},
                {0,0,0,0,0,1,0,0,0,0},
                {0,0,0,0,0,1,0,0,0,0}
        };
    }

    public int[][] getTerrain() {
        return tab;
    }
}
