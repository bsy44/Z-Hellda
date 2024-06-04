package fr.iut.montreuil.projetfinale.zhellda.modele;

public class PommeDor extends Item{
    public PommeDor(int posX, int posY) {
        super(posX, posY, "PommeDorre");
    }

    public void ajouterPv(){
        Environnement.getJ().setVie(2);
    }
}
