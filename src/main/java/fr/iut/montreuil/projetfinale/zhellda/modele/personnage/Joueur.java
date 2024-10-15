package fr.iut.montreuil.projetfinale.zhellda.modele.personnage;

import fr.iut.montreuil.projetfinale.zhellda.modele.*;
import fr.iut.montreuil.projetfinale.zhellda.modele.item.Arme;
import fr.iut.montreuil.projetfinale.zhellda.modele.item.Item;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Joueur extends Acteur {
    private boolean[] directions; // haut, gauche, bas, droite
    private int numArmeUtilise;
    private IntegerProperty directionProperty;
    private boolean etatAltere;
    private BooleanProperty transparent;
    private Inventaire inventaireArme;
    private Inventaire inventaireItem;

    public Joueur(Environnement environnement) {
        super(282, 50, 10, 5, "joueur", 30, 30, environnement);
        this.numArmeUtilise = 0;
        this.directions = new boolean[]{false, false, false, false};
        this.directionProperty = new SimpleIntegerProperty(-1);
        this.etatAltere = false;
        this.transparent = new SimpleBooleanProperty(false);
        this.inventaireArme = new Inventaire(3);
        this.inventaireItem = new Inventaire(6);
    }

    public boolean getDirections(int i) {
        return directions[i];
    }

    public Arme getArme() {
        return (Arme) this.inventaireArme.getListItem().get(numArmeUtilise);
    }

    public Inventaire getInventaireItem() {
        return inventaireItem;
    }

    public Inventaire getInventaireArme() {
        return inventaireArme;
    }

    public boolean getTransparent() {
        return transparent.getValue();
    }

    public BooleanProperty transparentProperty() {
        return transparent;
    }

    public void setTransparent(boolean transparent) {
        this.transparent.set(transparent);
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

    @Override
    public void agit() {
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

        if (colisionObstacle(haut, bas, droite, gauche)) {
            this.setX(newX);
            this.setY(newY);
        }

        if (colisionEnnemis() || colisionEnv()){
            this.setX(oldX);
            this.setY(oldY);
        }

        if (getTransparent()){
            this.setX(newX);
            this.setY(newY);
        }

        for (int i = 0; i < this.directions.length; i++) {
            this.directions[i] = false;
        }
    }

    @Override
    public boolean meurt() {
        if (getVie().getValue()<=0) {
            environnement.getListObsJoueur().remove(this);
            return true;
        }
        return false;
    }

    public boolean colisionObstacle(int haut, int bas, int droite, int gauche){
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

        for (Ennemis ennemi : environnement.getListEnnemis()) {
            int ennemiX = (int) ennemi.getHitbox().getX();
            int ennemiY = (int) ennemi.getHitbox().getY();
            int ennemiWidth = (int) ennemi.getHitbox().getWidth();
            int ennemiHeight = (int) ennemi.getHitbox().getHeight();

            if ( joueurX < ennemiX + ennemiWidth && joueurX + joueurWidth > ennemiX && joueurY < ennemiY + ennemiHeight && joueurY + joueurHeight > ennemiY){
                cpt++;
            }
        }
        return (cpt != 0);
    }


    private boolean estEnCollision(int objetX, int objetY, int objetWidth, int objetHeight) {
        return getX() < objetX + objetWidth &&
                getX() + getHitbox().getWidth() > objetX &&
                getY() < objetY + objetHeight &&
                getY() + getHitbox().getHeight() > objetY;
    }

    public boolean colisionEnv(){

        int coffreWidth = 32;
        int coffreHeight = 32;
        for (Coffre coffre : environnement.getListCoffre()) {
            if (estEnCollision(coffre.getX(), coffre.getY(), coffreWidth, coffreHeight)) {
                return true;
            }
        }

        for (Villageois villageois : environnement.getListVillageois()) {
            if (estEnCollision(villageois.getX(), villageois.getY(), (int)villageois.getHitbox().getWidth(), (int)villageois.getHitbox().getHeight())) {
                return true;
            }
        }

        return false;
    }

    
    public boolean isEtatAltere() {
        return etatAltere;
    }

    public int getVieMax() {
        return 10;
    }
    


    public void jeterItem(Item item){
        item.setX(getX());
        item.setY(getY() - 30);
        inventaireItem.supprimerItem(item);
        environnement.getListItemParTerre().add(item);
    }

    public void jeterArme(Arme arme){
        arme.setX(getX());
        arme.setY(getY() - 30);
        inventaireArme.supprimerItem(arme);
        environnement.ajouterItem(arme);
    }


    public boolean ramasserItem(Item item) {
        if (inventaireItem.estPlein()) {
            return false;
        }

        if (item.getX() + 10 >= this.getHitbox().getX() &&
                item.getX() + 10 <= this.getHitbox().getX() + this.getHitbox().getWidth() &&
                item.getY() + 10 >= this.getHitbox().getY() &&
                item.getY() + 10 <= this.getHitbox().getY() + this.getHitbox().getHeight()) {
            System.out.println("Ramasser");
            return true;
        }
        return false;
    }

    public void interagir(){
        Coffre coffre = coffreAuTour();

        if (coffre != null && !coffre.estOuvert().getValue()){
            coffre.setOuvert(true);
            if (coffre.getItem() instanceof Arme){
                inventaireArme.ajouterItem(coffre.getItem());
            }
            else {
                if (!inventaireItem.estPlein()) {
                    inventaireItem.ajouterItem(coffre.getItem());
                }
                else {
                    coffre.getItem().setX(coffre.getX());
                    coffre.getItem().setY(coffre.getY() + 25);
                    environnement.ajouterItem(coffre.getItem());
                }
            }
            coffre.supprimerItem();
        }
    }

    public Coffre coffreAuTour(){
        for (Coffre coffre : environnement.getListCoffre()) {
            int coffreWidth = 32;
            int coffreHeight = 32;

            if (estProche(coffre.getX(), coffre.getY(), coffreWidth, coffreHeight,16))
                return coffre;
            }

        return null;
    }

    public Villageois villageoisAutour(){
        for (Villageois villageois : environnement.getListVillageois()){
            int villageoisWidth = 40;
            int villageoisHeight = 40;
            if (estProche(villageois.getX(), villageois.getY(),villageoisWidth,villageoisHeight,16)){
                return villageois;
            }
        }
        return null;
    }

    public boolean estProche(int objetX, int objetY, int objetWidth, int objetHeight, int tailleDetection) {
        return objetX < this.getHitbox().getX() + this.getHitbox().getWidth() + tailleDetection &&
                objetX + objetWidth > this.getHitbox().getX() - tailleDetection &&
                objetY < this.getHitbox().getY() + this.getHitbox().getHeight() + tailleDetection &&
                objetY + objetHeight > this.getHitbox().getY() - tailleDetection;
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