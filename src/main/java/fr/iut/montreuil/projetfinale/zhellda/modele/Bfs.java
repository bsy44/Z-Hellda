package fr.iut.montreuil.projetfinale.zhellda.modele;

import java.util.*;
public class Bfs {
    private int [][] terrain;
    private Case source;
    private boolean[][] parcours;
    private Map<Case, Case> predecesseur;

    private ArrayList<Case> chemin;

    public Bfs (int x, int y){
        this.terrain = Environnement.getTerrain().getTerrain();
        source = new Case(x, y);
        parcours = tabFalse();
        predecesseur = new HashMap<Case, Case>();
        chemin = cheminVersSource();
//        lastChance();
    }

    private void algoBFS () {
        LinkedList fifo = new LinkedList<Case>();
        fifo.addFirst(source);
        this.predecesseur.put(source, null);
        this.parcours[source.getX()][source.getY()] = true;
        Case c1;

        while(!fifo.isEmpty()){
            c1 = (Case) fifo.pollFirst();
            System.out.println("Poll : x:"+c1.getX() + ", y:"+c1.getY());
            for (Case c : c1.adjacents()){
                System.out.println("c2 : x:" + c.getX() + ", y:" + c.getY());
                if (!parcours[c.getX()][c.getY()]) {
                    parcours[c.getX()][c.getY()] = true;
                    System.out.println("parcours");
                    predecesseur.put(c, c1);
                    System.out.println(predecesseur.get(c));
                    fifo.addLast(c);
                }
            }
        }
    }

    public ArrayList<Case> cheminVersSource(){
        ArrayList<Case> chemin = new ArrayList<>();
        Case c = lastChance();
        System.out.println("fin algo bfs");
        System.out.println(c);
        while (c != source){
            System.out.println("tant que");
            System.out.println(predecesseur.get(c));
            c = predecesseur.get(c);
            chemin.add(0, c);
        }
        System.out.println("return chemin :");
        System.out.println(chemin);
        return chemin;
    }

    private Case lastChance () {
        LinkedList fifo = new LinkedList<Case>();
        fifo.addFirst(source);
        this.predecesseur.put(source, null);
        this.parcours[source.getX()][source.getY()] = true;
        Case c1;
        Case posJ = new Case((int) Math.round(Environnement.getJ().getX()/30),(int) Math.round(Environnement.getJ().getY()/30));
        System.out.println(posJ);


        while(!fifo.isEmpty()){
            c1 = (Case) fifo.pollFirst();
            System.out.println("Poll : x:"+c1.getX() + ", y:"+c1.getY());
            for (Case c : c1.adjacents()){
                System.out.println("c2 : x:" + c.getX() + ", y:" + c.getY());
                if (!parcours[c.getX()][c.getY()]) {
                    parcours[c.getX()][c.getY()] = true;
                    System.out.println("parcours");
                    if (!Environnement.getTerrain().obstacle(c.getX(), c.getY())) {
                        predecesseur.put(c, c1);
                        System.out.println(predecesseur.get(c));
                        fifo.addLast(c);
                        if (c.getX() == posJ.getX() && c.getY() == posJ.getY()) {
                            System.out.println(c);
                            return c;
                        }
                    }
                }
            }
        }
        return null;
    }

    public ArrayList<Case> getChemin() {
        return chemin;
    }

    private boolean[][] tabFalse () {
        boolean[][] tab = new boolean[30][20];
        for (int x=0; x<30; x++)
            for (int y=0; y<20; y++)
                tab[x][y] = false;

        return tab;
    }


}
