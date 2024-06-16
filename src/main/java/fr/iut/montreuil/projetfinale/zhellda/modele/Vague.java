package fr.iut.montreuil.projetfinale.zhellda.modele;

import java.util.Random;

public class Vague {



        private Environnement environnement;
        private int debutVague;
        private int finVague;
        private int delaiApparition;

        private boolean bossGenerer;
        private ChangeurStringEnnemi changeurStringEnnemi;

        public Vague (Environnement environnement, int delaiApparition) {
            this.environnement = environnement;
            this.debutVague = 0;
            this.finVague = 1000000;//A régler
            this.delaiApparition = delaiApparition;
            this.bossGenerer = false;
            this.changeurStringEnnemi=new ChangeurStringEnnemi(environnement);
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
        int randomNb = random.nextInt(3)+1;
        if (randomNb == 1) {
            return "Tank";
        }
        if (randomNb == 2) {
            return "Rapide";
        }
        if (randomNb == 3) {
            return "Zombie";
        }
        return null;
    }

    public void genenerAddEnnemie(){
        environnement.ajouterEnnemi(changeurStringEnnemi.choisirEnnemie(genererSpawn(),genenerEnnemie()));
    }
        public void agit () {
            if (debute() && !estFini()) {
                if (environnement.getTourJeu() % delaiApparition == 0) {
                    System.out.println("ennemis");
                    genenerAddEnnemie();
                }
            }
            if (estFini() && environnement.getListEnnemis()==null && !bossGenerer) {
                //ajouter le boss
                bossGenerer = true;
            }
        }

        public boolean debute () {
            return environnement.getTourJeu() >= debutVague;
        }

        public boolean estFini () {
            return environnement.getTourJeu() > finVague;
        }

        public Environnement getEnvironnement() {
            return environnement;
        }

        public int getDelaiApparition() {
            return delaiApparition;
        }

}
