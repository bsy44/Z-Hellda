package fr.iut.montreuil.projetfinale.zhellda.controleur;

import fr.iut.montreuil.projetfinale.zhellda.Lancement;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class ControleurGameOver {
    public void rejouer(MouseEvent event) throws IOException {
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Lancement.class.getResource("Vue.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),1480 , 920);
        scene.setOnKeyPressed(e -> Clavier.keyPressed(e));
        primaryStage.setTitle("Z-Hellda");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void retournerAuMenu(MouseEvent event) throws IOException {
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Lancement.class.getResource("VueDebut.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1380, 920);
        scene.setOnKeyPressed(e -> Clavier.keyPressed(e));
        primaryStage.setTitle("Z-Hellda");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void quitter(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
}
