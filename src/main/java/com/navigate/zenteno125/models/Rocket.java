package com.navigate.zenteno125.models;

import java.util.Observable;


public class Rocket extends Observable implements Runnable {

    private Position pos;
    private boolean status;

    public Rocket() {
        status = true;
    }

    public void setPosicion(Position pos) {
        this.pos = pos;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public void run() {
        while (status) {
            pos.setPosX(pos.getPosX() + 10);
            setChanged();
            notifyObservers(pos);

            try {
                Thread.sleep(20L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}