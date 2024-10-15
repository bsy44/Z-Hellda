package fr.iut.montreuil.projetfinale.zhellda.modele.personnage;

import fr.iut.montreuil.projetfinale.zhellda.modele.Environnement;

import java.util.ArrayList;
import java.util.Random;

public class SchemaAttaqueChangeant extends SchemaAttaqueBoss {
    private ArrayList<SchemaAttaqueBoss> listeSchemaAttaque;

    public SchemaAttaqueChangeant(){
        this.listeSchemaAttaque = new ArrayList<>();
        this.listeSchemaAttaque.add(new SchemaAttaqueGriffe());
        this.listeSchemaAttaque.add(new SchemaAttaqueAttaqueDeZone());
        this.listeSchemaAttaque.add(new SchemaAttaqueBouleDeFeu());
    }

    @Override
    public void attaquer(Environnement environnement, Ennemi ennemi) {
        Random random = new Random();
        int randomInt = random.nextInt(listeSchemaAttaque.size());
        listeSchemaAttaque.get(randomInt).attaquer(environnement, ennemi);
    }
}
