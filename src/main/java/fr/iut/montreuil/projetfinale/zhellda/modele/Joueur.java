package fr.iut.montreuil.projetfinale.zhellda.modele;


public class Joueur extends Acteur {
    private Arme arme;


    public Joueur(Environnement environnement){
       super(10,10, 10,"joueur",22,25, environnement);
       this.arme=new Arc(environnement);
    }

    public Arme getArme() {
        return arme;
    }


    public void deplacement(int x, int y) {

        int hitboxWidth = (int) getHitbox().getWidth();
        int hitboxHeight = (int) getHitbox().getHeight();

        int posX = getX() + x;
        int posY = getY() + y;

        int gauche = posX / 30;
        int droite = (posX + hitboxWidth) / 30;
        int haut = posY / 30;
        int bas = (posY + hitboxHeight) / 30;

        if (Environnement.getTerrain().dansTerrain(gauche, haut) &&
                Environnement.getTerrain().dansTerrain(droite, haut) &&
                Environnement.getTerrain().dansTerrain(gauche, bas) &&
                Environnement.getTerrain().dansTerrain(droite, bas) &&
                (colisionEnv(haut, bas, droite, gauche))){
            this.setX(posX);
            this.setY(posY);
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
