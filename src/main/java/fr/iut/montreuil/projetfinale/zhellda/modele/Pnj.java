package fr.iut.montreuil.projetfinale.zhellda.modele;

import fr.iut.montreuil.projetfinale.zhellda.controleur.BulleTexte;
import javafx.scene.layout.Pane;

public class Pnj extends Acteur{
    private BulleTexte bulleTexte;
    public Pnj(int x, int y,Environnement environnement) {
        super(x, y, 1, 0, "pnj", 30, 30, environnement);
    }
    public void parler(Pane pane, String message) {
        if (bulleTexte == null) {
            bulleTexte = new BulleTexte(message);
            pane.getChildren().add(bulleTexte);
            bulleTexte.setTranslateX(this.getX());
            bulleTexte.setTranslateY(this.getY() - 50);
            bulleTexte.setTexte(message);
        }
    }

//    public void cacherBulleTexte(Pane pane) {
//        if (bulleTexte != null) {
//            pane.getChildren().remove(bulleTexte);
//            bulleTexte = null;
//        }
//    }
}
