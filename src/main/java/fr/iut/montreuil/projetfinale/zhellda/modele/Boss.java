package fr.iut.montreuil.projetfinale.zhellda.modele;

import fr.iut.montreuil.projetfinale.zhellda.vue.VueTerrain;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.util.Duration;

import java.util.ArrayList;

public class Boss extends Ennemis{
    private IntegerProperty shemaAttaque = new SimpleIntegerProperty();
    private String direction;

    public Boss(int x, int y, Environnement environnement) {
        super(x, y, 200, 3, 5, 0, 100, 100, environnement, "boss");
        shemaAttaque.set(0);
        direction = null;
    }

    @Override
    public int getPvMax() {
        return 200;
    }

    @Override
    public void agir(){
        attaquer();
        Timeline attendreDeplacement = new Timeline(
                new KeyFrame(Duration.seconds(2), e -> {
//                    seDeplacer();
                    setShemaAttaque(0);
                })
        );
        attendreDeplacement.play();
    }

    @Override
    public void attaquer(){
        fireBall();
    }

    public void clawAtk(){

        setShemaAttaque(1);
        nouvelleDirection();
        ArrayList<Case> casesAttaquees = new ArrayList<>();

        if (direction.equals("droite")) {
            casesAttaquees.add(new Case(Math.round(getX() / 16)+6, Math.round(getY() / 16)+7));
            casesAttaquees.add(new Case(Math.round(getX() / 16)+6, Math.round(getY() / 16)-1));
            for (int i = -1; i <= 7; i++) {
                casesAttaquees.add(new Case(Math.round(getX() / 16)+7, Math.round(getY() / 16)+i));
                if (i + 1 < 7) {
                    casesAttaquees.add(new Case(Math.round(getX() / 16)+8, Math.round(getY() / 16) + i + 1));
                }
                if (i + 2 < 6) {
                    casesAttaquees.add(new Case(Math.round(getX() / 16)+9, Math.round(getY() / 16)+i+2));
                }
            }

        } else if (direction.equals("gauche")) {
            casesAttaquees.add(new Case(Math.round(getX() / 16)+1, Math.round(getY() / 16)-1));
            casesAttaquees.add(new Case(Math.round(getX() / 16)+1, Math.round(getY() / 16)+7));

            for (int i = -1; i <= 7; i++) {
                casesAttaquees.add(new Case(Math.round(getX() / 16), Math.round(getY() / 16)+i));
                if (i + 1 < 7) {
                    casesAttaquees.add(new Case(Math.round(getX() / 16)-1, Math.round(getY() / 16)+i+1));
                }
                if (i + 2 < 6) {
                    casesAttaquees.add(new Case(Math.round(getX() / 16)-2, Math.round(getY() / 16)+i+2));
                }
            }

        } else if (direction.equals("bas")) {
            casesAttaquees.add(new Case(Math.round(getX() / 16) -1, Math.round(getY() / 16)+6));
            casesAttaquees.add(new Case(Math.round(getX() / 16)+7, Math.round(getY() / 16)+6));
            for (int i = -1; i <= 7; i++) {
                casesAttaquees.add(new Case(Math.round(getX() / 16)+i, Math.round(getY() / 16)+7));
                if (i + 1 < 7) {
                    casesAttaquees.add(new Case(Math.round(getX() / 16)+i+1, Math.round(getY() / 16)+8));
                }
                if (i + 2 < 6) {
                    casesAttaquees.add(new Case(Math.round(getX() / 16)+i+2, Math.round(getY() / 16)+9));
                }
            }

        } else {
            casesAttaquees.add(new Case(Math.round(getX() / 16) - 1, Math.round(getY() / 16) + 1));
            casesAttaquees.add(new Case(Math.round(getX() / 16) +7, Math.round(getY() / 16) + 1));
            for (int i = -1; i <= 7; i++) {
                casesAttaquees.add(new Case(Math.round(getX() / 16) + i, Math.round(getY() / 16)));
                if (i + 1 < 7) {
                    casesAttaquees.add(new Case(Math.round(getX() / 16) + i + 1, Math.round(getY() / 16) - 1));
                }
                if (i + 2 < 6) {
                    casesAttaquees.add(new Case(Math.round(getX() / 16) + i + 2, Math.round(getY() / 16) - 2));
                }
            }
        }

        verfificationZone(casesAttaquees);

    }

