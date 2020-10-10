package sample;

import com.intellij.codeInsight.template.postfix.templates.SoutPostfixTemplate;
import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Sortie extends Parent {
    private int mur;
    private double longueur;
    private double distance;
    private static double epaisseur = 10;


    public Sortie(int m, double l, double d) {
        this.mur = m;
        this.longueur = l;
        this.distance = d;
        Rectangle sortie = new Rectangle();
        if(mur==1){
            sortie.setWidth(longueur);
            sortie.setHeight(epaisseur);
            sortie.setTranslateX(distance);
            sortie.setTranslateY(0);
        }else if(mur==2){
            sortie.setHeight(longueur);
            sortie.setWidth(epaisseur);
        }else if(mur==3){
            sortie.setWidth(longueur);
            sortie.setHeight(epaisseur);
        }else if(mur==4) {
            sortie.setWidth(epaisseur);
            sortie.setHeight(longueur);
        } else {
            System.out.println("erreur dans l'argument mis");
            return;
        }
        sortie.setFill(Color.BLACK);
        this.getChildren().add(sortie);

    }
}
