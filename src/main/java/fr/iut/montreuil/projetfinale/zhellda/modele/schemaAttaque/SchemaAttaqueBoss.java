package fr.iut.montreuil.projetfinale.zhellda.modele.schemaAttaque;

import fr.iut.montreuil.projetfinale.zhellda.modele.Case;
import fr.iut.montreuil.projetfinale.zhellda.modele.Environnement;
import fr.iut.montreuil.projetfinale.zhellda.modele.personnage.Boss;
import fr.iut.montreuil.projetfinale.zhellda.modele.personnage.Ennemi;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.util.Duration;
import java.util.ArrayList;

public abstract class SchemaAttaqueBoss implements SchemaAttaqueEnnemi {

    private ObservableList<Case> casesAttaqueesProperty = FXCollections.<Case>observableArrayList();
    private ArrayList<Case> casesAttaquees = new ArrayList<>();

    public void attaquer (Ennemi ennemi){
        faireAttaque((Boss) ennemi);
        mettreAJourCasesAttaqueesProperty();
        verfificationZone((Boss) ennemi);
        System.out.println("Super attaque");
    }

    public abstract void faireAttaque(Boss boss);

    public void verfificationZone(Boss boss){
        int taille = (int) Math.round(Environnement.getJ().getHitbox().getHeight()/16);
        Timeline attaque = new Timeline(
                new KeyFrame(Duration.seconds(1), e -> {
                    boolean degatSubis = false;
                    ArrayList<Case> caseJ = new ArrayList<>();
                    caseJ.add(new Case(Math.round(Environnement.getJ().getX()/16), Math.round(Environnement.getJ().getY()/16)));
                    caseJ.add(new Case(Math.round(Environnement.getJ().getX()/16), Math.round(Environnement.getJ().getY()/16)+taille));
                    caseJ.add(new Case(Math.round(Environnement.getJ().getX()/16)+taille, Math.round(Environnement.getJ().getY()/16)));
                    caseJ.add(new Case(Math.round(Environnement.getJ().getX()/16)+taille, Math.round(Environnement.getJ().getY()/16)+taille));
                    for (Case c : caseJ) {
                        for (Case c1 : getCasesAttaqueesProperty()) {
                            if (!degatSubis && c1.equals(c)) {
                                Environnement.getJ().subirDegats(boss.getAttaque());
                                degatSubis = true;
                            }
                        }
                    }
                })
        );
        attaque.play();
    }

    public ObservableList<Case> getCasesAttaqueesProperty() {
        return casesAttaqueesProperty;
    }

    public void mettreAJourCasesAttaqueesProperty() {
        System.out.println("mise à jour");
        getCasesAttaqueesProperty().setAll(getCasesAttaquees());
        getCasesAttaquees().clear();
    }

    public void ajouterCasesAttaquees(Case caseAttaquee) {
        this.casesAttaquees.add(caseAttaquee);
    }

    public ArrayList<Case> getCasesAttaquees() {
        return casesAttaquees;
    }
}
