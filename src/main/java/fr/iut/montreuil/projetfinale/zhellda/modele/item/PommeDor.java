package fr.iut.montreuil.projetfinale.zhellda.modele.item;

import fr.iut.montreuil.projetfinale.zhellda.modele.personnage.Joueur;

public class PommeDor extends ItemConsomable{
    public PommeDor(int posX, int posY) {
        super(posX, posY, "pommeOr");
    }

    @Override
    public void consommerItem(Joueur joueur) {
        if (joueur.getVie().getValue() < joueur.getVieMax()) {
            if (joueur.getVie().getValue() == 9) {
                joueur.setVie(1);
            }
            else {
                joueur.setVie(2);
            }
            joueur.getInventaireItem().supprimerItem(this);
        }
    }
}
