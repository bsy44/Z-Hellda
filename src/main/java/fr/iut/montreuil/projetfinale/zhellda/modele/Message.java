package fr.iut.montreuil.projetfinale.zhellda.modele;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Message {

    private StringProperty contenueMessage;

    public Message(String contenueMessage){
        this.contenueMessage = new SimpleStringProperty(contenueMessage);
    }

    public String getContenueMessage() {
        return contenueMessage.get();
    }

    @Override
    public String toString() {
        return "Message{" +
                "contenueMessage : " + contenueMessage +
                '}';
    }
}
