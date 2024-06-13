package fr.iut.montreuil.projetfinale.zhellda.modele;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;

public class Villageois extends Acteur{
    private ArrayList<StringProperty> listMessage;
    private int indiceMessageActuel;
    public Villageois(Environnement environnement) {
        super(210, 125, 1, 0, "villageois", 30, 30, environnement);
        this.listMessage = new ArrayList<>();
        this.indiceMessageActuel = 1;
        this.ajouterMessage();
    }

    public ArrayList<StringProperty> getListMessage() {
        return listMessage;
    }

    public void ajouterMessage(){
        listMessage.add(new SimpleStringProperty("Bonjour jeune Aventurier. Bienvenue dans Z-Hellda !"));
        listMessage.add(new SimpleStringProperty("Avant de commencer Equipe toi bien, tu en auras besoin !"));
        listMessage.add(new SimpleStringProperty("Tu retrouveras des coffres un peu partout dans ce monde qui contiennent des items consomables ou des amres"));
        listMessage.add(new SimpleStringProperty("Je te laisse avant qu'il arrive..."));
        listMessage.add(new SimpleStringProperty(" A revoyure jeune aventurier !"));
    }

    public void supprimerMessage(StringProperty message){
        listMessage.remove(message);
    }

    public int getIndiceMessageActuel() {
        return indiceMessageActuel;
    }

    public void incrementerIndiceMessage() {
        indiceMessageActuel = (indiceMessageActuel + 1) % listMessage.size();
    }

}
