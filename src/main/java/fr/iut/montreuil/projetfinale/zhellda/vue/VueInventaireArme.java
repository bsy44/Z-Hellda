package fr.iut.montreuil.projetfinale.zhellda.vue;

import fr.iut.montreuil.projetfinale.zhellda.controleur.ListObsInventaireArme;
import fr.iut.montreuil.projetfinale.zhellda.modele.Arc;
import fr.iut.montreuil.projetfinale.zhellda.modele.Epee;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.util.Callback;
import fr.iut.montreuil.projetfinale.zhellda.modele.Arme;

public class VueInventaireArme {
    private ListView<Arme> listView;
    private ListObsInventaireArme listObsInventaireArme;

    public VueInventaireArme(ListView<Arme> listView, ListObsInventaireArme listObsInventaireArme) {
        this.listView = listView;
        this.listObsInventaireArme = listObsInventaireArme;

        configurerListView();
        lierListView();
    }

    private void configurerListView() {
        listView.setCellFactory(new Callback<ListView<Arme>, ListCell<Arme>>() {
            @Override
            public ListCell<Arme> call(ListView<Arme> listView) {
                return new ListCell<Arme>() {
                    private ImageView imageView = new ImageView();

                    @Override
                    protected void updateItem(Arme arme, boolean empty) {
                        if (empty || arme == null) {
                            setText(null);
                            setGraphic(null);
                        } else {
                            if (arme instanceof Arc) {
                                imageView.setImage(((Arc) arme).getImage());
                            } else if (arme instanceof Epee) {
                                imageView.setImage(((Epee) arme).getImage());
                            }
                            imageView.setFitHeight(30);
                            imageView.setFitWidth(30);
                            setText(arme.getClass().getSimpleName());
                            setGraphic(imageView);
                        }
                    }
                };
            }
        });
    }

    private void lierListView() {
        listView.setItems(listObsInventaireArme.getInventaire());
    }
}

