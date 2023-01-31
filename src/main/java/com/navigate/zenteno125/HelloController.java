package com.navigate.zenteno125;

import com.navigate.zenteno125.models.Position;
import com.navigate.zenteno125.models.Rock;
import com.navigate.zenteno125.models.Rocket;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.util.Observable;
import java.util.Observer;

public class HelloController implements Observer {

    @FXML
    private Button btnStartRocket;
    private ImageView rock;

    private Rock roca;
    @FXML
    private AnchorPane root;
    @FXML
    private ImageView entitieRock;
    @FXML
    private ImageView entitieRocket;


    @FXML
    void naveOnKeyPressed(KeyEvent event){
        if (event.getCode() == KeyCode.D) {
            if (entitieRocket.getLayoutX() > 332) {
                entitieRocket.setLayoutX(entitieRocket.getLayoutX() );
            }else
                entitieRocket.setLayoutX(entitieRocket.getLayoutX() + 15);
        }

        if (event.getCode() == KeyCode.A) {
            if(entitieRocket.getLayoutX() < 0) {
                entitieRocket.setLayoutX(entitieRocket.getLayoutX() );
            }else
                entitieRocket.setLayoutX(entitieRocket.getLayoutX() - 15);
        }


    }


    @FXML
    public void initialize(){
        Rocket rocket = new Rocket();
        Thread h1 = new Thread(rocket);
        h1.start();


        rock = new ImageView(new Image(getClass().getResourceAsStream("/assets/img/entities/asteroide.png")));
        rock.setFitWidth(50);
        rock.setFitHeight(50);
        rock.setLayoutX(171);
        rock.setLayoutY(14);

        root.getChildren().add(rock);


    }


    @FXML
    void OnMouseClicketStart(MouseEvent event) {
        roca = new Rock();
        roca.setPos(new Position(1, 171, 14));
        roca.addObserver(this);
        new Thread(roca).start();

    }






    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Rock) {

            Position pos = (Position) arg;
            Platform.runLater(() -> rock.setLayoutY(pos.getPosY()));

            if (pos.getPosY() >= 530){
                roca.setStatus(false);
                roca = new Rock();
                roca.setPos(new Position(1, 171, 14));
                roca.addObserver(this);
                new Thread(roca).start();
            }
        }
        else {
            Rocket rocket = (Rocket) arg;
        }
        if (rock.getBoundsInParent().intersects(entitieRocket.getBoundsInParent())) {
            System.exit(1);
        }
    }
}




