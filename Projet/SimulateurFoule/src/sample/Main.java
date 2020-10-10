package sample;

import a.j.S;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        /*Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();*/

        double longueur = 1000;
        double largeur = 750;

        Group root = new Group();
        Salle salle = new Salle(longueur,largeur);
        Sortie sortie = new Sortie(1,30,40,salle);
        Personne personne = new Personne(50, 600);
        root.getChildren().addAll(salle,personne,sortie);

        double dx = 0.4;

        Scene scene = new Scene(root, longueur, largeur, Color.WHITE);

        Timeline loop = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>() {
            public void handle(ActionEvent arg) {
                personne.setTranslateX(personne.getTranslateX()+dx);
            }
        }));
        loop.setCycleCount(Timeline.INDEFINITE);
        loop.play();

        primaryStage.setTitle("TEST");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
