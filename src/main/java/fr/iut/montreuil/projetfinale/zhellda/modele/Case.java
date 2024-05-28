package fr.iut.montreuil.projetfinale.zhellda.modele;

import java.util.ArrayList;

public class Case {

    private int x, y;

    public Case (int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean dansTerrain (){
        return (0 <= x && x <= 29 && 0 <= y && y <= 19);
    }

    public ArrayList<Case> adjacents (){
        ArrayList<Case> adj = new ArrayList<>();
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        Case c;

        for (int i=0; i<4; i++){
            c = new Case(x+dx[i], y+dy[i]);
            if (c.dansTerrain()) adj.add(c);
        }
        return adj;
    }

    @Override
    public String toString() {
        return "Case{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
