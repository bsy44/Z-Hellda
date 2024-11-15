package fr.iut.montreuil.projetfinale.zhellda.modele.personnage.schemaAttaque;

import fr.iut.montreuil.projetfinale.zhellda.modele.Case;
import fr.iut.montreuil.projetfinale.zhellda.modele.Environnement;
import fr.iut.montreuil.projetfinale.zhellda.modele.personnage.Boss;
import fr.iut.montreuil.projetfinale.zhellda.modele.personnage.Ennemi;

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
    public void attaquer(Ennemi ennemi) {
        faireAttaque((Boss) ennemi, direction(ennemi));
    }

    @Override
    public void faireAttaque(Boss boss, String direction) {
        Random random = new Random();
        int randomInt = random.nextInt(listeSchemaAttaque.size());
        System.out.println(randomInt);
        listeSchemaAttaque.get(randomInt).attaquer(boss);
        for (Case c : listeSchemaAttaque.get(randomInt).getCasesAttaqueesProperty()) this.getCasesAttaquees().add(c);
        mettreAJourCasesAttaqueesProperty();
    }
}
