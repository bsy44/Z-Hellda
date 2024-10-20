package fr.iut.montreuil.projetfinale.zhellda.modele.item;

import fr.iut.montreuil.projetfinale.zhellda.modele.personnage.Joueur;

import java.util.Timer;
import java.util.TimerTask;

public class PotionMagique extends ItemConsomable {
    public PotionMagique(int posX, int posY) {
        super(posX, posY, "passeMuraille");
    }

    @Override
    public void consommerItem(Joueur joueur) {
        joueur.setTransparent(true);
        Timer timer = new Timer();

        final long period = 100;
        timer.scheduleAtFixedRate(new TimerTask() {
            private long elapsedTime = 0;
  // Vérification périodique tous les 100ms

            @Override
            public void run() {
                elapsedTime += period;
                if (elapsedTime >= 7000 && joueur.colisionObstacle((joueur.getY() +joueur.getVitesse())/16, (joueur.getY()+joueur.getVitesse())/16 + (int) joueur.getHitbox().getHeight()/16, ((joueur.getX()+joueur.getVitesse())/16+ ((int) joueur.getHitbox().getWidth()) / 16), (joueur.getX()+joueur.getVitesse())/16) ){
                    joueur.setTransparent(false); // Désactiver la transparence
                    timer.cancel(); // Arrêter le timer
                }
            }
        }, 0, period);

        joueur.getInventaireItem().supprimerItem(this);
    }
}