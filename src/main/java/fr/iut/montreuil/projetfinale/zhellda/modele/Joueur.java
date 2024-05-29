package fr.iut.montreuil.projetfinale.zhellda.modele;


import javafx.beans.property.IntegerProperty;

public class Joueur extends Acteur {
    private boolean []directions; //haut, gauche, bas, droite
    private Arme arme;
    public Joueur(Environnement environnement){
       super(10,10, 10,"joueur",30,30, environnement);
       this.arme=new Arc(environnement);
       this.directions= new boolean[]{false, false, false, false};
    }

    public boolean getDirections(int i) {
        return directions[i];
    }

    public Arme getArme() {
        return arme;
    }

    public void setDirections(int i, boolean d) {
        for (int j = 0; j < this.directions.length; j++) {
            this.directions[j]=false;
        }
        directions[i]=true;
    }



    public void seDeplacer() {
        int deltaX = 0;
        int deltaY = 0;
        int oldX = this.getX();
        int oldY = this.getY();

        if (this.directions[0]) {
            deltaY = -3;
        } else if (this.directions[1]) {
            deltaX = -3;
        } else if (this.directions[2]) {
            deltaY = 3;
        } else if (this.directions[3]) {
            deltaX = 3;
        }

        int newX = this.getX() + deltaX;
        int newY = this.getY() + deltaY;

        int gauche = (newX + 3) / 30;
        int droite = (newX + 3 + (int) getHitbox().getWidth()) / 30;
        int haut = (newY + 3) / 30;
        int bas = ((newY + 3 + (int) getHitbox().getHeight()) / 30);

        if (colisionEnv(haut, bas, droite, gauche)) {
            this.setX(newX);
            this.setY(newY);
        }
        if (colisionEnnemis()){
            this.setX(oldX);
            this.setY(oldY);
        }

        for (int i = 0; i < this.directions.length; i++) {
            this.directions[i] = false;
        }
    }

    public boolean colisionEnv(int haut, int bas, int droite, int gauche){
        if (haut >= 0 && bas < Environnement.getTerrain().getTerrain().length &&
                gauche >= 0 && droite < Environnement.getTerrain().getTerrain()[0].length) {
            return  !Environnement.getTerrain().obstacle(gauche, haut) &&
                    !Environnement.getTerrain().obstacle(droite, haut) &&
                    !Environnement.getTerrain().obstacle(gauche, bas) &&
                    !Environnement.getTerrain().obstacle(droite, bas);
        }
        else {
            return false;
        }
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
