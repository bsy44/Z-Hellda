package fr.iut.montreuil.projetfinale.zhellda.modele;

import java.util.ArrayList;
import java.util.Objects;

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


    public ArrayList<Case> adjacents (){
        ArrayList<Case> adj = new ArrayList<>();
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        Case c;

        for (int i=0; i<4; i++){
            c = new Case(x+dx[i], y+dy[i]);
            if (Environnement.getTerrain().dansTerrain(c.getX(),c.getY())) adj.add(c);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Case aCase = (Case) o;
        return x == aCase.x && y == aCase.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
