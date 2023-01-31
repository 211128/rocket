package com.navigate.zenteno125.models;

import javafx.scene.image.ImageView;

import java.util.Observable;
import java.util.Random;

public class Rock extends Observable implements Runnable{

    private Position pos;

    public Position getPos() {
        return pos;
    }

    public void setPos(Position pos) {
        this.pos = pos;
    }

    private int distanceY;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    private int size;
    private Random random;
    private String path = "";
    private boolean status = true;

    public void Rock(int size, int distanceY, String path){


    }


    @Override
    public void run() {

        while (status){
            pos.setPosY(pos.getPosY() + 5);
            setChanged();
            notifyObservers(pos );
            try {
                Thread.sleep(50L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
