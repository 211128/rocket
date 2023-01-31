package com.navigate.zenteno125;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.util.Observable;
import java.util.Observer;

public class HelloController implements Observer {

    @FXML
    private Button btnStartRocket;

    private ImageView rock;

    private String path = "assets/img/entities/rocket.gif";

    @FXML
    private ImageView entitieRock;

    @FXML
    private ImageView entitieRocket;


    @FXML
    void naveOnKeyPressed(KeyEvent event){
        if (event.getCode() == KeyCode.D) {
            if (entitieRocket.getLayoutX() > 342) {
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


        rock = new ImageView(new Image(getClass().getResourceAsStream(path)));

    }


    @FXML
    void OnMouseClicketStartS(MouseEvent event) {



    }


    @Override
    public void update(Observable o, Object arg) {
        Rocket rocket = (Rocket) arg;


    }
}




