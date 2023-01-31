package com.navigate.zenteno125.models;

import javafx.scene.image.ImageView;

import java.util.Observable;
import java.util.Random;

public class Rock extends Observable implements Runnable{

    private Position pos;
    private int distanceY;
    private int size;
    private Random random;
    private String path = "";




    private boolean status = true;

    public void Rock(int size, int distanceY, String path){


    }


    @Override
    public void run() {

    }
}
