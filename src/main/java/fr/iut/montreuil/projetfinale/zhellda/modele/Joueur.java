package fr.iut.montreuil.projetfinale.zhellda.modele;


import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Joueur extends Acteur {
    private boolean[] directions; // haut, gauche, bas, droite
    private InventaireArme inventaireArme;
    private int numArmeUtilise;
    private IntegerProperty directionProperty;
    private boolean etatAltere;
    private ObservableList<Arme> inventaire;

    public Joueur(Environnement environnement) {
        super(50, 100, 10, 3, "joueur", 30, 30, environnement);
        this.inventaireArme = new InventaireArme();
        inventaireArme.ajouterArme(new Epee(environnement));
        this.numArmeUtilise = 1;
        this.directions = new boolean[]{false, false, false, false};
        this.directionProperty = new SimpleIntegerProperty(-1);
        this.etatAltere = false;
        this.inventaire = FXCollections.observableArrayList();
    }

    public boolean getDirections(int i) {
        return directions[i];
    }

    public Arme getArme() {
        if (this.inventaireArme.getArmes().size() - 1 > numArmeUtilise)
            return null;
        return this.inventaireArme.getArmes().get(numArmeUtilise - 1);
    }

    public void setNumArmeUtilise(int numArmeUtilise) {
        this.numArmeUtilise = numArmeUtilise;
    }

    public void setDirections(int i) {
        for (int j = 0; j < this.directions.length; j++) {
            this.directions[j] = false;
        }
        directions[i] = true;
        directionProperty.set(i);
    }

    public void setDoubleDirections(int i, int j) {
        for (int z = 0; z < this.directions.length; z++) {
            this.directions[z] = false;
        }
        directions[i] = true;
        directionProperty.set(i);
        directions[j] = true;
        directionProperty.set(j);
    }

    public IntegerProperty directionProperty() {
        return directionProperty;
    }

    public ObservableList<Arme> getInventaire() {
        return inventaire;
    }

    public boolean ramasserArme(Arme arme) {
        if (inventaire.size() < 3) {
            inventaire.add(arme);
            return true;
        } else {
            return false;
        }
    }

    public void seDeplacer() {
        int deltaX = 0;
        int deltaY = 0;
        int oldX = this.getX();
        int oldY = this.getY();

        if (this.directions[0]) deltaY -= this.vitesse; // Haut
        if (this.directions[1]) deltaX -= this.vitesse; // Gauche
        if (this.directions[2]) deltaY += this.vitesse; // Bas
        if (this.directions[3]) deltaX += this.vitesse; // Droite

        int newX = this.getX() + deltaX;
        int newY = this.getY() + deltaY;

        int gauche = (newX + this.vitesse) / 16;
        int droite = (newX + this.vitesse + (int) getHitbox().getWidth()) / 16;
        int haut = (newY + this.vitesse) / 16;
        int bas = ((newY + this.vitesse + (int) getHitbox().getHeight()) / 16);

        if (colisionEnv(haut, bas, droite, gauche)) {
            this.setX(newX);
            this.setY(newY);
        }
        if (colisionEnnemis()) {
            this.setX(oldX);
            this.setY(oldY);
        }

        for (int i = 0; i < this.directions.length; i++) {
            this.directions[i] = false;
        }
    }

    public void resetDeplacement() {
        for (int i = 0; i < this.directions.length; i++) {
            this.directions[i] = false;
        }
    }

    public boolean colisionEnv(int haut, int bas, int droite, int gauche) {
        if (haut >= 0 && bas < Environnement.getTerrain().getTerrain().length &&
                gauche >= 0 && droite < Environnement.getTerrain().getTerrain()[0].length) {
            return !Environnement.getTerrain().obstacle(gauche, haut) &&
                    !Environnement.getTerrain().obstacle(droite, haut) &&
                    !Environnement.getTerrain().obstacle(gauche, bas) &&
                    !Environnement.getTerrain().obstacle(droite, bas);
        }
        else {
            return false;
        }
    }


    public boolean colisionEnnemis() {
        int cpt = 0;
        int joueurX = (int) this.getHitbox().getX();
        int joueurY = (int) this.getHitbox().getY();
        int joueurWidth = (int) this.getHitbox().getWidth();
        int joueurHeight = (int) this.getHitbox().getHeight();

        for (Ennemis ennemi : Environnement.getObsEnnemis()) {

        for (Ennemis ennemi : getEnvironnement().getObsEnnemis()) {
            int ennemiX = (int) ennemi.getHitbox().getX();
            int ennemiY = (int) ennemi.getHitbox().getY();
            int ennemiWidth = (int) ennemi.getHitbox().getWidth();
            int ennemiHeight = (int) ennemi.getHitbox().getHeight();

            if (joueurX < ennemiX + ennemiWidth && joueurX + joueurWidth > ennemiX && joueurY < ennemiY + ennemiHeight && joueurY + joueurHeight > ennemiY) {
                cpt++;
            }
        }
        return (cpt != 0);
    }

    public boolean isEtatAltere() {
        return etatAltere;
    }

    public int getVieMax() {
        return 10;
    }

    public boolean ramasserItem(Item item) {
        if (this.getInventaire().estPlein()) {
            return false;
        }

        if (item.getX() + 10 >= this.getHitbox().getX() &&
                item.getX() + 10 <= this.getHitbox().getX() + this.getHitbox().getWidth() &&
                item.getY() + 10 >= this.getHitbox().getY() &&
                item.getY() + 10 <= this.getHitbox().getY() + this.getHitbox().getHeight()) {
            return true;
        }
        return false;
    }
    public Inventaire getInventaire() {
        return inventaire;
    }

    public void setEtatAltere(boolean etatAltere) {
        this.etatAltere = etatAltere;
    }

    public void debuffVitesse(int viteseDebuff) {
        this.vitesse = (vitesse - viteseDebuff);
    }

    public void buffVitesse(int viteseBuff) {
        this.vitesse = (vitesse + viteseBuff);
    }

}