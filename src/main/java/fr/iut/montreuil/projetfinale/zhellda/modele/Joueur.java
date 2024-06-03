package fr.iut.montreuil.projetfinale.zhellda.modele;


import javafx.beans.property.IntegerProperty;

public class Joueur extends Acteur {
    private Arme arme;


    public Joueur(Environnement environnement){
       super(282,10, 10,"joueur",30,30, environnement);
       this.arme=new Arc(environnement);
    }

    public Arme getArme() {
        return arme;
    }


    public void deplacement(int x, int y) {
        int gauche = (getX() + x) / 16; //représente le point à en haut à gauche de la Hitnox
        int droite = ((getX() + x + (int)getHitbox().getWidth()) / 16); //représente le point en haut à droite de la Hitbox
        int haut = (getY() + y) / 16; //représente le point à en haut à gauche de la Hitnox
        int bas =  ((getY() + y + (int)getHitbox().getHeight()) / 16); //représente le point à en bas à gauche de la Hitnox

        int oldX = this.getX();
        int oldY = this.getY();

        if (Environnement.getTerrain().dansTerrain(gauche, haut) &&
                Environnement.getTerrain().dansTerrain(droite, haut) &&
                Environnement.getTerrain().dansTerrain(gauche, bas) &&
                Environnement.getTerrain().dansTerrain(droite, bas) &&
                colisionEnv(haut, bas, droite, gauche)) {

            this.setX(getX() + x);
            this.setY(getY() + y);

            if (colisionEnnemis()) {
                this.setX(oldX);
                this.setY(oldY);
            }
        }
    }

    public boolean colisionEnv(int haut, int bas, int droite, int gauche){
        return  !Environnement.getTerrain().obstacle(gauche, haut) &&
                !Environnement.getTerrain().obstacle(droite, haut) &&
                !Environnement.getTerrain().obstacle(gauche, bas) &&
                !Environnement.getTerrain().obstacle(droite, bas);
    }

    public boolean colisionEnnemis() {
        int cpt=0;
        int joueurX = (int) this.getHitbox().getX();
        int joueurY = (int) this.getHitbox().getY();
        int joueurWidth = (int) this.getHitbox().getWidth();
        int joueurHeight = (int) this.getHitbox().getHeight();

        for (Ennemis ennemi : Environnement.getObsEnnemis()) {
            System.out.println(ennemi.getId());
            int ennemiX = (int) ennemi.getHitbox().getX();
            int ennemiY = (int) ennemi.getHitbox().getY();
            int ennemiWidth = (int) ennemi.getHitbox().getWidth();
            int ennemiHeight = (int) ennemi.getHitbox().getHeight();

            if ( joueurX < ennemiX + ennemiWidth && joueurX + joueurWidth > ennemiX && joueurY < ennemiY + ennemiHeight && joueurY + joueurHeight > ennemiY){
                cpt++;
            }
        }
        System.out.println(cpt);
        System.out.println(Environnement.getObsEnnemis().size());
        return (cpt!=0);
    }

    @Override
    public IntegerProperty getVie() {
        return super.getVie();
    }
    public int getVieMax() {
        return 10;
    }
}
