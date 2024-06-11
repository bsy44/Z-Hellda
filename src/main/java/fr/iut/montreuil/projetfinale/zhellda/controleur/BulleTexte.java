package fr.iut.montreuil.projetfinale.zhellda.controleur;

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

public class BulleTexte extends StackPane {
    private Villageois villageois;
    private Label label;
    private Button boutonPasser;

    public BulleTexte(Villageois villageois) {
        this.villageois = villageois;
        label = new Label();
        boutonPasser = new Button("Suivant");
        VBox vbox = new VBox();
        HBox hbox = new HBox(boutonPasser);

        label.setFont(new Font("Arial", 15));
        label.setTextFill(Color.WHITE);
        label.setTextAlignment(TextAlignment.CENTER);
        label.setWrapText(true); // Activer le retour à la ligne pour le label

        vbox.getChildren().addAll(label);
        hbox.setAlignment(Pos.BOTTOM_RIGHT);

        this.getChildren().addAll(vbox, hbox);
        this.setTranslateY(villageois.getY());
        this.setTranslateX(villageois.getX());

        this.getStyleClass().add("bulle-texte");
        label.getStyleClass().add("label");
        boutonPasser.getStyleClass().add("button");
    }

    public void setTexte(String texte) {
        label.setText(texte);
    }

    public void messageSuivant() {
        boutonPasser.setOnAction(event -> {
            System.out.println("Click");
            if (villageois != null) {
                villageois.incrementerIndiceMessage();
                setTexte(villageois.getListMessage().get(villageois.getIndiceMessageActuel()).getValue());
            }
        });
    }
}