    public void areaOfEffect (){
        setShemaAttaque(2);
        ArrayList<Case> casesAttaquees = new ArrayList<>();

            for (int i = -1; i < 8; i++) {
                casesAttaquees.add(new Case(Math.round(getX() / 16)+7, Math.round(getY() / 16)+i));
                casesAttaquees.add(new Case(Math.round(getX() / 16)-1, Math.round(getY() / 16)+i));
                casesAttaquees.add(new Case(Math.round(getX() / 16)+i, Math.round(getY() / 16)+7));
                casesAttaquees.add(new Case(Math.round(getX() / 16)+i, Math.round(getY() / 16)-1));
                if (i > -1 && i < 7 ){
                    casesAttaquees.add(new Case(Math.round(getX() / 16)+8, Math.round(getY() / 16)+i));
                    casesAttaquees.add(new Case(Math.round(getX() / 16)-2, Math.round(getY() / 16)+i));
                    casesAttaquees.add(new Case(Math.round(getX() / 16)+i, Math.round(getY() / 16)+8));
                    casesAttaquees.add(new Case(Math.round(getX() / 16)+i, Math.round(getY() / 16)-2));
                    if (i > 1 && i < 5){
                        casesAttaquees.add(new Case(Math.round(getX() / 16)-3, Math.round(getY() / 16)+i));
                        casesAttaquees.add(new Case(Math.round(getX() / 16)+i, Math.round(getY() / 16)+9));
                        casesAttaquees.add(new Case(Math.round(getX() / 16)+i, Math.round(getY() / 16)-3));
                    }
                }
            }
            verfificationZone(casesAttaquees);
    }

    public String direction(){

        // Est à 0 si on est collé à la hitbox du boss et augmente plus on s'en éloigne
        // Passe en négatif si on est dans la direction opposé
        double yBas = Environnement.getJ().getY() - (getY() + getHitbox().getHeight());
        double yHaut = getY() - (Environnement.getJ().getY() + Environnement.getJ().getHitbox().getHeight());
        double xDroite = Environnement.getJ().getX() - (getX() + getHitbox().getWidth());
        double xGauche = getX() - (Environnement.getJ().getX() + Environnement.getJ().getHitbox().getWidth());

        String direciton = "bas";
        double max = yBas;

        if (yHaut > max) {
            max = yHaut;
            direciton = "haut";
        }
        if (xDroite > max) {
            max = xDroite;
            direciton = "droite";
        }
        if (xGauche > max) {
            direciton = "gauche";
        }

        return direciton;
    }

    public IntegerProperty getShemaAttaque() {
        return shemaAttaque;
    }
    public String getDirection (){
        return direction();
    }

    public void setShemaAttaque(int shemaAttaque) {
        this.shemaAttaque.set(shemaAttaque);
    }

    public void nouvelleDirection(){
        this.direction = direction();
    }

    public void verfificationZone (ArrayList<Case> casesAttaquees){
        int taille = (int) Math.round(Environnement.getJ().getHitbox().getHeight()/16);
        Timeline attaque = new Timeline(
                new KeyFrame(Duration.seconds(1), e -> {
                    boolean degatSubis = false;
                    ArrayList<Case> caseJ = new ArrayList<>();
                    caseJ.add(new Case(Math.round(Environnement.getJ().getX()/16), Math.round(Environnement.getJ().getY()/16)));
                    caseJ.add(new Case(Math.round(Environnement.getJ().getX()/16), Math.round(Environnement.getJ().getY()/16)+taille));
                    caseJ.add(new Case(Math.round(Environnement.getJ().getX()/16)+taille, Math.round(Environnement.getJ().getY()/16)));
                    caseJ.add(new Case(Math.round(Environnement.getJ().getX()/16)+taille, Math.round(Environnement.getJ().getY()/16)+taille));
                    for (Case c : caseJ)
                        if (!degatSubis && casesAttaquees.contains(c)) {
                            Environnement.getJ().subirDegats(getAttaque());
                            degatSubis = true;
                        }
                })
        );
        attaque.play();
    }

    public void fireBall(){
        setShemaAttaque(3);
        nouvelleDirection();

        if (direction.equals("droite")) {

            environnement.ajouterProjectile(new Projectile(1, getX(), getY(), Environnement.getJ().getX(), Environnement.getJ().getY(), getAttaque(), environnement));

        } else if (direction.equals("gauche")) {



        } else if (direction.equals("bas")) {



        } else {



        }
    }
}
