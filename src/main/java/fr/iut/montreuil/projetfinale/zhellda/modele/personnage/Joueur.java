package fr.iut.montreuil.projetfinale.zhellda.modele.personnage;

import fr.iut.montreuil.projetfinale.zhellda.modele.Environnement;
import fr.iut.montreuil.projetfinale.zhellda.modele.arme.Arme;
import fr.iut.montreuil.projetfinale.zhellda.modele.arme.Epee;
import fr.iut.montreuil.projetfinale.zhellda.modele.personnage.Acteur;
import fr.iut.montreuil.projetfinale.zhellda.modele.personnage.Ennemis;

public class Joueur extends Acteur {
    private Arme arme;

    public Joueur(Environnement environnement){
       super(10,10, 10,"joueur", 20, 25, environnement);
       this.arme = new Epee(environnement);
    }

    public Arme getArme() {
        return arme;
    }

    public void deplacement(int x, int y) {
        int gauche = (getX() + x) / 30; //représente le point à en haut à gauche de la Hitnox
        int droite =  ((getX() + x + (int)getHitbox().getWidth()) / 30); //représente le point en haut à droite de la Hitbox
        int haut = (getY() + y) / 30; //représente le point à en haut à gauche de la Hitnox
        int bas =  ((getY() + y + (int)getHitbox().getHeight()) / 30); //représente le point à en bas à gauche de la Hitnox

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
        int joueurX = (int) this.getHitbox().getX();
        int joueurY = (int) this.getHitbox().getY();
        int joueurWidth = (int) this.getHitbox().getWidth();
        int joueurHeight = (int) this.getHitbox().getHeight();

        for (Ennemis ennemi : Environnement.getObsEnnemis()) {
            int ennemiX = (int) ennemi.getHitbox().getX();
            int ennemiY = (int) ennemi.getHitbox().getY();
            int ennemiWidth = (int) ennemi.getHitbox().getWidth();
            int ennemiHeight = (int) ennemi.getHitbox().getHeight();

           return joueurX < ennemiX + ennemiWidth && joueurX + joueurWidth > ennemiX && joueurY < ennemiY + ennemiHeight && joueurY + joueurHeight > ennemiY;
        }
        return false;
    }
}