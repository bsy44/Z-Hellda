package fr.iut.montreuil.projetfinale.zhellda.modele;

import java.util.Timer;
import java.util.TimerTask;

public class GrimoirArme extends ItemConsomable{

    public GrimoirArme(int posX, int posY) {
        super(posX, posY, "grimoireArme");
    }

    @Override
    public void consommerItem(Joueur joueur) {
        int degatParDefaut = joueur.getArme().getAttaque();
        joueur.getArme().setAttaque((int) (degatParDefaut * 1.5));

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                joueur.getArme().setAttaque(degatParDefaut);
            }
        }, 10000);

        joueur.getInventaireItem().supprimerItem(this);
    }
}
