package fr.iut.montreuil.projetfinale.zhellda.modele;

public class Joueur extends Acteur {
    private Arme arme;

    public Joueur(Environnement environnement){
       super(10,10, 10,"joueur", 25, 25);
       this.arme = new Epee(environnement);
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
                colisionEnv(haut, bas, droite, gauche)) {
            // Enregistrer les positions actuelles
            int oldX = getX();
            int oldY = getY();

            // Mettre à jour les positions du joueur
            this.setX(posX);
            this.setY(posY);

            // Vérifier la collision avec les ennemis
            if (colisionEnnemis()) {
                // Revenir aux positions précédentes en cas de collision
                this.setX(oldX);
                this.setY(oldY);
            }
        }
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

            boolean collisionX = joueurX < ennemiX + ennemiWidth && joueurX + joueurWidth > ennemiX;
            boolean collisionY = joueurY < ennemiY + ennemiHeight && joueurY + joueurHeight > ennemiY;

            if (collisionX && collisionY) {
                return true;
            }
        }
        return false;
    }
}
