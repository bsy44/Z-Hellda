package fr.iut.montreuil.projetfinale.zhellda;

import fr.iut.montreuil.projetfinale.zhellda.controleur.Clavier;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Lancement extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Lancement.class.getResource("VueDebut.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),1380 , 920);
        scene.setOnKeyPressed(e -> Clavier.keyPressed(e));
        stage.setTitle("Z-Hellda");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}