package fr.iut.montreuil.projetfinale.zhellda.modele;

public class PotionMagique extends ItemConsomable{
    public PotionMagique(int posX, int posY) {
        super(posX, posY, "passeMuraille");
    }

    @Override
    public void consommerItem(Joueur joueur) {
        joueur.setTransparent(true);
        java.util.Timer timer = new java.util.Timer();
        timer.schedule(new java.util.TimerTask() {
            @Override
            public void run() {
                joueur.setTransparent(false); // Désactiver la transparence
            }
        }, 7000);

        joueur.getInventaireItem().supprimerItem(this);
    }
}