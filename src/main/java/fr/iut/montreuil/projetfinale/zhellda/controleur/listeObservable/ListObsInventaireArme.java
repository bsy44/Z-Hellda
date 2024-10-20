package fr.iut.montreuil.projetfinale.zhellda.controleur.listeObservable;

import fr.iut.montreuil.projetfinale.zhellda.Lancement;
import fr.iut.montreuil.projetfinale.zhellda.modele.item.Arme;
import fr.iut.montreuil.projetfinale.zhellda.modele.Environnement;
import fr.iut.montreuil.projetfinale.zhellda.modele.item.Item;
import javafx.collections.ListChangeListener;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.net.URL;

public class ListObsInventaireArme implements ListChangeListener<Item> {
    private HBox inventaireArme;

    public ListObsInventaireArme(HBox inventaireArme) {
        this.inventaireArme = inventaireArme;
    }

    @Override
    public void onChanged(Change<? extends Item> change) {
        while (change.next()){
            if (change.wasAdded()){
                for (Item arme : change.getAddedSubList()) {
                    ajouterImageVersInventaire((Arme) arme);
                }
            }

            if (change.wasRemoved()){
                for (Item arme : change.getRemoved()) {
                    retirerImageDeInventaire((Arme) arme);
                }
            }
        }
    }

    public void ajouterImageVersInventaire(Arme arme) {
        URL url = Lancement.class.getResource(arme.getNom() + ".png");
        if (url != null) {
            Image image = new Image(url.toExternalForm());
            int index = getFirstSlot();
            if (index != -1) {
                ImageView imageView = (ImageView) inventaireArme.lookup("#arme" + index);
                if (imageView != null ) {
                    imageView.setImage(image);
                    arme.setIndexInventaire(index);
                }
            }
        }
    }

    public void retirerImageDeInventaire(Arme arme) {
        int index = arme.getIndexInventaire();
        if (index != -1) {
            ImageView imageView = (ImageView) inventaireArme.lookup("#arme" + index);
            if (imageView != null) {
                imageView.setImage(null);
            }
            arme.setIndexInventaire(-1);
        }
    }

    public int getFirstSlot() {
        for (int i = 0; i < Environnement.getJ().getInventaireArme().getCapaciteMax(); i++) {
            ImageView imageView = (ImageView) inventaireArme.lookup("#arme" + i);
            if (imageView != null && imageView.getImage() == null) {
                return i;
            }
        }
        return -1;
    }
}
