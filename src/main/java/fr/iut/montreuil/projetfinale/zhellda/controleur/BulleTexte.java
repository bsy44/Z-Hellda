package fr.iut.montreuil.projetfinale.zhellda.controleur;

import fr.iut.montreuil.projetfinale.zhellda.modele.Pnj;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class BulleTexte extends StackPane {
    private Label label;
    private Rectangle background;

    public BulleTexte(String texte, Pnj pnj) {
        label = new Label(texte);
        label.setFont(new Font("Arial", 14));
        label.setTextFill(Color.WHITE);
        label.setTextAlignment(TextAlignment.CENTER);


        background = new Rectangle();
        background.setFill(Color.BLACK);
        background.setArcWidth(10);
        background.setArcHeight(10);

        // Ajuster la taille du rectangle
        background.widthProperty().bind(label.widthProperty().add(20));
        background.heightProperty().bind(label.heightProperty().add(20));

        this.getChildren().addAll(background, label);

        this.setTranslateY(pnj.getY());
        this.setTranslateX(pnj.getX());
    }

    public void setTexte(String texte) {
        label.setText(texte);
    }
}
