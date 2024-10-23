package fr.iut.montreuil.projetfinale.zhellda.modele;

import fr.iut.montreuil.projetfinale.zhellda.controleur.listeObservable.ObsPaterneBoss;
import fr.iut.montreuil.projetfinale.zhellda.modele.personnage.Boss;

import java.util.Random;

public class Vague {
    private int debutVague;
    private int finVague;
    private int delaiApparition;
    private boolean bossGenerer;
    private ChangeurStringEnnemi changeurStringEnnemi;

    public Vague (int delaiApparition) {
        this.debutVague = 0;
        this.finVague = 100000;//A régler
        this.delaiApparition = delaiApparition;
        this.bossGenerer = false;
        this.changeurStringEnnemi=new ChangeurStringEnnemi();
    }

    public Case genererSpawn() {
        Random random = new Random();
        int randomNb = random.nextInt(5)+1;
        if (randomNb == 1) {
            return caseEnnemi(1);
        }
        if (randomNb == 2) {
            return caseEnnemi(2);
        }
        if (randomNb == 3) {
            return caseEnnemi(3);
        }
        if (randomNb == 4) {
            return caseEnnemi(4);
        }
        if (randomNb == 5) {
            return caseEnnemi(4);
        }
        return null;
    }

    public Case caseEnnemi(int spawnEnnemie) {
        switch (spawnEnnemie){
            case 1:
                return new Case(240,0);
            case 2:
                return new Case(0,390);
            case 3:
                return new Case(240,1560);
            case 4:
                return new Case(1560,1140);
            case 5:
                return new Case(1410,570);
        }
        return null;
    }

    public  String genenerEnnemie() {
        Random random = new Random();
        int randomNb = random.nextInt(4)+1;
        if (randomNb == 1) {
            return "sentinelle";
        }
        if (randomNb == 2) {
            return "rapide";
        }
        if (randomNb == 3) {
            return "zombie";
        }
        if (randomNb == 4){
            return "tank";
        }
        return null;
    }

    public void genenerAddEnnemie(){
        Environnement.getUniqueInstance().ajouterEnnemi(changeurStringEnnemi.choisirEnnemie(genererSpawn(),genenerEnnemie()));
    }

    public void lancerVague () {
        if (debute() && !estFini()) {
            if (Environnement.getUniqueInstance().getTourJeu() % delaiApparition == 0) {
                genenerAddEnnemie();
            }
        }
        if (estFini() && Environnement.getUniqueInstance().getListEnnemis().isEmpty() && bossGenerer == false) {
            Boss boss = new Boss(1190, 900);
            new ObsPaterneBoss(boss);
            Environnement.getUniqueInstance().ajouterEnnemi(boss);
            bossGenerer = true;
        }
    }

    public boolean debute () {
        return Environnement.getUniqueInstance().getTourJeu() >= debutVague;
    }

    public boolean estFini () {
        return Environnement.getUniqueInstance().getTourJeu() > finVague;
    }

    public int getDelaiApparition() {
        return delaiApparition;
    }

    public boolean isBossGenerer() {
        return bossGenerer;
    }
}
