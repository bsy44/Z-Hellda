package fr.iut.montreuil.projetfinale.zhellda.modele;

public abstract class Arme {
    private int portee;
    private int attaque;

    public Arme (int attaque, int portee){
        this.attaque=attaque;
        this.portee=portee;
    }



    public int getPortee (){
        return this.portee;
    }

    public int getAttaque() {
        return attaque;
    }
}
