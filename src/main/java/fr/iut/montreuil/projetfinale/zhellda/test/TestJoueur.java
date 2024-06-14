package fr.iut.montreuil.projetfinale.zhellda.test;



import fr.iut.montreuil.projetfinale.zhellda.modele.Environnement;
import fr.iut.montreuil.projetfinale.zhellda.modele.Joueur;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestJoueur {

    private Joueur joueur = new Joueur(new Environnement());




    @Test
    public void testSetDirections() {
        joueur.setDirections(0);

        assertTrue(joueur.getDirections(0));
        assertFalse(joueur.getDirections(1));
        assertFalse(joueur.getDirections(2));
        assertFalse(joueur.getDirections(3));
    }




}
