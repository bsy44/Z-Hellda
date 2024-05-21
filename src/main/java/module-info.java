module fr.iut.montreuil.projetfinale.zhellda {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens fr.iut.montreuil.projetfinale.zhellda to javafx.fxml;
    exports fr.iut.montreuil.projetfinale.zhellda;
    exports fr.iut.montreuil.projetfinale.zhellda.controleur;
    opens fr.iut.montreuil.projetfinale.zhellda.controleur to javafx.fxml;
    exports fr.iut.montreuil.projetfinale.zhellda.modele;
    opens fr.iut.montreuil.projetfinale.zhellda.modele to javafx.fxml;
    exports fr.iut.montreuil.projetfinale.zhellda.modele.arme;
    opens fr.iut.montreuil.projetfinale.zhellda.modele.arme to javafx.fxml;
    exports fr.iut.montreuil.projetfinale.zhellda.modele.personnage;
    opens fr.iut.montreuil.projetfinale.zhellda.modele.personnage to javafx.fxml;
}