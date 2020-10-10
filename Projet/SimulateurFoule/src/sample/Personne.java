package sample;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Personne extends Parent {
    private double x;
    private double y;

    public Personne(double posX , double posY){
        x=posX;
        y=posY;
        Circle cercle = new Circle(x,y,25);
        cercle.setFill(Color.RED);
        this.getChildren().add(cercle);
    }
}
