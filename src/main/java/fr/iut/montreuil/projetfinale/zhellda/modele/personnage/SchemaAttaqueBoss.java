package fr.iut.montreuil.projetfinale.zhellda.modele.personnage;

import fr.iut.montreuil.projetfinale.zhellda.modele.Case;
import fr.iut.montreuil.projetfinale.zhellda.modele.Environnement;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.util.Duration;

import java.util.ArrayList;

public abstract class SchemaAttaqueBoss implements SchemaAttaqueEnnemi {

    private ObservableList<Case> casesAttaqueesProperty = FXCollections.<Case>observableArrayList();
    private ArrayList<Case> casesAttaquees = new ArrayList<>();

    public abstract void attaquer (Environnement environnement, Ennemi ennemi);

    public String direction(Ennemi ennemi){
        // Est à 0 si on est collé à la hitbox du boss et augmente plus on s'en éloigne
        // Passe en négatif si on est dans la direction opposé
        double yBas = Environnement.getJ().getY() - (ennemi.getY() + ennemi.getHitbox().getHeight());
        double yHaut = ennemi.getY() - (Environnement.getJ().getY() + Environnement.getJ().getHitbox().getHeight());
        double xDroite = Environnement.getJ().getX() - (ennemi.getX() + ennemi.getHitbox().getWidth());
        double xGauche = ennemi.getX() - (Environnement.getJ().getX() + Environnement.getJ().getHitbox().getWidth());

        String direction = "bas";
        double max = yBas;

        if (yHaut > max) {
            max = yHaut;
            direction = "haut";
        }
        if (xDroite > max) {
            max = xDroite;
            direction = "droite";
        }
        if (xGauche > max) direction = "gauche";

        return direction;
    }

    public void verfificationZone(ArrayList<Case> casesAttaquees, Boss boss){
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
                            Environnement.getJ().subirDegats(boss.getAttaque());
                            degatSubis = true;
                        }
                })
        );
        attaque.play();
    }

    public ObservableList<Case> getCasesAttaqueesProperty() {
        return casesAttaqueesProperty;
    }

    public void mettreAJourCasesAttaqueesProperty() {
        this.casesAttaqueesProperty.setAll(this.casesAttaquees);
        this.casesAttaquees.clear();
    }

    public void ajouterCasesAttaquees(Case caseAttaquee) {
        this.casesAttaquees.add(caseAttaquee);
    }
}
