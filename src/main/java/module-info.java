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
    exports fr.iut.montreuil.projetfinale.zhellda.modele.personnage;
    opens fr.iut.montreuil.projetfinale.zhellda.modele.personnage to javafx.fxml;
    exports fr.iut.montreuil.projetfinale.zhellda.modele.item;
    opens fr.iut.montreuil.projetfinale.zhellda.modele.item to javafx.fxml;
    exports fr.iut.montreuil.projetfinale.zhellda.modele.projectile;
    opens fr.iut.montreuil.projetfinale.zhellda.modele.projectile to javafx.fxml;
    exports fr.iut.montreuil.projetfinale.zhellda.controleur.controlleurs;
    opens fr.iut.montreuil.projetfinale.zhellda.controleur.controlleurs to javafx.fxml;
    exports fr.iut.montreuil.projetfinale.zhellda.controleur.listeObservable;
    opens fr.iut.montreuil.projetfinale.zhellda.controleur.listeObservable to javafx.fxml;
}