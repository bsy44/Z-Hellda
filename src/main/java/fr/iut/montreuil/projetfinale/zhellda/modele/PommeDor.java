package fr.iut.montreuil.projetfinale.zhellda.modele;

public class PommeDor extends ItemConsomable{
    public PommeDor(int posX, int posY) {
        super(posX, posY, "pommeOr");
    }

    @Override
    public void consommerItem() {
        if (Environnement.getJ().getVie().getValue() < Environnement.getJ().getVieMax()) {
            if (Environnement.getJ().getVie().getValue() == 9) {
                Environnement.getJ().setVie(1);
            }
            else {
                Environnement.getJ().setVie(2);
            }
            Environnement.getJ().getInventaireItem().supprimerItem(this);
        }
    }
}
