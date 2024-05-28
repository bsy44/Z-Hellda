module fr.iut.montreuil.projetfinale.zhellda {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires com.google.gson;


    opens fr.iut.montreuil.projetfinale.zhellda to javafx.fxml;
    exports fr.iut.montreuil.projetfinale.zhellda;
    exports fr.iut.montreuil.projetfinale.zhellda.controleur;
    opens fr.iut.montreuil.projetfinale.zhellda.controleur to javafx.fxml;
    exports fr.iut.montreuil.projetfinale.zhellda.modele;
    opens fr.iut.montreuil.projetfinale.zhellda.modele to javafx.fxml;
}