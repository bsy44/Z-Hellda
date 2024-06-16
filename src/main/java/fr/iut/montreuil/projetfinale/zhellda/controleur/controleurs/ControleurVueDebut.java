package fr.iut.montreuil.projetfinale.zhellda.controleur.controleurs;

import fr.iut.montreuil.projetfinale.zhellda.Lancement;
import fr.iut.montreuil.projetfinale.zhellda.controleur.Clavier;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.IOException;

public class ControleurVueDebut{
    @FXML
    public void lancerJeu(MouseEvent event) throws IOException  {
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Lancement.class.getResource("Vue.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),1480 , 920);
        scene.setOnKeyPressed(e -> Clavier.keyPressed(e));
        primaryStage.setTitle("Z-Hellda");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

   @FXML
   public void menuOption(MouseEvent event) throws IOException{
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Lancement.class.getResource("MenuOption.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),1380 , 950);
        primaryStage.setTitle("Z-Hellda - Menu option");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    public void quitterJeu(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
}
