package sample;

import a.j.P;
import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.apache.xmlbeans.impl.store.Saaj;

import java.awt.*;

public class Salle extends Parent {
    private double longuer;
    private double largeur;
    private double marge = 30;

    public Salle(double lon, double lar) {
        this.longuer = lon - (2 * marge);
        this.largeur = lar - (2 * marge);
        Rectangle salle = new Rectangle(longuer,largeur);
        salle.setTranslateX(marge);
        salle.setTranslateY(marge);
        salle.setFill(Color.LIGHTCYAN);
        this.getChildren().add(salle);
    }



    public double getLargeur() {
        return largeur;
    }

    public double getLonguer() {
        return longuer;
    }

    public double getMarge() {
        return marge;
    }
}
