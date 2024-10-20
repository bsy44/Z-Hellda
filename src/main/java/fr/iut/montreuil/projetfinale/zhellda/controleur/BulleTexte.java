package fr.iut.montreuil.projetfinale.zhellda.controleur;

import fr.iut.montreuil.projetfinale.zhellda.modele.personnage.Villageois;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class BulleTexte extends HBox {
    private Label label;

    public BulleTexte(Villageois villageois) {
        this.label = new Label();
        this.getChildren().add(label);

        this.getStyleClass().add("bulle-texte");
        this.label.getStyleClass().add("label");

        this.label.textProperty().bind(villageois.messageActuelProperty());
    }
}
