package fr.iut.montreuil.projetfinale.zhellda.controleur.controleurs;

import fr.iut.montreuil.projetfinale.zhellda.Lancement;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.IOException;

public class ControleurVictoire {

    @FXML
    public void retourMenu(MouseEvent event) throws IOException {
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Lancement.class.getResource("VueDebut.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1380, 920);
        primaryStage.setTitle("Z-Hellda - Menu");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    public void quitter(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
}
