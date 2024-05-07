package fr.iut.montreuil.projetfinale.zhellda.modele;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.awt.*;

import static fr.iut.montreuil.projetfinale.zhellda.controleur.Controleur.j;

public class ObsClavier extends java.awt.event.KeyEvent {

    public ObsClavier(Component source, int id, long when, int modifiers, int keyCode, char keyChar, int keyLocation) {
        super(source, id, when, modifiers, keyCode, keyChar, keyLocation);
    }

    public static void keyPressed (KeyEvent e){
        //déplacements
        if (e.getCode() == KeyCode.Z) j.deplacerHaut();
        if (e.getCode() == KeyCode.Q) j.deplacerGauche();
        if (e.getCode() == KeyCode.D) j.deplacerDroite();
        if (e.getCode() == KeyCode.S) j.deplacerBas();

        //attaques
        if (e.getCode() == KeyCode.UP) System.out.println("up");
        if (e.getCode() == KeyCode.DOWN) System.out.println("down");
        if (e.getCode() == KeyCode.RIGHT) System.out.println("right");
        if (e.getCode() == KeyCode.LEFT) System.out.println("left");

    }

}
