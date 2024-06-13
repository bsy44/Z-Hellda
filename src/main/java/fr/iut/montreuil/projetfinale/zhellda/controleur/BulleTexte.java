/*package fr.iut.montreuil.projetfinale.zhellda.controleur;

import fr.iut.montreuil.projetfinale.zhellda.modele.Villageois;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class BulleTexte extends Button {
    private Villageois villageois;
    private Label label;

/*    public BulleTexte(Villageois villageois) {
        this.villageois = villageois;
        label = new Label();
        VBox vbox = new VBox();

        label.setFont(new Font("Arial", 15));
        label.setTextFill(Color.WHITE);
        label.setTextAlignment(TextAlignment.CENTER);
        label.setWrapText(true); // Activer le retour à la ligne pour le label

        vbox.getChildren().add(label);

        this.getChildren().add(vbox);
        this.setTranslateY(villageois.getY());
        this.setTranslateX(villageois.getX());

        this.getStyleClass().add("bulle-texte");
        label.getStyleClass().add("label");
    }

    public void setTexte(String texte) {
        label.setText(texte);
    }

    public void messageSuivant() {
        villageois.incrementerIndiceMessage();
        setTexte(villageois.getListMessage().get(villageois.getIndiceMessageActuel()).getValue());
    }
}

    public BulleTexte(Villageois villageois) {
        this.villageois = villageois;
        this.setText(villageois.getListMessage().get(0).getValue());
        messageSuivant();
    }

    public void messageSuivant() {
        this.setOnMouseClicked(mouseEvent -> {
            if (villageois.getIndiceMessageActuel() <= villageois.getListMessage().size()) {
                villageois.incrementerIndiceMessage();
                this.setText(villageois.getListMessage().get(villageois.getIndiceMessageActuel()).getValue());
            }
        });
    }
}*/

package fr.iut.montreuil.projetfinale.zhellda.controleur;

import fr.iut.montreuil.projetfinale.zhellda.modele.Villageois;
import javafx.scene.control.Button;

public class BulleTexte extends Button {
    private Villageois villageois;

    public BulleTexte(Villageois villageois) {
        this.villageois = villageois;
        this.setText(villageois.getListMessage().get(0).getValue());
        this.setFocusTraversable(false);
        this.isMnemonicParsing();
        this.setOnAction(mouseEvent -> messageSuivant());
        this.setStyle("-fx-background-color: lightblue; -fx-text-fill: black;");
    }

    public void messageSuivant() {
        if (villageois.getIndiceMessageActuel() < villageois.getListMessage().size() - 1) {
            villageois.incrementerIndiceMessage();
            this.setText(villageois.getListMessage().get(villageois.getIndiceMessageActuel()).getValue());
        }
    }
}

