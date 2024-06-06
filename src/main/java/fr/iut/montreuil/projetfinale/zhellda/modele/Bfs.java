package fr.iut.montreuil.projetfinale.zhellda.modele;

import java.util.*;
public class Bfs {
    private Case source;
    private Map<Case, Case> predecesseur;
    private boolean[][] visite = new boolean[100][100];

    public Bfs (){
        source = new Case(Math.round(Environnement.getJ().getX() /16), Math.round(Environnement.getJ().getY() /16));
        predecesseur = new HashMap<Case, Case>();
        visite = tabFasle();
        algoBfs();
    }

    private void algoBfs() {
        System.out.println("debut algo bfs");
        LinkedList fifo = new LinkedList<Case>();
        fifo.addFirst(source);
        this.predecesseur.put(source, null);
        Case c1;
        System.out.println("source :" + source);
            while (!fifo.isEmpty()) {
                System.out.println("while");
                c1 = (Case) fifo.pollFirst();
                System.out.println(c1);
                for (Case c : c1.adjacents()) {
                    System.out.println(c);
                    if (!visite[c.getX()][c.getY()]) {
                        visite[c.getX()][c.getY()] = true;
                        if (!Environnement.getTerrain().obstacle(c.getX(), c.getY())) {
                            predecesseur.put(c, c1);
                            fifo.addLast(c);
                        }
                    }
                }
            }
    }

    public ArrayList<Case> cheminVersSource(int x, int y){
        x = Math.round(x /16);
        y = Math.round(y /16);
        ArrayList<Case> chemin = new ArrayList<>();
        Case c = predecesseur.get(new Case(x, y));
        if (c != null) {
            chemin.add(c);
            while (c != source) {
                c = predecesseur.get(c);
                if (c != source)
                    chemin.add(c);
            }
        }
        return chemin;
    }

    public Map<Case, Case> getPredecesseur() {
        return predecesseur;
    }

    private boolean[][] tabFasle (){
        boolean[][] tab = new boolean[100][100];
        for (int i=0; i<100; i++) {
            for (int y = 0; y < 100; y++) {
                tab[i][y]=false;
            }
        }
        return tab;
    }

}
