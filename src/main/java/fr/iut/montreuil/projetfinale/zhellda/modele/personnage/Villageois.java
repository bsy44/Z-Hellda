/*package fr.iut.montreuil.projetfinale.zhellda.modele;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import java.util.ArrayList;

public class Villageois extends Acteur{
    private ArrayList<StringProperty> listMessage;
    private int indiceMessageActuel;
    private StringProperty messageActuel;

    public Villageois(Environnement environnement) {
        super(210, 125, 1, 0, "villageois", 30, 30, environnement);
        this.listMessage = new ArrayList<>();
        this.indiceMessageActuel = 0;
        this.messageActuel = new SimpleStringProperty();
        this.ajouterMessage();
        this.setMessageActuel();
    }

    public ArrayList<StringProperty> getListMessage() {
        return listMessage;
    }

    public void ajouterMessage(){
        listMessage.add(new SimpleStringProperty("Bonjour jeune Aventurier. Bienvenue dans Z-Hellda !"));
        listMessage.add(new SimpleStringProperty("Nous sommes dans un univers qui mélange appocalypse et enfer."));
        listMessage.add(new SimpleStringProperty("Avant de commencer équipe toi bien, tu en auras besoin !"));
        listMessage.add(new SimpleStringProperty("Tien voici une épée pour commencer."));
        listMessage.add(new SimpleStringProperty("Tu retrouveras des coffres un peu partout dans ce monde, "));
        listMessage.add(new SimpleStringProperty("ils contiennent des items consomables ou d'autres amres."));
        listMessage.add(new SimpleStringProperty("Je te laisse avant qu'il arrive..."));
        listMessage.add(new SimpleStringProperty("A revoyure jeune aventurier !"));

        listMessage.add(new SimpleStringProperty("WOW! félicitation tu as vaincu le boss final !"));
        listMessage.add(new SimpleStringProperty("Je te remercie infiniment d'avoir sauver ce monde jeune aventurier."));
        listMessage.add(new SimpleStringProperty("On se retrouve en S3 pour de nouveuax projet."));
    }

    public StringProperty messageActuelProperty() {
        return messageActuel;
    }

    public void setMessageActuel() {
        if (indiceMessageActuel < listMessage.size()) {
            messageActuel.set(listMessage.get(indiceMessageActuel).getValue());
        }
    }

    public void incrementerIndiceMessage() {
        if (indiceMessageActuel <= listMessage.size()){
            indiceMessageActuel++;
            setMessageActuel();
            donArme();
        }
    }

    public void donArme(){
        if (indiceMessageActuel == 3){
            Epee epee = new Epee(environnement, getX(), getY() + 25);
            Environnement.getJ().getInventaireArme().ajouterItem(epee);
        }
    }

    @Override
    public boolean meurt() {
        if (indiceMessageActuel == listMessage.size()){
            environnement.getListVillageois().remove(this);
            return true;
        }
        return false;
    }

    @Override
    public void seDeplacer() {
    }
}*/

package fr.iut.montreuil.projetfinale.zhellda.modele.personnage;

import fr.iut.montreuil.projetfinale.zhellda.modele.Environnement;
import fr.iut.montreuil.projetfinale.zhellda.modele.item.Epee;
import fr.iut.montreuil.projetfinale.zhellda.modele.Message;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import java.util.ArrayList;

public class Villageois extends Acteur{
    private ArrayList<Message> listMessage;
    private int indiceMessageActuel;
    private StringProperty messageActuel;

    public Villageois(int x, int y, Environnement environnement) {
        super(x, y, 1, 0, "villageois", 30, 30, environnement);
        this.listMessage = new ArrayList<>();
        this.indiceMessageActuel = 0;
        this.messageActuel = new SimpleStringProperty();
        this.ajouterMessage();
        this.setMessageActuel();
    }

    public ArrayList<Message> getListMessage() {
        return listMessage;
    }

    public void ajouterMessage(){
        listMessage.add(new Message("Bonjour jeune Aventurier. Bienvenue dans Z-Hellda !"));
        listMessage.add(new Message("Nous sommes dans un univers qui mélange appocalypse et enfer."));
        listMessage.add(new Message("Avant de commencer équipe toi bien, tu en auras besoin !"));
        listMessage.add(new Message("Tien voici une épée pour commencer."));
        listMessage.add(new Message("Tu retrouveras des coffres un peu partout dans ce monde, "));
        listMessage.add(new Message("ils contiennent des items consomables ou d'autres amres."));
        listMessage.add(new Message("Je te laisse avant qu'ils arrivent..."));
        listMessage.add(new Message("A revoyure jeune aventurier!"));

        /*listMessage.add(new Message("WOW! félicitation tu as vaincu le boss final !"));
        listMessage.add(new Message("Je te remercie infiniment d'avoir sauver ce monde jeune aventurier."));
        listMessage.add(new Message("On se retrouve en S3 pour de nouveuax projet."));*/
    }

    public StringProperty messageActuelProperty() {
        return messageActuel;
    }

    public void setMessageActuel() {
        if (indiceMessageActuel < listMessage.size()) {
            messageActuel.set(listMessage.get(indiceMessageActuel).getContenueMessage());
        }
    }

    public void incrementerIndiceMessage() {
        if (indiceMessageActuel <= listMessage.size()){
            indiceMessageActuel++;
            setMessageActuel();
            donArme();
        }
    }

    public void donArme(){
        if (indiceMessageActuel == 3){
            Epee epee = new Epee(environnement, getX(), getY() + 25);
            Environnement.getJ().getInventaireArme().ajouterItem(epee);
        }
    }

    @Override
    public void agit() {
    }

    @Override
    public boolean meurt() {
        if (indiceMessageActuel == listMessage.size()){
            environnement.getListVillageois().remove(this);
            return true;
        }
        return false;
    }
}

